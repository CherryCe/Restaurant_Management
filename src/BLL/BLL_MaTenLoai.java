/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.DAL_MaTenLoai;
import DTO.DTO_MaTenLoai;
import HELPER.HELPER_ComboBox;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CherryCe
 */
public class BLL_MaTenLoai {

    public static String getPhanQuyen(String tenDangNhap) {
        ResultSet rs = DAL_MaTenLoai.findTenDangNhap(tenDangNhap);
        try {
            while (rs.next()) {
                return rs.getString("phanQuyen");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getTenMon(String maMon) {
        ResultSet rs = DAL_MaTenLoai.findMaMon(maMon);
        try {
            while (rs.next()) {
                return rs.getString("tenMon");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getMaMon(String tenMon) {
        ResultSet rs = DAL_MaTenLoai.findTenMon(tenMon);
        try {
            while (rs.next()) {
                return rs.getString("maMon");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getTenBan(String maBan) {
        ResultSet rs = DAL_MaTenLoai.findMaBan(maBan);
        try {
            while (rs.next()) {
                return rs.getString("tenBan");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getMaBan(String tenBan) {
        ResultSet rs = DAL_MaTenLoai.findTenBan(tenBan);
        try {
            while (rs.next()) {
                return rs.getString("maBan");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getMaNhanVien(String tenNhanVien) {
        ResultSet rs = DAL_MaTenLoai.findTenNhanVien(tenNhanVien);
        try {
            while (rs.next()) {
                return rs.getString("maNhanVien");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getTenNhanVien(String maNhanVien) {
        ResultSet rs = DAL_MaTenLoai.findMaNhanVien(maNhanVien);
        try {
            while (rs.next()) {
                return rs.getString("tenNhanVien");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<DTO_MaTenLoai> selectMaTenBan() {
        ResultSet rs = DAL_MaTenLoai.selectMaTenBan();
        ArrayList<DTO_MaTenLoai> array = new ArrayList<>();
        try {
            while (rs.next()) {
                DTO_MaTenLoai maTenBan = new DTO_MaTenLoai();
                maTenBan.setMaLoai(rs.getString("maBan"));
                maTenBan.setTenLoai(rs.getString("tenBan"));
                array.add(maTenBan);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return array;
    }

    public static ArrayList<DTO_MaTenLoai> selectMaTenNhanVien() {
        ResultSet rs = DAL_MaTenLoai.selectMaTenNhanVien();
        ArrayList<DTO_MaTenLoai> array = new ArrayList<>();
        try {
            while (rs.next()) {
                DTO_MaTenLoai maTenNhanVien = new DTO_MaTenLoai();
                maTenNhanVien.setMaLoai(rs.getString("maNhanVien"));
                maTenNhanVien.setTenLoai(rs.getString("tenNhanVien"));
                array.add(maTenNhanVien);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return array;
    }

    public static void loadMaTenBan(ArrayList<DTO_MaTenLoai> array, JComboBox cbo) {
        DefaultComboBoxModel cboModel = (DefaultComboBoxModel) cbo.getModel();
        cboModel.removeAllElements();
        for (DTO_MaTenLoai maTenBan : array) {
            Object value = maTenBan.getMaLoai();
            Object text = maTenBan.getTenLoai();
            HELPER_ComboBox myCbo = new HELPER_ComboBox(value, text);
            cboModel.addElement(myCbo);
        }
    }

    public static void loadMaTenNhanVien(ArrayList<DTO_MaTenLoai> array, JComboBox cbo) {
        DefaultComboBoxModel cboModel = (DefaultComboBoxModel) cbo.getModel();
        cboModel.removeAllElements();
        for (DTO_MaTenLoai maTenNhanVien : array) {
            Object value = maTenNhanVien.getMaLoai();
            Object text = maTenNhanVien.getTenLoai();
            HELPER_ComboBox myCbo = new HELPER_ComboBox(value, text);
            cboModel.addElement(myCbo);
        }
    }

    public static void loadMaTenMon(ArrayList<DTO_MaTenLoai> array, ArrayList<String> str) {
        for (DTO_MaTenLoai maTenMon : array) {
            String tenMon = maTenMon.getTenLoai();
            str.add(tenMon);
        }
    }

    public static void isAdd(JTable tbl, JComboBox cbo, JButton btn, int index) {
        for (int i = 0; i < tbl.getRowCount(); i++) {
            if (String.valueOf(cbo.getSelectedItem()).equals(tbl.getValueAt(i, index).toString())) {
                btn.setEnabled(false);
                break;
            } else {
                btn.setEnabled(true);
            }
        }
    }

    public static void isAdd(JTable tbl, JTextField txt, JButton btn, int index) {
        for (int i = 0; i < tbl.getRowCount(); i++) {
            if (txt.getText().equals(tbl.getValueAt(i, index).toString())) {
                btn.setEnabled(false);
                break;
            } else {
                btn.setEnabled(true);
            }
        }
    }
}
