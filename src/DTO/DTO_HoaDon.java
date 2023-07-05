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
public class DTO_HoaDon {

    public int STT;
    public String maBan;
    public int maHoaDon;
    public String thoiGian;
    public String tenKhach;
    public String maNhanVien;
    public String ghiChu;
    public int tienBan;
    public int thueVAT;
    public int tienThue;
    public int tongTien;
    public int nhanKhach;
    public int traKhach;

    public DTO_HoaDon() {
    }

    @Override
    public String toString() {
        return "DTO_HoaDon{" + "STT=" + STT + ", maBan=" + maBan + ", maHoaDon=" + maHoaDon + ", thoiGian=" + thoiGian + ", tenKhach=" + tenKhach + ", maNhanVien=" + maNhanVien + ", ghiChu=" + ghiChu + ", tienBan=" + tienBan + ", thueVAT=" + thueVAT + ", tienThue=" + tienThue + ", tongTien=" + tongTien + ", nhanKhach=" + nhanKhach + ", traKhach=" + traKhach + '}';
    }

    public DTO_HoaDon(String maBan, int maHoaDon, String tenKhach, String maNhanVien, String ghiChu, int tienBan, int thueVAT, int tienThue, int tongTien, int nhanKhach, int traKhach) {
        this.maBan = maBan;
        this.maHoaDon = maHoaDon;
        this.tenKhach = tenKhach;
        this.maNhanVien = maNhanVien;
        this.ghiChu = ghiChu;
        this.tienBan = tienBan;
        this.thueVAT = thueVAT;
        this.tienThue = tienThue;
        this.tongTien = tongTien;
        this.nhanKhach = nhanKhach;
        this.traKhach = traKhach;
    }

    public int getSTT() {
        return STT;
    }

    public void setSTT(int STT) {
        this.STT = STT;
    }

    public String getMaBan() {
        return maBan;
    }

    public void setMaBan(String maBan) {
        this.maBan = maBan;
    }

    public int getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

    public String getTenKhach() {
        return tenKhach;
    }

    public void setTenKhach(String tenKhach) {
        this.tenKhach = tenKhach;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public int getTienBan() {
        return tienBan;
    }

    public void setTienBan(int tienBan) {
        this.tienBan = tienBan;
    }

    public int getThueVAT() {
        return thueVAT;
    }

    public void setThueVAT(int thueVAT) {
        this.thueVAT = thueVAT;
    }

    public int getTienThue() {
        return tienThue;
    }

    public void setTienThue(int tienThue) {
        this.tienThue = tienThue;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    public int getNhanKhach() {
        return nhanKhach;
    }

    public void setNhanKhach(int nhanKhach) {
        this.nhanKhach = nhanKhach;
    }

    public int getTraKhach() {
        return traKhach;
    }

    public void setTraKhach(int traKhach) {
        this.traKhach = traKhach;
    }
}
