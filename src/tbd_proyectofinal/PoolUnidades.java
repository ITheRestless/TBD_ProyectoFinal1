package tbd_proyectofinal;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/*
 * @author Mauricio Avitia
 */

public class PoolUnidades extends javax.swing.JFrame {
    ArrayList<Personaje> pers;
    int pag = 0;
    int sesID;
    
    public PoolUnidades(int sesID) {
        initComponents();
        
        this.sesID = sesID;
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

        Conexion sql = new Conexion();
        pers = sql.consultaPersnajes("select * from unidades");
        MostrarPagina();
    }
    
    public void MostrarPagina() {
        try {
            BufferedImage img = ImageIO.read(new File(pers.get((pag*4)).un_sprite));
            Image dimg  = img.getScaledInstance(sp1.getWidth(), sp1.getHeight(), Image.SCALE_SMOOTH);
            sp1.setIcon(new ImageIcon(dimg));
            name1.setText(pers.get((pag*4)).un_nombre);
            atk1.setText(pers.get((pag*4) + 1).un_atkinc + "");
            hp1.setText(pers.get((pag*4) + 1).un_hp + "");
            rare1.setText(pers.get((pag*4) + 1).un_rareza);
        } catch (IOException ex) {
            sp1.setIcon(null);
            name1.setText("");
            atk1.setText("");
            hp1.setText("");
            rare1.setText("");
        }
        try {
            BufferedImage img = ImageIO.read(new File(pers.get((pag*4) + 1).un_sprite));
            Image dimg  = img.getScaledInstance(sp2.getWidth(), sp2.getHeight(), Image.SCALE_SMOOTH);
            sp2.setIcon(new ImageIcon(dimg));
            name2.setText(pers.get((pag*4) + 2).un_nombre);
            atk2.setText(pers.get((pag*4) + 2).un_atkinc + "");
            hp2.setText(pers.get((pag*4) + 2).un_hp + "");
            rare2.setText(pers.get((pag*4) + 2).un_rareza);
        } catch (IOException ex) {
            sp2.setIcon(null);
            name2.setText("");
            atk2.setText("");
            hp2.setText("");
            rare2.setText("");
        }
        try {    
            BufferedImage img = ImageIO.read(new File(pers.get((pag*4) + 2).un_sprite));
            Image dimg  = img.getScaledInstance(sp3.getWidth(), sp3.getHeight(), Image.SCALE_SMOOTH);
            sp3.setIcon(new ImageIcon(dimg));
            name3.setText(pers.get((pag*4) + 2).un_nombre);
            atk3.setText(pers.get((pag*4) + 2).un_atkinc + "");
            hp3.setText(pers.get((pag*4) + 2).un_hp + "");
            rare3.setText(pers.get((pag*4) + 2).un_rareza);
        } catch (IOException ex) {
            sp3.setIcon(null);
            name3.setText("");
            atk3.setText("");
            hp3.setText("");
            rare3.setText("");
        }
        try {
            BufferedImage img = ImageIO.read(new File(pers.get((pag*4) + 3).un_sprite));
            Image dimg  = img.getScaledInstance(sp4.getWidth(), sp4.getHeight(), Image.SCALE_SMOOTH);
            sp4.setIcon(new ImageIcon(dimg));
            name4.setText(pers.get((pag*4) + 3).un_nombre);
            atk4.setText(pers.get((pag*4) + 3).un_atkinc + "");
            hp4.setText(pers.get((pag*4) + 3).un_hp + "");
            rare4.setText(pers.get((pag*4) + 3).un_rareza);
        } catch (IOException ex) {
            sp4.setIcon(null);
            name4.setText("");
            atk4.setText("");
            hp4.setText("");
            rare4.setText("");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sp1 = new javax.swing.JLabel();
        name1 = new javax.swing.JLabel();
        atk1 = new javax.swing.JLabel();
        hp1 = new javax.swing.JLabel();
        rare1 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        sp2 = new javax.swing.JLabel();
        name2 = new javax.swing.JLabel();
        atk2 = new javax.swing.JLabel();
        hp2 = new javax.swing.JLabel();
        rare2 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        sp3 = new javax.swing.JLabel();
        name3 = new javax.swing.JLabel();
        atk3 = new javax.swing.JLabel();
        hp3 = new javax.swing.JLabel();
        rare3 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        sp4 = new javax.swing.JLabel();
        name4 = new javax.swing.JLabel();
        atk4 = new javax.swing.JLabel();
        hp4 = new javax.swing.JLabel();
        rare4 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(934, 412));
        setMinimumSize(new java.awt.Dimension(934, 412));
        setPreferredSize(new java.awt.Dimension(934, 412));
        getContentPane().setLayout(null);

        sp1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sprites/Gifs/Iddle.gif"))); // NOI18N
        getContentPane().add(sp1);
        sp1.setBounds(130, 30, 120, 120);

        name1.setFont(new java.awt.Font("Bahnschrift", 1, 12)); // NOI18N
        name1.setForeground(new java.awt.Color(255, 255, 255));
        name1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        name1.setText("No - Name");
        getContentPane().add(name1);
        name1.setBounds(260, 30, 80, 15);

        atk1.setForeground(new java.awt.Color(255, 255, 255));
        atk1.setText("atk");
        getContentPane().add(atk1);
        atk1.setBounds(260, 50, 80, 16);

        hp1.setForeground(new java.awt.Color(255, 255, 255));
        hp1.setText("hp");
        getContentPane().add(hp1);
        hp1.setBounds(260, 70, 80, 16);

        rare1.setForeground(new java.awt.Color(255, 255, 255));
        rare1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rare1.setText("rare");
        getContentPane().add(rare1);
        rare1.setBounds(300, 110, 40, 40);

        jLabel22.setBackground(new java.awt.Color(51, 51, 51));
        jLabel22.setOpaque(true);
        getContentPane().add(jLabel22);
        jLabel22.setBounds(120, 20, 310, 140);

        sp2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sprites/Gifs/Iddle.gif"))); // NOI18N
        getContentPane().add(sp2);
        sp2.setBounds(460, 30, 120, 120);

        name2.setFont(new java.awt.Font("Bahnschrift", 1, 12)); // NOI18N
        name2.setForeground(new java.awt.Color(255, 255, 255));
        name2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        name2.setText("No - Name");
        getContentPane().add(name2);
        name2.setBounds(590, 30, 90, 15);

        atk2.setForeground(new java.awt.Color(255, 255, 255));
        atk2.setText("atk");
        getContentPane().add(atk2);
        atk2.setBounds(590, 50, 90, 16);

        hp2.setForeground(new java.awt.Color(255, 255, 255));
        hp2.setText("hp");
        getContentPane().add(hp2);
        hp2.setBounds(590, 70, 90, 16);

        rare2.setForeground(new java.awt.Color(255, 255, 255));
        rare2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rare2.setText("rare");
        getContentPane().add(rare2);
        rare2.setBounds(630, 110, 50, 40);

        jLabel23.setBackground(new java.awt.Color(51, 51, 51));
        jLabel23.setOpaque(true);
        getContentPane().add(jLabel23);
        jLabel23.setBounds(450, 20, 340, 140);

        sp3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sprites/Gifs/Iddle.gif"))); // NOI18N
        getContentPane().add(sp3);
        sp3.setBounds(130, 190, 120, 120);

        name3.setFont(new java.awt.Font("Bahnschrift", 1, 12)); // NOI18N
        name3.setForeground(new java.awt.Color(255, 255, 255));
        name3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        name3.setText("No - Name");
        getContentPane().add(name3);
        name3.setBounds(260, 190, 80, 15);

        atk3.setForeground(new java.awt.Color(255, 255, 255));
        atk3.setText("atk");
        getContentPane().add(atk3);
        atk3.setBounds(260, 210, 80, 16);

        hp3.setForeground(new java.awt.Color(255, 255, 255));
        hp3.setText("hp");
        getContentPane().add(hp3);
        hp3.setBounds(260, 230, 80, 16);

        rare3.setForeground(new java.awt.Color(255, 255, 255));
        rare3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rare3.setText("rare");
        getContentPane().add(rare3);
        rare3.setBounds(300, 270, 40, 40);

        jLabel24.setBackground(new java.awt.Color(51, 51, 51));
        jLabel24.setOpaque(true);
        getContentPane().add(jLabel24);
        jLabel24.setBounds(120, 180, 310, 140);

        sp4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sprites/Gifs/Iddle.gif"))); // NOI18N
        getContentPane().add(sp4);
        sp4.setBounds(460, 190, 120, 120);

        name4.setFont(new java.awt.Font("Bahnschrift", 1, 12)); // NOI18N
        name4.setForeground(new java.awt.Color(255, 255, 255));
        name4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        name4.setText("No - Name");
        getContentPane().add(name4);
        name4.setBounds(590, 190, 90, 15);

        atk4.setForeground(new java.awt.Color(255, 255, 255));
        atk4.setText("atk");
        getContentPane().add(atk4);
        atk4.setBounds(590, 210, 90, 16);

        hp4.setForeground(new java.awt.Color(255, 255, 255));
        hp4.setText("hp");
        getContentPane().add(hp4);
        hp4.setBounds(590, 230, 90, 16);

        rare4.setForeground(new java.awt.Color(255, 255, 255));
        rare4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rare4.setText("rare");
        getContentPane().add(rare4);
        rare4.setBounds(630, 270, 50, 40);

        jLabel25.setBackground(new java.awt.Color(51, 51, 51));
        jLabel25.setOpaque(true);
        getContentPane().add(jLabel25);
        jLabel25.setBounds(450, 180, 340, 140);

        jLabel26.setBackground(new java.awt.Color(153, 153, 153));
        jLabel26.setOpaque(true);
        getContentPane().add(jLabel26);
        jLabel26.setBounds(100, 0, 710, 340);

        jButton1.setFont(new java.awt.Font("Bahnschrift", 1, 48)); // NOI18N
        jButton1.setText("<<");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(0, 0, 100, 340);

        jButton3.setFont(new java.awt.Font("Bahnschrift", 1, 48)); // NOI18N
        jButton3.setText(">>");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(810, 0, 100, 340);

        jButton2.setText("Volver");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(100, 350, 710, 25);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        pag++;
        MostrarPagina();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(pag != 0) {
            pag--;
            MostrarPagina();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new Unidades(sesID).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(PoolUnidades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PoolUnidades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PoolUnidades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PoolUnidades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PoolUnidades(0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel atk1;
    private javax.swing.JLabel atk2;
    private javax.swing.JLabel atk3;
    private javax.swing.JLabel atk4;
    private javax.swing.JLabel hp1;
    private javax.swing.JLabel hp2;
    private javax.swing.JLabel hp3;
    private javax.swing.JLabel hp4;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel name1;
    private javax.swing.JLabel name2;
    private javax.swing.JLabel name3;
    private javax.swing.JLabel name4;
    private javax.swing.JLabel rare1;
    private javax.swing.JLabel rare2;
    private javax.swing.JLabel rare3;
    private javax.swing.JLabel rare4;
    private javax.swing.JLabel sp1;
    private javax.swing.JLabel sp2;
    private javax.swing.JLabel sp3;
    private javax.swing.JLabel sp4;
    // End of variables declaration//GEN-END:variables
}
