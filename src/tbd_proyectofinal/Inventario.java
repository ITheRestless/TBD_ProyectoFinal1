/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tbd_proyectofinal;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author 52871
 */
public class Inventario extends javax.swing.JFrame {

    /**
     * Creates new form Inventario
     */
    public int sesID;
    Conexion con;
    Statement st;
    ResultSet rs;
    Personaje pers;
    ArrayList <Personaje> lista;
    int cont;
    public Inventario(int sesID) {
        initComponents();
        cont = 0;
        this.sesID = sesID;
        con = new Conexion();
        con.conectar();
        pers = new Personaje();
        lista = new ArrayList();
        //Personaje psj = new Personaje(1000, 5000, 3000, 100, "Michael Jackson", "C:\\Users\\52871\\Desktop\\Pixiv\\sauce.JPG", "C:\\Users\\52871\\Desktop\\Pixiv\\sauce.JPG", "C:\\Users\\52871\\Desktop\\Pixiv\\sauce.JPG", "SSSR");
        //Personaje psj2 = new Personaje(10000, 50000, 30000, 1000, "Jackson Michael ", "C:\\Users\\52871\\Desktop\\Pixiv\\yes.png", "C:\\Users\\52871\\Desktop\\Pixiv\\yes.png", "C:\\Users\\52871\\Desktop\\Pixiv\\yes.png", "SSSSR");
        //lista.add(psj);
        //lista.add(psj2);
        //String cueri = "SELECT un_id, inv_un_atk, inv_un_hp, inv_un_nivel FROM inventario_uni WHERE inv_un_usr_id = (SELECT sesiones.usr_id FROM sesiones WHERE sesiones.ses_id = "+sesID+")";
        String cueri = "SELECT invu.un_id, invu.inv_un_atk, invu.inv_un_hp, invu.inv_un_nivel, uni.un_nombre, uni.un_rareza, uni.un_img, uni.un_sprite, uni.un_icono FROM inventario_uni AS invu INNER JOIN unidades AS uni ON (uni.un_id = invu.un_id) WHERE inv_un_usr_id = (SELECT sesiones.usr_id FROM sesiones WHERE ses_id = "+sesID+")";
        try {
            st = con.conexion.createStatement();
            rs = st.executeQuery(cueri);
            
            while(rs.next()){
                pers.setId(rs.getInt(1));
                pers.setAtk(rs.getInt(2));
                pers.setHp(rs.getInt(3));
                pers.setNivel(rs.getInt(4));
                pers.setNombre(rs.getString(5));
                pers.setImg(rs.getString(7));
                pers.setSprite(rs.getString(8));
                pers.setIcono(rs.getString(9));
                pers.setRareza(rs.getString(6));
                lista.add(pers);
            }
        } 
        catch (SQLException ex) {
            Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(lista.size() > 0)
            informacion();
    }
    
    public void informacion(){
        if(cont == lista.size())
            cont = 0;
        try {
            BufferedImage img = ImageIO.read(new File(lista.get(cont).getImg()));
            Image dimg = img.getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_SMOOTH);
            jLabel1.setIcon(new ImageIcon(dimg));
        } 
        catch (IOException ex) {
            Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE, null, ex);
        }
        jnombre.setText(lista.get(cont).getNombre());
        this.jnivel.setText(lista.get(cont).getNivel()+"");
        this.jrareza.setText(lista.get(cont).getRareza());
        this.jatk.setText(lista.get(cont).getAtk()+"");
        this.jhp.setText(lista.get(cont++).getHp()+"");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jnombre = new javax.swing.JLabel();
        jnivel = new javax.swing.JLabel();
        jrareza = new javax.swing.JLabel();
        jatk = new javax.swing.JLabel();
        jhp = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("jLabel1");

        jnombre.setText("jLabel2");

        jnivel.setText("jLabel3");

        jrareza.setText("jLabel2");

        jatk.setText("jLabel2");

        jhp.setText("jLabel2");

        jButton1.setText("Siguiente");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Volver");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jnombre)
                    .addComponent(jnivel)
                    .addComponent(jrareza)
                    .addComponent(jatk)
                    .addComponent(jhp)
                    .addComponent(jButton1))
                .addContainerGap(286, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jnombre)
                        .addGap(18, 18, 18)
                        .addComponent(jnivel)
                        .addGap(18, 18, 18)
                        .addComponent(jrareza)
                        .addGap(18, 18, 18)
                        .addComponent(jatk)
                        .addGap(18, 18, 18)
                        .addComponent(jhp))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(lista.size() > 0)
            this.informacion();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new Menu(sesID).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inventario(0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jatk;
    private javax.swing.JLabel jhp;
    private javax.swing.JLabel jnivel;
    private javax.swing.JLabel jnombre;
    private javax.swing.JLabel jrareza;
    // End of variables declaration//GEN-END:variables
}
