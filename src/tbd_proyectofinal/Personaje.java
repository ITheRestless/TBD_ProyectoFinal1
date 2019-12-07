/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tbd_proyectofinal;

/**
 *
 * @author Jesus
 */
public class Personaje {
    private String _nombre;
    private int _hp;
    private String _rareza;
    private String _imagen;
    
    public Personaje(String nom, int hp, String rareza, String imagen){
        _nombre = nom;
        _hp = hp;
        _rareza = rareza;
        _imagen = imagen;
    }
    
    public String getNombre(){
        return _nombre;
    }
    public int getHp(){
        return _hp;
    }
    public String getRareza(){
        return _rareza;
    }
    public String getImagen(){
        return _imagen;
    }
    
    public void setNombre(String nom){
        _nombre = nom;
    }
    public void setHp(int hp){
        _hp = hp;
    }
    public void setRareza(String rareza){
        _rareza = rareza;
    }
    public void serImagen(String imagen){
        _imagen = imagen;
    }
}
