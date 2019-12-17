package tbd_proyectofinal;

/**
 * @author Jesus
 */
public class Personaje {
    int un_id;
    String un_nombre;
    int un_hp;
    String un_rareza;
    int un_atkinc;
    String un_img;
    String un_sprite;
    String un_icono;
    int ses_id;
    
    public Personaje(int un_id, String un_nombre, int un_hp, String un_rareza, 
        int un_atkinc, String un_img, String un_sprite, String un_icono, int ses_id) {
        this.un_id = un_id; 
        this.un_nombre = un_nombre;
        this.un_hp = un_hp;
        this.un_rareza = un_rareza;
        this.un_atkinc = un_atkinc;
        this.un_img = un_img;
        this.un_sprite = un_sprite;
        this.un_icono = un_icono;
        this.ses_id = ses_id;
    }
    
    public Personaje(){
        this.un_id = 0; 
        this.un_nombre = "";
        this.un_hp = 0;
        this.un_rareza = "";
        this.un_atkinc = 0;
        this.un_img = "";
        this.un_sprite = "";
        this.un_icono = "";
        this.ses_id = 0;
    }  
}
