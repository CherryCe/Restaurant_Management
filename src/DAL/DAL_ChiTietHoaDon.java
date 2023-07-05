/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.DTO_ChiTietHoaDon;
import DTO.DTO_MonAn;
import DTO.DTO_NhanVien;
import HELPER.HELPER_ChuyenDoi;
import HELPER.HELPER_ConnectSQL;
import java.sql.ResultSet;

/**
 *
 * @author CherryCe
 */
public class DAL_ChiTietHoaDon {

    public static void add(DTO_ChiTietHoaDon chiTiet) {
        String sqlSelect = "INSERT INTO chiTietHoaDon VALUES (?, ?, ?, ?, ?, ?)";
        HELPER_ConnectSQL.executeUpdate(sqlSelect, chiTiet.getMaBan(), chiTiet.getMaMon(), chiTiet.getGiaTien(), chiTiet.getSoLuong(), chiTiet.getThanhTien(), chiTiet.getGhiChu());
    }

    public static void delete(String maMon, String maBan) {
        String sqlDelete = "DELETE FROM chiTietHoaDon WHERE maMon = ? AND maBan = ?";
        HELPER_ConnectSQL.executeUpdate(sqlDelete, maMon, maBan);
    }

    public static void edit(DTO_ChiTietHoaDon chiTiet) {
        String sqlUpdate = "UPDATE chiTietHoaDon SET soLuong = ?, thanhTien = ?, ghiChu = ? WHERE maMon = ?";
        HELPER_ConnectSQL.executeUpdate(sqlUpdate, chiTiet.getSoLuong(), chiTiet.getThanhTien(), chiTiet.getGhiChu(), chiTiet.getMaMon());
    }

    public static ResultSet select(String maBan) {
        String sqlSelect = "SELECT * FROM chiTietHoaDon WHERE maBan = ? ORDER BY STT";
        return HELPER_ConnectSQL.executeQuery(sqlSelect, maBan);
    }
}
