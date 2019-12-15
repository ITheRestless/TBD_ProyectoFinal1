/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tbd_proyectofinal;

/**
 *
 * @author Mauricio Avitia
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LabUsrName = new javax.swing.JLabel();
        ButtFondos = new javax.swing.JButton();
        UltimaUnidad = new javax.swing.JLabel();
        ButtInvocar = new javax.swing.JButton();
        ButtAdventures = new javax.swing.JButton();
        ButtUnidades = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(690, 387));
        setMinimumSize(new java.awt.Dimension(690, 387));
        setPreferredSize(new java.awt.Dimension(690, 387));
        getContentPane().setLayout(null);

        LabUsrName.setFont(new java.awt.Font("Bahnschrift", 1, 24)); // NOI18N
        LabUsrName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabUsrName.setText("DonMau");
        getContentPane().add(LabUsrName);
        LabUsrName.setBounds(198, 11, 279, 29);

        ButtFondos.setFont(new java.awt.Font("Bahnschrift", 1, 24)); // NOI18N
        ButtFondos.setForeground(new java.awt.Color(255, 255, 255));
        ButtFondos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sprites/Gifs/gems.gif"))); // NOI18N
        ButtFondos.setText("Fondos");
        ButtFondos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ButtFondos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(ButtFondos);
        ButtFondos.setBounds(480, 80, 184, 140);
        getContentPane().add(UltimaUnidad);
        UltimaUnidad.setBounds(200, 50, 280, 247);

        ButtInvocar.setFont(new java.awt.Font("Bahnschrift", 1, 24)); // NOI18N
        ButtInvocar.setForeground(new java.awt.Color(255, 255, 255));
        ButtInvocar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sprites/Gifs/ButtInvocar.gif"))); // NOI18N
        ButtInvocar.setText("Invocar");
        ButtInvocar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ButtInvocar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ButtInvocar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ButtInvocar.setMaximumSize(new java.awt.Dimension(200, 200));
        ButtInvocar.setMinimumSize(new java.awt.Dimension(200, 200));
        ButtInvocar.setOpaque(false);
        ButtInvocar.setPreferredSize(new java.awt.Dimension(200, 200));
        ButtInvocar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtInvocarActionPerformed(evt);
            }
        });
        getContentPane().add(ButtInvocar);
        ButtInvocar.setBounds(10, 230, 184, 150);

        ButtAdventures.setFont(new java.awt.Font("Bahnschrift", 1, 24)); // NOI18N
        ButtAdventures.setForeground(new java.awt.Color(255, 255, 255));
        ButtAdventures.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sprites/Gifs/ButtAveturas.gif"))); // NOI18N
        ButtAdventures.setText("Aventuras");
        ButtAdventures.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ButtAdventures.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(ButtAdventures);
        ButtAdventures.setBounds(480, 230, 184, 150);

        ButtUnidades.setBackground(new java.awt.Color(102, 102, 102));
        ButtUnidades.setFont(new java.awt.Font("Bahnschrift", 1, 24)); // NOI18N
        ButtUnidades.setForeground(new java.awt.Color(255, 255, 255));
        ButtUnidades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sprites/Gifs/ResizedIddle.gif"))); // NOI18N
        ButtUnidades.setText("Unidades");
        ButtUnidades.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ButtUnidades.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ButtUnidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtUnidadesActionPerformed(evt);
            }
        });
        getContentPane().add(ButtUnidades);
        ButtUnidades.setBounds(10, 80, 184, 140);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtUnidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtUnidadesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtUnidadesActionPerformed

    private void ButtInvocarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtInvocarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtInvocarActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtAdventures;
    private javax.swing.JButton ButtFondos;
    private javax.swing.JButton ButtInvocar;
    private javax.swing.JButton ButtUnidades;
    private javax.swing.JLabel LabUsrName;
    private javax.swing.JLabel UltimaUnidad;
    // End of variables declaration//GEN-END:variables
}