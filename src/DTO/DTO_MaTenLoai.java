/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author CherryCe
 */
public class DTO_MaTenLoai {

    String maLoai;
    String tenLoai;

    public DTO_MaTenLoai() {
    }

    @Override
    public String toString() {
        return "DTO_maTenLoai{" + "maLoai=" + maLoai + ", tenLoai=" + tenLoai + '}';
    }

    public DTO_MaTenLoai(String maLoai, String tenLoai) {
        this.maLoai = maLoai;
        this.tenLoai = tenLoai;
    }

    public String getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(String maLoai) {
        this.maLoai = maLoai;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

}
