package Proyecjoin;
import java.awt.Font;
import java.util.Random;
import javax.swing.JLabel;
public class Tablero extends JLabel{
    char [] letra = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','ñ',+
            'o','p','q','r','s','t','u','v','w','x','y','z','1','2','3','4','5',+
            '6','7','8','9','0'};
    Random azar = new Random();
    public Tablero(){
        this.setSize(20, 20);
        this.setFont(new Font("Courier New",Font.BOLD,15));
        this.setText(letra[azar.nextInt(letra.length)]+"");
    }
}
