/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.DAL_ChiTietHoaDon;
import DAL.DAL_DanhSach;
import DAL.DAL_NhanVien;
import DTO.DTO_ChiTietHoaDon;
import DTO.DTO_MonAn;
import DTO.DTO_DanhSach;
import DTO.DTO_HoaDon;
import DTO.DTO_NhanVien;
import HELPER.HELPER_ChuyenDoi;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CherryCe
 */
public class BLL_ChiTietHoaDon {

    public static void add(DTO_ChiTietHoaDon chiTiet) {
        DAL_ChiTietHoaDon.add(chiTiet);
    }

    public static void delete(String maMon, String maBan) {
        DAL_ChiTietHoaDon.delete(maMon, maBan);
    }
    
    public static void edit(DTO_ChiTietHoaDon chiTiet){
        DAL_ChiTietHoaDon.edit(chiTiet);
    }

    public static ArrayList<DTO_ChiTietHoaDon> select(String maBan) {
        ResultSet rs = DAL_ChiTietHoaDon.select(maBan);
        ArrayList<DTO_ChiTietHoaDon> array = new ArrayList<>();
        try {
            while (rs.next()) {
                DTO_ChiTietHoaDon chiTiet = new DTO_ChiTietHoaDon();
                chiTiet.setSTT(rs.getInt("STT"));
                chiTiet.setMaBan(rs.getString("maBan"));
                chiTiet.setMaMon(rs.getString("maMon"));
                chiTiet.setGiaTien(rs.getInt("giaTien"));
                chiTiet.setSoLuong(rs.getInt("soLuong"));
                chiTiet.setThanhTien(rs.getInt("thanhTien"));
                chiTiet.setGhiChu(rs.getString("ghiChu"));
                array.add(chiTiet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return array;
    }

    public static void load(ArrayList<DTO_ChiTietHoaDon> array, JTable tbl) {
        DefaultTableModel tblModel = (DefaultTableModel) tbl.getModel();
        tblModel.setColumnIdentifiers(new Object[]{"STT", "Tên Món", "Giá Tiền", "Số Lượng", "Thành Tiền", "Chú Thích"});
        tblModel.setRowCount(0);
        for (DTO_ChiTietHoaDon chiTiet : array) {
            Object obj[] = new Object[6];
            obj[0] = chiTiet.getSTT();
            obj[1] = BLL_MaTenLoai.getTenMon(chiTiet.getMaMon());
            obj[2] = chiTiet.getGiaTien();
            obj[3] = chiTiet.getSoLuong();
            obj[4] = chiTiet.getThanhTien();
            obj[5] = chiTiet.getGhiChu();
            tblModel.addRow(obj);
        }
    }
}
