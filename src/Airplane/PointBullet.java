package Airplane;

import javax.swing.*;
import java.awt.*;

public class PointBullet {

    //Fields
    public double x;
    public double y;
    public int timeVisible = 45;
    int a = -1;

    Image image = new ImageIcon("r-33 (1).png").getImage();

    public int length;

    //Constructor
    public PointBullet(){
        x = (20 + Math.random() * ((((GamePanel.wigth-20) - 20)  - 20) + 20));
        y = (20 + Math.random() * ((((GamePanel.heigth-20) - 20)  - 20) + 20));
    length = 20;
    }

    //Functions
    public void hit(){
        x = (20 + Math.random() * ((((GamePanel.wigth-20) - 20)  - 20) + 20));
        y = (20 + Math.random() * ((((GamePanel.heigth-20) - 20)  - 20) + 20));
        a = 0;

    }

    public boolean createPointBullet(){
        if (GamePanel.menu.t.time % timeVisible >= 0 && GamePanel.menu.t.time % timeVisible <= a) {
            a = 4;
            return true;

        }
        return false;
    }


    public void update(){
        if(Math.abs(x - GamePanel.player.getX()) <= length && Math.abs(y - GamePanel.player.getY()) <= length){
                hit();
            GamePanel.poinBullet = true;
        }

    }

    public void draw(Graphics2D g) {
        g.drawImage(image, (int) x - length , (int) y - length , length , length + 10, null);
    }

}
