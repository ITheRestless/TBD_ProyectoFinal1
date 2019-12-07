package tbd_proyectofinal;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
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
    
    String[] tablas = {};

    //Atributo
    private Connection conexion = null;
   
    //Métodos
    public Connection conectarUSR(){         
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexion = (Connection)DriverManager.getConnection("jdbc:mysql://localhost/FBD_EQ17_Script?autoReconnect=true&useSSL=false","RPG_User","");
        } catch (ClassNotFoundException | SQLException ex) {
            
        }
        return conexion;
    }
    
    public Connection conectarAdmin(String password){         
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexion = (Connection)DriverManager.getConnection("jdbc:mysql://localhost/FBD_EQ17_Script?autoReconnect=true&useSSL=false","Admin","");
        } catch (ClassNotFoundException | SQLException ex) {
            
        }
        return conexion;
    }
    
    public void Login() {
        
    }

    public void desconectar() {
        try{
            conexion.close();
        }catch(SQLException ex){
            System.out.println("Error: " + ex);
        }  
    }

   //Metodos de Guardado
    
    public void guardar(String formato, String values, String tabla) {
        try {
            conectarUSR();
            
            String ssql = "INSERT INTO " + tabla + " (" + formato + ") VALUES (" + values + ")";
            System.out.println(ssql);
            PreparedStatement psql = conexion.prepareStatement(ssql);
            
            psql.executeUpdate();
            psql.close();
            
            desconectar();
            
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Metodos de Eliminar
    
    public void eliminar(String clave, int tablaSQL, String nombreLlave){
        
        conectarUSR();
        
        try{
            
            String ssql = "DELETE FROM " + tablas[tablaSQL] + " WHERE " + nombreLlave + "='"+clave+"'";
            PreparedStatement ps = conexion.prepareStatement(ssql);
            ps.executeUpdate();
            
        } catch(SQLException ex) {
            
            System.out.println("Error: " + ex.getMessage());
        }
        desconectar();      
    }
    
    //Metodo de Mostrado

    public void mostrarDatos(JTable tabla, int pos){
        consulta(tabla, "SELECT * FROM " + tablas[pos]);
    }
    
    public void buscar(JTable tabla, int posTabla){
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        consulta(tabla, "SELECT * FROM " + tablas[posTabla] + " WHERE "
                + tabla.getColumnName(0) + " = " + tabla.getValueAt(0, 0));
    }
    
    //Metodos de Modificado
    
    public void modificar(String formato, String values, int posTabla){
        String[] formatos = formato.split(",");
        String[] valores = values.split(",");
        
        String query = "UPDATE " + tablas[posTabla] + " SET ";
        query += formatos[1] + "='" + valores[1] + "' ";
        
        for(int i = 2 ; i < formatos.length ; i++) {
            query += ", " + formatos[i] + "='" + valores[i] + "'";
        }
        
        query += " WHERE " + formatos[0] + "='" + valores[0] + "'";
        
        try{
            conectarUSR();

            System.out.println(query);
            
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.executeUpdate();

            desconectar();

        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null,ex.getMessage());          
        }
    }
    
    public void consulta(JTable tabla, String consulta) {
        
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.setColumnCount(0);
        modelo.setRowCount(0);

        conectarUSR();
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
    
    public void mostrarClaves(JComboBox combo, String tabla, String campoPrimario) {
            
        try {
            
            combo.removeAllItems();
            
            conectarUSR();
        
            Statement st;
            st = (Statement) conexion.createStatement();
            ResultSet rs = st.executeQuery("SELECT " + campoPrimario + " FROM " + tabla);
                    
            ResultSetMetaData rsmd = rs.getMetaData();
            
            String[] lista = new String[rsmd.getColumnCount()];
            
            while(rs.next()){
                combo.addItem(rs.getString(1));
            }
            
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error"+ex);
        } 
    }
}












