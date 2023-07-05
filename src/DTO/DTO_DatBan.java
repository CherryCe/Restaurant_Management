/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.Date;

/**
 *
 * @author CherryCe
 */
public class DTO_DatBan {
 
    public String maKhachHang;
    public String tenKhachHang;
    public String soDienThoai;
    public String maBan;
    public Date ngay;
    public String traTruoc;
    public String ghiChu;

    public DTO_DatBan() {
    }

    @Override
    public String toString() {
        return "DTO_DatBan{" + "maKhachHang=" + maKhachHang + ", tenKhachHang=" + tenKhachHang + ", soDienThoai=" + soDienThoai + ", maBan=" + maBan + ", ngay=" + ngay + ", traTruoc=" + traTruoc + ", ghiChu=" + ghiChu + '}';
    }

    public DTO_DatBan(String maKhachHang, String tenKhachHang, String soDienThoai, String maBan, Date ngay, String traTruoc, String ghiChu) {
        this.maKhachHang = maKhachHang;
        this.tenKhachHang = tenKhachHang;
        this.soDienThoai = soDienThoai;
        this.maBan = maBan;
        this.ngay = ngay;
        this.traTruoc = traTruoc;
        this.ghiChu = ghiChu;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getMaBan() {
        return maBan;
    }

    public void setMaBan(String maBan) {
        this.maBan = maBan;
    }

    public Date getNgay() {
        return ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }

    public String getTraTruoc() {
        return traTruoc;
    }

    public void setTraTruoc(String traTruoc) {
        this.traTruoc = traTruoc;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
    
}
