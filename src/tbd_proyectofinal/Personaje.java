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
    private int id;
    private int inv_un_id;
    private String nombre;
    private int hp;
    private int atk;
    private String rareza;
    private int nivel;
    //private String imagen;
    private String img;
    private String sprite;
    private String icono;
    
    public Personaje(int nivel, int inv_un_id, int id, String nom, int hp, String rareza, String img, String sprite, String icono, int atk){
        this.id = id;
        this.nivel = nivel;
        this.inv_un_id = inv_un_id;
        this.nombre = nom;
        this.hp = hp;
        this.rareza = rareza;
        //this.imagen = imagen;
        this.img = img;
        this.icono = icono;
        this.sprite = sprite;
        this.atk = atk;
    }
    
    public Personaje(){
        id = 0;
        nombre = "";
        hp = 0;
        rareza = "";
        img = "";
        icono = "";
        sprite = "";
        atk = 0;
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
    
    public void setNombre(String nom){
        this.nombre = nom;
    }
    public void setHp(int hp){
        this.hp = hp;
    }
    public void setRareza(String rareza){
        this.rareza = rareza;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getInv_un_id() {
        return inv_un_id;
    }

    public void setInv_un_id(int inv_un_id) {
        this.inv_un_id = inv_un_id;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    
    
}
