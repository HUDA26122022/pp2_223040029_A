/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model;

import org.apache.ibatis.annotations.*;
import java.util.List;
/**
 *
 * @author Amh
 */
public interface TransportMapper {
    @Select("SELECT * FROM transports")
    List<Transport> getAllTransports();

    @Insert("INSERT INTO transports (name, brand, price, stock) VALUES (#{name}, #{brand}, #{price}, #{stock})")
    void insertTransport(Transport transport);

    @Update("UPDATE transports SET name = #{name}, brand = #{brand}, price = #{price}, stock = #{stock} WHERE id = #{id}")
    void updateTransport(Transport transport);

    @Delete("DELETE FROM transports WHERE id = #{id}")
    void deleteTransport(int id);
}
