import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import java.awt.*;
import java.util.List;

public class MainFrame {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->{
            JFrame frame = new JFrame("Contoh konkurensi di Swing");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 200);
            frame.setLayout(new BorderLayout());

        //label untuk status
        JLabel statusJLabel = new JLabel("Tekan Tombol Untuk Melakukan Tugas Berat",JLabel.CENTER);

        //tombol untuk memulai suatu proses
        JButton starButton = new JButton("Mulai");

        //progres bar
        JProgressBar progressBar = new JProgressBar(0, 60);
        progressBar.setValue(0);
        progressBar.setStringPainted(true);

        //tambah komponen ke frame
        frame.add(statusJLabel, BorderLayout.NORTH);
        frame.add(starButton, BorderLayout.CENTER);
        

        //tombol aksi 
        starButton.addActionListener(e -> {
            //update progress bar 1% per detik
            for (int i=0; i<=60; i++){
                progressBar.setValue(i);
                try {
                    Thread.sleep(1000);
                } catch (Exception ex){
                    System.err.println(ex.getMessage());
                }
                }
            });
            //tampilakn frame
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });

    }
}