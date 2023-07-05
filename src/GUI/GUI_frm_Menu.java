/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import BLL.BLL_MaTenLoai;
import HELPER.HELPER_ClockThread;
import java.awt.Color;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author ASUS
 */
public class GUI_frm_Menu extends javax.swing.JFrame {

    /**
     * Creates new form GUI_frm_Menu
     */
    public GUI_frm_Menu() {
        initComponents();
        setLocationRelativeTo(null);
        initClock();
        PhanQuyen();
    }

    public void PhanQuyen() {
        if (BLL_MaTenLoai.getPhanQuyen(GUI_frm_DangNhap.taiKhoan).equals("Quản Lý")) {
            pnlTaiKhoan.setVisible(true);
        }
        else if(BLL_MaTenLoai.getPhanQuyen(GUI_frm_DangNhap.taiKhoan).equals("Nhân Viên")){
            pnlTaiKhoan.setVisible(false);
        }
    }

    public void initClock() {
        HELPER_ClockThread clock = new HELPER_ClockThread(mnThoiGian);
        clock.start();
    }

    public void menuTrangChu() {
        GUI_frm_TrangChu trangChu = new GUI_frm_TrangChu();
        this.setVisible(false);
        trangChu.setVisible(true);
    }

    public void menuMonAn() {
        pnlChiTietMenu.removeAll();
        pnlChiTietMenu.add(new GUI_pnl_MonAn());
        pnlChiTietMenu.validate();
        pnlThucDon.setBackground(new java.awt.Color(49, 139, 130));
        pnlDanhSach.setBackground(new java.awt.Color(51, 51, 51));
        pnlDatBan.setBackground(new java.awt.Color(51, 51, 51));
        pnlHoaDon.setBackground(new java.awt.Color(51, 51, 51));
        pnlNhanVien.setBackground(new java.awt.Color(51, 51, 51));
        pnlThongKe.setBackground(new java.awt.Color(51, 51, 51));
        pnlThongTin.setBackground(new java.awt.Color(51, 51, 51));
        pnlTrangChu.setBackground(new java.awt.Color(51, 51, 51));
        pnlTaiKhoan.setBackground(new java.awt.Color(51, 51, 51));
    }

    public void menuDatBan() {
        pnlChiTietMenu.removeAll();
        pnlChiTietMenu.add(new GUI_pnl_DatBan());
        pnlChiTietMenu.validate();
        pnlDatBan.setBackground(new java.awt.Color(49, 139, 130));
        pnlDanhSach.setBackground(new java.awt.Color(51, 51, 51));
        pnlTrangChu.setBackground(new java.awt.Color(51, 51, 51));
        pnlHoaDon.setBackground(new java.awt.Color(51, 51, 51));
        pnlNhanVien.setBackground(new java.awt.Color(51, 51, 51));
        pnlThongKe.setBackground(new java.awt.Color(51, 51, 51));
        pnlThongTin.setBackground(new java.awt.Color(51, 51, 51));
        pnlThucDon.setBackground(new java.awt.Color(51, 51, 51));
        pnlTaiKhoan.setBackground(new java.awt.Color(51, 51, 51));
    }

    public void menuHoaDon() {
        pnlChiTietMenu.removeAll();
        pnlChiTietMenu.add(new GUI_pnl_HoaDon());
        pnlChiTietMenu.validate();
        pnlHoaDon.setBackground(new java.awt.Color(49, 139, 130));
        pnlDanhSach.setBackground(new java.awt.Color(51, 51, 51));
        pnlDatBan.setBackground(new java.awt.Color(51, 51, 51));
        pnlTrangChu.setBackground(new java.awt.Color(51, 51, 51));
        pnlNhanVien.setBackground(new java.awt.Color(51, 51, 51));
        pnlThongKe.setBackground(new java.awt.Color(51, 51, 51));
        pnlThongTin.setBackground(new java.awt.Color(51, 51, 51));
        pnlThucDon.setBackground(new java.awt.Color(51, 51, 51));
        pnlTaiKhoan.setBackground(new java.awt.Color(51, 51, 51));
    }

    public void menuThongKe() {
        pnlChiTietMenu.removeAll();
        pnlChiTietMenu.add(new GUI_pnl_ThongKe());
        pnlChiTietMenu.validate();
        pnlThongKe.setBackground(new java.awt.Color(49, 139, 130));
        pnlDanhSach.setBackground(new java.awt.Color(51, 51, 51));
        pnlDatBan.setBackground(new java.awt.Color(51, 51, 51));
        pnlHoaDon.setBackground(new java.awt.Color(51, 51, 51));
        pnlNhanVien.setBackground(new java.awt.Color(51, 51, 51));
        pnlTrangChu.setBackground(new java.awt.Color(51, 51, 51));
        pnlThongTin.setBackground(new java.awt.Color(51, 51, 51));
        pnlThucDon.setBackground(new java.awt.Color(51, 51, 51));
        pnlTaiKhoan.setBackground(new java.awt.Color(51, 51, 51));
    }

