/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import static BLL.BLL_DatBan.check;
import DAL.DAL_DatBan;
import DAL.DAL_NhanVien;
import DAL.DAL_TaiKhoan;
import DTO.DTO_NhanVien;
import DTO.DTO_TaiKhoan;
import HELPER.HELPER_ConnectSQL;
import HELPER.HELPER_ShowHinhAnh;
import HELPER.HELPER_ChuyenDoi;
import java.awt.Image;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CherryCe
 */
public class BLL_NhanVien {

    public static boolean check(DTO_NhanVien nhanVien) {
        if (nhanVien.getHoVaTen().isEmpty() || nhanVien.getSoDienThoai().isEmpty() || nhanVien.getDiaChi().isEmpty() || nhanVien.getHinhAnh() == null) {
            return false;
        }
        return true;
    }

    public static void add(DTO_NhanVien nhanVien) {
        if (check(nhanVien) == false) {
            JOptionPane.showMessageDialog(null, "Dữ Liệu Không Được Để Trống !!!");
            return;
        } else {
            DAL_NhanVien.add(nhanVien);
        }
    }

    public static void delete(String maNhanVien) {
        try {
            DAL_NhanVien.delete(maNhanVien);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Dữ Liệu Đang Được Sử Dụng !!!");
        }
    }

    public static void edit(DTO_NhanVien nhanVien) {
        if (check(nhanVien) == false) {
            JOptionPane.showMessageDialog(null, "Dữ Liệu Không Được Để Trống !!!");
        } else {
            DAL_NhanVien.edit(nhanVien);
        }
    }

    public static ArrayList<DTO_NhanVien> search(String search) {
        ResultSet rs = DAL_NhanVien.search(search);
        ArrayList<DTO_NhanVien> array = new ArrayList<>();
        try {
            while (rs.next()) {
                DTO_NhanVien nhanVien = new DTO_NhanVien();
                nhanVien.setMaNhanVien(rs.getString("maNhanVien"));
                nhanVien.setHoVaTen(rs.getString("tenNhanVien"));
                nhanVien.setNgaySinh(rs.getDate("ngaySinh"));
                nhanVien.setSoDienThoai(rs.getString("soDienThoai"));
                nhanVien.setDiaChi(rs.getString("diaChi"));
                nhanVien.setGioiTinh(rs.getString("gioiTinh"));
                nhanVien.setHinhAnh(rs.getString("hinhAnh"));
                array.add(nhanVien);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return array;
    }

    public static ArrayList<DTO_NhanVien> select() {
        ResultSet rs = DAL_NhanVien.select();
        ArrayList<DTO_NhanVien> array = new ArrayList<>();
        try {
            while (rs.next()) {
                DTO_NhanVien nhanVien = new DTO_NhanVien();
                nhanVien.setMaNhanVien(rs.getString("maNhanVien"));
                nhanVien.setHoVaTen(rs.getString("tenNhanVien"));
                nhanVien.setNgaySinh(rs.getDate("ngaySinh"));
                nhanVien.setSoDienThoai(rs.getString("soDienThoai"));
                nhanVien.setDiaChi(rs.getString("diaChi"));
                nhanVien.setGioiTinh(rs.getString("gioiTinh"));
                nhanVien.setHinhAnh(rs.getString("hinhAnh"));
                array.add(nhanVien);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return array;
    }

    public static void load(ArrayList<DTO_NhanVien> array, JTable tbl) {
        DefaultTableModel tblModel = (DefaultTableModel) tbl.getModel();
        tblModel.setColumnIdentifiers(new Object[]{"Mã Nhân Viên", "Họ Và Tên", "Ngày Sinh", "SĐT", "Địa Chỉ", "Giới Tính", "Hình Ảnh"});
        tblModel.setRowCount(0);
        for (DTO_NhanVien nhanVien : array) {
            Object obj[] = new Object[7];
            obj[0] = nhanVien.getMaNhanVien();
            obj[1] = nhanVien.getHoVaTen();
            obj[2] = HELPER_ChuyenDoi.LayNgayString(nhanVien.getNgaySinh());
            obj[3] = nhanVien.getSoDienThoai();
            obj[4] = nhanVien.getDiaChi();
            obj[5] = nhanVien.getGioiTinh();
            obj[6] = nhanVien.getHinhAnh();
            tblModel.addRow(obj);
        }
    }

    public static ArrayList<DTO_NhanVien> selectMaNhanVien() {
        ResultSet rs = DAL_NhanVien.selectMaNhanVien();
        ArrayList<DTO_NhanVien> array = new ArrayList<>();
        try {
            while (rs.next()) {
                DTO_NhanVien nhanVien = new DTO_NhanVien();
                nhanVien.setMaNhanVien(rs.getString("maNhanVien"));
                array.add(nhanVien);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return array;
    }

    public static void loadMaNhanVien(ArrayList<DTO_NhanVien> array, JComboBox cbo) {
        DefaultComboBoxModel cboModel = (DefaultComboBoxModel) cbo.getModel();
        cboModel.removeAllElements();
        for (DTO_NhanVien nhanVien : array) {
            Object obj = nhanVien.getMaNhanVien();
            cboModel.addElement(obj);
        }
    }
}
