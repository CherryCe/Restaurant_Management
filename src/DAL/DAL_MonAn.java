/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.DTO_DanhSach;
import DTO.DTO_MonAn;
import HELPER.HELPER_ConnectSQL;
import java.sql.ResultSet;

/**
 *
 * @author CherryCe
 */
public class DAL_MonAn {

    public static void add(DTO_MonAn monAn) {
        String sqlSelect = "INSERT INTO monAn VALUES (?, ?, ?, ?, ?, ?)";
        HELPER_ConnectSQL.executeUpdate(sqlSelect, monAn.getMaMon(), monAn.getTenMon(), monAn.getLoaiMon(), monAn.getDonViTinh(), monAn.getGiaTien(), monAn.getHinhAnh());
    }

    public static void delete(String maMon) {
        String sqlDelete = "DELETE FROM monAn WHERE maMon = ?";
        HELPER_ConnectSQL.executeUpdate(sqlDelete, maMon);
    }

    public static void edit(DTO_MonAn monAn) {
        String sqlUPDATE = "UPDATE monAn SET tenMon = ?, loaiMon = ?, donViTinh = ?, giaTien = ?, hinhAnh = ? WHERE maMon = ?";
        HELPER_ConnectSQL.executeUpdate(sqlUPDATE, monAn.getTenMon(), monAn.getLoaiMon(), monAn.getDonViTinh(), monAn.getGiaTien(), monAn.getHinhAnh(), monAn.getMaMon());
    }

    public static ResultSet select() {
        String sqlSelect = "SELECT * FROM monAn ORDER BY maMon";
        return HELPER_ConnectSQL.executeQuery(sqlSelect);
    }

    public static ResultSet search(String search) {
        String sqlSelect = "SELECT * FROM monAn WHERE maMon = ?";
        return HELPER_ConnectSQL.executeQuery(sqlSelect, search);
    }

    public static ResultSet select(String tenMon, String loaiMon) {
        String sqlSelect = "SELECT * FROM monAn WHERE tenMon = ? AND loaiMon = ?";
        return HELPER_ConnectSQL.executeQuery(sqlSelect, tenMon, loaiMon);
    }

    public static ResultSet selectTenMon(String loaiMon) {
        String sqlSelect = "SELECT * FROM monAn WHERE loaiMon = ?";
        return HELPER_ConnectSQL.executeQuery(sqlSelect, loaiMon);
    }

    public static ResultSet selectLoaiMon() {
        String sqlSelect = "SELECT DISTINCT loaiMon FROM monAn";
        return HELPER_ConnectSQL.executeQuery(sqlSelect);
    }

    public static ResultSet selectChiTietMonAn(String maBan) {
        String sqlSelect = "SELECT * FROM monAn JOIN chiTietHoaDon ON chiTietHoaDon.maMon = monAn.maMon WHERE maBan = ? ORDER BY STT";
        return HELPER_ConnectSQL.executeQuery(sqlSelect, maBan);
    }
}
