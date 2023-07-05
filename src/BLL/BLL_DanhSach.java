/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.DAL_DanhSach;
import DAL.DAL_NhanVien;
import DTO.DTO_DanhSach;
import DTO.DTO_MonAn;
import DTO.DTO_NhanVien;
import HELPER.HELPER_ChuyenDoi;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CherryCe
 */
public class BLL_DanhSach {

    public static boolean check(DTO_DanhSach danhSach) {
        if (danhSach.getMaBan().isEmpty() || danhSach.getTenBan().isEmpty()) {
            return false;
        }
        return true;
    }

    public static void add(DTO_DanhSach danhSach) {
        if (check(danhSach) == false) {
            JOptionPane.showMessageDialog(null, "Dữ Liệu Không Được Để Trống !!!");
        } else {
            DAL_DanhSach.add(danhSach);
        }
    }

    public static void delete(String maBan) {
        try {
            DAL_DanhSach.delete(maBan);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Dữ Liệu Đang Được Sử Dụng !!!");
        }
    }

    public static void edit(DTO_DanhSach danhSach) {
       if (check(danhSach) == false) {
            JOptionPane.showMessageDialog(null, "Dữ Liệu Không Được Để Trống !!!");
        } else {
            DAL_DanhSach.edit(danhSach);
        }
    }

    public static ArrayList<DTO_DanhSach> select() {
        ResultSet rs = DAL_DanhSach.select();
        ArrayList<DTO_DanhSach> array = new ArrayList<>();
        try {
            while (rs.next()) {
                DTO_DanhSach danhSach = new DTO_DanhSach();
                danhSach.setMaBan(rs.getString("maBan"));
                danhSach.setTenBan(rs.getString("tenBan"));
                danhSach.setTrangThai(rs.getString("trangThai"));
                array.add(danhSach);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return array;
    }

    public static void load(ArrayList<DTO_DanhSach> array, JTable tbl) {
        DefaultTableModel tblModel = (DefaultTableModel) tbl.getModel();
        tblModel.setColumnIdentifiers(new Object[]{"Mã Bàn", "Tên Bàn", "Trạng Thái"});
        tblModel.setRowCount(0);
        for (DTO_DanhSach danhSach : array) {
            Object obj[] = new Object[3];
            obj[0] = danhSach.getMaBan();
            obj[1] = danhSach.getTenBan();
            obj[2] = danhSach.getTrangThai();
            tblModel.addRow(obj);
        }
    }
}
