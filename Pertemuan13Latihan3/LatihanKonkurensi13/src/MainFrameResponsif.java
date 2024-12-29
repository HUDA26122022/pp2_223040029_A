import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

import java.awt.*;
import java.util.List;

public class MainFrameResponsif {

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
        

          // Tombol aksi
          starButton.addActionListener(e -> {
            starButton.setEnabled(false); // Nonaktifkan tombol saat proses berjalan
            statusJLabel.setText("Proses berjalan...");

            // Buat SwingWorker untuk menangani tugas berat
            SwingWorker<Void, Integer> worker = new SwingWorker<>() {
                @Override
                protected Void doInBackground() throws Exception {
                    // Simulasi tugas berat
                    for (int i = 0; i <= 100; i++) {
                        Thread.sleep(50); // Simulasi delay
                        publish(i); // Perbarui progres
                    }
                    return null;
                }

                @Override
                protected void process(List<Integer> chunks) {
                    // Perbarui progress bar
                    int latestProgress = chunks.get(chunks.size() - 1);
                    progressBar.setValue(latestProgress);
                }

                @Override
                protected void done() {
                    // Aksi setelah tugas selesai
                    starButton.setEnabled(true);
                    statusJLabel.setText("Proses selesai!");
                }
            };

            // Jalankan SwingWorker
            worker.execute();
        });
            //tampilakn frame
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });

    }
}