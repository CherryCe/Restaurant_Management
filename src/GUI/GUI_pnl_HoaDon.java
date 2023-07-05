/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import BLL.BLL_ChiTietHoaDon;
import BLL.BLL_DatBan;
import BLL.BLL_HoaDon;
import BLL.BLL_MaTenLoai;
import BLL.BLL_MonAn;
import BLL.BLL_NhanVien;
import DAL.DAL_HoaDon;
import DTO.DTO_ChiTietHoaDon;
import DTO.DTO_DatBan;
import DTO.DTO_HoaDon;
import DTO.DTO_MonAn;
import DTO.DTO_MaTenLoai;
import HELPER.HELPER_ChuyenDoi;
import HELPER.HELPER_ComboBox;
import HELPER.HELPER_ConnectSQL;
import java.awt.Desktop;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Locale;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author CherryCe
 */
public class GUI_pnl_HoaDon extends javax.swing.JPanel {

    int index = -1;

    /**
     * Creates new form pnl_HoaDon
     */
    public GUI_pnl_HoaDon() {
        initComponents();
        loadTenBan();
        loadTenNhanVien();
        loadLoaiMon();
        dateThoiGian.setEnabled(false);
        txtMaHoaDon.setEnabled(false);
        dateThoiGian.setDate(HELPER_ChuyenDoi.LayNgayDate(LocalDateTime.now()));
        txtMaHoaDon.setText(setMaHoaDon());
    }

    public void addChiTietHoaDon() {
        DTO_ChiTietHoaDon chiTiet = new DTO_ChiTietHoaDon(BLL_MaTenLoai.getMaBan(String.valueOf(cboTenBan.getSelectedItem())), BLL_MaTenLoai.getMaMon(String.valueOf(cboTenMon.getSelectedItem())), HELPER_ChuyenDoi.SoInt(lblSetGiaTien.getText()), HELPER_ChuyenDoi.SoInt(spnSoLuong.getValue().toString()), HELPER_ChuyenDoi.SoInt(lblSetThanhTien.getText()), txtGhiChu.getText());
        BLL_ChiTietHoaDon.add(chiTiet);
    }

    public void addHoaDon() {
        DTO_HoaDon hoaDon = new DTO_HoaDon(BLL_MaTenLoai.getMaBan(String.valueOf(cboTenBan_QuanLy.getSelectedItem())), HELPER_ChuyenDoi.SoInt(txtMaHoaDon.getText()), txtTenKhach.getText(), BLL_MaTenLoai.getMaNhanVien(String.valueOf(cboTenNhanVien.getSelectedItem())), txtGhiChu.getText(), HELPER_ChuyenDoi.SoInt(lblSetTongTienBan.getText()), HELPER_ChuyenDoi.SoInt(txtThueVAT.getText()), HELPER_ChuyenDoi.SoInt(lblSetTienThueVAT.getText()), HELPER_ChuyenDoi.SoInt(lblSetTongTien.getText()), HELPER_ChuyenDoi.SoInt(txtTienNhanKhach.getText()), HELPER_ChuyenDoi.SoInt(lblSetTienTraKhach.getText()));
        if (dateThoiGian.getDate() == null || txtMaHoaDon.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Dữ Liệu Không Được Để Trống !!!");
            return;
        } else {
            BLL_HoaDon.add(hoaDon);
        }
    }

    public void deleteChiTietHoaDon(int index) {
        if (index < 0) {
            JOptionPane.showMessageDialog(this, "Bạn Chưa Chọn Dòng Cần Sửa");
        } else {
            int choice = JOptionPane.showConfirmDialog(this, "Bạn Có Muốn Xóa Không ?", "Xóa", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                int indexs[] = tblChiTietHoaDon.getSelectedRows();
                for (int i = 0; i < indexs.length; i++) {
                    String maMon = BLL_MaTenLoai.getMaMon(tblChiTietHoaDon.getValueAt(indexs[i], 1).toString());
                    String maBan = BLL_MaTenLoai.getMaBan(String.valueOf(cboTenBan.getSelectedItem()));
                    BLL_ChiTietHoaDon.delete(maMon, maBan);
                }
            }
            return;
        }
    }

    public void editChiTietHoaDon(int index) {
        if (index < 0) {
            JOptionPane.showMessageDialog(this, "Bạn Chưa Chọn Dòng Cần Sửa");
        }
        DTO_ChiTietHoaDon chiTiet = new DTO_ChiTietHoaDon(BLL_MaTenLoai.getMaBan(String.valueOf(cboTenBan.getSelectedItem())), BLL_MaTenLoai.getMaMon(String.valueOf(cboTenMon.getSelectedItem())), HELPER_ChuyenDoi.SoInt(lblSetGiaTien.getText()), HELPER_ChuyenDoi.SoInt(spnSoLuong.getValue().toString()), HELPER_ChuyenDoi.SoInt(lblSetThanhTien.getText()), txtGhiChu.getText());
        BLL_ChiTietHoaDon.edit(chiTiet);
    }

