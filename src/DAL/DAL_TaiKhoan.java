/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.DTO_TaiKhoan;
import BLL.BLL_TaiKhoan;
import HELPER.HELPER_ConnectSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CherryCe
 */
public class DAL_TaiKhoan {

    public static void add(DTO_TaiKhoan taiKhoan) {
        String sqlInsert = "INSERT INTO taiKhoan VALUES (?, ?, ?, ?)";
        HELPER_ConnectSQL.executeUpdate(sqlInsert, taiKhoan.getMaNhanVien(), taiKhoan.getTenDangNhap(), taiKhoan.getMatKhau(), taiKhoan.getPhanQuyen());
    }

    public static void delete(String maNhanVien) {
        String sqlDelete = "DELETE FROM taiKhoan WHERE maNhanVien = ?";
        HELPER_ConnectSQL.executeUpdate(sqlDelete, maNhanVien);
    }

    public static ResultSet select() {
        String sqlSelect = "SELECT * FROM taiKhoan ORDER BY maNhanVien";
        return HELPER_ConnectSQL.executeQuery(sqlSelect);
    }

    public static ResultSet select(String tenDangNhap, String matKhau) {
        String sqlSelect = "SELECT * FROM taiKhoan WHERE tenDangNhap = ? AND matKhau = ?";
        return HELPER_ConnectSQL.executeQuery(sqlSelect, tenDangNhap, matKhau);
    }

    public static ResultSet search(String search) {
        String sqlSelect = "SELECT * FROM taiKhoan WHERE maNhanVien = ?";
        return HELPER_ConnectSQL.executeQuery(sqlSelect, search);
    }

    public static void edit(DTO_TaiKhoan taiKhoan) {
        String sqlUpdate = "UPDATE taiKhoan SET tenDangNhap = ?, matKhau = ?, phanQuyen = ? WHERE maNhanVien = ?";
        HELPER_ConnectSQL.executeUpdate(sqlUpdate, taiKhoan.getTenDangNhap(), taiKhoan.getMatKhau(), taiKhoan.getPhanQuyen(), taiKhoan.getMaNhanVien());
    }
}
