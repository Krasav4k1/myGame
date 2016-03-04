package Tenis;

import java.awt.*;

public class Boll {

    //Fields
    public static double x;
    public static double y;

    public static double dx;
    public static double dy;

    private static int r;

    private static int speed;

    private Color color;

    private static int direction;

    //Constuctor
    public Boll(){
    x = GamePanel.wigth / 2;
    y = GamePanel.heigth / 2;
    dx = 0;
    dy = 0;
    speed = 10;
    color = Color.white;
    r = 15;
    direction = (int) (1 + Math.random() * ((2 - 1) + 1));
}

    //Functions
    public void update(){
        //GamePanel y
 //       if(y == 0 && direction == 2) direction = 1;
 //       if(y == 0 && direction == 4) direction = 5;
 //       if(y == 0 && direction == 3) direction = 6;

        //GamePanel x
        if (x == GamePanel.wigth && direction == 3) direction = 4;
        if (x == GamePanel.wigth && direction == 6) direction = 5;
        if (x == 0 && direction == 4) direction = 3;
        if (x == 0 && direction == 5) direction = 6;

        //Move for Platform
        if (Math.abs(x - Platform.getX()) <= ((r * 2) + Platform.getWidth() + (Platform.getWidth() / 2) ) /2
                && (Math.abs(y - Platform.getY()) <= ((r *2) + Platform.getHeigth() + 20) / 2)) direction = 2;
        if ((Platform.left) && (Math.abs(x - Platform.getX()) <= ((r * 2) + Platform.getWidth() + (Platform.getWidth() / 2)) /2)
                && (Math.abs(y - Platform.getY()) <= ((r *2) + Platform.getHeigth() + 20) / 2)) direction = 3;
        if ((Platform.rigth) && (Math.abs(x - Platform.getX()) <= ((r * 2) + Platform.getWidth() + (Platform.getWidth() / 2)) /2)
                && (Math.abs(y - Platform.getY()) <= ((r *2) + Platform.getHeigth() + 20) / 2)) direction = 4;

        //Move for Platform2
        if (Math.abs(x - Platform2.getX()) <= ((r * 2) + Platform2.getWidth()  + (Platform2.getWidth() / 2)) /2
                && (Math.abs(y - Platform2.getY()) <= ((r *2) + Platform2.getHeigth() - 10) / 2)) direction = 1;
        if ((Platform2.left) && (Math.abs(x - Platform2.getX()) <= ((r * 2) + Platform2.getWidth()  + (Platform2.getWidth() / 2)) /2)
                && (Math.abs(y - Platform2.getY()) <= ((r *2) + Platform2.getHeigth() - 10) / 2)) direction = 6;
        if ((Platform2.rigth) && (Math.abs(x - Platform2.getX()) <= ((r * 2) + Platform2.getWidth() + (Platform2.getWidth() / 2) ) /2)
                && (Math.abs(y - Platform2.getY()) <= ((r *2) + Platform2.getHeigth() - 10) / 2)) direction = 5;

        switch (direction){
            case 1:
                y += speed ;
                break;
            case 2:
                y -= speed ;
                break;
            case 3:
                y -= speed;
                x += speed;
                break;
            case 4:
                y -= speed;
                x -= speed;
                break;
            case 5:
                y += speed;
                x -= speed;
                break;
            case 6:
                y += speed;
                x += speed;
                break;
        }

    }

    public void draw(Graphics2D g){
        if (direction == 1 || direction == 5 || direction == 6){
           color = Color.black;
       }
        if (direction == 2 || direction == 3 || direction == 4){
            color = Color.white;
        }
        g.setColor(color);
        g.fillOval((int) x,(int) y, r, r);
    }


}
