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

     @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        siralabel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblogrenciler = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        lblSearch = new javax.swing.JLabel();
        kaydolbutton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        soyadiniztxt = new javax.swing.JTextField();
        sifreniztxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        adiniztxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        idtxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tctxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        siralabel.setBackground(new java.awt.Color(153, 153, 255));

        tblogrenciler.setBackground(new java.awt.Color(255, 255, 204));
        tblogrenciler.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "name", "surname", "password", "TCKN"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblogrenciler);
        if (tblogrenciler.getColumnModel().getColumnCount() > 0) {
            tblogrenciler.getColumnModel().getColumn(0).setResizable(false);
            tblogrenciler.getColumnModel().getColumn(1).setResizable(false);
            tblogrenciler.getColumnModel().getColumn(2).setResizable(false);
            tblogrenciler.getColumnModel().getColumn(3).setResizable(false);
            tblogrenciler.getColumnModel().getColumn(4).setResizable(false);
        }

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        lblSearch.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblSearch.setText("ARAMA İFADESİ:");
        lblSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                lblSearchKeyReleased(evt);
            }
        });
