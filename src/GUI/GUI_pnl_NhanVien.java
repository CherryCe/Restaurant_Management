/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import BLL.BLL_MaTenLoai;
import BLL.BLL_NhanVien;
import BLL.BLL_TaiKhoan;
import DTO.DTO_NhanVien;
import DTO.DTO_TaiKhoan;
import HELPER.HELPER_ChuyenDoi;
import HELPER.HELPER_ShowHinhAnh;
import java.awt.Image;
import java.io.File;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author CherryCe
 */
public class GUI_pnl_NhanVien extends javax.swing.JPanel {

    String Url;
    int index = -1;

    /**
     * Creates new form pnl_NhanVien
     */
    public GUI_pnl_NhanVien() {
        initComponents();
        load();
        loadMaNhanVien();
        GUI_frm_DangNhap.isPhanQuyen(btnThem, btnXoa, btnSua);
        valiDate();
    }

    public void valiDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -18);
        dateThoiGian.setMaxSelectableDate(calendar.getTime());
    }

    public void add() {
        DTO_NhanVien nhanVien = new DTO_NhanVien(String.valueOf(cboMaNhanVien.getSelectedItem()), txtHoVaTen.getText(), dateThoiGian.getDate(), txtSoDienThoai.getText(), txtDiaChi.getText(), rdoNam.isSelected() ? "Nam" : "Nữ", Url);
        if (dateThoiGian.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Dữ Liệu Không Được Để Trống !!!");
            return;
        }
        if (txtSoDienThoai.getText().length() > 10) {
            JOptionPane.showMessageDialog(this, "Lỗi Định Dạng Số ???");
            return;
        } else {
            BLL_NhanVien.add(nhanVien);
            btnThem.setEnabled(false);
        }
    }

    public void delete(int index) {
        if (index < 0) {
            JOptionPane.showMessageDialog(this, "Bạn Chưa Chọn Dòng Cần Sửa");
        } else {
            int choice = JOptionPane.showConfirmDialog(this, "Bạn Có Muốn Xóa Không ?", "Xóa", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                int indexs[] = tblNhanVien.getSelectedRows();
                for (int i = 0; i < indexs.length; i++) {
                    String maNhanVien = tblNhanVien.getValueAt(indexs[i], 0).toString();
                    BLL_NhanVien.delete(maNhanVien);
                }
            }
            return;
        }
    }

    public void edit(int index) {
        if (index < 0) {
            JOptionPane.showMessageDialog(this, "Bạn Chưa Chọn Dòng Cần Sửa");
        }
        DTO_NhanVien nhanVien = new DTO_NhanVien(String.valueOf(cboMaNhanVien.getSelectedItem()), txtHoVaTen.getText(), dateThoiGian.getDate(), txtSoDienThoai.getText(), txtDiaChi.getText(), rdoNam.isSelected() ? "Nam" : "Nữ", Url);
        BLL_NhanVien.edit(nhanVien);
    }

    public void search() {
        if (txtTimKiem.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tìm Kiếm Không Được Để Trống");
        } else {
            ArrayList<DTO_NhanVien> array = BLL_NhanVien.search(txtTimKiem.getText());
            BLL_NhanVien.load(array, tblNhanVien);
        }
    }

    public void reset() {
        cboMaNhanVien.setSelectedItem(null);
        txtHoVaTen.setText(null);
        dateThoiGian.setDate(null);
        txtSoDienThoai.setText(null);
        txtDiaChi.setText(null);
        rdoNam.setSelected(true);
        lblHinhAnh.setIcon(null);
        Url = null;
        txtTimKiem.setText(null);
    }

    public void fill(int index) {
        cboMaNhanVien.setSelectedItem(tblNhanVien.getValueAt(index, 0).toString());
        txtHoVaTen.setText(tblNhanVien.getValueAt(index, 1).toString());
        dateThoiGian.setDate(HELPER_ChuyenDoi.LayNgayDate(tblNhanVien.getValueAt(index, 2).toString()));
        txtSoDienThoai.setText(tblNhanVien.getValueAt(index, 3).toString());
        txtDiaChi.setText(tblNhanVien.getValueAt(index, 4).toString());
        String sex = tblNhanVien.getValueAt(index, 5).toString();
        if (sex.equals("Nam")) {
            rdoNam.setSelected(true);
        } else if (sex.equals("Nữ")) {
            rdoNu.setSelected(true);
        }
        lblHinhAnh.setIcon(new HELPER_ShowHinhAnh().resizeImage(tblNhanVien.getValueAt(index, 6).toString(), lblHinhAnh));
    }

    public void open() {
        try {
            JFileChooser chooser = new JFileChooser("C:\\Users\\CherryCe\\Documents\\JAVA\\SOF203_ASM\\src\\AVATAR");
            chooser.setDialogTitle("Open File");
            chooser.showOpenDialog(this);
            File nameIMG = chooser.getSelectedFile();
            Url = nameIMG.getAbsolutePath();
            if (Url != null) {
                JOptionPane.showMessageDialog(this, "Add IMG Complete");
                lblHinhAnh.setIcon(new HELPER_ShowHinhAnh().resizeImage(Url, lblHinhAnh));
            } else {
                JOptionPane.showMessageDialog(this, "Add IMG Failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void load() {
        ArrayList<DTO_NhanVien> array = BLL_NhanVien.select();
        BLL_NhanVien.load(array, tblNhanVien);
        rdoNam.setSelected(true);
    }

    public void loadMaNhanVien() {
        ArrayList<DTO_NhanVien> array = BLL_NhanVien.selectMaNhanVien();
        BLL_NhanVien.loadMaNhanVien(array, cboMaNhanVien);
    }

    public void exit() {
        int choice = JOptionPane.showConfirmDialog(this, "Bạn Có Muốn Thoát Chương Trình ?", "Thoát", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
        return;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grpGioiTinh = new javax.swing.ButtonGroup();
        pnlNhanVien = new javax.swing.JPanel();
        scrNhanVien = new javax.swing.JScrollPane();
        tblNhanVien = new javax.swing.JTable();
        pnlFormChinh = new javax.swing.JPanel();
        lblMaNhanVien = new javax.swing.JLabel();
        lblHoVaTen = new javax.swing.JLabel();
        lblGioiTinh = new javax.swing.JLabel();
        lblNgaySinh = new javax.swing.JLabel();
        lblSoDienThoai = new javax.swing.JLabel();
        lblDiaChi = new javax.swing.JLabel();
        txtHoVaTen = new javax.swing.JTextField();
        txtSoDienThoai = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        lblThongTin = new javax.swing.JLabel();
        lblThoat = new javax.swing.JLabel();
        lblHinhAnh = new javax.swing.JLabel();
        btnMoHinh = new javax.swing.JButton();
        dateThoiGian = new com.toedter.calendar.JDateChooser();
        lblTieuDe = new javax.swing.JLabel();
        cboMaNhanVien = new javax.swing.JComboBox<>();
        pnlChucNang = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        pnlTimKiem = new javax.swing.JPanel();
        btnTimKiem = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();

        pnlNhanVien.setBackground(new java.awt.Color(255, 255, 255));
        pnlNhanVien.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblNhanVien.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Nhân Viên", "Họ Và Tên", "Ngày Sinh", "SÐT", "Địa Chỉ", "Giới Tính", "Hình Ảnh"
            }
        ));
        tblNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhanVienMouseClicked(evt);
            }
        });
        scrNhanVien.setViewportView(tblNhanVien);

        pnlNhanVien.add(scrNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 900, 240));

        pnlFormChinh.setBackground(new java.awt.Color(255, 255, 255));
        pnlFormChinh.setForeground(new java.awt.Color(49, 139, 130));
        pnlFormChinh.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblMaNhanVien.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblMaNhanVien.setForeground(new java.awt.Color(49, 139, 130));
        lblMaNhanVien.setText("Mã Nhân Viên:");
        pnlFormChinh.add(lblMaNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, 30));

        lblHoVaTen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblHoVaTen.setForeground(new java.awt.Color(49, 139, 130));
        lblHoVaTen.setText("Họ Và Tên:");
        pnlFormChinh.add(lblHoVaTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, 30));

        lblGioiTinh.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblGioiTinh.setForeground(new java.awt.Color(49, 139, 130));
        lblGioiTinh.setText("Giới Tính:");
        pnlFormChinh.add(lblGioiTinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, 29));

        lblNgaySinh.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNgaySinh.setForeground(new java.awt.Color(49, 139, 130));
        lblNgaySinh.setText("Ngày Sinh:");
        pnlFormChinh.add(lblNgaySinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, 30));

        lblSoDienThoai.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblSoDienThoai.setForeground(new java.awt.Color(49, 139, 130));
        lblSoDienThoai.setText("Số Ðiện Thoại:");
        pnlFormChinh.add(lblSoDienThoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, 30));

        lblDiaChi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblDiaChi.setForeground(new java.awt.Color(49, 139, 130));
        lblDiaChi.setText("Địa Chỉ:");
        pnlFormChinh.add(lblDiaChi, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 207, 64, 30));

        txtHoVaTen.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pnlFormChinh.add(txtHoVaTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 196, 30));

        txtSoDienThoai.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtSoDienThoai.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSoDienThoaiKeyReleased(evt);
            }
        });
        pnlFormChinh.add(txtSoDienThoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 198, 31));

        txtDiaChi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pnlFormChinh.add(txtDiaChi, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, 198, 30));

        rdoNam.setBackground(new java.awt.Color(255, 255, 255));
        grpGioiTinh.add(rdoNam);
        rdoNam.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdoNam.setForeground(new java.awt.Color(49, 139, 130));
        rdoNam.setSelected(true);
        rdoNam.setText("Nam");
        pnlFormChinh.add(rdoNam, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 63, 34));

        rdoNu.setBackground(new java.awt.Color(255, 255, 255));
        grpGioiTinh.add(rdoNu);
        rdoNu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdoNu.setForeground(new java.awt.Color(49, 139, 130));
        rdoNu.setText("Nữ");
        rdoNu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoNuActionPerformed(evt);
            }
        });
        pnlFormChinh.add(rdoNu, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 250, 54, 32));

        lblThongTin.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblThongTin.setForeground(new java.awt.Color(49, 139, 130));
        lblThongTin.setText("Thông Tin:");
        pnlFormChinh.add(lblThongTin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 6, 842, -1));

        lblThoat.setBackground(new java.awt.Color(49, 139, 130));
        lblThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Close_18px.png"))); // NOI18N
        lblThoat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblThoatMouseClicked(evt);
            }
        });
        pnlFormChinh.add(lblThoat, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 0, 20, 20));

        lblHinhAnh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHinhAnh.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblHinhAnh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHinhAnhMouseClicked(evt);
            }
        });
        pnlFormChinh.add(lblHinhAnh, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, 192, 188));

        btnMoHinh.setForeground(new java.awt.Color(49, 139, 130));
        btnMoHinh.setText("Mở Hình");
        btnMoHinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMoHinhMouseClicked(evt);
            }
        });
        btnMoHinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoHinhActionPerformed(evt);
            }
        });
        pnlFormChinh.add(btnMoHinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(422, 259, -1, -1));

        dateThoiGian.setBackground(new java.awt.Color(255, 255, 255));
        dateThoiGian.setDateFormatString("dd-MM-yyyy");
        dateThoiGian.setMaxSelectableDate(new java.util.Date(253370743302000L));
        pnlFormChinh.add(dateThoiGian, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 196, 30));

        lblTieuDe.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        lblTieuDe.setForeground(new java.awt.Color(49, 139, 130));
        lblTieuDe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTieuDe.setText("NHÂN VIÊN");
        lblTieuDe.setToolTipText("");
        pnlFormChinh.add(lblTieuDe, new org.netbeans.lib.awtextra.AbsoluteConstraints(573, 119, 306, -1));

        cboMaNhanVien.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboMaNhanVienItemStateChanged(evt);
            }
        });
        pnlFormChinh.add(cboMaNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 196, 33));

        pnlNhanVien.add(pnlFormChinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 900, 300));

        pnlChucNang.setBackground(new java.awt.Color(255, 255, 255));

        btnThem.setForeground(new java.awt.Color(49, 139, 130));
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/add_28px.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setForeground(new java.awt.Color(49, 139, 130));
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Delete_28px.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnSua.setForeground(new java.awt.Color(49, 139, 130));
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/edit_28px.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.setToolTipText("");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnLamMoi.setForeground(new java.awt.Color(49, 139, 130));
        btnLamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/reset_28px.png"))); // NOI18N
        btnLamMoi.setText("Làm Mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlChucNangLayout = new javax.swing.GroupLayout(pnlChucNang);
        pnlChucNang.setLayout(pnlChucNangLayout);
        pnlChucNangLayout.setHorizontalGroup(
            pnlChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlChucNangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnLamMoi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnThem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnXoa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSua)
                .addContainerGap())
        );
        pnlChucNangLayout.setVerticalGroup(
            pnlChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlChucNangLayout.createSequentialGroup()
                .addGroup(pnlChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLamMoi)
                    .addComponent(btnThem)
                    .addComponent(btnXoa)
                    .addComponent(btnSua))
                .addGap(7, 7, 7))
        );

        pnlNhanVien.add(pnlChucNang, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 470, -1));

        pnlTimKiem.setBackground(new java.awt.Color(255, 255, 255));
        pnlTimKiem.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnTimKiem.setForeground(new java.awt.Color(49, 139, 130));
        btnTimKiem.setText("Tìm Kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });
        pnlTimKiem.add(btnTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 9, 90, 30));
        pnlTimKiem.add(txtTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 9, 220, 30));

        pnlNhanVien.add(pnlTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 310, 350, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 920, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 920, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 610, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanVienMouseClicked
        index = tblNhanVien.getSelectedRow();
        fill(index);
    }//GEN-LAST:event_tblNhanVienMouseClicked

    private void txtSoDienThoaiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoDienThoaiKeyReleased
        txtSoDienThoai.setText(txtSoDienThoai.getText().replaceAll("[abcdefghijklmnopqrstuvwxyz-]", ""));
    }//GEN-LAST:event_txtSoDienThoaiKeyReleased

    private void lblThoatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThoatMouseClicked
        exit();
    }//GEN-LAST:event_lblThoatMouseClicked

    private void lblHinhAnhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHinhAnhMouseClicked

    }//GEN-LAST:event_lblHinhAnhMouseClicked

    private void btnMoHinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMoHinhMouseClicked

    }//GEN-LAST:event_btnMoHinhMouseClicked

    private void btnMoHinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoHinhActionPerformed
        open();
    }//GEN-LAST:event_btnMoHinhActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        add();
        load();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        index = tblNhanVien.getSelectedRow();

        delete(index);
        reset();
        load();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        index = tblNhanVien.getSelectedRow();

        edit(index);
        load();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        reset();
        load();
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        search();
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void rdoNuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoNuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoNuActionPerformed

    private void cboMaNhanVienItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboMaNhanVienItemStateChanged
        BLL_MaTenLoai.isAdd(tblNhanVien, cboMaNhanVien, btnThem, 0);
    }//GEN-LAST:event_cboMaNhanVienItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnMoHinh;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cboMaNhanVien;
    private com.toedter.calendar.JDateChooser dateThoiGian;
    private javax.swing.ButtonGroup grpGioiTinh;
    private javax.swing.JLabel lblDiaChi;
    private javax.swing.JLabel lblGioiTinh;
    private javax.swing.JLabel lblHinhAnh;
    private javax.swing.JLabel lblHoVaTen;
    private javax.swing.JLabel lblMaNhanVien;
    private javax.swing.JLabel lblNgaySinh;
    private javax.swing.JLabel lblSoDienThoai;
    private javax.swing.JLabel lblThoat;
    private javax.swing.JLabel lblThongTin;
    private javax.swing.JLabel lblTieuDe;
    private javax.swing.JPanel pnlChucNang;
    private javax.swing.JPanel pnlFormChinh;
    private javax.swing.JPanel pnlNhanVien;
    private javax.swing.JPanel pnlTimKiem;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JScrollPane scrNhanVien;
    private javax.swing.JTable tblNhanVien;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtHoVaTen;
    private javax.swing.JTextField txtSoDienThoai;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
