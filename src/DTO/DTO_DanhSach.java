/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author CherryCe
 */
public class DTO_DanhSach {

    public String maBan;
    public String tenBan;
    public String trangThai;

    public DTO_DanhSach() {
    }

    @Override
    public String toString() {
        return "DTO_DanhSach{" + "maBan=" + maBan + ", tenBan=" + tenBan + ", trangThai=" + trangThai + '}';
    }

    public DTO_DanhSach(String maBan, String tenBan, String trangThai) {
        this.maBan = maBan;
        this.tenBan = tenBan;
        this.trangThai = trangThai;
    }

    public String getMaBan() {
        return maBan;
    }

    public void setMaBan(String maBan) {
        this.maBan = maBan;
    }

    public String getTenBan() {
        return tenBan;
    }

    public void setTenBan(String tenBan) {
        this.tenBan = tenBan;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}
