/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.DTO_DanhSach;
import DTO.DTO_DatBan;
import HELPER.HELPER_ChuyenDoi;
import HELPER.HELPER_ConnectSQL;
import java.sql.ResultSet;

/**
 *
 * @author CherryCe
 */
public class DAL_DatBan {

    public static void add(DTO_DatBan datBan) {
        String sqlSelect = "SET DATEFORMAT DMY INSERT INTO datBan VALUES (?, ?, ?, ?, ?, ?, ?)";
        HELPER_ConnectSQL.executeUpdate(sqlSelect, datBan.getMaKhachHang(), datBan.getTenKhachHang(), datBan.getSoDienThoai(), datBan.getMaBan(), HELPER_ChuyenDoi.LayNgayString(datBan.getNgay()), datBan.getTraTruoc(), datBan.getGhiChu());
    }

    public static void delete(String maKhachHang) {
        String sqlDelete = "DELETE FROM datBan WHERE maKhachHang = ?";
        HELPER_ConnectSQL.executeUpdate(sqlDelete, maKhachHang);
    }

    public static void edit(DTO_DatBan datBan) {
        String sqlUpdate = "SET DATEFORMAT DMY UPDATE datBan SET tenKhachHang = ?, soDienThoai = ?, maBan = ?, ngay = ?, traTruoc = ?, ghiChu = ? WHERE maKhachHang = ?";
        HELPER_ConnectSQL.executeUpdate(sqlUpdate, datBan.getTenKhachHang(), datBan.getSoDienThoai(), datBan.getMaBan(), HELPER_ChuyenDoi.LayNgayString(datBan.getNgay()), datBan.getTraTruoc(), datBan.getGhiChu(), datBan.getMaKhachHang());
    }

    public static ResultSet select() {
        String sqlSelect = "SELECT * FROM datBan ORDER BY maKhachHang";
        return HELPER_ConnectSQL.executeQuery(sqlSelect);
    }
    
    public static ResultSet selectMaBan() {
        String sqlSelect = "SELECT * FROM danhSach WHERE trangThai = N'Khách Đặt' ORDER BY maBan";
        return HELPER_ConnectSQL.executeQuery(sqlSelect);
    }
}
