/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import HELPER.HELPER_ConnectSQL;
import java.sql.ResultSet;

/**
 *
 * @author CherryCe
 */
public class DAL_MaTenLoai {

    public static ResultSet findTenDangNhap(String tenDangNhap) {
        String sqlSelect = "SELECT * FROM taiKhoan WHERE tenDangNhap = ?";
        return HELPER_ConnectSQL.executeQuery(sqlSelect, tenDangNhap);
    }

    public static ResultSet findMaMon(String maMon) {
        String sqlSelect = "SELECT * FROM monAn WHERE maMon = ?";
        return HELPER_ConnectSQL.executeQuery(sqlSelect, maMon);
    }

    public static ResultSet findTenMon(String tenMon) {
        String sqlSelect = "SELECT * FROM monAn WHERE tenMon = ?";
        return HELPER_ConnectSQL.executeQuery(sqlSelect, tenMon);
    }

    public static ResultSet findMaBan(String maBan) {
        String sqlSelect = "SELECT * FROM danhSach WHERE maBan = ?";
        return HELPER_ConnectSQL.executeQuery(sqlSelect, maBan);
    }

    public static ResultSet findTenBan(String tenBan) {
        String sqlSelect = "SELECT * FROM danhSach WHERE tenBan = ? AND trangThai = N'Có Khách'";
        return HELPER_ConnectSQL.executeQuery(sqlSelect, tenBan);
    }

    public static ResultSet findTenNhanVien(String tenNhanVien) {
        String sqlSelect = "SELECT * FROM nhanVien WHERE tenNhanVien = ?";
        return HELPER_ConnectSQL.executeQuery(sqlSelect, tenNhanVien);
    }

    public static ResultSet findMaNhanVien(String maNhanVien) {
        String sqlSelect = "SELECT * FROM nhanVien WHERE maNhanVien = ?";
        return HELPER_ConnectSQL.executeQuery(sqlSelect, maNhanVien);
    }

    public static ResultSet selectMaTenBan() {
        String sqlSelect = "SELECT * FROM danhSach WHERE trangThai = N'Có Khách'";
        return HELPER_ConnectSQL.executeQuery(sqlSelect);
    }

    public static ResultSet selectMaTenNhanVien() {
        String sqlSelect = "SELECT * FROM nhanVien";
        return HELPER_ConnectSQL.executeQuery(sqlSelect);
    }
}
