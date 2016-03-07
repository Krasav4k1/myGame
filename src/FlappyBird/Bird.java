package FlappyBird;

import javax.swing.*;
import java.awt.*;

public class Bird implements Runnable{

    //Fields
    private int birdX;
    private int birdY;

    private int heigth;
    private int wigth;

    private int speed;
    private int time = -1;
    public int upMoment;

    Thread thread;

    public static boolean up = false;
    public static boolean stoppress = true;

    Image image;

    //Constuctor
    public Bird() {
        birdX = GamePanel.wigth / 3;
        birdY = GamePanel.heigth / 2;

        heigth = 50;
        wigth = 50;

        image = new ImageIcon("birdForFlappyBird.png").getImage();

        speed = 10;

        thread = new Thread(this);
        thread.start();
    }

    //Getters Setters
    public int getBirdX(){return birdX;}
    public void setBirdX(int birdX){this.birdX = birdX;}
    public int getBirdY(){return birdY;}
    public void setBirdY(int birdY){this.birdY = birdY;}
    public int getHeigth(){return heigth;}
    public void setHeigth(int heigth){this.heigth = heigth;}
    public int getWigth(){return wigth;}
    public void setWigth(int wigth){this.wigth = wigth;}

    //Functions
    @Override
    public void run(){


        while (true) {
            time++;
            move();
            try {
                thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    public void move(){
        if(GamePanel.statys.equals(GamePanel.STATYS.PLAY)) {
            if (up) {
                birdY -= speed;
                image = new ImageIcon("birdForFlappyBirdUp.png").getImage();
            } else {
                birdY += speed;
                image = new ImageIcon("birdForFlappyBirdDown.png").getImage();
            }
            if (birdY <= 0) {
                up = false;
            }
            if (birdY >= GamePanel.heigth) {
                JOptionPane.showMessageDialog(null, "You lose");
                GamePanel.statys = GamePanel.STATYS.MENU;
            }
        }
    }





    //Functions working wthis GamePanel Thread
    public void update() {
        timeDown();

    }

    public void draw(Graphics2D g) {
        g.drawImage(image, birdX - wigth / 2, birdY - heigth / 2, wigth, heigth, null);
       // g.drawRect(birdX - wigth / 2, birdY - heigth / 2, wigth, heigth);
    }

    public boolean timeDown(){
        if(upMoment - birdY >= 100){
            return up = false;
        }
        return false;
    }


}
