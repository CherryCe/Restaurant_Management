/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.DTO_DanhSach;
import HELPER.HELPER_ConnectSQL;
import java.sql.ResultSet;

/**
 *
 * @author CherryCe
 */
public class DAL_DanhSach {
    
    public static void add(DTO_DanhSach danhSach){
        String sqlSelect = "INSERT INTO danhSach VALUES (?, ?, ?)";
        HELPER_ConnectSQL.executeUpdate(sqlSelect, danhSach.getMaBan(), danhSach.getTenBan(), danhSach.getTrangThai());
    }
    
    public static void delete(String maBan){
        String sqlDelete = "DELETE FROM danhSach WHERE maBan = ?";
        HELPER_ConnectSQL.executeUpdate(sqlDelete, maBan);
    }
    
    public static void edit(DTO_DanhSach danhSach){
        String sqlUPDATE = "UPDATE danhSach SET tenBan = ?, trangThai = ? WHERE maBan = ?";
        HELPER_ConnectSQL.executeUpdate(sqlUPDATE, danhSach.getTenBan(), danhSach.getTrangThai(), danhSach.getMaBan());
    }
    
    public static ResultSet select(){
        String sqlSelect = "SELECT * FROM danhSach ORDER BY maBan";
        return HELPER_ConnectSQL.executeQuery(sqlSelect);
    }
    
    public static ResultSet search(String search) {
        String sqlSelect = "SELECT * FROM danhSach WHERE maBan = ?";
        return HELPER_ConnectSQL.executeQuery(sqlSelect, search);
    }
}
