/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author CherryCe
 */
public class DTO_ChiTietHoaDon {

    public int STT;
    public String maBan;
    public String maMon;
    public int giaTien;
    public int soLuong;
    public int thanhTien;
    public String ghiChu;

    public DTO_ChiTietHoaDon() {
    }

    @Override
    public String toString() {
        return "DTO_ChiTietHoaDon{" + "STT=" + STT + ", maBan=" + maBan + ", maMon=" + maMon + ", giaTien=" + giaTien + ", soLuong=" + soLuong + ", thanhTien=" + thanhTien + ", ghiChu=" + ghiChu + '}';
    }

    public DTO_ChiTietHoaDon(String maBan, String maMon, int giaTien, int soLuong, int thanhTien, String ghiChu) {
        this.maBan = maBan;
        this.maMon = maMon;
        this.giaTien = giaTien;
        this.soLuong = soLuong;
        this.thanhTien = thanhTien;
        this.ghiChu = ghiChu;
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

    public String getMaMon() {
        return maMon;
    }

    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }

    public int getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(int giaTien) {
        this.giaTien = giaTien;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(int thanhTien) {
        this.thanhTien = thanhTien;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

}