    public void reset() {
        txtTenKhach.setText(null);
        txtGhiChu_QuanLy.setText(null);
        for (int i = 0; i < tblChiTietHoaDon.getRowCount(); i++) {
            String maMon = BLL_MaTenLoai.getMaMon(tblChiTietHoaDon.getValueAt(i, 1).toString());
            String maBan = BLL_MaTenLoai.getMaBan(String.valueOf(cboTenBan.getSelectedItem()));
            BLL_ChiTietHoaDon.delete(maMon, maBan);
        }
        String sqlUPDATE = "UPDATE danhSach SET trangThai = N'Bàn Trống' WHERE maBan = ?";
        HELPER_ConnectSQL.executeUpdate(sqlUPDATE, BLL_MaTenLoai.getMaBan(String.valueOf(cboTenBan.getSelectedItem())));
        cboTenBan.removeItem(cboTenBan_QuanLy.getSelectedItem());
        cboTenBan_QuanLy.removeItem(cboTenBan_QuanLy.getSelectedItem());
    }

    public void fillChiTietHoaDon(int index) {
        cboTenMon.setSelectedItem(tblChiTietHoaDon.getValueAt(index, 1).toString());
        cboLoaiMon.setSelectedItem(tblChiTietMonAn.getValueAt(index, 1).toString());
        spnSoLuong.setValue(tblChiTietHoaDon.getValueAt(index, 3));
        txtGhiChu.setText(tblChiTietHoaDon.getValueAt(index, 5).toString());
        lblSetDonViTinh.setText(tblChiTietMonAn.getValueAt(index, 2).toString());
        lblSetGiaTien.setText(currency(tblChiTietHoaDon.getValueAt(index, 2)));
        lblSetThanhTien.setText(currency(tblChiTietHoaDon.getValueAt(index, 4)));
    }

    public void loadChiTietMonAn(String maBan) {
        ArrayList<DTO_MonAn> array = BLL_MonAn.selectChiTietMonAn(maBan);
        BLL_MonAn.loadChiTietMonAn(array, tblChiTietMonAn);
    }

    public void loadChiTietHoaDon(String maBan) {
        ArrayList<DTO_ChiTietHoaDon> array = BLL_ChiTietHoaDon.select(maBan);
        BLL_ChiTietHoaDon.load(array, tblChiTietHoaDon);
    }

    public void loadTenBan() {
        ArrayList<DTO_MaTenLoai> array = BLL_MaTenLoai.selectMaTenBan();
        BLL_MaTenLoai.loadMaTenBan(array, cboTenBan);
        BLL_MaTenLoai.loadMaTenBan(array, cboTenBan_QuanLy);
    }

    public void loadTenNhanVien() {
        ArrayList<DTO_MaTenLoai> array = BLL_MaTenLoai.selectMaTenNhanVien();
        BLL_MaTenLoai.loadMaTenNhanVien(array, cboTenNhanVien);
    }

    public void loadLoaiMon() {
        ArrayList<DTO_MonAn> array = BLL_MonAn.selectLoaiMon();
        BLL_MonAn.loadLoaiMon(array, cboLoaiMon);
    }

    public void loadTenMon(String loaiMon) {
        ArrayList<DTO_MonAn> array = BLL_MonAn.selectTenMon(loaiMon);
        BLL_MonAn.loadTenMon(array, cboTenMon);
    }

    public void loadMonAn(String tenMon, String loaiMon) {
        ArrayList<DTO_MonAn> array = BLL_MonAn.selectMonAn(tenMon, loaiMon);
        BLL_MonAn.loadMonAn(array, lblSetDonViTinh, lblSetGiaTien);
    }

    public void setTienBan_formatSTT() {
        double tienBan = 0;

        for (int i = 0; i < tblChiTietHoaDon.getRowCount(); i++) {
            tblChiTietHoaDon.setValueAt(i + 1, i, 0);
            tienBan += HELPER_ChuyenDoi.SoDouble(tblChiTietHoaDon.getValueAt(i, 4).toString());
        }
        lblSetTongTienBan.setText(currency(tienBan));
    }

