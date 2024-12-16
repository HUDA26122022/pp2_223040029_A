/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.GridLayout;
import model.Transport;
import view.TransportsView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import model.TransportMapper;
/**
 *
 * @author Amh
 */
public class TransportsController {
    private TransportsView view;
    private TransportMapper mapper;
    
    

    public TransportsController(TransportsView view, TransportMapper mapper) {
        this.view = view;
        this.mapper = mapper;

        view.getBtnAdd().addActionListener(e -> addTransport());
        view.getBtnDelete().addActionListener(e -> deleteTransport());
        view.getBtnRefresh().addActionListener(e -> loadTransports());
        
        view.getBtnUpdate().addActionListener(e -> {
    int selectedRow = view.getTable().getSelectedRow();
    if (selectedRow == -1) {

        return;
    }

    int id = (int) view.getTable().getValueAt(selectedRow, 0);
    String currentName = view.getTable().getValueAt(selectedRow, 1).toString();
    String currentBrand = view.getTable().getValueAt(selectedRow, 2).toString();
    double currentPrice = Double.parseDouble(view.getTable().getValueAt(selectedRow, 3).toString());
    int currentStock = Integer.parseInt(view.getTable().getValueAt(selectedRow, 4).toString());

    JDialog dialog = new JDialog(view, "Update Transport", true);
    dialog.setLayout(new GridLayout(5, 2, 10, 10));
    dialog.setSize(400, 300);

    JTextField tfName = new JTextField(currentName);
    JTextField tfBrand = new JTextField(currentBrand);
    JTextField tfPrice = new JTextField(String.valueOf(currentPrice));
    JTextField tfStock = new JTextField(String.valueOf(currentStock));
    JButton btnUpdateDialog = new JButton("Update");

    dialog.add(new JLabel("Name:"));
    dialog.add(tfName);
    dialog.add(new JLabel("Brand:"));
    dialog.add(tfBrand);
    dialog.add(new JLabel("Price:"));
    dialog.add(tfPrice);
    dialog.add(new JLabel("Stock:"));
    dialog.add(tfStock);
    dialog.add(new JLabel()); // untuk jarak
    dialog.add(btnUpdateDialog);

    btnUpdateDialog.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            Transport e = new Transport();
            e.setId(id);
            e.setName(tfName.getText());
            e.setBrand(tfBrand.getText());
            e.setPrice(Double.parseDouble(tfPrice.getText()));
            e.setStock(Integer.parseInt(tfStock.getText()));
            
            mapper.updateTransport(e);
            JOptionPane.showMessageDialog(dialog, "Data berhasil di update");
            dialog.dispose();
            loadTransports();
        }
    });
        dialog.setLocationRelativeTo(view);
        dialog.setVisible(true);
    });  
        loadTransports();
    }

    private void loadTransports() {
        List<Transport> transports = mapper.getAllTransports();
        DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Name", "Brand", "Price", "Stock"}, 0);
        for (Transport e : transports) {
            model.addRow(new Object[]{e.getId(), e.getName(), e.getBrand(), e.getPrice(), e.getStock()});
        }
        view.getTable().setModel(model);
    }

    private void addTransport() {
        Transport e = new Transport();
        e.setName(view.getTfName().getText());
        e.setBrand(view.getTfBrand().getText());
        e.setPrice(Double.parseDouble(view.getTfPrice().getText()));
        e.setStock(Integer.parseInt(view.getTfStock().getText()));
        mapper.insertTransport(e);
        loadTransports();
    }

    private void updateTransport() {
        int selectedRow = view.getTable().getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(view, "Pilih baris yang ingin di update");
            return;
        }
        Transport e = new Transport();
    }

    private void deleteTransport() {
        int selectedRow = view.getTable().getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(view, "Pilih baris yang ingin di hapus");
            return;
        }
        int id = (int) view.getTable().getValueAt(selectedRow, 0);
        mapper.deleteTransport(id);
        loadTransports();
    }
}