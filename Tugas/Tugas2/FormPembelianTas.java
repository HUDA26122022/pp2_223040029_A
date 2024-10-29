package Tugas.Tugas2;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class FormPembelianTas extends JFrame {
    private JTextField txtKode, txtJudul;
    private JTextArea txtDeskripsi;
    private JComboBox<String> cmbKategori;
    private JRadioButton rbBaru, rbBekas;
    private JCheckBox cbTersedia;
    private JSpinner spnStok;
    private JSlider sldHarga;
    private JTable tblBuku;
    private DefaultTableModel tableModel;

    public FormPembelianTas() {



        setTitle("From Pemesanan Tas");
        setSize(600, 800);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Panel Input
        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        // Komponen-komponen input
        txtKode = new JTextField(20);
        txtJudul = new JTextField(20);
        txtDeskripsi = new JTextArea(3, 20);
        cmbKategori = new JComboBox<>(new String[]{"Pink", "Hitam", "Purple", "Merah"});
        
        ButtonGroup bgKondisi = new ButtonGroup();
        rbBaru = new JRadioButton("Kecil");
        rbBekas = new JRadioButton("Besar");
        bgKondisi.add(rbBaru);
        bgKondisi.add(rbBekas);
        
        cbTersedia = new JCheckBox("Tersedia");
        
        spnStok = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        
        sldHarga = new JSlider(5000, 25000, 25000);
        sldHarga.setMajorTickSpacing(5000);
        sldHarga.setPaintTicks(true);
        sldHarga.setPaintLabels(true);

        // Menambahkan komponen ke panel
        gbc.gridx = 0; gbc.gridy = 0;
        inputPanel.add(new JLabel("Nama :"), gbc);
        gbc.gridx = 1;
        inputPanel.add(txtKode, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        inputPanel.add(new JLabel("Alamat :"), gbc);
        gbc.gridx = 1;
        inputPanel.add(txtJudul, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        inputPanel.add(new JLabel("Catatan Pesanan :"), gbc);
        gbc.gridx = 1;
        inputPanel.add(new JScrollPane(txtDeskripsi), gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        inputPanel.add(new JLabel("Varian :"), gbc);
        gbc.gridx = 1;
        inputPanel.add(cmbKategori, gbc);

        gbc.gridx = 0; gbc.gridy = 4;
        inputPanel.add(new JLabel("Ukuran :"), gbc);
        JPanel kondisiPanel = new JPanel();
        kondisiPanel.add(rbBaru);
        kondisiPanel.add(rbBekas);
        gbc.gridx = 1;
        inputPanel.add(kondisiPanel, gbc);

        gbc.gridx = 0; gbc.gridy = 5;
        inputPanel.add(new JLabel("Status :"), gbc);
        gbc.gridx = 1;
        inputPanel.add(cbTersedia, gbc);

        gbc.gridx = 0; gbc.gridy = 6;
        inputPanel.add(new JLabel("Jumlah Pemesanan :"), gbc);
        gbc.gridx = 1;
        inputPanel.add(spnStok, gbc);

        gbc.gridx = 0; gbc.gridy = 7;
        inputPanel.add(new JLabel("Harga :"), gbc);
        gbc.gridx = 1;
        inputPanel.add(sldHarga, gbc);

        // Button
        JButton btnSimpan = new JButton("Simpan");
        gbc.gridx = 1; gbc.gridy = 8;
        inputPanel.add(btnSimpan, gbc);

        // Table
        String[] columns = {"Nama", "Alamat", "Catatan Pesanan", "Varian", "Status", "Jumlah Pemesanan", "Harga"};
        tableModel = new DefaultTableModel(columns, 0);
        tblBuku = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tblBuku);

        // Action Listener untuk button simpan
        btnSimpan.addActionListener(e -> {
            String[] data = {
                txtKode.getText(),
                txtJudul.getText(),
                cmbKategori.getSelectedItem().toString(),
                rbBaru.isSelected() ? "Besar" : "Kecil",
                cbTersedia.isSelected() ? "Tersedia" : "Tidak Tersedia",
                spnStok.getValue().toString(),
                String.valueOf(sldHarga.getValue())
            };
            tableModel.addRow(data);
            clearForm();
        });

        // Layout
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void clearForm() {
        txtKode.setText("");
        txtJudul.setText("");
        txtDeskripsi.setText("");
        cmbKategori.setSelectedIndex(0);
        rbBaru.setSelected(true);
        cbTersedia.setSelected(false);
        spnStok.setValue(0);
        sldHarga.setValue(50000);
    }
}
