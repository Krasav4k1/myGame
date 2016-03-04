package Airplane;

import javax.swing.*;
import java.awt.*;

public class Player {

    //Fields
    private int r;

    private double x;
    private double y;

    private double dx;
    private double dy;

    public int speed;

    public static int health;

    private Color color1;
    private Color color2;

    private double distX;
    private double distY;

    public static boolean up;
    public static boolean down;
    public static boolean left;
    public static boolean rigth;

    Image image;
    Image imageleft;
    Image imageright;

    public static boolean isFiring;
    public int movelBackgroundLeftOrRight = GamePanel.wigth/2;
    public int movelBackgroundUpOrDown = GamePanel.heigth/2;

    //Constructor
    public Player(){
        x = GamePanel.wigth / 2;
        y = GamePanel.heigth / 2;
        r = 20;
        color1 = Color.WHITE;

        speed = 10;

        dx = 0 ;
        dy = 0;

        image = new ImageIcon("692fab62a8ed.png").getImage();
        imageleft = new ImageIcon("692fab62a8edLeft.png").getImage();
        imageright = new ImageIcon("692fab62a8edReaght.png").getImage();

        up = false;
        down = false;
        left = false;
        rigth = false;

        isFiring = false;

        health = 4;

        Record.setHealth(health / 2);

    }

    //Getter
    public double getX(){return x;}
    public double getY(){
        return y;
    }
    public int getR(){return r;}
    public static void setHealth(int health) {Player.health += health;}


    //Function
    public void hit(){
        health--;
        Record.setHealth(health / 2);
    }

    public void addHealth(){
        Record.setHealth(health / 2);
    }

    public void update(){


        if(up && y > r) dy = -speed;
        if(down && y < GamePanel.heigth - r) dy = speed;
        if(left && x > r)dx = -speed;
        if(rigth && x < GamePanel.wigth - r)dx = speed;
        if(up && left || up && rigth || down && left || down && rigth){
            double angle = Math.toRadians(45);
            dy = dy * Math.sin(angle);
            dx = dx * Math.cos(angle);
        }

        if(left){
            int d = GamePanel.wigth / 2 -(int) x;
            movelBackgroundLeftOrRight =d + GamePanel.wigth / 2;
        }
        if(rigth){
            int d = GamePanel.wigth / 2 -(int) x;
            movelBackgroundLeftOrRight =d + GamePanel.wigth / 2;
        }
        if(up){
            int d = GamePanel.heigth / 2 -(int) y;
            movelBackgroundUpOrDown=d + GamePanel.heigth / 2;
        }
        if(down){
            int d = GamePanel.heigth / 2 -(int) y;
            movelBackgroundUpOrDown =d + GamePanel.heigth / 2;
        }


        y += dy;
        x += dx;

        dy = 0;
        dx = 0;

        if (isFiring) GamePanel.bullets.add(new Bullet());

        if(health <= 0) GamePanel.state = GamePanel.STATES.RESTART;

    }

    public void draw(Graphics2D g){
        if(left){
            g.drawImage(imageright,(int) (x - r),(int) (y - r), 2 * r, 2 * r,null);
        }
        if(rigth){
            g.drawImage(imageleft,(int) (x - r),(int) (y - r), 2 * r, 2 * r,null);
        }
        if(!left && !rigth) {
            g.drawImage(image, (int) (x - r), (int) (y - r), 2 * r, 2 * r, null);
        }
    }
}
