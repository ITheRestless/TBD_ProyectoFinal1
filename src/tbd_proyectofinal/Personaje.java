package tbd_proyectofinal;

/**
 * @author Jesus
 */
public class Personaje {
    int id;
    int atk;
    int hp;
    int nivel;
    String nombre;
    String img;
    String rareza;
    //int un_atkinc;
    //int ses_id;
    
    public Personaje(int id, int atk, int hp, int nivel, String nombre, String img, String rareza){
        this.id = id;
        this.atk = atk;
        this.hp = hp;
        this.nivel = nivel;
        this.nombre = nombre;
        this.img = img;
        this.rareza = rareza;
    }
    
    public Personaje(){
        id = 0;
        atk = 0;
        hp = 0;
        nivel = 0;
        nombre = "";
        img = "";
        rareza = "";
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

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getRareza() {
        return rareza;
    }

    public void setRareza(String rareza) {
        this.rareza = rareza;
    }
    
    
}
