/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import model.MyBatisUtil; 
import org.apache.ibatis.session.SqlSession; 
import view.TransportsView;
import controller.TransportsController;
import model.TransportMapper;
/**
 *
 * @author Amh
 */
public class Main {
    public static void main(String[] args) {
        SqlSession session = MyBatisUtil.getSqlSession(); 
        TransportMapper mapper = session.getMapper(TransportMapper.class);
        
        TransportsView view = new TransportsView(); 
        new TransportsController(view, mapper);
        
        view.setVisible(true);
    }
}