    public void menuNhanVien() {
        pnlChiTietMenu.removeAll();
        pnlChiTietMenu.add(new GUI_pnl_NhanVien());
        pnlChiTietMenu.validate();
        pnlNhanVien.setBackground(new java.awt.Color(49, 139, 130));
        pnlDanhSach.setBackground(new java.awt.Color(51, 51, 51));
        pnlDatBan.setBackground(new java.awt.Color(51, 51, 51));
        pnlHoaDon.setBackground(new java.awt.Color(51, 51, 51));
        pnlTrangChu.setBackground(new java.awt.Color(51, 51, 51));
        pnlThongKe.setBackground(new java.awt.Color(51, 51, 51));
        pnlThongTin.setBackground(new java.awt.Color(51, 51, 51));
        pnlThucDon.setBackground(new java.awt.Color(51, 51, 51));
        pnlTaiKhoan.setBackground(new java.awt.Color(51, 51, 51));
    }

    public void menuDanhSach() {
        pnlChiTietMenu.removeAll();
        pnlChiTietMenu.add(new GUI_pnl_DanhSach());
        pnlChiTietMenu.validate();
        pnlDanhSach.setBackground(new java.awt.Color(49, 139, 130));
        pnlTrangChu.setBackground(new java.awt.Color(51, 51, 51));
        pnlDatBan.setBackground(new java.awt.Color(51, 51, 51));
        pnlHoaDon.setBackground(new java.awt.Color(51, 51, 51));
        pnlNhanVien.setBackground(new java.awt.Color(51, 51, 51));
        pnlThongKe.setBackground(new java.awt.Color(51, 51, 51));
        pnlThongTin.setBackground(new java.awt.Color(51, 51, 51));
        pnlThucDon.setBackground(new java.awt.Color(51, 51, 51));
        pnlTaiKhoan.setBackground(new java.awt.Color(51, 51, 51));
    }

    public void menuTaiKhoan() {
        pnlChiTietMenu.removeAll();
        pnlChiTietMenu.add(new GUI_pnl_TaiKhoan());
        pnlChiTietMenu.validate();
        pnlTaiKhoan.setBackground(new java.awt.Color(49, 139, 130));
        pnlDanhSach.setBackground(new java.awt.Color(51, 51, 51));
        pnlDatBan.setBackground(new java.awt.Color(51, 51, 51));
        pnlHoaDon.setBackground(new java.awt.Color(51, 51, 51));
        pnlNhanVien.setBackground(new java.awt.Color(51, 51, 51));
        pnlThongKe.setBackground(new java.awt.Color(51, 51, 51));
        pnlTrangChu.setBackground(new java.awt.Color(51, 51, 51));
        pnlThucDon.setBackground(new java.awt.Color(51, 51, 51));
        pnlThongTin.setBackground(new java.awt.Color(51, 51, 51));
    }

    public void menuThongTin() {
        pnlChiTietMenu.removeAll();
        pnlChiTietMenu.add(new GUI_pnl_ThongTin());
        pnlChiTietMenu.validate();
        pnlThongTin.setBackground(new java.awt.Color(49, 139, 130));
        pnlDanhSach.setBackground(new java.awt.Color(51, 51, 51));
        pnlDatBan.setBackground(new java.awt.Color(51, 51, 51));
        pnlHoaDon.setBackground(new java.awt.Color(51, 51, 51));
        pnlNhanVien.setBackground(new java.awt.Color(51, 51, 51));
        pnlThongKe.setBackground(new java.awt.Color(51, 51, 51));
        pnlTrangChu.setBackground(new java.awt.Color(51, 51, 51));
        pnlThucDon.setBackground(new java.awt.Color(51, 51, 51));
        pnlTaiKhoan.setBackground(new java.awt.Color(51, 51, 51));
    }

