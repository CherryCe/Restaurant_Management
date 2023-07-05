/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author CherryCe
 */
public class DTO_MonAn {

    public String maMon;
    public String tenMon;
    public String loaiMon;
    public String donViTinh;
    public int giaTien;
    public String hinhAnh;

    public DTO_MonAn() {
    }

    @Override
    public String toString() {
        return "DTO_MonAn{" + "maMon=" + maMon + ", tenMon=" + tenMon + ", loaiMon=" + loaiMon + ", donViTinh=" + donViTinh + ", giaTien=" + giaTien + ", hinhAnh=" + hinhAnh + '}';
    }

    public DTO_MonAn(String maMon, String tenMon, String loaiMon, String donViTinh, int giaTien, String hinhAnh) {
        this.maMon = maMon;
        this.tenMon = tenMon;
        this.loaiMon = loaiMon;
        this.donViTinh = donViTinh;
        this.giaTien = giaTien;
        this.hinhAnh = hinhAnh;
    }

    public String getMaMon() {
        return maMon;
    }

    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public String getLoaiMon() {
        return loaiMon;
    }

    public void setLoaiMon(String loaiMon) {
        this.loaiMon = loaiMon;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }

    public int getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(int giaTien) {
        this.giaTien = giaTien;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

}
