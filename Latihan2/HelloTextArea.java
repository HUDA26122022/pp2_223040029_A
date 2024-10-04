package Latihan2;

import java.awt.event.*;
import javax.swing.*;


public class HelloTextArea extends JFrame {
    
    public HelloTextArea(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel labelInput = new JLabel("Input nama");
        labelInput.setBounds(130,40,400,15);

        JTextField textField = new JTextField();
        textField.setBounds(130,60,100,30);

        JLabel labelInputNoHp = new JLabel("Input Nomber Hp");
        labelInputNoHp.setBounds(130,100,400,15);

        JTextField textFieldNoHp = new JTextField();
        textFieldNoHp.setBounds(130,120,100,30);


        JButton button = new JButton("Klik");
        button.setBounds(130,160,100,40);

        JTextArea textOutput = new JTextArea("");
        textOutput.setBounds(80,220,200,100);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String nama = textField.getText();
                String NoHp = textFieldNoHp.getText();
                textOutput.append("Hello "+ nama  + " - " + NoHp);
                textField.setText("");
            }
        });

        this.add(button);
        this.add(textField);
        this.add(labelInput);
        this.add(labelInputNoHp);
        this.add(textFieldNoHp);
        this.add(textOutput);

        this.setSize(400,500);
        this.setLayout(null);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run(){
                HelloTextArea h = new HelloTextArea();
                h.setVisible(true);
            }

        });
    }
}
