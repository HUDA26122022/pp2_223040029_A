package Latihan2;

import java.awt.event.*;
import javax.swing.*;

public class HelloCheckBox extends JFrame {

    private boolean checkBoxSelected;

    public HelloCheckBox(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel labelInput = new JLabel("input nama");
        labelInput.setBounds(15,40,350,15);

        JTextField textField = new JTextField();
        textField.setBounds(15,60,350,30);

        JCheckBox checkBox = new JCheckBox("Saya menyetujui syarat dan ketentuan yang berlaku");
        checkBox.setBounds(15,100,350,30);

        JButton button = new JButton("simpan");
        button.setBounds(15,150,100,40);

        JTextArea labelOutput = new JTextArea("");
        labelOutput.setBounds(15,200,350,100);

       checkBox.addItemListener(new ItemListener() {
        public void itemStateChanged(ItemEvent e){
            checkBoxSelected = e.getStateChange()==1;
        }
       });

       button.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
           if(checkBoxSelected){
            String nama = textField.getText();
            labelOutput.append("Hello "+ nama  + "\n");
            textField.setText("");
        }else {
            labelOutput.append("Anda tidak mencentang kotak persetujuan\n");
        }
           }
            
    });

        this.add(button);
        this.add(textField);
        this.add(checkBox);
        this.add(labelInput);
        this.add(labelOutput);

        this.setSize(400,500);
        this.setLayout(null);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                HelloCheckBox b = new HelloCheckBox();
                b.setVisible(true);
            }

        });
    }
}
