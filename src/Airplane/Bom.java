package Airplane;

import javax.swing.*;
import java.awt.*;

public class Bom {

    //Fields
    public static double x;
    public static double y;
    public static int r;
    TimerfForGame timerfForGame = new TimerfForGame() ;

    Image image = new ImageIcon("0_1205de_e1ed4085_L.png").getImage();

    //Constructor
    public Bom(){
    timerfForGame.startMilisTimer();

    }

    //Functions
    public void update(){

    }

    public void draw(Graphics2D g){
        g.drawImage(image,(int) x - r * 2, (int) y - r * 2, r * 6, r * 6, null);
        if(timerfForGame.miliTime % 1 == 0) {
            x = -50;
            y = -50;
        }
    }

}
