import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tgmnblt
 */
public class kisiListesi extends javax.swing.JFrame {
    DefaultTableModel model;

    /**
     * Creates new form kisiListesi
     */
    public kisiListesi() {
        
        initComponents();
        tabloyudoldur();
    }
    
    
    public void tabloyudoldur() 
    {
          model=(DefaultTableModel)tblogrenciler.getModel();
          model.setRowCount(0); 
        try {
            ArrayList<ogrenci> ogrenciler=getOgrenciler();
            for(ogrenci ogr: ogrenciler )
            {
                Object[] row={ogr.getId(),ogr.getName(),ogr.getSurname(),ogr.getPassword(),ogr.getTCKN()};
                model.addRow(row);
                        }
                    } catch (SQLException ex) {
            
        }
    }
    
    
    public ArrayList<ogrenci> getOgrenciler() throws SQLException{
    Connection connection=null;
    dbHelper db=new dbHelper();
    Statement statement =null;
    ResultSet resultSet;
     ArrayList<ogrenci> ogrenciler =null;
    
    try{
        connection=db.getConnection();
        statement = connection.createStatement();
        resultSet=statement.executeQuery("select * from kayitliogrenciler");
        ogrenciler=new ArrayList<ogrenci>();
        
       while(resultSet.next())
     {
          ogrenciler.add(new ogrenci  
                ( resultSet.getInt("ID") ,
                  resultSet.getString("NAME") , 
                  resultSet.getString("SURNAME"),
                  resultSet.getInt("password"),
                 resultSet.getInt("TCKN")
                ));
     }
        
        
    }catch(SQLException exception)
     {
        
     }finally
    {
        statement.close();
        connection.close();
    }
    return ogrenciler;
            
}
    private void kat1btnActionPerformed(java.awt.event.ActionEvent evt) {                                        
        kat1veli k1 = new kat1veli();
        k1.setVisible(true);
    }                                       

    private void kat2btnActionPerformed(java.awt.event.ActionEvent evt) {                                        
         kat2veli k2 = new kat2veli();
         k2.setVisible(true);
    }                                       

    private void kat3btnActionPerformed(java.awt.event.ActionEvent evt) {                                        
         kat3veli k3 = new kat3veli();
         k3.setVisible(true);
    }                                       

    private void kat4btnActionPerformed(java.awt.event.ActionEvent evt) {                                        
        kat4veli k4 = new kat4veli();
        k4.setVisible(true);
    }                                       

    private void kat5btnActionPerformed(java.awt.event.ActionEvent evt) {                                        
        kat5veli k5 = new kat5veli();
        k5.setVisible(true);
    }                                       

    private void kat6btnActionPerformed(java.awt.event.ActionEvent evt) {                                        
        kat6veli k6 = new kat6veli();
        k6.setVisible(true);
    }  
