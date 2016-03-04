package Airplane;

import javax.swing.*;
import java.awt.*;

public class Heard {

    //Fields
    private double x;
    private double y;
    public int a = -1;
    public int timeVisible = 50;

    private int length;
    private java.awt.Image imageHeard;
    Player player;
    Graphics2D g;


    //Counstructor
    public Heard(){

    x = (20 + Math.random() * ((((GamePanel.wigth-20) - 20)  - 20) + 20));
    y = (20 + Math.random() * ((((GamePanel.heigth-20) - 20)  - 20) + 20));
    imageHeard = new ImageIcon("heart_PNG695.png").getImage();
    length = 25;


    }

    //Getter
    public double getX() {return x;}
    public double getY() {return y;}
    public int getLength() {return length;}

    //Functions
    public void hit(){
        Player.setHealth(10);
        GamePanel.player.addHealth();
        a = 0;
        x = (20 + Math.random() * ((((GamePanel.wigth-20) - 20)  - 20) + 20));
        y = (20 + Math.random() * ((((GamePanel.heigth-20) - 20)  - 20) + 20));

    }

    public boolean create(){
            if (GamePanel.menu.t.time % timeVisible >= 0 && GamePanel.menu.t.time % timeVisible <= a) {
                a = 4;
                return true;
        }
        return false;
    }

    public void update(){
        //Піксельні Границі обєкта
        if (Math.abs(x - GamePanel.player.getX()) <= ((length * 2)) /2
                && (Math.abs(y - GamePanel.player.getY()) <= ((length *2)) / 2)) hit();

    }


    public void draw(Graphics2D g){
    g.drawImage(imageHeard,(int)x - length / 2 ,(int) y - length / 2 , length , length  , null);
    }


}
