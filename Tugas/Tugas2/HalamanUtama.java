package Tugas.Tugas2;

import java.awt.event.*;
import java.text.Normalizer.Form;

import javax.swing.*;

public class HalamanUtama {
    public static void main(String[] args) {
        JFrame frame = new JFrame("AMH STORE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Penggunaan JMenuBar
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        
        JMenuItem menu1 = new JMenuItem("Halaman Pertama");
        JMenuItem menu2 = new JMenuItem("Halaman Kedua");

        menu1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Membuka halaman kedua saat menu1 diklik
                FormPembelianGantungan halamanPertama = new FormPembelianGantungan();
                halamanPertama.setVisible(true);
            }
        });

        menu2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Membuka halaman kedua saat menu1 diklik
                FormPembelianTas halamanKedua = new FormPembelianTas();
                halamanKedua.setVisible(true);
            }
        });

        menuBar.add(menu);
        menu.add(menu1);
        menu.add(menu2);

        frame.setJMenuBar(menuBar);       
        frame.setSize(400, 200);
        frame.setLocationRelativeTo(null); // Memposisikan frame di tengah
        frame.setVisible(true);
    }
}
