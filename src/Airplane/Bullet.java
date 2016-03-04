package Airplane;

import javax.swing.*;
import java.awt.*;

public class Bullet {

    //Fields
    private int r;
    private double x;
    private double y;

    private double x1;
    private double y1;



    private int speed;

    Image image;

    //Constructor
    public Bullet(){


            x = GamePanel.player.getX();
            y = GamePanel.player.getY();



        if (GamePanel.poinBullet) {
            x1 = GamePanel.player.getX();
            y1 = GamePanel.player.getY();


        }

        r = 5;

        speed = 10;

        image = new ImageIcon("r27tt.png").getImage();

    }
    //Getter
    public double getX() {return x;}
    public double getY() {return y;}
    public int getR(){return r;}

    //Functions
    public boolean remove(){
        if (y < 0 || y > GamePanel.heigth || x < 0 || x > GamePanel.wigth)return true;
        return false;
    }

    public void update(){
        y -= speed;

        y1 -= speed;


    }

    public void draw(Graphics2D g) {
        if(!GamePanel.poinBullet)
        g.drawImage(image,(int) x - 47,(int) y, 20 * r, 3 * r,null);

        else  {
            g.drawImage(image,(int) x - 38,(int) y, 20 * r, 3 * r,null);
            g.drawImage(image,(int) x1 - 56,(int) y1, 20 * r, 3 * r,null);
        }
    }
}
