package TheDragon;

import javax.swing.*;
import java.awt.*;

public class TheDragon{

    //Fields
    public static double x;
    public static double y;
    public double xForCube;
    public double yForCube;


    public static int heigth;
    public static int wigth;
    public int heigthCube;
    public int wigthCube;

    public int speed;
    public static int maxUp;
    public int crouchint;
    public int heigthnull;

    public boolean up = false;
    public boolean down = false;
    public boolean crouch= false;
    public int nullY;

    public Image image;


    //Constructor
    public TheDragon(){
        wigth = 60;
        heigth = 60;
        crouchint = heigth / 2;
        x = GamePanel.wigth / 2;
        nullY = 206;//206
        y = nullY;
        speed = 10;
        maxUp =100;

        heigthCube = 20;
        wigthCube = 25;

        xForCube = x + wigthCube / 2;
        yForCube = nullY + heigth - 20 ;

        GamePanel.background.t.startMilisTimer();

    }

    //Getter
    public static double getX(){return x;}
    public static void setX(double x){TheDragon.x = x;}
    public static double getY(){return y;}
    public static void setY(double y){TheDragon.y = y;}
    public static int getMaxUp(){return maxUp;}

    //Functions
    public void update() {
        if(y <= maxUp) {
            up = false;
        }
            if (up) {
                y -= speed;
                yForCube -= speed;
            }

        if(down){
            y += speed;
            yForCube += speed;
            up = false;
        }
        if(y <= maxUp){
            up = false;
            down = true;
        }
        if(y >= nullY){
            down = false;
            y = nullY;
            yForCube = nullY + heigth - 20;
        }
        if(crouch){
            heigth = crouchint + 6;
            wigth = 70;
            y = nullY + crouchint;
            wigthCube = 70;
            yForCube = nullY + heigth - 5;
            xForCube = x ;
        }else{
            xForCube = x + wigthCube / 2;
            wigthCube = 25;
            heigth = 60;
            wigth =  60;
        }

        if(GamePanel.noises.size() > 0) {
            int dist = wigth * heigth;
            for (int d = 0; d < GamePanel.noises.size(); d++) {
                if (Math.abs(GamePanel.theDragon.xForCube - GamePanel.noises.get(d).nX) <= ((wigthCube * 2) - (wigthCube / 2) + (GamePanel.noises.get(d).wigth / 2)  ) /2
                        && (Math.abs(GamePanel.theDragon.yForCube - GamePanel.noises.get(d).nY) <= ((heigthCube * 2) - 40 + GamePanel.noises.get(d).heigth ) / 2)){
                GamePanel.states = GamePanel.STATES.MENUE;
                }
            }
        }


    }

    public void draw(Graphics2D g){
        if(GamePanel.background.t.miliTime % 2 == 0){
            image = new ImageIcon("dragonR.png").getImage();
        }
        if(GamePanel.background.t.miliTime % 2 == 1){
            image = new ImageIcon("dragonL.png").getImage();
        }
        if(crouch){
            image = new ImageIcon("dragonDown.png").getImage();
        }
        g.drawImage(image,(int) x, (int) y, wigth, heigth,null);
    }

}
