package tbd_proyectofinal;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

// @https://github.com/ITheRestless/TBD_ProyectoFinal1

/**
 * @authors Mauricio Emmanuel Avitia Maturino
 *         German Alejo Castro Ortega
 *         Jesus Alberto Diaz de Leon
 */

public class Conexion {
    
    //Atributo
    private Connection conexion = null;
   
    //Métodos
    public Connection conectar(){         
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexion = (Connection)DriverManager.getConnection("jdbc:mysql://localhost/uwu?autoReconnect=true&useSSL=false","root","");
        } catch (ClassNotFoundException | SQLException ex) {    
            System.out.println("Error al conectar: " + ex);
        }
        return conexion;
    }

    public void desconectar() {
        try{
            conexion.close();
        }catch(SQLException ex){
        }  
    }
    
    public int SignUp(String correo, String nombre, String pass) {
        String ip = "";
        try {
            ip = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        conectar();
        
        int numero=0;
       
        try {
            conectar();
            System.out.println(ip);
            
                PreparedStatement st = conexion.prepareStatement("select SignUp('"+ 
                        correo +"','" + 
                        nombre + "','" + 
                        Md5(pass) + "','" + 
                        "127.0.0.1" + "')");
          
                ResultSet rs = st.executeQuery();
                
                rs.next();
                
                numero = rs.getInt(1);
               
                st.close();
                
                desconectar();
                
            } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
 
        return numero;
    }
    

    
    public int LogIn(String correo, String pass) {
        String ip = "";
        try {
            ip = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        conectar();
        
        int numero=-3;
       
        try {
            conectar();
            
                PreparedStatement st = conexion.prepareStatement("select LogIn('"+ 
                        correo +"','" +  
                        Md5(pass) + "','" + 
                        ip + "')");
          
                ResultSet rs = st.executeQuery();
                
                rs.next();
                
                numero = rs.getInt(1);
                
                System.out.println(numero);
               
                st.close();
                
                desconectar();
                
            } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
 
        return numero;
    }
    
    public void update(String consulta) {
        
        try{
            conectar();
            
            Statement st;
            st = (Statement) conexion.createStatement();
            ResultSet rs = st.executeQuery(consulta);
           
            rs.next();
            
            
            st.close();
            rs.close();
            desconectar();
            
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String consultaUnitaria(String consulta) {
        String cad = "";
        
        try{
            conectar();
            
            Statement st;
            st = (Statement) conexion.createStatement();
            ResultSet rs = st.executeQuery(consulta);
           
            rs.next();
            
            cad = rs.getString(1);
            
            st.close();
            rs.close();
            desconectar();
            
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return cad;
    }
    
    public void consulta(JTable tabla, String consulta) {
        
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.setColumnCount(0);
        modelo.setRowCount(0);

        conectar();
        modelo = (DefaultTableModel) tabla.getModel();

        tabla.setModel(modelo);

        try{
            
            Statement st;
            st = (Statement) conexion.createStatement();
            ResultSet rs = st.executeQuery(consulta);
                    
            ResultSetMetaData rsmd = rs.getMetaData();
            
            for (int i = 1 ; i <= rsmd.getColumnCount() ; i++) {
                modelo.addColumn(rsmd.getColumnName(i));
            }
            
            String[] lista = new String[rsmd.getColumnCount()];
            
            while(rs.next()){
                for(int i = 1 ; i < lista.length + 1 ; i++) {
                    lista[i - 1] = rs.getString(i);
                }
                modelo.addRow(lista);
            }
            
            tabla.setModel(modelo);
            
            desconectar();

        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error"+ex);
        }  
    }
    
    public static String Md5(String input) 
    { 
        try { 
  
            // Static getInstance method is called with hashing MD5 
            MessageDigest md = MessageDigest.getInstance("MD5"); 
  
            // digest() method is called to calculate message digest 
            //  of an input digest() return array of byte 
            byte[] messageDigest = md.digest(input.getBytes()); 
  
            // Convert byte array into signum representation 
            BigInteger no = new BigInteger(1, messageDigest); 
  
            // Convert message digest into hex value 
            String hashtext = no.toString(16); 
            while (hashtext.length() < 32) { 
                hashtext = "0" + hashtext; 
            } 
            return hashtext; 
        }  
  
        // For specifying wrong message digest algorithms 
        catch (NoSuchAlgorithmException e) { 
            throw new RuntimeException(e); 
        } 
    } 
}












