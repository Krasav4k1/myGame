package Tenis;

import java.awt.*;

public class Platform {

    //Fields
    private static double x;
    private static double y;

    private static int width;
    private static int heigth;

    private Color color;

    public static boolean rigth;
    public static boolean left;

    private static int speed;

    //Constructor
    public Platform(){

        x = GamePanel.wigth / 2;
        y = GamePanel.heigth - 10;

        color = Color.white;

        width = 30;
        heigth = 5;

        speed = 10;

        rigth = false;
        left = false;
    }
    //Getter
    public static double getY() {return y;}
    public static double getX() {return x;}
    public static int getWidth(){return width;}
    public static int getHeigth(){return heigth;}

    //Functions
    public void update(){
        if (left && x > width) x -= speed;
        if (rigth && x < GamePanel.wigth - width) x +=speed;
    }

    public void draw(Graphics2D g){
        g.setColor(color);
        g.fillRect((int) x - width,(int) y - heigth, width * 2 , heigth * 2);
        g.setStroke(new BasicStroke(3));
    }

}
