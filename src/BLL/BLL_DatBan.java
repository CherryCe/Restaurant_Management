/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.DAL_DatBan;
import DAL.DAL_NhanVien;
import DTO.DTO_DatBan;
import DTO.DTO_NhanVien;
import HELPER.HELPER_ChuyenDoi;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CherryCe
 */
public class BLL_DatBan {

    public static boolean check(DTO_DatBan datBan) {
        if (datBan.getMaKhachHang().isEmpty() || datBan.getTenKhachHang().isEmpty() || datBan.getSoDienThoai().isEmpty() || datBan.getMaBan().isEmpty() || datBan.getTraTruoc().isEmpty()) {
            return false;
        }
        return true;
    }

    public static void add(DTO_DatBan datBan) {
        if (check(datBan) == false) {
            JOptionPane.showMessageDialog(null, "Dữ Liệu Không Được Để Trống !!!");
            return;
        } else {
            DAL_DatBan.add(datBan);
        }

    }

    public static void delete(String maKhachHang) {
        try {
            DAL_DatBan.delete(maKhachHang);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Dữ Liệu Đang Được Sử Dụng !!!");
        }
    }

    public static void edit(DTO_DatBan datBan) {
        if (check(datBan) == false) {
            JOptionPane.showMessageDialog(null, "Dữ Liệu Không Được Để Trống !!!");
        } else {
            DAL_DatBan.edit(datBan);
        }
    }

    public static ArrayList<DTO_DatBan> select() {
        ResultSet rs = DAL_DatBan.select();
        ArrayList<DTO_DatBan> arrayList = new ArrayList<>();
        try {
            while (rs.next()) {
                DTO_DatBan datBan = new DTO_DatBan();
                datBan.setMaKhachHang(rs.getString("maKhachHang"));
                datBan.setTenKhachHang(rs.getString("tenKhachHang"));
                datBan.setSoDienThoai(rs.getString("soDienThoai"));
                datBan.setMaBan(rs.getString("maBan"));
                datBan.setNgay(rs.getDate("ngay"));
                datBan.setTraTruoc(rs.getString("traTruoc"));
                datBan.setGhiChu(rs.getString("ghiChu"));
                arrayList.add(datBan);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public static void load(ArrayList<DTO_DatBan> array, JTable tbl) {
        DefaultTableModel tblModel = (DefaultTableModel) tbl.getModel();
        tblModel.setColumnIdentifiers(new Object[]{"Mã Khách Hàng", "Tên Khách Hàng", "Số Điện Thoại", "Mã Bàn", "Ngày", "Trả Trước", "Ghi Chú"});
        tblModel.setRowCount(0);
        for (DTO_DatBan datBan : array) {
            Object obj[] = new Object[7];
            obj[0] = datBan.getMaKhachHang();
            obj[1] = datBan.getTenKhachHang();
            obj[2] = datBan.getSoDienThoai();
            obj[3] = datBan.getMaBan();
            obj[4] = HELPER_ChuyenDoi.LayNgayString(datBan.getNgay());
            obj[5] = datBan.getTraTruoc();
            obj[6] = datBan.getGhiChu();
            tblModel.addRow(obj);
        }
    }

    public static ArrayList<DTO_DatBan> selectMaBan() {
        ResultSet rs = DAL_DatBan.selectMaBan();
        ArrayList<DTO_DatBan> array = new ArrayList<>();
        try {
            while (rs.next()) {
                DTO_DatBan datBan = new DTO_DatBan();
                datBan.setMaBan(rs.getString("maBan"));
                array.add(datBan);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return array;
    }

    public static void loadMaBan(ArrayList<DTO_DatBan> array, JComboBox cbo) {
        DefaultComboBoxModel cboModel = (DefaultComboBoxModel) cbo.getModel();
        cboModel.removeAllElements();
        for (DTO_DatBan datBan : array) {
            Object obj = datBan.getMaBan();
            cboModel.addElement(obj);
        }
    }
}
