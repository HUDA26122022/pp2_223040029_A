package Latihan2;

import java.awt.Frame;
import java.awt.event.*;
import javax.swing.*;

public class BioData extends JFrame {
    
    private boolean checkBoxSelected;

    public BioData(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel labelInput = new JLabel("Nama : ");
        labelInput.setBounds(15,40,350,15);

        JTextField textField = new JTextField();
        textField.setBounds(15,60,350,30);

        JLabel labelInputNoHp = new JLabel("No Hp : ");
        labelInputNoHp.setBounds(15,100,350,15);

        JTextField textFieldNoHp = new JTextField();
        textFieldNoHp.setBounds(15,120,350,30);

        JLabel labelRadio = new JLabel("Jenis kelamin :");
        labelRadio.setBounds(15,160,350,15);

        JRadioButton radioButton1 = new JRadioButton(" Laki - Laki");
        radioButton1.setBounds(15,175,350,30);
        
        JRadioButton radioButton2 = new JRadioButton(" Perempuan");
        radioButton2.setBounds(15,200,350,30);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(radioButton1);
        bg.add(radioButton2);

        JCheckBox checkBox = new JCheckBox("Warga Negara Asing");
        checkBox.setBounds(15,225,350,30);

        JButton button = new JButton("simpan");
        button.setBounds(15,265,100,40);

        JTextArea labelOutput = new JTextArea("");
        labelOutput.setBounds(15,320,350,500);


        checkBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e){
                checkBoxSelected = e.getStateChange()==1;
            }
           });

       button.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
            String jenisKelamin = "";
           if(radioButton1.isSelected()){
            jenisKelamin = radioButton1.getText();
           }
           if(radioButton2.isSelected()){
            jenisKelamin = radioButton2.getText();
           } 
           if(checkBoxSelected){
            String nama = textField.getText();
            String NoHp = textFieldNoHp.getText();
            labelOutput.append("Nama : "+ nama  + "\n");
            labelOutput.append("No Hp : " + NoHp + "\n");
            labelOutput.append("Jenis Kelamin : "+ jenisKelamin +"\n");
            labelOutput.append("WNA : ya" +"\n");
            labelOutput.append("==================="+ "\n");
            textField.setText("");

        }else {
            String nama = textField.getText();
            String NoHp = textFieldNoHp.getText();
            labelOutput.append("Nama : "+ nama  + "\n");
            labelOutput.append("No Hp : " + NoHp + "\n");
            labelOutput.append("Jenis Kelamin : "+ jenisKelamin +"\n");
            labelOutput.append("WNA : Bukan WNA" + "\n");
            labelOutput.append("===================" + "\n");
            textField.setText("");
        }

    }});

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

        this.setSize(400,500);
        this.setLayout(null);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                BioData b = new BioData();
                b.setVisible(true);
            }

        });
    }
}
