/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.DAL_ChiTietHoaDon;
import DAL.DAL_MonAn;
import DTO.DTO_DatBan;
import DTO.DTO_MonAn;
import static GUI.GUI_pnl_HoaDon.currency;
import java.sql.ResultSet;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CherryCe
 */
public class BLL_MonAn {

    public static boolean check(DTO_MonAn monAn) {
        if (monAn.getMaMon().isEmpty() || monAn.getTenMon().isEmpty() || monAn.getHinhAnh() == null) {
            return false;
        }
        return true;
    }

    public static void add(DTO_MonAn monAn) {
        if (check(monAn) == false) {
            JOptionPane.showMessageDialog(null, "Dữ Liệu Không Được Để Trống !!!");
            return;
        } else {
            DAL_MonAn.add(monAn);
        }
    }

    public static void delete(String maMon) {
        try {
            DAL_MonAn.delete(maMon);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Dữ Liệu Đang Được Sử Dụng !!!");
        }
    }

    public static void edit(DTO_MonAn monAn) {
        if (check(monAn)==false) {
            JOptionPane.showMessageDialog(null, "Dữ Liệu Không Được Để Trống !!!");
            return;
        } else {
            DAL_MonAn.edit(monAn);
        }
    }

    public static ArrayList<DTO_MonAn> search(String search) {
        ResultSet rs = DAL_MonAn.search(search);
        ArrayList<DTO_MonAn> array = new ArrayList<>();
        try {
            while (rs.next()) {
                DTO_MonAn monAn = new DTO_MonAn();
                monAn.setMaMon(rs.getString("maMon"));
                monAn.setTenMon(rs.getString("tenMon"));
                monAn.setLoaiMon(rs.getString("loaiMon"));
                monAn.setDonViTinh(rs.getString("donViTinh"));
                monAn.setGiaTien(rs.getInt("giaTien"));
                monAn.setHinhAnh(rs.getString("hinhAnh"));
                array.add(monAn);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return array;
    }

    public static ArrayList<DTO_MonAn> select() {
        ResultSet rs = DAL_MonAn.select();
        ArrayList<DTO_MonAn> array = new ArrayList<>();
        try {
            while (rs.next()) {
                DTO_MonAn monAn = new DTO_MonAn();
                monAn.setMaMon(rs.getString("maMon"));
                monAn.setTenMon(rs.getString("tenMon"));
                monAn.setLoaiMon(rs.getString("loaiMon"));
                monAn.setDonViTinh(rs.getString("donViTinh"));
                monAn.setGiaTien(rs.getInt("giaTien"));
                monAn.setHinhAnh(rs.getString("hinhAnh"));
                array.add(monAn);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return array;
    }

    public static void load(ArrayList<DTO_MonAn> array, JTable tbl) {
        DefaultTableModel tblModel = (DefaultTableModel) tbl.getModel();
        tblModel.setColumnIdentifiers(new Object[]{"Mã Món", "Tên Món", "Loại Món", "Đơn Vị Tính", "Giá Tiền", "Hình Ảnh"});
        tblModel.setRowCount(0);
        for (DTO_MonAn monAn : array) {
            Object obj[] = new Object[6];
            obj[0] = monAn.getMaMon();
            obj[1] = monAn.getTenMon();
            obj[2] = monAn.getLoaiMon();
            obj[3] = monAn.getDonViTinh();
            obj[4] = monAn.getGiaTien();
            obj[5] = monAn.getHinhAnh();
            tblModel.addRow(obj);
        }
    }

    public static ArrayList<DTO_MonAn> selectLoaiMon() {
        ResultSet rs = DAL_MonAn.selectLoaiMon();
        ArrayList<DTO_MonAn> array = new ArrayList<>();
        try {
            while (rs.next()) {
                DTO_MonAn monAn = new DTO_MonAn();
                monAn.setLoaiMon(rs.getString("loaiMon"));
                array.add(monAn);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return array;
    }

    public static ArrayList<DTO_MonAn> selectTenMon(String loaiMon) {
        ResultSet rs = DAL_MonAn.selectTenMon(loaiMon);
        ArrayList<DTO_MonAn> array = new ArrayList<>();
        try {
            while (rs.next()) {
                DTO_MonAn monAn = new DTO_MonAn();
                monAn.setTenMon(rs.getString("tenMon"));
                monAn.setLoaiMon(rs.getString("loaiMon"));
                array.add(monAn);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return array;
    }

    public static ArrayList<DTO_MonAn> selectMonAn(String tenMon, String loaiMon) {
        ResultSet rs = DAL_MonAn.select(tenMon, loaiMon);
        ArrayList<DTO_MonAn> array = new ArrayList<>();
        try {
            while (rs.next()) {
                DTO_MonAn monAn = new DTO_MonAn();
                monAn.setMaMon(rs.getString("maMon"));
                monAn.setTenMon(rs.getString("tenMon"));
                monAn.setLoaiMon(rs.getString("loaiMon"));
                monAn.setDonViTinh(rs.getString("donViTinh"));
                monAn.setGiaTien(rs.getInt("giaTien"));
                array.add(monAn);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return array;
    }

    public static ArrayList<DTO_MonAn> selectChiTietMonAn(String maBan) {
        ResultSet rs = DAL_MonAn.selectChiTietMonAn(maBan);
        ArrayList<DTO_MonAn> array = new ArrayList<>();
        try {
            while (rs.next()) {
                DTO_MonAn monAn = new DTO_MonAn();
                monAn.setMaMon(rs.getString("maMon"));
                monAn.setTenMon(rs.getString("tenMon"));
                monAn.setLoaiMon(rs.getString("loaiMon"));
                monAn.setDonViTinh(rs.getString("donViTinh"));
                monAn.setGiaTien(rs.getInt("giaTien"));
                array.add(monAn);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return array;
    }

    public static void loadLoaiMon(ArrayList<DTO_MonAn> array, JComboBox cboLoaiMon) {
        DefaultComboBoxModel cboModelLoaiMon = (DefaultComboBoxModel) cboLoaiMon.getModel();
        cboModelLoaiMon.removeAllElements();
        for (DTO_MonAn monAn : array) {
            Object objLoaiMon = monAn.getLoaiMon();
            cboModelLoaiMon.addElement(objLoaiMon);
        }
    }

    public static void loadTenMon(ArrayList<DTO_MonAn> array, JComboBox cboTenMon) {
        DefaultComboBoxModel cboModelTenMon = (DefaultComboBoxModel) cboTenMon.getModel();
        cboModelTenMon.removeAllElements();
        for (DTO_MonAn monAn : array) {
            Object objTenMon = monAn.getTenMon();
            cboModelTenMon.addElement(objTenMon);
        }
    }

    public static void loadMonAn(ArrayList<DTO_MonAn> array, JLabel donViTinh, JLabel giaTien) {
        for (DTO_MonAn monAn : array) {
            Object[] obj = new Object[2];
            obj[0] = monAn.getDonViTinh();
            obj[1] = monAn.getGiaTien();
            donViTinh.setText(String.valueOf(obj[0]));
            giaTien.setText(currency(obj[1]));
        }
    }

    public static void loadChiTietMonAn(ArrayList<DTO_MonAn> array, JTable tbl) {
        DefaultTableModel tblModel = (DefaultTableModel) tbl.getModel();
        tblModel.setColumnIdentifiers(new Object[]{"Tên Món", "Loại Món", "Đơn Vị Tính", "Giá Tiền"});
        tblModel.setRowCount(0);
        for (DTO_MonAn monAn : array) {
            Object[] obj = new Object[4];
            obj[0] = monAn.getTenMon();
            obj[1] = monAn.getLoaiMon();
            obj[2] = monAn.getDonViTinh();
            obj[3] = monAn.getGiaTien();
            tblModel.addRow(obj);
        }
    }
}
