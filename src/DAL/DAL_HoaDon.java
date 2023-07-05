/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.DTO_DatBan;
import DTO.DTO_HoaDon;
import HELPER.HELPER_ChuyenDoi;
import HELPER.HELPER_ConnectSQL;
import java.sql.ResultSet;

/**
 *
 * @author CherryCe
 */
public class DAL_HoaDon {

    public static ResultSet select(String maBan) {
        String sqlSelect = "SELECT * FROM hoaDon WHERE maBan = ?";
        return HELPER_ConnectSQL.executeQuery(sqlSelect, maBan);
    }

    public static ResultSet findDate(String ngay) {
        String sqlSelect = "SELECT CONVERT(DATE, thoiGian) AS dateTime, * FROM hoaDon WHERE CONVERT(DATE, thoiGian) = ?";
        return HELPER_ConnectSQL.executeQuery(sqlSelect, ngay);
    }

    public static ResultSet select() {
        String sqlSelect = "SELECT * FROM hoaDon ORDER BY STT";
        return HELPER_ConnectSQL.executeQuery(sqlSelect);
    }

    public static void add(DTO_HoaDon hoaDon) {
        String sqlInsert = "INSERT INTO hoaDon VALUES (?, ?, CONVERT(VARCHAR, GETDATE(), 120), ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        HELPER_ConnectSQL.executeUpdate(sqlInsert, hoaDon.getMaBan(), hoaDon.getMaHoaDon(), hoaDon.getTenKhach(), hoaDon.getMaNhanVien(), hoaDon.getGhiChu(), hoaDon.getTienBan(), hoaDon.getThueVAT(), hoaDon.getTienThue(), hoaDon.getTongTien(), hoaDon.getNhanKhach(), hoaDon.getTraKhach());
    }

    public static ResultSet count(String thoiGian) {
        String sqlSelect = "SELECT COUNT(*) FROM hoaDon WHERE CONVERT(DATE, thoiGian) = ?";
        return HELPER_ConnectSQL.executeQuery(sqlSelect, thoiGian);
    }

    public static ResultSet top() {
        String sqlSelect = "SELECT TOP 1 * FROM hoaDon ORDER BY maHoaDon DESC";
        return HELPER_ConnectSQL.executeQuery(sqlSelect);
    }
}
