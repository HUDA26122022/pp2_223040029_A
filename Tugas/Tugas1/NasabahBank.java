package Tugas.Tugas1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class NasabahBank extends JFrame {

    private boolean checkBoxSelected;

    public NasabahBank() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Menu bar
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Opsi");
        JMenuItem resetItem = new JMenuItem("Reset");
        JMenuItem exitItem = new JMenuItem("Keluar");
        menu.add(resetItem);
        menu.add(exitItem);
        menuBar.add(menu);
        this.setJMenuBar(menuBar);

        exitItem.addActionListener(e -> System.exit(0));

        JLabel labelInput = new JLabel("Nama : ");
        labelInput.setBounds(15, 40, 350, 15);

        JTextField textField = new JTextField();
        textField.setBounds(15, 60, 350, 30);

        JLabel labelInputNoHp = new JLabel("No Hp : ");
        labelInputNoHp.setBounds(15, 100, 350, 15);

        JTextField textFieldNoHp = new JTextField();
        textFieldNoHp.setBounds(15, 120, 350, 30);

        JLabel labelRadio = new JLabel("Jenis kelamin : ");
        labelRadio.setBounds(15, 160, 350, 15);

        JRadioButton radioButton1 = new JRadioButton(" Laki - Laki");
        radioButton1.setBounds(15, 175, 350, 30);

        JRadioButton radioButton2 = new JRadioButton(" Perempuan");
        radioButton2.setBounds(15, 200, 350, 30);

        ButtonGroup bg = new ButtonGroup();
        bg.add(radioButton1);
        bg.add(radioButton2);

        JCheckBox checkBox = new JCheckBox("Warga Negara Asing");
        checkBox.setBounds(15, 225, 350, 30);

        JLabel labelAccountType = new JLabel("Jenis Tabungan:");
        labelAccountType.setBounds(15, 265, 350, 15);

        // JList untuk jenis tabungan
        String[] accountTypes = { "Tabungan Biasa", "Tabungan Berjangka", "Deposito", "Tabungan Investasi" };
        JList<String> accountList = new JList<>(accountTypes);
        accountList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        accountList.setBounds(15, 285, 350, 70);

        JLabel labelTransactionFreq = new JLabel("Frekuensi Transaksi per Bulan:");
        labelTransactionFreq.setBounds(15, 360, 350, 15);

        // JSpinner untuk frekuensi transaksi
        JSpinner spinnerFreq = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
        spinnerFreq.setBounds(15, 375, 100, 30);

        JLabel labelPassword = new JLabel("Password:");
        labelPassword.setBounds(15, 415, 350, 15);

        // Field password
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(15, 435, 350, 30);

        JLabel labelConfirmPassword = new JLabel("Konfirmasi Password:");
        labelConfirmPassword.setBounds(15, 475, 350, 15);

        JPasswordField confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(15, 495, 350, 30);

        JLabel labelBirthDate = new JLabel("Tanggal Lahir:");
        labelBirthDate.setBounds(15, 535, 350, 15);

        // JSpinner untuk tanggal lahir
        SpinnerDateModel dateModel = new SpinnerDateModel();
        JSpinner spinnerBirthDate = new JSpinner(dateModel);
        spinnerBirthDate.setBounds(15, 555, 200, 30);
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(spinnerBirthDate, "dd/MM/yyyy");
        spinnerBirthDate.setEditor(dateEditor);

        JButton button = new JButton("Simpan");
        button.setBounds(15, 595, 100, 40);

        JTextArea labelOutput = new JTextArea("");
        labelOutput.setBounds(15, 650, 350, 200);

        checkBox.addItemListener(e -> checkBoxSelected = e.getStateChange() == 1);

        button.addActionListener(e -> {
            String jenisKelamin = radioButton1.isSelected() ? radioButton1.getText()
                    : radioButton2.isSelected() ? radioButton2.getText() : "";

            String nama = textField.getText();
            String noHp = textFieldNoHp.getText();
            String jenisTabungan = accountList.getSelectedValue();
            int transaksiPerBulan = (Integer) spinnerFreq.getValue();
            char[] password = passwordField.getPassword();
            char[] confirmPassword = confirmPasswordField.getPassword();
            String passwordCheck = new String(password).equals(new String(confirmPassword)) ? "Password cocok"
                    : "Password tidak cocok";

            labelOutput.setText("");
            labelOutput.append("Nama: " + nama + "\n");
            labelOutput.append("No Hp: " + noHp + "\n");
            labelOutput.append("Jenis Kelamin: " + jenisKelamin + "\n");
            labelOutput.append("Jenis Tabungan: " + jenisTabungan + "\n");
            labelOutput.append("Frekuensi Transaksi: " + transaksiPerBulan + " kali per bulan " + "\n");
            labelOutput.append("Password: " + passwordCheck + "\n");
            labelOutput.append("Tanggal Lahir: " + dateEditor.getFormat().format(spinnerBirthDate.getValue()) + "\n");
            labelOutput.append("WNA: " + (checkBoxSelected ? "ya" : "Bukan WNA") + "\n");
            labelOutput.append("===================" + "\n");

            // Aksi reset
            resetItem.addActionListener(a -> {
                textField.setText("");
                textFieldNoHp.setText("");
                bg.clearSelection();
                accountList.clearSelection();
                spinnerFreq.setValue(1);
                passwordField.setText("");
                confirmPasswordField.setText("");
                spinnerBirthDate.setValue(new java.util.Date());
                labelOutput.setText("");
            });
        });
        // JScrollPane untuk scroll halaman
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(400, 800));

        this.add(scrollPane);
        this.setSize(420, 850);
        this.setLayout(new BorderLayout());

        this.add(button);
        this.add(textField);
        this.add(labelRadio);
        this.add(radioButton1);
        this.add(radioButton2);
        this.add(checkBox);
        this.add(labelInputNoHp);
        this.add(textFieldNoHp);
        this.add(labelInput);
        this.add(labelOutput);
        this.add(labelAccountType);
        this.add(accountList);
        this.add(labelTransactionFreq);
        this.add(spinnerFreq);
        this.add(labelPassword);
        this.add(passwordField);
        this.add(labelConfirmPassword);
        this.add(confirmPasswordField);
        this.add(labelBirthDate);
        this.add(spinnerBirthDate);

        this.setSize(400, 900);
        this.setLayout(null);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            NasabahBank b = new NasabahBank();
            b.setVisible(true);
        });
    }
}
