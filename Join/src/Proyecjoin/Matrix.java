package Proyecjoin;
import java.awt.Color;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Matrix extends javax.swing.JFrame implements Runnable {
    // Se da de alta el arreglo de labels e hilos
    private Tablero [][] juego = new Tablero [60][40];
    Thread [] t = new Thread[1000];
    
    // Se declaran las variables globales
    Random azar;
    int cont; //Lleva el control del arreglo de hilos
    Boolean band; 
    Date d;
    GregorianCalendar c;
    
    // Se especifica el nombre del archivo y se declaran los strings
    // que contendrán información que será escrita en el archivo
    String nomArch = "archivoHilos.txt";
    String strTiempo, strFecha, strDespliega;
    FileWriter arch;
    File f;
    
    // Esto lo utilizamos para poder hacer saltos de línea
    String newLine = System.getProperty("line.separator");
    
    public Matrix() throws IOException{
        initComponents();
        
        // Se le da el nombre al archivo y se elimina en caso de que ya exista
        f = new File(nomArch);
        f.delete();
        arch = new FileWriter(nomArch, true);
        
        // La bandera se utiliza para detener los hilos una vez que el usuario
        // oprima el botón de "Detener"
        band = true;
        
        // Variables para el manejo del tiempo
        d = new Date();
        c = new GregorianCalendar();
        
        // cont es el encargado de contar los hilos que se han creado
        cont = 0;
        
        // Se pinta de negro el fondo del Frame
        this.getContentPane().setBackground(Color.BLACK);
        azar = new Random();
        
        // El arreglo de labels es inicializado
        for(int i = 0 ; i < juego.length ; i++)
            for(int j = 0 ; j < juego[0].length ; j++)
            juego[i][j] = new Tablero();
        
        // Acomoda los labels del arreglo dentro del frame
        inicio();
        
        // Se crean todos los hilos excepto el último que se tomará como bandera
        // para detener el proceso en caso de que el usuario no lo haga
        for(int i = 0 ; i < t.length-1 ; i++)
            t[i] = new Thread(this);
        t[t.length-1] = null;
        
        // Se inicia el primer hilo que a la vez iniciará los demás
        t[cont].start();
        
        // Despliega() llena de información los strings que serán escritos en
        // el archivo
        despliega();
        
        // Se escriben los primeros datos del archivo
        try {
            arch.write("Hora de inicio del programa: "+newLine);
            arch.write(strDespliega+newLine+newLine);
        } 
        catch (IOException ex) {
            Logger.getLogger(Matrix.class.getName()).log(Level.SEVERE, null, ex);
        }
        contador.setText((cont+1)+"");
    }
    
    public void despliega(){
        // Se toma el Date y GregorianCalendar para obtener la fecha y hora en que se
        // inició  y detuvo el proceso
        c.setTime(d);
        strTiempo = c.get(Calendar.HOUR)+":"+c.get(Calendar.MINUTE)+":"+c.get(Calendar.SECOND);
        strFecha = c.get(Calendar.MONTH)+"/"+c.get(Calendar.DAY_OF_MONTH)+"/"+c.get(Calendar.YEAR);
        strDespliega = strTiempo + "    "+strFecha;
    }
    
    public void inicio()
    {
        // X y Y son las coordenadas de las labels
        int x = 0;
        int y = 0;
        
        // En los siguientes ciclos, X y Y se modifican para no sobreponer una
        // label sobre otra
        for(int i = 0 ; i < juego.length ; i++)
        {
            for(int j = 0 ; j < juego[0].length ; j++)
            {
                juego[i][j].setLocation(x, y);
                y+=20;
                this.add(juego[i][j]);
            }
            x+=20;
            y = 0; 
        }
        this.setSize(1212,700);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        contador = new javax.swing.JLabel();
        Detener = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(new java.awt.Color(0, 0, 0));
        setResizable(false);

        jLabel1.setText("Germán Alejo Castro Ortega");

        jLabel2.setText("17130769");

        jLabel3.setText("Josué Manuel Romero Canáan");

        jLabel4.setText("17130835");

        Detener.setBackground(new java.awt.Color(51, 51, 51));
        Detener.setForeground(new java.awt.Color(153, 255, 102));
        Detener.setText("Detener");
        Detener.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DetenerActionPerformed(evt);
            }
        });
        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(1064, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(contador, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Detener, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 491, Short.MAX_VALUE)
                .addComponent(Detener)
                .addGap(18, 18, 18)
                .addComponent(contador, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DetenerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DetenerActionPerformed
        // Una vez que se presiona el botón, este desaparece y la bandera la
        // cambia a false para que dejen de crearse nuevos hilos pero los
        // existentes siguen corriendo
        Detener.setVisible(false);
        band = false;
    }//GEN-LAST:event_DetenerActionPerformed

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
            java.util.logging.Logger.getLogger(Matrix.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Matrix.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Matrix.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Matrix.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Matrix().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Matrix.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Detener;
    private javax.swing.JLabel contador;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        //Si la bandera band es falsa o la posición del arreglo +1 es nula, 
        //no se correrán más hilos
        if(t[cont+1]!=null && band){
            try{
                sleep(1);
                t[++cont].start(); //iniciamos el hilo de la siguiente posición
                contador.setText((cont+1)+"");
            }
            catch(InterruptedException e){}
            
            //x es el lugar dónde van a empezar a caer las letras
            //mov_y es el tiempo que se dormirá el hilo para simular
            //la velocidad
            //la velocidad mínima de mov_y es de 8 milésimas de segundo
            //la velocidad máxima de mov_y es de 16 centésimas de segundo
            int x, mov_y = 100+azar.nextInt(100);
            x = azar.nextInt(juego.length);

            //Enciendo los labels disponibles.
            //Los bloques try-catch por debajo del primero solo se van a 
            //activar durante las primeras 5 labels.
            for(int i = 0 ; i < juego[0].length ; i++){
                try{
                    juego[x][i-6].setForeground(new Color(0,0,0));
                    juego[x][i-5].setForeground(new Color(0,55,0));
                    juego[x][i-4].setForeground(new Color(0,100,0));
                    juego[x][i-3].setForeground(new Color(0,155,0));
                    juego[x][i-2].setForeground(new Color(0,200,0));
                    juego[x][i-1].setForeground(new Color(0,255,0));
                    juego[x][i].setForeground(Color.white);
                }
                catch(Exception a){
                    try{
                        juego[x][i-5].setForeground(new Color(0,55,0));
                        juego[x][i-4].setForeground(new Color(0,100,0));
                        juego[x][i-3].setForeground(new Color(0,155,0));
                        juego[x][i-2].setForeground(new Color(0,200,0));
                        juego[x][i-1].setForeground(new Color(0,255,0));
                        juego[x][i].setForeground(Color.white);
                    }
                    catch(Exception b){
                        try{
                            juego[x][i-4].setForeground(new Color(0,100,0));
                            juego[x][i-3].setForeground(new Color(0,155,0));
                            juego[x][i-2].setForeground(new Color(0,200,0));
                            juego[x][i-1].setForeground(new Color(0,255,0));
                            juego[x][i].setForeground(Color.white);
                        }
                        catch(Exception c){
                            try{
                                juego[x][i-3].setForeground(new Color(0,155,0));
                                juego[x][i-2].setForeground(new Color(0,200,0));
                                juego[x][i-1].setForeground(new Color(0,255,0));
                                juego[x][i].setForeground(Color.white);
                            }
                            catch(Exception d){
                                try{
                                    juego[x][i-2].setForeground(new Color(0,200,0));
                                    juego[x][i-1].setForeground(new Color(0,255,0));
                                    juego[x][i].setForeground(Color.white);
                                }
                                catch(Exception f){
                                    try{
                                        juego[x][i-1].setForeground(new Color(0,255,0));
                                        juego[x][i].setForeground(Color.white);
                                    }
                                    catch(Exception g){
                                        juego[x][i].setForeground(Color.white);
                                    }
                                }
                            }
                        }
                    }
                }
                
                try{
                    sleep(mov_y);
                }
                catch(InterruptedException e){}
            }
        }
        else{
            jLabel1.setForeground(new Color(0,255,0));
            jLabel2.setForeground(new Color(0,200,0));
            jLabel3.setForeground(new Color(0,255,0));
            jLabel4.setForeground(new Color(0,200,0));
            contador.setForeground(new Color(200,200,0));

            //Escribe en el archivo la información contenida en los labels que aparecen
            //cuando se presiona el botón
            try {
                Detener.setVisible(false);
                arch.write(jLabel1.getText()+newLine+" No.Ctrl: ");
                arch.write(jLabel2.getText()+newLine+newLine);
                arch.write(jLabel3.getText()+newLine+" No Ctrl: ");
                arch.write(jLabel4.getText()+newLine+newLine);
                arch.write("Número de hilos creados: ");
                arch.write((cont+1)+newLine+newLine);
                despliega();
                arch.write("Hora a la que terminó el programa:"+newLine);
                arch.write(strDespliega);
                arch.close();
            } 
            catch (IOException ex) {
                Logger.getLogger(Matrix.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
