/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.DAL_ChiTietHoaDon;
import DAL.DAL_HoaDon;
import DTO.DTO_HoaDon;
import HELPER.HELPER_ChuyenDoi;
import com.toedter.calendar.JDateChooser;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CherryCe
 */
public class BLL_HoaDon {

    public static boolean check(DTO_HoaDon hoaDon) {
        if (hoaDon.getMaBan().isEmpty() || hoaDon.getTenKhach().isEmpty() || hoaDon.getMaNhanVien().isEmpty()) {
            return false;
        }
        return true;
    }

    public static void add(DTO_HoaDon hoaDon) {
        if (check(hoaDon) == false) {
            JOptionPane.showMessageDialog(null, "Dữ Liệu Không Được Để Trống !!!");
            return;
        } else {
            DAL_HoaDon.add(hoaDon);
            JOptionPane.showMessageDialog(null, "Thêm Hóa Đơn Thành Công !!!");
        }
    }

    public static ArrayList<DTO_HoaDon> findDate(String ngay) {
        ResultSet rs = DAL_HoaDon.findDate(ngay);
        ArrayList<DTO_HoaDon> array = new ArrayList<>();
        try {
            while (rs.next()) {
                DTO_HoaDon hoaDon = new DTO_HoaDon();
                hoaDon.setSTT(rs.getInt("STT"));
                hoaDon.setMaBan(rs.getString("maBan"));
                hoaDon.setMaHoaDon(rs.getInt("maHoaDon"));
                hoaDon.setThoiGian(rs.getString("thoiGian"));
                hoaDon.setTenKhach(rs.getString("tenKhach"));
                hoaDon.setMaNhanVien(rs.getString("maNhanVien"));
                hoaDon.setTongTien(rs.getInt("tongTien"));
                hoaDon.setGhiChu(rs.getString("ghiChu"));
                array.add(hoaDon);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return array;
    }

    public static ArrayList<DTO_HoaDon> select() {
        ResultSet rs = DAL_HoaDon.select();
        ArrayList<DTO_HoaDon> array = new ArrayList<>();
        try {
            while (rs.next()) {
                DTO_HoaDon hoaDon = new DTO_HoaDon();
                hoaDon.setSTT(rs.getInt("STT"));
                hoaDon.setMaBan(rs.getString("maBan"));
                hoaDon.setMaHoaDon(rs.getInt("maHoaDon"));
                hoaDon.setThoiGian(rs.getString("thoiGian"));
                hoaDon.setTenKhach(rs.getString("tenKhach"));
                hoaDon.setMaNhanVien(rs.getString("maNhanVien"));
                hoaDon.setTongTien(rs.getInt("tongTien"));
                hoaDon.setGhiChu(rs.getString("ghiChu"));
                array.add(hoaDon);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return array;
    }

    public static void load(ArrayList<DTO_HoaDon> array, JTable tbl) {

        DefaultTableModel tblModel = (DefaultTableModel) tbl.getModel();
        tblModel.setColumnIdentifiers(new Object[]{"STT", "Mã Hóa Đơn", "Tên Bàn", "Nhân Viên", "Ngày Bán", "Tổng Tiền Hóa Đơn"});
        tblModel.setRowCount(0);
        for (DTO_HoaDon hoaDon : array) {
            Object obj[] = new Object[6];
            obj[0] = hoaDon.getSTT();
            obj[1] = hoaDon.getMaHoaDon();
            obj[2] = hoaDon.getMaBan();
            obj[3] = hoaDon.getMaNhanVien();
            obj[4] = hoaDon.getThoiGian();
            obj[5] = hoaDon.getTongTien();
            tblModel.addRow(obj);
        }
    }

    public static int top() {
        ResultSet rs = DAL_HoaDon.top();
        try {
            while (rs.next()) {
                return rs.getInt("maHoaDon");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
