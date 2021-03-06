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
        lblSearch.setText("ARAMA ??FADES??:");
        lblSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                lblSearchKeyReleased(evt);
            }
        });

        kaydolbutton.setBackground(new java.awt.Color(255, 255, 204));
        kaydolbutton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        kaydolbutton.setText("KAYDOL");
        kaydolbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kaydolbuttonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("SOYADINIZ:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("????FRE:");

        soyadiniztxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                soyadiniztxtActionPerformed(evt);
            }
        });

        sifreniztxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sifreniztxtActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("ADINIZ:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("SIRA NUMARASI:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("TCKN:");

        javax.swing.GroupLayout siralabelLayout = new javax.swing.GroupLayout(siralabel);
        siralabel.setLayout(siralabelLayout);
        siralabelLayout.setHorizontalGroup(
            siralabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(siralabelLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(siralabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(siralabelLayout.createSequentialGroup()
                        .addGroup(siralabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(siralabelLayout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(adiniztxt, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(siralabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addGroup(siralabelLayout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(siralabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tctxt, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(soyadiniztxt, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(siralabelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(idtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(148, 148, 148)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(siralabelLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sifreniztxt, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, siralabelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(kaydolbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(247, 247, 247))
            .addGroup(siralabelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(siralabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(siralabelLayout.createSequentialGroup()
                        .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        siralabelLayout.setVerticalGroup(
            siralabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, siralabelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(siralabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(siralabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(siralabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(adiniztxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(soyadiniztxt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(siralabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sifreniztxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(tctxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(kaydolbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(siralabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(siralabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lblSearchKeyReleased
        
    }//GEN-LAST:event_lblSearchKeyReleased

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
     
    }//GEN-LAST:event_txtSearchActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        String searchKey=txtSearch.getText();
        TableRowSorter<DefaultTableModel> tableRowSorter=new TableRowSorter<DefaultTableModel>(model);
        tblogrenciler.setRowSorter(tableRowSorter);
        tableRowSorter.setRowFilter(RowFilter.regexFilter(searchKey)); 
    }//GEN-LAST:event_txtSearchKeyReleased

    private void soyadiniztxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_soyadiniztxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_soyadiniztxtActionPerformed

    private void kaydolbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kaydolbuttonActionPerformed
       Connection connection=null;
       dbHelper dbhelper=new dbHelper();
       PreparedStatement statement = null;
       
       try
       {
           connection=dbhelper.getConnection();
           String sql="insert into kayitliogrenciler (id,name,surname,password,TCKN) values(?,?,?,?,?)";
           
           statement=connection.prepareStatement(sql);
           statement.setInt(1,Integer.valueOf( idtxt.getText()));
           statement.setString(2,adiniztxt.getText() );
           statement.setString(3,soyadiniztxt.getText());
           statement.setInt(4,Integer.valueOf( sifreniztxt.getText()));
           statement.setInt(5, Integer.valueOf( tctxt.getText()));
           int result=statement.executeUpdate();
           tabloyudoldur();
       }catch(SQLException exception ){
           dbhelper.showErrorMessage(exception);
       }finally{
           try {
               statement.close();
               connection.close();
           } catch (SQLException ex) {
             
           }
       }
    }//GEN-LAST:event_kaydolbuttonActionPerformed

    private void sifreniztxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sifreniztxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sifreniztxtActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(kisiListesi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(kisiListesi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(kisiListesi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(kisiListesi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new kisiListesi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField adiniztxt;
    private javax.swing.JTextField idtxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton kaydolbutton;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JTextField sifreniztxt;
    private javax.swing.JPanel siralabel;
    private javax.swing.JTextField soyadiniztxt;
    private javax.swing.JTable tblogrenciler;
    private javax.swing.JTextField tctxt;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