    public void showEdge() {
        try {
            Runtime run = Runtime.getRuntime();
            String path = "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe";
            run.exec(path);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void showNetBeans() {
        try {
            Runtime run = Runtime.getRuntime();
            String path = "C:\\Program Files\\NetBeans-13\\netbeans\\bin\\netbeans64.exe";
            run.exec(path);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void showSQL() {
        try {
            Runtime run = Runtime.getRuntime();
            String path = "C:\\Program Files (x86)\\Microsoft SQL Server Management Studio 18\\Common7\\IDE\\Ssms.exe";
            run.exec(path);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void showExcel() {
        Desktop desktop = Desktop.getDesktop();
        try {
            desktop.browse(new URI("https://www.office.com/?ui=vi-VN&rs=VN&auth=1"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void showFanPage() {
        Desktop desktop = Desktop.getDesktop();
        try {
            desktop.browse(new URI("https://www.facebook.com/MrPii.2k3"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void backgroundColorBlack() {
        pnlMenu.setBackground(new java.awt.Color(51, 51, 51));
        pnlTrangChu.setBackground(new java.awt.Color(51, 51, 51));
        pnlThucDon.setBackground(new java.awt.Color(51, 51, 51));
        pnlDatBan.setBackground(new java.awt.Color(51, 51, 51));
        pnlHoaDon.setBackground(new java.awt.Color(51, 51, 51));
        pnlThongKe.setBackground(new java.awt.Color(51, 51, 51));
        pnlNhanVien.setBackground(new java.awt.Color(51, 51, 51));
        pnlDanhSach.setBackground(new java.awt.Color(51, 51, 51));
        pnlTaiKhoan.setBackground(new java.awt.Color(51, 51, 51));
        pnlThongTin.setBackground(new java.awt.Color(51, 51, 51));
    }

    public void backgroundColorGreen() {
        pnlMenu.setBackground(Color.GREEN);
        pnlTrangChu.setBackground(Color.GREEN);
        pnlThucDon.setBackground(Color.GREEN);
        pnlDatBan.setBackground(Color.GREEN);
        pnlHoaDon.setBackground(Color.GREEN);
        pnlThongKe.setBackground(Color.GREEN);
        pnlNhanVien.setBackground(Color.GREEN);
        pnlDanhSach.setBackground(Color.GREEN);
        pnlTaiKhoan.setBackground(Color.GREEN);
        pnlThongTin.setBackground(Color.GREEN);
    }

    public void backgroundColorRed() {
        pnlMenu.setBackground(Color.RED);
        pnlTrangChu.setBackground(Color.RED);
        pnlThucDon.setBackground(Color.RED);
        pnlDatBan.setBackground(Color.RED);
        pnlHoaDon.setBackground(Color.RED);
        pnlThongKe.setBackground(Color.RED);
        pnlNhanVien.setBackground(Color.RED);
        pnlDanhSach.setBackground(Color.RED);
        pnlTaiKhoan.setBackground(Color.RED);
        pnlThongTin.setBackground(Color.RED);
    }

    public void backgroundColorYellow() {
        pnlMenu.setBackground(Color.YELLOW);
        pnlTrangChu.setBackground(Color.YELLOW);
        pnlThucDon.setBackground(Color.YELLOW);
        pnlDatBan.setBackground(Color.YELLOW);
        pnlHoaDon.setBackground(Color.YELLOW);
        pnlThongKe.setBackground(Color.YELLOW);
        pnlNhanVien.setBackground(Color.YELLOW);
        pnlDanhSach.setBackground(Color.YELLOW);
        pnlTaiKhoan.setBackground(Color.YELLOW);
        pnlThongTin.setBackground(Color.YELLOW);
    }

    public void showHiddenToolbar() {
        if (!mni_chbToolbar.isSelected()) {
            pnlMenu.setVisible(false);
            mni_chbToolbar.setText("Hiện Toolbar");

        } else {
            pnlMenu.setVisible(true);
            mni_chbToolbar.setText("Ẩn Toolbar");

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grpColor = new javax.swing.ButtonGroup();
        pnlMenu = new javax.swing.JPanel();
        pnlTrangChu = new javax.swing.JPanel();
        lblIconTrangChu = new javax.swing.JLabel();
        lblTrangChu = new javax.swing.JLabel();
        pnlThucDon = new javax.swing.JPanel();
        lblIconThucDon = new javax.swing.JLabel();
        lblThucDon = new javax.swing.JLabel();
        pnlDatBan = new javax.swing.JPanel();
        lblIconDatBan = new javax.swing.JLabel();
        lblDatBan = new javax.swing.JLabel();
        pnlHoaDon = new javax.swing.JPanel();
        pnlIconHoaDon = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblHoaDon = new javax.swing.JLabel();
        pnlThongKe = new javax.swing.JPanel();
        lblIconThongKe = new javax.swing.JLabel();
        lblThongKe = new javax.swing.JLabel();
        pnlNhanVien = new javax.swing.JPanel();
        lblIconNhanVien = new javax.swing.JLabel();
        lblNhanVien = new javax.swing.JLabel();
        pnlDanhSach = new javax.swing.JPanel();
        lblIconDanhSach = new javax.swing.JLabel();
        lblDanhSach = new javax.swing.JLabel();
        pnlThongTin = new javax.swing.JPanel();
        lblIconThongTin = new javax.swing.JLabel();
        lblThongTin = new javax.swing.JLabel();
        pnlTaiKhoan = new javax.swing.JPanel();
        lblIconTaiKhoan = new javax.swing.JLabel();
        lblTaiKhoan = new javax.swing.JLabel();
        pnlChiTietMenu = new javax.swing.JPanel();
        mnbMenuBar = new javax.swing.JMenuBar();
        mnMenu = new javax.swing.JMenu();
        mniTrangChu = new javax.swing.JMenuItem();
        mniThucDon = new javax.swing.JMenuItem();
        mniDatban = new javax.swing.JMenuItem();
        mniHoaDon = new javax.swing.JMenuItem();
        mniThongKe = new javax.swing.JMenuItem();
        mniNhanVien = new javax.swing.JMenuItem();
        mniDanhSach = new javax.swing.JMenuItem();
        mniTaiKhoan = new javax.swing.JMenuItem();
        mniThongTin = new javax.swing.JMenuItem();
        mniDangXuat = new javax.swing.JMenuItem();
        mniThoat = new javax.swing.JMenuItem();
        mnChucNang = new javax.swing.JMenu();
        mniXuatFile = new javax.swing.JMenuItem();
        mniXuatHoaDon = new javax.swing.JMenuItem();
        mniBieuDo = new javax.swing.JMenuItem();
        mniDoiMatKhau = new javax.swing.JMenuItem();
        mnHienThi = new javax.swing.JMenu();
        mni_chbToolbar = new javax.swing.JCheckBoxMenuItem();
        mnChonMau = new javax.swing.JMenu();
        mni_rdoDen = new javax.swing.JRadioButtonMenuItem();
        mni_rdoXanh = new javax.swing.JRadioButtonMenuItem();
        mni_rdoDo = new javax.swing.JRadioButtonMenuItem();
        mni_rdoVang = new javax.swing.JRadioButtonMenuItem();
        mnUngDung = new javax.swing.JMenu();
        mniEdge = new javax.swing.JMenuItem();
        mniNetbeans = new javax.swing.JMenuItem();
        mniSql = new javax.swing.JMenuItem();
        mniExcel = new javax.swing.JMenuItem();
        mnGiupDo = new javax.swing.JMenu();
        mniVe = new javax.swing.JMenuItem();
        mniBaoCao = new javax.swing.JMenuItem();
        mniWebsite = new javax.swing.JMenuItem();
        mnBackSpace = new javax.swing.JMenu();
        mnThoiGian = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1100, 610));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlMenu.setBackground(new java.awt.Color(51, 51, 51));

        pnlTrangChu.setBackground(new java.awt.Color(51, 51, 51));
        pnlTrangChu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlTrangChuMouseClicked(evt);
            }
        });
        pnlTrangChu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblIconTrangChu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/home_23px.png"))); // NOI18N
        pnlTrangChu.add(lblIconTrangChu, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 10, 30, 30));

        lblTrangChu.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        lblTrangChu.setForeground(new java.awt.Color(255, 255, 255));
        lblTrangChu.setText("Trang Chủ");
        pnlTrangChu.add(lblTrangChu, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 110, 50));

        pnlThucDon.setBackground(new java.awt.Color(51, 51, 51));
        pnlThucDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlThucDonMouseClicked(evt);
            }
        });
        pnlThucDon.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblIconThucDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Menu_23px.png"))); // NOI18N
        pnlThucDon.add(lblIconThucDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 10, 30, 30));

        lblThucDon.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        lblThucDon.setForeground(new java.awt.Color(255, 255, 255));
        lblThucDon.setText("Món Ăn");
        pnlThucDon.add(lblThucDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 110, 50));

        pnlDatBan.setBackground(new java.awt.Color(51, 51, 51));
        pnlDatBan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlDatBanMouseClicked(evt);
            }
        });
        pnlDatBan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblIconDatBan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/table_23px.png"))); // NOI18N
        pnlDatBan.add(lblIconDatBan, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 10, 30, 30));

