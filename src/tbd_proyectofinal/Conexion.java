package tbd_proyectofinal;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;
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
    public void update(int cantidad, int id)
    {
    try
    {
      // create a java mysql database connection
      conectar();
      // create the java mysql update preparedstatement
      String query = "update usuarios SET usr_currency = usr_currency + "+cantidad+ " where ((select usr_id from sesiones where (ses_id =" +id+"  )) = usr_id)";
      PreparedStatement preparedStmt = conexion.prepareStatement(query);
      preparedStmt.executeUpdate();
      
      desconectar();
    }
    catch (Exception e)
    {
      System.err.println("Got an exception! ");
      System.err.println(e.getMessage());
    }
  }
    public void Llamar(String llamada) throws SQLException{
        conectar();
        String llam = llamada;
    CallableStatement call = conexion.prepareCall(llamada);
        call.execute();
    }
    
    /*public void Llamada(String consulta, int id, int c) throws SQLException {
        
            conectar();
            
            CallableStatement sp = conexion.prepareCall(" CALL contar_productos(?,?)");
//se cargan los parametros de entrada
sp.setInt(2, id);//Tipo String
sp.setInt(1,c);
// parametros de salida
//sp.registerOutParameter("nproductos", Types.VARCHAR);//Tipo String
// Se ejecuta el procedimiento almacenado
sp.execute();            
           
            //rs.next();
            
            
            
            //sp.close();
            //rs.close();
            desconectar();
            
       
    }*/
    
    /*public void Update(int sesID) throws SQLException{
        conectar();
        PreparedStatement stmt = (PreparedStatement) conexion.createStatement();
        String q1 = "UPDATE usuarios SET usr_currency = usr_currency + 5 WHERE ((select usr_id from sesiones where (ses_id ="+sesID+")) = usr_id)"; 
           // int x = stmt.executeUpdate(q1); 
    }
    */
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
    
    public ArrayList<Personaje> consultaPersnajes(String consulta) {
        conectar();

        ArrayList<Personaje> tabla = new ArrayList();
                
        try{
            
            Statement st;
            st = (Statement) conexion.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            
            while(rs.next()){
                tabla.add(new Personaje(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), 
                        rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9)));
            }
            
            desconectar();

        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error"+ex);
        }  
        
        return tabla;
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












