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
    private String nombre;
    private int hp;
    private String rareza;
    private String imagen;
    private String img;
    private String sprite;
    private String icono;
    
    public Personaje(String nom, int hp, String rareza, String imagen, String img, String sprite, String icono){
        this.nombre = nom;
        this.hp = hp;
        this.rareza = rareza;
        this.imagen = imagen;
        this.img = img;
        this.icono = icono;
        this.sprite = sprite;
    }
    
    public String getNombre(){
        return nombre;
    }
    public int getHp(){
        return hp;
    }
    public String getRareza(){
        return rareza;
    }
    public String getImagen(){
        return imagen;
    }
    
    public void setNombre(String nom){
        this.nombre = nom;
    }
    public void setHp(int hp){
        this.hp = hp;
    }
    public void setRareza(String rareza){
        this.rareza = rareza;
    }
    public void serImagen(String imagen){
        this.imagen = imagen;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getSprite() {
        return sprite;
    }

    public void setSprite(String sprite) {
        this.sprite = sprite;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }
    
    
}