        lblDatBan.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        lblDatBan.setForeground(new java.awt.Color(255, 255, 255));
        lblDatBan.setText("Đặt Bàn");
        pnlDatBan.add(lblDatBan, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 110, 50));

        pnlHoaDon.setBackground(new java.awt.Color(51, 51, 51));
        pnlHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlHoaDonMouseClicked(evt);
            }
        });
        pnlHoaDon.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlIconHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/bills_23px.png"))); // NOI18N
        pnlHoaDon.add(pnlIconHoaDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 10, 30, 30));

        jLabel11.setBackground(new java.awt.Color(153, 0, 0));
        pnlHoaDon.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, 50));

        lblHoaDon.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        lblHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        lblHoaDon.setText("Hóa Ðơn");
        pnlHoaDon.add(lblHoaDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 110, 50));

        pnlThongKe.setBackground(new java.awt.Color(51, 51, 51));
        pnlThongKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlThongKeMouseClicked(evt);
            }
        });
        pnlThongKe.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblIconThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Money_23px.png"))); // NOI18N
        pnlThongKe.add(lblIconThongKe, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 10, 30, 30));

        lblThongKe.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        lblThongKe.setForeground(new java.awt.Color(255, 255, 255));
        lblThongKe.setText("Thống Kê");
        pnlThongKe.add(lblThongKe, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 110, 50));

        pnlNhanVien.setBackground(new java.awt.Color(51, 51, 51));
        pnlNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlNhanVienMouseClicked(evt);
            }
        });
        pnlNhanVien.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblIconNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/management_23px.png"))); // NOI18N
        pnlNhanVien.add(lblIconNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 10, 30, 30));

        lblNhanVien.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        lblNhanVien.setForeground(new java.awt.Color(255, 255, 255));
        lblNhanVien.setText("Nhân Viên");
        pnlNhanVien.add(lblNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 110, 50));

        pnlDanhSach.setBackground(new java.awt.Color(51, 51, 51));
        pnlDanhSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlDanhSachMouseClicked(evt);
            }
        });
        pnlDanhSach.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblIconDanhSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/list-ingredients-24.png"))); // NOI18N
        pnlDanhSach.add(lblIconDanhSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 10, 30, 30));

        lblDanhSach.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        lblDanhSach.setForeground(new java.awt.Color(255, 255, 255));
        lblDanhSach.setText("Danh Sách");
        lblDanhSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDanhSachMouseClicked(evt);
            }
        });
        pnlDanhSach.add(lblDanhSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 110, 50));

        pnlThongTin.setBackground(new java.awt.Color(51, 51, 51));
        pnlThongTin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlThongTinMouseClicked(evt);
            }
        });
        pnlThongTin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblIconThongTin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/info_24px.png"))); // NOI18N
        pnlThongTin.add(lblIconThongTin, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 10, 30, 30));

        lblThongTin.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        lblThongTin.setForeground(new java.awt.Color(255, 255, 255));
        lblThongTin.setText("Thông Tin");
        pnlThongTin.add(lblThongTin, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 110, 50));

        pnlTaiKhoan.setBackground(new java.awt.Color(51, 51, 51));
        pnlTaiKhoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlTaiKhoanMouseClicked(evt);
            }
        });
        pnlTaiKhoan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblIconTaiKhoan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/reviewer-24.png"))); // NOI18N
        pnlTaiKhoan.add(lblIconTaiKhoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 10, 30, 30));

        lblTaiKhoan.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        lblTaiKhoan.setForeground(new java.awt.Color(255, 255, 255));
        lblTaiKhoan.setText("Tài Khoản");
        pnlTaiKhoan.add(lblTaiKhoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 110, 50));

        javax.swing.GroupLayout pnlMenuLayout = new javax.swing.GroupLayout(pnlMenu);
        pnlMenu.setLayout(pnlMenuLayout);
        pnlMenuLayout.setHorizontalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlTrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(pnlThucDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(pnlDatBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(pnlHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(pnlThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(pnlNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(pnlDanhSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(pnlTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(pnlThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pnlMenuLayout.setVerticalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(pnlTrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlThucDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlDatBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlDanhSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        getContentPane().add(pnlMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 610));

        pnlChiTietMenu.setBackground(new java.awt.Color(255, 255, 255));
        pnlChiTietMenu.setLayout(new java.awt.CardLayout());
        getContentPane().add(pnlChiTietMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 930, 610));

        mnbMenuBar.setPreferredSize(new java.awt.Dimension(1120, 30));

        mnMenu.setText("Menu");

        mniTrangChu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mniTrangChu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/House-icon.png"))); // NOI18N
        mniTrangChu.setText("Trang chủ");
        mniTrangChu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniTrangChuActionPerformed(evt);
            }
        });
        mnMenu.add(mniTrangChu);

        mniThucDon.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mniThucDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/hamburger-icon.png"))); // NOI18N
        mniThucDon.setText("Thực đơn");
        mniThucDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniThucDonActionPerformed(evt);
            }
        });
        mnMenu.add(mniThucDon);

        mniDatban.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_3, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mniDatban.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Checklist-icon-24px.png"))); // NOI18N
        mniDatban.setText("Đặt bàn");
        mniDatban.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniDatbanActionPerformed(evt);
            }
        });
        mnMenu.add(mniDatban);

        mniHoaDon.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_4, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mniHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/icons8-billing-machine-32.png"))); // NOI18N
        mniHoaDon.setText("Hóa đơn");
        mniHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniHoaDonActionPerformed(evt);
            }
        });
        mnMenu.add(mniHoaDon);

        mniThongKe.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_5, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mniThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Misc-Stats-icon.png"))); // NOI18N
        mniThongKe.setText("Thống kê");
        mniThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniThongKeActionPerformed(evt);
            }
        });
        mnMenu.add(mniThongKe);

        mniNhanVien.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_6, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mniNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Users-icon-24.png"))); // NOI18N
        mniNhanVien.setText("Nhân viên");
        mniNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniNhanVienActionPerformed(evt);
            }
        });
        mnMenu.add(mniNhanVien);

        mniDanhSach.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_7, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mniDanhSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/App-list-manager-icon.png"))); // NOI18N
        mniDanhSach.setText("Danh sách");
        mniDanhSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniDanhSachActionPerformed(evt);
            }
        });
        mnMenu.add(mniDanhSach);

        mniTaiKhoan.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_8, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mniTaiKhoan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/user-settings-icon-24px.png"))); // NOI18N
        mniTaiKhoan.setText("Tài khoản");
        mniTaiKhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniTaiKhoanActionPerformed(evt);
            }
        });
        mnMenu.add(mniTaiKhoan);

        mniThongTin.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_9, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mniThongTin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/information-icon.png"))); // NOI18N
        mniThongTin.setText("Thông tin");
        mniThongTin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniThongTinActionPerformed(evt);
            }
        });
        mnMenu.add(mniThongTin);

        mniDangXuat.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mniDangXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Log-Out-icon.png"))); // NOI18N
        mniDangXuat.setText("Đăng xuất");
        mniDangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniDangXuatActionPerformed(evt);
            }
        });
        mnMenu.add(mniDangXuat);

        mniThoat.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mniThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Button-Close-icon.png"))); // NOI18N
        mniThoat.setText("Thoát");
        mniThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniThoatActionPerformed(evt);
            }
        });
        mnMenu.add(mniThoat);

        mnbMenuBar.add(mnMenu);

        mnChucNang.setText("Chức Năng");
        mnChucNang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnChucNangMouseClicked(evt);
            }
        });
        mnChucNang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnChucNangActionPerformed(evt);
            }
        });

        mniXuatFile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mniXuatFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Microsoft-Excel-2013-icon.png"))); // NOI18N
        mniXuatFile.setText("Xuất File Excel");
        mniXuatFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniXuatFileActionPerformed(evt);
            }
        });
        mnChucNang.add(mniXuatFile);

        mniXuatHoaDon.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mniXuatHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/folder-orange-open-icon.png"))); // NOI18N
        mniXuatHoaDon.setText("Xuất Hóa Ðơn");
        mnChucNang.add(mniXuatHoaDon);

        mniBieuDo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mniBieuDo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Actions-office-chart-bar-icon.png"))); // NOI18N
        mniBieuDo.setText("Biểu Ðồ Thống Kê");
        mnChucNang.add(mniBieuDo);

        mniDoiMatKhau.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mniDoiMatKhau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/change-password-icon.png"))); // NOI18N
        mniDoiMatKhau.setText("Đổi Mật Khẩu");
        mnChucNang.add(mniDoiMatKhau);

        mnbMenuBar.add(mnChucNang);

        mnHienThi.setText("Hiển Thị");
        mnHienThi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnHienThiMouseClicked(evt);
            }
        });
        mnHienThi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnHienThiActionPerformed(evt);
            }
        });

        mni_chbToolbar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mni_chbToolbar.setSelected(true);
        mni_chbToolbar.setText("Ẩn Toolbar");
        mni_chbToolbar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Programming-Show-Property-icon.png"))); // NOI18N
        mni_chbToolbar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mni_chbToolbarActionPerformed(evt);
            }
        });
        mnHienThi.add(mni_chbToolbar);

        mnChonMau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Color-Meter-icon.png"))); // NOI18N
        mnChonMau.setText("Chọn Màu");

        mni_rdoDen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        grpColor.add(mni_rdoDen);
        mni_rdoDen.setSelected(true);
        mni_rdoDen.setText("Đen");
        mni_rdoDen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Heart-black-icon.png"))); // NOI18N
        mni_rdoDen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mni_rdoDenActionPerformed(evt);
            }
        });
        mnChonMau.add(mni_rdoDen);

        mni_rdoXanh.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        grpColor.add(mni_rdoXanh);
        mni_rdoXanh.setText("Xanh");
        mni_rdoXanh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Heart-green-icon.png"))); // NOI18N
        mni_rdoXanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mni_rdoXanhActionPerformed(evt);
            }
        });
        mnChonMau.add(mni_rdoXanh);

        mni_rdoDo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        grpColor.add(mni_rdoDo);
        mni_rdoDo.setText("Đỏ");
        mni_rdoDo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Heart-red-icon.png"))); // NOI18N
        mni_rdoDo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mni_rdoDoActionPerformed(evt);
            }
        });
        mnChonMau.add(mni_rdoDo);

        mni_rdoVang.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        grpColor.add(mni_rdoVang);
        mni_rdoVang.setText("Vàng");
        mni_rdoVang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/heart-yellow-5-icon.png"))); // NOI18N
        mni_rdoVang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mni_rdoVangActionPerformed(evt);
            }
        });
        mnChonMau.add(mni_rdoVang);

        mnHienThi.add(mnChonMau);

        mnbMenuBar.add(mnHienThi);

        mnUngDung.setText("Mở Ứng Dụng");

        mniEdge.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mniEdge.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/icons8-microsoft-edge-24.png"))); // NOI18N
        mniEdge.setText("Edge Browser");
        mniEdge.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mniEdgeMouseClicked(evt);
            }
        });
        mniEdge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniEdgeActionPerformed(evt);
            }
        });
        mnUngDung.add(mniEdge);

        mniNetbeans.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mniNetbeans.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Java-icon.png"))); // NOI18N
        mniNetbeans.setText("NetBeans IDE");
        mniNetbeans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniNetbeansActionPerformed(evt);
            }
        });
        mnUngDung.add(mniNetbeans);

        mniSql.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mniSql.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Sql-runner-icon.png"))); // NOI18N
        mniSql.setText("SQL Server");
        mniSql.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniSqlActionPerformed(evt);
            }
        });
        mnUngDung.add(mniSql);

        mniExcel.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mniExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Microsoft-Excel-2013-icon.png"))); // NOI18N
        mniExcel.setText("MS Excel");
        mniExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniExcelActionPerformed(evt);
            }
        });
        mnUngDung.add(mniExcel);

        mnbMenuBar.add(mnUngDung);

        mnGiupDo.setBorder(null);
        mnGiupDo.setText("Giúp Ðỡ");

        mniVe.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mniVe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Button-Help-icon.png"))); // NOI18N
        mniVe.setText("Về");
        mniVe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniVeActionPerformed(evt);
            }
        });
        mnGiupDo.add(mniVe);

        mniBaoCao.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mniBaoCao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Places-folder-important-icon.png"))); // NOI18N
        mniBaoCao.setText("Báo Cáo");
        mniBaoCao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniBaoCaoActionPerformed(evt);
            }
        });
        mnGiupDo.add(mniBaoCao);

        mniWebsite.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mniWebsite.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Mail-icon.png"))); // NOI18N
        mniWebsite.setText("Website");
        mniWebsite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniWebsiteActionPerformed(evt);
            }
        });
        mnGiupDo.add(mniWebsite);

        mnbMenuBar.add(mnGiupDo);

        mnBackSpace.setText("                                                                                                                                                                                                                   ");
        mnBackSpace.setEnabled(false);
        mnbMenuBar.add(mnBackSpace);

        mnThoiGian.setText("DD/MM/YYYY HH:MM:SS");
        mnbMenuBar.add(mnThoiGian);

        setJMenuBar(mnbMenuBar);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void pnlTrangChuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlTrangChuMouseClicked
        menuTrangChu();
    }//GEN-LAST:event_pnlTrangChuMouseClicked

    private void pnlThucDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlThucDonMouseClicked
        menuMonAn();
    }//GEN-LAST:event_pnlThucDonMouseClicked

    private void pnlNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlNhanVienMouseClicked
        menuNhanVien();
    }//GEN-LAST:event_pnlNhanVienMouseClicked

    private void pnlThongKeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlThongKeMouseClicked
        menuThongKe();
    }//GEN-LAST:event_pnlThongKeMouseClicked

    private void pnlDatBanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlDatBanMouseClicked
        menuDatBan();
    }//GEN-LAST:event_pnlDatBanMouseClicked

    private void pnlHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlHoaDonMouseClicked
        menuHoaDon();
    }//GEN-LAST:event_pnlHoaDonMouseClicked

    private void pnlDanhSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlDanhSachMouseClicked
        menuDanhSach();
    }//GEN-LAST:event_pnlDanhSachMouseClicked

    private void pnlThongTinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlThongTinMouseClicked
        menuThongTin();
    }//GEN-LAST:event_pnlThongTinMouseClicked

    private void pnlTaiKhoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlTaiKhoanMouseClicked
        menuTaiKhoan();
    }//GEN-LAST:event_pnlTaiKhoanMouseClicked

    private void mnHienThiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnHienThiMouseClicked

    }//GEN-LAST:event_mnHienThiMouseClicked

    private void mnHienThiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnHienThiActionPerformed

    }//GEN-LAST:event_mnHienThiActionPerformed

    private void mniWebsiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniWebsiteActionPerformed
        showFanPage();
    }//GEN-LAST:event_mniWebsiteActionPerformed

    private void mnChucNangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnChucNangActionPerformed

    }//GEN-LAST:event_mnChucNangActionPerformed

    private void mnChucNangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnChucNangMouseClicked

    }//GEN-LAST:event_mnChucNangMouseClicked

    private void mniExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniExcelActionPerformed
        showExcel();
    }//GEN-LAST:event_mniExcelActionPerformed

    private void mniEdgeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mniEdgeMouseClicked

    }//GEN-LAST:event_mniEdgeMouseClicked

    private void mniEdgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniEdgeActionPerformed
        showEdge();
    }//GEN-LAST:event_mniEdgeActionPerformed

    private void mniNetbeansActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniNetbeansActionPerformed
        showNetBeans();
    }//GEN-LAST:event_mniNetbeansActionPerformed

    private void mniSqlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniSqlActionPerformed
        showSQL();
    }//GEN-LAST:event_mniSqlActionPerformed

    private void mni_rdoXanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mni_rdoXanhActionPerformed
        backgroundColorGreen();
    }//GEN-LAST:event_mni_rdoXanhActionPerformed

    private void mni_rdoVangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mni_rdoVangActionPerformed
        backgroundColorYellow();
    }//GEN-LAST:event_mni_rdoVangActionPerformed

    private void mni_rdoDoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mni_rdoDoActionPerformed
        backgroundColorRed();
    }//GEN-LAST:event_mni_rdoDoActionPerformed

    private void mni_rdoDenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mni_rdoDenActionPerformed
        backgroundColorBlack();
    }//GEN-LAST:event_mni_rdoDenActionPerformed

    private void mni_chbToolbarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mni_chbToolbarActionPerformed
        showHiddenToolbar();
    }//GEN-LAST:event_mni_chbToolbarActionPerformed

    private void mniTrangChuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniTrangChuActionPerformed
        menuTrangChu();
    }//GEN-LAST:event_mniTrangChuActionPerformed

    private void mniThucDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniThucDonActionPerformed
        menuMonAn();
    }//GEN-LAST:event_mniThucDonActionPerformed

    private void mniDatbanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniDatbanActionPerformed
        menuDatBan();
    }//GEN-LAST:event_mniDatbanActionPerformed

    private void mniHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniHoaDonActionPerformed
        menuHoaDon();
    }//GEN-LAST:event_mniHoaDonActionPerformed

    private void mniThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniThongKeActionPerformed
        menuThongKe();
    }//GEN-LAST:event_mniThongKeActionPerformed

    private void mniNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniNhanVienActionPerformed
        menuNhanVien();
    }//GEN-LAST:event_mniNhanVienActionPerformed

    private void mniDanhSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniDanhSachActionPerformed
        menuDanhSach();
    }//GEN-LAST:event_mniDanhSachActionPerformed

    private void mniTaiKhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniTaiKhoanActionPerformed
        menuTaiKhoan();
    }//GEN-LAST:event_mniTaiKhoanActionPerformed

    private void mniThongTinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniThongTinActionPerformed
        menuThongTin();
    }//GEN-LAST:event_mniThongTinActionPerformed

    private void mniDangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniDangXuatActionPerformed
        this.setVisible(false);
        new GUI_frm_TrangChu().dangXuat();
    }//GEN-LAST:event_mniDangXuatActionPerformed

    private void mniThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniThoatActionPerformed
        new GUI_frm_TrangChu().thoat();
    }//GEN-LAST:event_mniThoatActionPerformed

    private void mniBaoCaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniBaoCaoActionPerformed
        new GUI_frm_MailClient().setVisible(true);
    }//GEN-LAST:event_mniBaoCaoActionPerformed

    private void mniVeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniVeActionPerformed
        new GUI_pnl_MonAn().setVisible(true);
    }//GEN-LAST:event_mniVeActionPerformed

    private void mniXuatFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniXuatFileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mniXuatFileActionPerformed

    private void lblDanhSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDanhSachMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblDanhSachMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI_frm_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_frm_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_frm_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_frm_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_frm_Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup grpColor;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel lblDanhSach;
    private javax.swing.JLabel lblDatBan;
    private javax.swing.JLabel lblHoaDon;
    private javax.swing.JLabel lblIconDanhSach;
    private javax.swing.JLabel lblIconDatBan;
    private javax.swing.JLabel lblIconNhanVien;
    private javax.swing.JLabel lblIconTaiKhoan;
    private javax.swing.JLabel lblIconThongKe;
    private javax.swing.JLabel lblIconThongTin;
    private javax.swing.JLabel lblIconThucDon;
    private javax.swing.JLabel lblIconTrangChu;
    private javax.swing.JLabel lblNhanVien;
    private javax.swing.JLabel lblTaiKhoan;
    private javax.swing.JLabel lblThongKe;
    private javax.swing.JLabel lblThongTin;
    private javax.swing.JLabel lblThucDon;
    private javax.swing.JLabel lblTrangChu;
    private javax.swing.JMenu mnBackSpace;
    private javax.swing.JMenu mnChonMau;
    private javax.swing.JMenu mnChucNang;
    private javax.swing.JMenu mnGiupDo;
    private javax.swing.JMenu mnHienThi;
    private javax.swing.JMenu mnMenu;
    public javax.swing.JMenu mnThoiGian;
    private javax.swing.JMenu mnUngDung;
    private javax.swing.JMenuBar mnbMenuBar;
    private javax.swing.JMenuItem mniBaoCao;
    private javax.swing.JMenuItem mniBieuDo;
    private javax.swing.JMenuItem mniDangXuat;
    private javax.swing.JMenuItem mniDanhSach;
    private javax.swing.JMenuItem mniDatban;
    private javax.swing.JMenuItem mniDoiMatKhau;
    private javax.swing.JMenuItem mniEdge;
    private javax.swing.JMenuItem mniExcel;
    private javax.swing.JMenuItem mniHoaDon;
    private javax.swing.JMenuItem mniNetbeans;
    private javax.swing.JMenuItem mniNhanVien;
    private javax.swing.JMenuItem mniSql;
    private javax.swing.JMenuItem mniTaiKhoan;
    private javax.swing.JMenuItem mniThoat;
    private javax.swing.JMenuItem mniThongKe;
    private javax.swing.JMenuItem mniThongTin;
    private javax.swing.JMenuItem mniThucDon;
    private javax.swing.JMenuItem mniTrangChu;
    private javax.swing.JMenuItem mniVe;
    private javax.swing.JMenuItem mniWebsite;
    private javax.swing.JMenuItem mniXuatFile;
    private javax.swing.JMenuItem mniXuatHoaDon;
    private javax.swing.JCheckBoxMenuItem mni_chbToolbar;
    private javax.swing.JRadioButtonMenuItem mni_rdoDen;
    private javax.swing.JRadioButtonMenuItem mni_rdoDo;
    private javax.swing.JRadioButtonMenuItem mni_rdoVang;
    private javax.swing.JRadioButtonMenuItem mni_rdoXanh;
    private javax.swing.JPanel pnlChiTietMenu;
    private javax.swing.JPanel pnlDanhSach;
    private javax.swing.JPanel pnlDatBan;
    private javax.swing.JPanel pnlHoaDon;
    private javax.swing.JLabel pnlIconHoaDon;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JPanel pnlNhanVien;
    private javax.swing.JPanel pnlTaiKhoan;
    private javax.swing.JPanel pnlThongKe;
    private javax.swing.JPanel pnlThongTin;
    private javax.swing.JPanel pnlThucDon;
    private javax.swing.JPanel pnlTrangChu;
    // End of variables declaration//GEN-END:variables
}