    public void openFile(String file) {
        try {
            File path = new File(file);
            Desktop.getDesktop().open(path);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void loadExcel() {
        try {
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.showSaveDialog(this);
            File saveFile = jFileChooser.getSelectedFile();

            if (saveFile != null) {
                saveFile = new File(saveFile.toString());
                Workbook wb = new XSSFWorkbook();
                Sheet sheet = wb.createSheet("Sheet");
                Row rowCol = sheet.createRow(0);

                for (int i = 0; i < tblChiTietHoaDon.getColumnCount(); i++) {
                    Cell cell = rowCol.createCell(i);
                    cell.setCellValue(tblChiTietHoaDon.getColumnName(i));
                }

                for (int i = 0; i < tblChiTietMonAn.getColumnCount(); i++) {
                    int j = tblChiTietHoaDon.getColumnCount();
                    Cell cell = rowCol.createCell(i + j);
                    cell.setCellValue(tblChiTietMonAn.getColumnName(i));
                }

                for (int j = 0; j < tblChiTietHoaDon.getRowCount(); j++) {
                    Row row = sheet.createRow(j + 1);
                    for (int k = 0; k < tblChiTietHoaDon.getColumnCount(); k++) {
                        Cell cell = row.createCell(k);
                        if (tblChiTietHoaDon.getValueAt(j, k) != null) {
                            cell.setCellValue(tblChiTietHoaDon.getValueAt(j, k).toString());
                        }
                    }

                    int i = tblChiTietHoaDon.getColumnCount();

                    for (int k = 0; k < tblChiTietMonAn.getColumnCount(); k++) {
                        Cell cell = row.createCell(i + k);
                        if (tblChiTietMonAn.getValueAt(j, k) != null) {
                            cell.setCellValue(tblChiTietMonAn.getValueAt(j, k).toString());
                        }

                    }

                }
                FileOutputStream out = new FileOutputStream(new File(saveFile.toString()));
                wb.write(out);
                wb.close();
                out.close();
                openFile(saveFile.toString());
            } else {
                JOptionPane.showMessageDialog(null, "Error");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readExcel() {
        try {
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.showSaveDialog(this);
            File saveFile = jFileChooser.getSelectedFile();
            if (saveFile != null) {
                saveFile = new File(saveFile.toString());
            }
            FileInputStream file = new FileInputStream(new File(saveFile.toString()));
            Workbook workbook = new XSSFWorkbook(file);
            DataFormatter dataFormatter = new DataFormatter();
            Iterator<Sheet> sheets = workbook.sheetIterator();
            while (sheets.hasNext()) {
                Sheet sh = sheets.next();
                System.out.println("Sheet name is " + sh.getSheetName());
                System.out.println();
                Iterator<Row> iterator = sh.iterator();
                while (iterator.hasNext()) {
                    Row row = iterator.next();
                    Iterator<Cell> cellIterator = row.iterator();
                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                        String cellValue = dataFormatter.formatCellValue(cell);
                        System.out.print(cellValue + "\t");
                    }
                    System.out.println();
                }
            }
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void isAdd() {
        for (int i = 0; i < tblChiTietMonAn.getRowCount(); i++) {
            if (String.valueOf(cboTenMon.getSelectedItem()).equals(tblChiTietMonAn.getValueAt(i, 0).toString())) {
                btnThem.setEnabled(false);
                break;
            } else {
                btnThem.setEnabled(true);
            }
        }
    }

    public void isReport() {
        if (tblChiTietMonAn.getRowCount() == 0) {
            btnThem.setEnabled(true);
            btnXuatExcel.setEnabled(false);
            btnThanhToan.setEnabled(false);
        } else {
            btnXuatExcel.setEnabled(true);
            btnThanhToan.setEnabled(true);
        }
    }

    public static String currency(Object obj) {
        Locale localeVN = new Locale("en", "EN");
        NumberFormat currency = NumberFormat.getInstance(localeVN);

        return currency.format(obj);
    }

    public String setMaHoaDon() {
        String maHoaDon = "";
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyMMdd");
            Date date = new Date();
            maHoaDon = dateFormat.format(date);
            ResultSet rs = DAL_HoaDon.count(HELPER_ChuyenDoi.LayNgayString(dateThoiGian.getDate()));
            int rowCount = 0;
            while (rs.next()) {
                rowCount = rs.getInt(1);
                if (rowCount > 99) {
                    maHoaDon = maHoaDon + (rowCount + 1);
                } else if (rowCount > 9) {
                    maHoaDon = maHoaDon + "0" + (rowCount + 1);
                } else {
                    maHoaDon = maHoaDon + "00" + (rowCount + 1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return maHoaDon;
    }

    public static void xuatHoaDon(int maHoaDon) {
        try {
            Hashtable map = new Hashtable();
            JasperReport report = JasperCompileManager.compileReport("src/GUI/GUI_rpt_XuatHoaDon.jrxml");
            map.put("maHoaDon", maHoaDon);
            JasperPrint p = JasperFillManager.fillReport(report, map, HELPER_ConnectSQL.conn);
            JasperViewer.viewReport(p, false);
            JasperExportManager.exportReportToPdfFile(p, "test.pdf");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void thoat() {
        int choice = JOptionPane.showConfirmDialog(this, "Bạn có muốn thoát chương trình ?", "Thoát", JOptionPane.YES_NO_OPTION);
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

        pnlHoaDon = new javax.swing.JPanel();
        lblThoat = new javax.swing.JLabel();
        pnlTieuDe = new javax.swing.JPanel();
        lblTieuDe = new javax.swing.JLabel();
        pnlThongTinBanAn = new javax.swing.JPanel();
        scrHoaDon = new javax.swing.JScrollPane();
        tblChiTietHoaDon = new javax.swing.JTable();
        cboTenNhanVien = new javax.swing.JComboBox<>();
        lblTongTienBan = new javax.swing.JLabel();
        lblThueVAT = new javax.swing.JLabel();
        lblTienThueVAT = new javax.swing.JLabel();
        lblSetTongTienBan = new javax.swing.JLabel();
        lblSetTienThueVAT = new javax.swing.JLabel();
        txtThueVAT = new javax.swing.JTextField();
        lblTenKhach = new javax.swing.JLabel();
        lblTenNhanVien = new javax.swing.JLabel();
        txtTenKhach = new javax.swing.JTextField();
        lblTenBan_QuanLy = new javax.swing.JLabel();
        lblMaHoaDon = new javax.swing.JLabel();
        cboTenBan_QuanLy = new javax.swing.JComboBox<>();
        lblThoiGian = new javax.swing.JLabel();
        txtMaHoaDon = new javax.swing.JTextField();
        lblGhiChu_QuanLy = new javax.swing.JLabel();
        txtGhiChu_QuanLy = new javax.swing.JTextField();
        btnXuatExcel = new javax.swing.JButton();
        dateThoiGian = new com.toedter.calendar.JDateChooser();
        pnlThongTinMonAn = new javax.swing.JPanel();
        scrXuatHoaDon = new javax.swing.JScrollPane();
        tblChiTietMonAn = new javax.swing.JTable();
        pnlThongTinHoaDon = new javax.swing.JPanel();
        lblTenBan = new javax.swing.JLabel();
        cboLoaiMon = new javax.swing.JComboBox<>();
        lblThanhTien = new javax.swing.JLabel();
        lblSoLuong = new javax.swing.JLabel();
        lblLoaiMon = new javax.swing.JLabel();
        lblTenMon = new javax.swing.JLabel();
        lblDonViTinh = new javax.swing.JLabel();
        cboTenMon = new javax.swing.JComboBox<>();
        cboTenBan = new javax.swing.JComboBox<>();
        spnSoLuong = new javax.swing.JSpinner();
        lblSetThanhTien = new javax.swing.JLabel();
        lblSetDonViTinh = new javax.swing.JLabel();
        lblGiaTien = new javax.swing.JLabel();
        lblSetGiaTien = new javax.swing.JLabel();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        lblGhiChu = new javax.swing.JLabel();
        txtGhiChu = new javax.swing.JTextField();
        pnlThongTinTien = new javax.swing.JPanel();
        lblTongTien = new javax.swing.JLabel();
        lblTienNhanKhach = new javax.swing.JLabel();
        lblTienTraKhach = new javax.swing.JLabel();
        lblSetTongTien = new javax.swing.JLabel();
        txtTienNhanKhach = new javax.swing.JTextField();
        lblSetTienTraKhach = new javax.swing.JLabel();
        btnThanhToan = new javax.swing.JButton();

        pnlHoaDon.setBackground(new java.awt.Color(255, 255, 255));
        pnlHoaDon.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblThoat.setBackground(new java.awt.Color(49, 139, 130));
        lblThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Close_18px.png"))); // NOI18N
        lblThoat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblThoatMouseClicked(evt);
            }
        });
        pnlHoaDon.add(lblThoat, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 10, 20, 20));

        pnlTieuDe.setBackground(new java.awt.Color(255, 255, 255));
        pnlTieuDe.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTieuDe.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        lblTieuDe.setForeground(new java.awt.Color(49, 139, 130));
        lblTieuDe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTieuDe.setText("HÓA ĐƠN");
        lblTieuDe.setToolTipText("");
        pnlTieuDe.add(lblTieuDe, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 390, -1));

        pnlHoaDon.add(pnlTieuDe, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 410, 80));

        pnlThongTinBanAn.setBackground(new java.awt.Color(255, 255, 255));
        pnlThongTinBanAn.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Quản lý bàn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(49, 139, 130))); // NOI18N
        pnlThongTinBanAn.setForeground(new java.awt.Color(49, 139, 130));
        pnlThongTinBanAn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblChiTietHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Tên Món", "Giá Tiền", "Số Lượng", "Thành Tiền", "Ghi Chú"
            }
        ));
        tblChiTietHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblChiTietHoaDonMouseClicked(evt);
            }
        });
        scrHoaDon.setViewportView(tblChiTietHoaDon);

        pnlThongTinBanAn.add(scrHoaDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 430, 200));

        pnlThongTinBanAn.add(cboTenNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, 110, 30));

        lblTongTienBan.setBackground(new java.awt.Color(49, 139, 130));
        lblTongTienBan.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblTongTienBan.setForeground(new java.awt.Color(49, 139, 130));
        lblTongTienBan.setText("Tổng Tiền Bàn:");
        pnlThongTinBanAn.add(lblTongTienBan, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, -1, 30));

        lblThueVAT.setBackground(new java.awt.Color(49, 139, 130));
        lblThueVAT.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblThueVAT.setForeground(new java.awt.Color(49, 139, 130));
        lblThueVAT.setText("Thuế VAT:");
        pnlThongTinBanAn.add(lblThueVAT, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, -1, 30));

        lblTienThueVAT.setBackground(new java.awt.Color(49, 139, 130));
        lblTienThueVAT.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblTienThueVAT.setForeground(new java.awt.Color(49, 139, 130));
        lblTienThueVAT.setText("Tiền Thuế VAT:");
        pnlThongTinBanAn.add(lblTienThueVAT, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, -1, 30));
        pnlThongTinBanAn.add(lblSetTongTienBan, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 380, 160, 30));
        pnlThongTinBanAn.add(lblSetTienThueVAT, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 460, 160, 30));

        txtThueVAT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtThueVATKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtThueVATKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtThueVATKeyTyped(evt);
            }
        });
        pnlThongTinBanAn.add(txtThueVAT, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 420, 160, 30));

        lblTenKhach.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblTenKhach.setForeground(new java.awt.Color(49, 139, 130));
        lblTenKhach.setText("Tên Khách:");
        pnlThongTinBanAn.add(lblTenKhach, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, 30));

        lblTenNhanVien.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblTenNhanVien.setForeground(new java.awt.Color(49, 139, 130));
        lblTenNhanVien.setText("Tên Nhân Viên:");
        pnlThongTinBanAn.add(lblTenNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, -1, 30));

        txtTenKhach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenKhachActionPerformed(evt);
            }
        });
        pnlThongTinBanAn.add(txtTenKhach, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 100, 30));

        lblTenBan_QuanLy.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblTenBan_QuanLy.setForeground(new java.awt.Color(49, 139, 130));
        lblTenBan_QuanLy.setText("Tên Bàn:");
        pnlThongTinBanAn.add(lblTenBan_QuanLy, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, 30));

        lblMaHoaDon.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblMaHoaDon.setForeground(new java.awt.Color(49, 139, 130));
        lblMaHoaDon.setText("Mã Hóa Ðơn:");
        pnlThongTinBanAn.add(lblMaHoaDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, -1, 30));

        cboTenBan_QuanLy.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboTenBan_QuanLyItemStateChanged(evt);
            }
        });
        pnlThongTinBanAn.add(cboTenBan_QuanLy, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 100, 30));

        lblThoiGian.setBackground(new java.awt.Color(49, 139, 130));
        lblThoiGian.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblThoiGian.setForeground(new java.awt.Color(49, 139, 130));
        lblThoiGian.setText("Thời Gian:");
        pnlThongTinBanAn.add(lblThoiGian, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, 30));

        txtMaHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaHoaDonActionPerformed(evt);
            }
        });
        txtMaHoaDon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMaHoaDonKeyReleased(evt);
            }
        });
        pnlThongTinBanAn.add(txtMaHoaDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, 110, 30));

        lblGhiChu_QuanLy.setBackground(new java.awt.Color(49, 139, 130));
        lblGhiChu_QuanLy.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblGhiChu_QuanLy.setForeground(new java.awt.Color(49, 139, 130));
        lblGhiChu_QuanLy.setText("Ghi Chú:");
        pnlThongTinBanAn.add(lblGhiChu_QuanLy, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, -1, 30));

        txtGhiChu_QuanLy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGhiChu_QuanLyActionPerformed(evt);
            }
        });
        pnlThongTinBanAn.add(txtGhiChu_QuanLy, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, 110, 30));

        btnXuatExcel.setForeground(new java.awt.Color(49, 139, 130));
        btnXuatExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/icons8-add-list-96.png"))); // NOI18N
        btnXuatExcel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnXuatExcel.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        btnXuatExcel.setHideActionText(true);
        btnXuatExcel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnXuatExcel.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnXuatExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatExcelActionPerformed(evt);
            }
        });
        pnlThongTinBanAn.add(btnXuatExcel, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 380, 110, -1));

        dateThoiGian.setDateFormatString("dd-MM-yyyy");
        pnlThongTinBanAn.add(dateThoiGian, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 100, 30));

        pnlHoaDon.add(pnlThongTinBanAn, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 108, 450, 500));
        pnlThongTinBanAn.getAccessibleContext().setAccessibleName("Quản Lý Bàn");

        pnlThongTinMonAn.setBackground(new java.awt.Color(255, 255, 255));
        pnlThongTinMonAn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblChiTietMonAn.setForeground(new java.awt.Color(49, 139, 130));
        tblChiTietMonAn.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Tên Món", "Loại Món", "Đơn Vị Tính", "Giá Tiền"
            }
        ));
        tblChiTietMonAn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblChiTietMonAnMouseClicked(evt);
            }
        });
        scrXuatHoaDon.setViewportView(tblChiTietMonAn);

        pnlThongTinMonAn.add(scrXuatHoaDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 200));

        pnlHoaDon.add(pnlThongTinMonAn, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 280, 450, 200));

        pnlThongTinHoaDon.setBackground(new java.awt.Color(255, 255, 255));
        pnlThongTinHoaDon.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTenBan.setBackground(new java.awt.Color(49, 139, 130));
        lblTenBan.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblTenBan.setForeground(new java.awt.Color(49, 139, 130));
        lblTenBan.setText("Tên Bàn:");
        pnlThongTinHoaDon.add(lblTenBan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, 30));

        cboLoaiMon.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cboLoaiMon.setForeground(new java.awt.Color(49, 139, 130));
        cboLoaiMon.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboLoaiMonItemStateChanged(evt);
            }
        });
        cboLoaiMon.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cboLoaiMonPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        cboLoaiMon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cboLoaiMonMouseClicked(evt);
            }
        });
        cboLoaiMon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboLoaiMonActionPerformed(evt);
            }
        });
        pnlThongTinHoaDon.add(cboLoaiMon, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 130, 30));

        lblThanhTien.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblThanhTien.setForeground(new java.awt.Color(49, 139, 130));
        lblThanhTien.setText("Thành Tiền:");
        pnlThongTinHoaDon.add(lblThanhTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, -1, 30));

        lblSoLuong.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblSoLuong.setForeground(new java.awt.Color(49, 139, 130));
        lblSoLuong.setText("Số Lượng:");
        pnlThongTinHoaDon.add(lblSoLuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 70, 30));

        lblLoaiMon.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblLoaiMon.setForeground(new java.awt.Color(49, 139, 130));
        lblLoaiMon.setText("Loại Món:");
        pnlThongTinHoaDon.add(lblLoaiMon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, -1, 30));

        lblTenMon.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblTenMon.setForeground(new java.awt.Color(49, 139, 130));
        lblTenMon.setText("Tên Món:");
        pnlThongTinHoaDon.add(lblTenMon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, -1, 30));

        lblDonViTinh.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblDonViTinh.setForeground(new java.awt.Color(49, 139, 130));
        lblDonViTinh.setText("Đơn Vị Tính:");
        pnlThongTinHoaDon.add(lblDonViTinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, -1, 30));

        cboTenMon.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cboTenMon.setForeground(new java.awt.Color(49, 139, 130));
        cboTenMon.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboTenMonItemStateChanged(evt);
            }
        });
        cboTenMon.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cboTenMonPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        cboTenMon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTenMonActionPerformed(evt);
            }
        });
        pnlThongTinHoaDon.add(cboTenMon, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 130, 30));

        cboTenBan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cboTenBan.setForeground(new java.awt.Color(49, 139, 130));
        cboTenBan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboTenBanItemStateChanged(evt);
            }
        });
        cboTenBan.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cboTenBanPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        cboTenBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTenBanActionPerformed(evt);
            }
        });
        pnlThongTinHoaDon.add(cboTenBan, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 130, 30));

        spnSoLuong.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        spnSoLuong.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnSoLuongStateChanged(evt);
            }
        });
        pnlThongTinHoaDon.add(spnSoLuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 130, 30));
        pnlThongTinHoaDon.add(lblSetThanhTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 100, 30));
        pnlThongTinHoaDon.add(lblSetDonViTinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, 100, 30));

        lblGiaTien.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblGiaTien.setForeground(new java.awt.Color(49, 139, 130));
        lblGiaTien.setText("Giá Tiền:");
        pnlThongTinHoaDon.add(lblGiaTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, -1, 30));
        pnlThongTinHoaDon.add(lblSetGiaTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, 100, 30));

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Delete_28px.png"))); // NOI18N
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        pnlThongTinHoaDon.add(btnXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 40, -1));

        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/edit_28px.png"))); // NOI18N
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        pnlThongTinHoaDon.add(btnSua, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 40, -1));

        btnLamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/reset_28px.png"))); // NOI18N
        pnlThongTinHoaDon.add(btnLamMoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 40, -1));

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/add_28px.png"))); // NOI18N
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        pnlThongTinHoaDon.add(btnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 40, -1));
        pnlThongTinHoaDon.add(txtTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, 90, 30));

        btnTimKiem.setForeground(new java.awt.Color(49, 139, 130));
        btnTimKiem.setText("Tìm Kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });
        pnlThongTinHoaDon.add(btnTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 190, 90, 30));

        lblGhiChu.setBackground(new java.awt.Color(49, 139, 130));
        lblGhiChu.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblGhiChu.setForeground(new java.awt.Color(49, 139, 130));
        lblGhiChu.setText("Ghi Chú:");
        pnlThongTinHoaDon.add(lblGhiChu, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, -1, 30));

        txtGhiChu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGhiChuActionPerformed(evt);
            }
        });
        pnlThongTinHoaDon.add(txtGhiChu, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 100, 30));

        pnlHoaDon.add(pnlThongTinHoaDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 30, 450, 240));

        pnlThongTinTien.setBackground(new java.awt.Color(255, 255, 255));
        pnlThongTinTien.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTongTien.setBackground(new java.awt.Color(49, 139, 130));
        lblTongTien.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblTongTien.setForeground(new java.awt.Color(49, 139, 130));
        lblTongTien.setText("Tổng Tiền Hóa Đơn:");
        pnlThongTinTien.add(lblTongTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, 31));

        lblTienNhanKhach.setBackground(new java.awt.Color(49, 139, 130));
        lblTienNhanKhach.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblTienNhanKhach.setForeground(new java.awt.Color(49, 139, 130));
        lblTienNhanKhach.setText("Tiền Nhận Của Khách:");
        pnlThongTinTien.add(lblTienNhanKhach, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, -1, 30));

        lblTienTraKhach.setBackground(new java.awt.Color(49, 139, 130));
        lblTienTraKhach.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblTienTraKhach.setForeground(new java.awt.Color(49, 139, 130));
        lblTienTraKhach.setText("Tiền Trả Lại Khách:");
        pnlThongTinTien.add(lblTienTraKhach, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, -1, 30));

        lblSetTongTien.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblSetTongTien.setForeground(new java.awt.Color(49, 139, 130));
        lblSetTongTien.setEnabled(false);
        pnlThongTinTien.add(lblSetTongTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 140, 30));

        txtTienNhanKhach.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtTienNhanKhach.setForeground(new java.awt.Color(49, 139, 130));
        txtTienNhanKhach.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTienNhanKhachKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTienNhanKhachKeyReleased(evt);
            }
        });
        pnlThongTinTien.add(txtTienNhanKhach, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 140, 30));

        lblSetTienTraKhach.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblSetTienTraKhach.setForeground(new java.awt.Color(49, 139, 130));
        lblSetTienTraKhach.setEnabled(false);
        pnlThongTinTien.add(lblSetTienTraKhach, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 140, 30));

        pnlHoaDon.add(pnlThongTinTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 480, 310, 130));

        btnThanhToan.setForeground(new java.awt.Color(49, 139, 130));
        btnThanhToan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/icons8-paid-bill-96.png"))); // NOI18N
        btnThanhToan.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnThanhToan.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        btnThanhToan.setHideActionText(true);
        btnThanhToan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnThanhToan.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });
        pnlHoaDon.add(btnThanhToan, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 490, 110, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pnlHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pnlHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lblThoatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThoatMouseClicked
        thoat();
    }//GEN-LAST:event_lblThoatMouseClicked

    private void cboLoaiMonPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cboLoaiMonPopupMenuWillBecomeInvisible

    }//GEN-LAST:event_cboLoaiMonPopupMenuWillBecomeInvisible

    private void cboLoaiMonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboLoaiMonMouseClicked

    }//GEN-LAST:event_cboLoaiMonMouseClicked

    private void cboLoaiMonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboLoaiMonActionPerformed

    }//GEN-LAST:event_cboLoaiMonActionPerformed

    private void btnXuatExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatExcelActionPerformed
        loadExcel();
    }//GEN-LAST:event_btnXuatExcelActionPerformed

    private void cboTenMonPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cboTenMonPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
    }//GEN-LAST:event_cboTenMonPopupMenuWillBecomeInvisible

    private void cboTenMonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTenMonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboTenMonActionPerformed

    private void txtTenKhachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenKhachActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenKhachActionPerformed

    private void txtGhiChuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGhiChuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGhiChuActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        readExcel();
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void txtMaHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaHoaDonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaHoaDonActionPerformed

    private void txtGhiChu_QuanLyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGhiChu_QuanLyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGhiChu_QuanLyActionPerformed

    private void cboTenMonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboTenMonItemStateChanged
        String tenMon = String.valueOf(cboTenMon.getSelectedItem());
        String loaiMon = String.valueOf(cboLoaiMon.getSelectedItem());

        loadMonAn(tenMon, loaiMon);
        BLL_MaTenLoai.isAdd(tblChiTietMonAn, cboTenMon, btnThem, 0);
    }//GEN-LAST:event_cboTenMonItemStateChanged

    private void cboLoaiMonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboLoaiMonItemStateChanged
        String loaiMon = String.valueOf(cboLoaiMon.getSelectedItem());

        loadTenMon(loaiMon);
        BLL_MaTenLoai.isAdd(tblChiTietMonAn, cboTenMon, btnThem, 0);
    }//GEN-LAST:event_cboLoaiMonItemStateChanged

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        index = tblChiTietHoaDon.getSelectedRow();
        String maBan = BLL_MaTenLoai.getMaBan(String.valueOf(cboTenBan.getSelectedItem()));

        deleteChiTietHoaDon(index);
        loadChiTietHoaDon(maBan);
        loadChiTietMonAn(maBan);
        setTienBan_formatSTT();
        isReport();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void spnSoLuongStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnSoLuongStateChanged
        int thanhTien = HELPER_ChuyenDoi.SoInt(lblSetGiaTien.getText()) * HELPER_ChuyenDoi.SoInt(spnSoLuong.getValue().toString());
        lblSetThanhTien.setText(currency(thanhTien));
    }//GEN-LAST:event_spnSoLuongStateChanged

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        String maBan = BLL_MaTenLoai.getMaBan(String.valueOf(cboTenBan.getSelectedItem()));

        addChiTietHoaDon();
        loadChiTietHoaDon(maBan);
        loadChiTietMonAn(maBan);
        setTienBan_formatSTT();
        isReport();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        addHoaDon();
        xuatHoaDon(BLL_HoaDon.top());
        txtMaHoaDon.setText(setMaHoaDon());
        reset();
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void cboTenBan_QuanLyItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboTenBan_QuanLyItemStateChanged
        index = cboTenBan_QuanLy.getSelectedIndex();
        cboTenBan.setSelectedIndex(index);
        String maBan = BLL_MaTenLoai.getMaBan(cboTenBan_QuanLy.getSelectedItem().toString());

        isReport();
        loadChiTietHoaDon(maBan);
        loadChiTietMonAn(maBan);
        setTienBan_formatSTT();
    }//GEN-LAST:event_cboTenBan_QuanLyItemStateChanged

    private void tblChiTietHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblChiTietHoaDonMouseClicked
        index = tblChiTietHoaDon.getSelectedRow();

        fillChiTietHoaDon(index);
        tblChiTietMonAn.setRowSelectionInterval(index, index);
    }//GEN-LAST:event_tblChiTietHoaDonMouseClicked

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        index = tblChiTietHoaDon.getSelectedRow();
        String maBan = BLL_MaTenLoai.getMaBan(String.valueOf(cboTenBan.getSelectedItem()));

        editChiTietHoaDon(index);
        loadChiTietHoaDon(maBan);
        setTienBan_formatSTT();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void tblChiTietMonAnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblChiTietMonAnMouseClicked
        index = tblChiTietMonAn.getSelectedRow();

        fillChiTietHoaDon(index);
        tblChiTietHoaDon.setRowSelectionInterval(index, index);
    }//GEN-LAST:event_tblChiTietMonAnMouseClicked

    private void cboTenBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTenBanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboTenBanActionPerformed

    private void cboTenBanPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cboTenBanPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
    }//GEN-LAST:event_cboTenBanPopupMenuWillBecomeInvisible

    private void cboTenBanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboTenBanItemStateChanged
        String maBan = BLL_MaTenLoai.getMaBan(cboTenBan.getSelectedItem().toString());

        isReport();
        loadChiTietHoaDon(maBan);
        loadChiTietMonAn(maBan);
        setTienBan_formatSTT();
    }//GEN-LAST:event_cboTenBanItemStateChanged

    private void txtThueVATKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtThueVATKeyPressed

    }//GEN-LAST:event_txtThueVATKeyPressed

    private void txtTienNhanKhachKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienNhanKhachKeyPressed

    }//GEN-LAST:event_txtTienNhanKhachKeyPressed

    private void txtThueVATKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtThueVATKeyReleased
        double tienVAT = 0;
        double tongTien = 0;
        double tienBan = HELPER_ChuyenDoi.SoDouble(lblSetTongTienBan.getText());

        txtThueVAT.setText(txtThueVAT.getText().replaceAll("[abcdefghijklmnopqrstuvwxyz-]", ""));
        txtThueVAT.setText(currency(HELPER_ChuyenDoi.SoDouble(txtThueVAT.getText())));
        if (HELPER_ChuyenDoi.SoDouble(txtThueVAT.getText()) > 100) {
            lblSetTienThueVAT.setText("Lỗi Định Dạng Số ???");
            tongTien = 0;
            lblSetTongTien.setText(String.valueOf(tongTien));
        } else {
            tienVAT = HELPER_ChuyenDoi.SoDouble(lblSetTongTienBan.getText()) * HELPER_ChuyenDoi.SoDouble(txtThueVAT.getText()) / 100;
            lblSetTienThueVAT.setText(currency(tienVAT));
            tongTien = tienVAT + tienBan;
            lblSetTongTien.setText(currency(tongTien));
        }
    }//GEN-LAST:event_txtThueVATKeyReleased

    private void txtThueVATKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtThueVATKeyTyped

    }//GEN-LAST:event_txtThueVATKeyTyped

    private void txtTienNhanKhachKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienNhanKhachKeyReleased
        double tienTra = 0;
        double tongTien = HELPER_ChuyenDoi.SoDouble(lblSetTongTien.getText());

        txtTienNhanKhach.setText(txtTienNhanKhach.getText().replaceAll("[abcdefghijklmnopqrstuvwxyz-]", ""));
        txtTienNhanKhach.setText(currency(HELPER_ChuyenDoi.SoDouble(txtTienNhanKhach.getText())));
        tienTra = HELPER_ChuyenDoi.SoDouble(txtTienNhanKhach.getText()) - tongTien;
        if (tienTra < 0) {
            lblSetTienTraKhach.setText("Lỗi Định Dạng Số ???");
            btnThanhToan.setEnabled(false);
        } else {
            lblSetTienTraKhach.setText(currency(tienTra));
            btnThanhToan.setEnabled(true);
        }
    }//GEN-LAST:event_txtTienNhanKhachKeyReleased

    private void txtMaHoaDonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaHoaDonKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaHoaDonKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXuatExcel;
    private javax.swing.JComboBox<String> cboLoaiMon;
    private javax.swing.JComboBox<String> cboTenBan;
    private javax.swing.JComboBox<String> cboTenBan_QuanLy;
    private javax.swing.JComboBox<String> cboTenMon;
    private javax.swing.JComboBox<String> cboTenNhanVien;
    private com.toedter.calendar.JDateChooser dateThoiGian;
    private javax.swing.JLabel lblDonViTinh;
    private javax.swing.JLabel lblGhiChu;
    private javax.swing.JLabel lblGhiChu_QuanLy;
    private javax.swing.JLabel lblGiaTien;
    private javax.swing.JLabel lblLoaiMon;
    private javax.swing.JLabel lblMaHoaDon;
    private javax.swing.JLabel lblSetDonViTinh;
    private javax.swing.JLabel lblSetGiaTien;
    private javax.swing.JLabel lblSetThanhTien;
    private javax.swing.JLabel lblSetTienThueVAT;
    private javax.swing.JLabel lblSetTienTraKhach;
    private javax.swing.JLabel lblSetTongTien;
    private javax.swing.JLabel lblSetTongTienBan;
    private javax.swing.JLabel lblSoLuong;
    private javax.swing.JLabel lblTenBan;
    private javax.swing.JLabel lblTenBan_QuanLy;
    private javax.swing.JLabel lblTenKhach;
    private javax.swing.JLabel lblTenMon;
    private javax.swing.JLabel lblTenNhanVien;
    private javax.swing.JLabel lblThanhTien;
    private javax.swing.JLabel lblThoat;
    private javax.swing.JLabel lblThoiGian;
    private javax.swing.JLabel lblThueVAT;
    private javax.swing.JLabel lblTienNhanKhach;
    private javax.swing.JLabel lblTienThueVAT;
    private javax.swing.JLabel lblTienTraKhach;
    private javax.swing.JLabel lblTieuDe;
    private javax.swing.JLabel lblTongTien;
    private javax.swing.JLabel lblTongTienBan;
    private javax.swing.JPanel pnlHoaDon;
    private javax.swing.JPanel pnlThongTinBanAn;
    private javax.swing.JPanel pnlThongTinHoaDon;
    private javax.swing.JPanel pnlThongTinMonAn;
    private javax.swing.JPanel pnlThongTinTien;
    private javax.swing.JPanel pnlTieuDe;
    private javax.swing.JScrollPane scrHoaDon;
    private javax.swing.JScrollPane scrXuatHoaDon;
    private javax.swing.JSpinner spnSoLuong;
    private javax.swing.JTable tblChiTietHoaDon;
    private javax.swing.JTable tblChiTietMonAn;
    private javax.swing.JTextField txtGhiChu;
    private javax.swing.JTextField txtGhiChu_QuanLy;
    private javax.swing.JTextField txtMaHoaDon;
    private javax.swing.JTextField txtTenKhach;
    private javax.swing.JTextField txtThueVAT;
    private javax.swing.JTextField txtTienNhanKhach;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
