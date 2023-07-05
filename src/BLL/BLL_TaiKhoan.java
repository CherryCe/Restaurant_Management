/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.DAL_TaiKhoan;
import DTO.DTO_TaiKhoan;
import HELPER.HELPER_ConnectSQL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CherryCe
 */
public class BLL_TaiKhoan {

    public static void add(DTO_TaiKhoan taiKhoan) {
        DAL_TaiKhoan.add(taiKhoan);
    }

    public static void delete(String maNhanVien) {
        DAL_TaiKhoan.delete(maNhanVien);
    }

    public static void edit(DTO_TaiKhoan taiKhoan) {
        DAL_TaiKhoan.edit(taiKhoan);
    }

    public static ArrayList<DTO_TaiKhoan> search(String search) {
        ResultSet rs = DAL_TaiKhoan.search(search);
        ArrayList<DTO_TaiKhoan> array = new ArrayList<>();
        try {
            while (rs.next()) {
                DTO_TaiKhoan taiKhoan = new DTO_TaiKhoan();
                taiKhoan.setMaNhanVien(rs.getString("maNhanVien"));
                taiKhoan.setTenDangNhap(rs.getString("tenDangNhap"));
                taiKhoan.setMatKhau(rs.getString("matKhau"));
                taiKhoan.setPhanQuyen(rs.getString("phanQuyen"));
                array.add(taiKhoan);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return array;
    }

    public static ArrayList<DTO_TaiKhoan> select() {
        ResultSet rs = DAL_TaiKhoan.select();
        ArrayList<DTO_TaiKhoan> array = new ArrayList<>();
        try {
            while (rs.next()) {
                DTO_TaiKhoan taiKhoan = new DTO_TaiKhoan();
                taiKhoan.setMaNhanVien(rs.getString("maNhanVien"));
                taiKhoan.setTenDangNhap(rs.getString("tenDangNhap"));
                taiKhoan.setMatKhau(rs.getString("matKhau"));
                taiKhoan.setPhanQuyen(rs.getString("phanQuyen"));
                array.add(taiKhoan);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return array;
    }
    
    public static ArrayList<DTO_TaiKhoan> select(String tenDangNhap, String matKhau) {
        ResultSet rs = DAL_TaiKhoan.select(tenDangNhap, matKhau);
        ArrayList<DTO_TaiKhoan> array = new ArrayList<>();
        try {
            while (rs.next()) {
                DTO_TaiKhoan taiKhoan = new DTO_TaiKhoan();
                taiKhoan.setMaNhanVien(rs.getString("maNhanVien"));
                taiKhoan.setTenDangNhap(rs.getString("tenDangNhap"));
                taiKhoan.setMatKhau(rs.getString("matKhau"));
                taiKhoan.setPhanQuyen(rs.getString("phanQuyen"));
                array.add(taiKhoan);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return array;
    }

    public static void load(ArrayList<DTO_TaiKhoan> array, JTable tbl) {
        DefaultTableModel tblModel = (DefaultTableModel) tbl.getModel();
        tblModel.setColumnIdentifiers(new Object[]{"Mã Nhân Viên", "Tên Đăng Nhập", "Mật Khẩu", "Phân Quyền"});
        tblModel.setRowCount(0);
        for (DTO_TaiKhoan taiKhoan : array) {
            Object obj[] = new Object[4];
            obj[0] = taiKhoan.getMaNhanVien();
            obj[1] = taiKhoan.getTenDangNhap();
            obj[2] = taiKhoan.getMatKhau();
            obj[3] = taiKhoan.getPhanQuyen();
            tblModel.addRow(obj);
        }
    }
}
