/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import BLL.BLL_TaiKhoan;
import DTO.DTO_NhanVien;
import DTO.DTO_TaiKhoan;
import HELPER.HELPER_ConnectSQL;
import HELPER.HELPER_ChuyenDoi;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author CherryCe
 */
public class DAL_NhanVien {

    public static void add(DTO_NhanVien nhanVien) {
        String sqlInsert = "SET DATEFORMAT DMY INSERT INTO nhanVien VALUES (?, ?, ?, ?, ?, ?, ?)";
        HELPER_ConnectSQL.executeUpdate(sqlInsert, nhanVien.getMaNhanVien(), nhanVien.getHoVaTen(), HELPER_ChuyenDoi.LayNgayString(nhanVien.getNgaySinh()), nhanVien.getSoDienThoai(), nhanVien.getDiaChi(), nhanVien.getGioiTinh(), nhanVien.getHinhAnh());
    }

    public static void delete(String maNhanVien) {
        String sqlInsert = "DELETE FROM nhanVien WHERE maNhanVien = ?";
        HELPER_ConnectSQL.executeUpdate(sqlInsert, maNhanVien);
    }

    public static ResultSet select() {
        String sqlSelect = "SELECT * FROM nhanVien ORDER BY maNhanVien";
        return HELPER_ConnectSQL.executeQuery(sqlSelect);
    }

    public static ResultSet search(String search) {
        String sqlSelect = "SELECT * FROM nhanVien WHERE maNhanVien LIKE ?";
        return HELPER_ConnectSQL.executeQuery(sqlSelect, "%" + search + "%");
    }

    public static void edit(DTO_NhanVien nhanVien) {
        String sqlUpdate = "SET DATEFORMAT DMY UPDATE nhanVien SET tenNhanVien = ?, ngaySinh = ?, soDienThoai = ?, diaChi = ?, gioiTinh = ?, hinhAnh = ? WHERE maNhanVien = ?";
        HELPER_ConnectSQL.executeUpdate(sqlUpdate, nhanVien.getHoVaTen(), HELPER_ChuyenDoi.LayNgayString2(nhanVien.getNgaySinh()), nhanVien.getSoDienThoai(), nhanVien.getDiaChi(), nhanVien.getGioiTinh(), nhanVien.getHinhAnh(), nhanVien.getMaNhanVien());
    }

    public static ResultSet selectMaNhanVien() {
        String sqlSelect = "SELECT * FROM taiKhoan ORDER BY maNhanVien";
        return HELPER_ConnectSQL.executeQuery(sqlSelect);
    }
}
