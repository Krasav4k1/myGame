package FlappyBird;

import javax.swing.*;
import java.awt.*;

public class Noise {

    //Fields
    public int noiseXD;
    public int noiseYD;
    public int noiseXU;
    public int noiseYU;

    public int heigth;
    public int wigth;

    public Image imageD;
    public Image imageU;

    //Constructor
    public Noise(){
        heigth = 500;
        wigth = 80;

        imageD = new ImageIcon("NoiseForFlappeBirdDown.jpg").getImage();
        noiseXD = 600;
        noiseYD = 50;

        imageU = new ImageIcon("NoiseForFlappeBirdUp.jpg").getImage();
        noiseXU = 600;
        noiseYU = 700;

    }

    //Functions
    public void update(){
        randomForNoise();
        lookHit();
        removeAndAdd();
        noiseXD -= 8;
        noiseXU -= 8;
    }

    public void draw(Graphics2D g){
        g.drawImage(imageD, noiseXD - wigth / 2, noiseYD - heigth / 2, wigth, heigth, null);
        g.drawImage(imageU, noiseXU - wigth / 2, noiseYU - heigth / 2, wigth, heigth, null);

    }

    public void lookHit(){
        if(Math.abs(noiseXD - GamePanel.bird.getBirdX()) <=  GamePanel.bird.getWigth() + (GamePanel.bird.getHeigth() / 2) / 2 - 10
                && Math.abs(noiseYD - GamePanel.bird.getBirdY()) <= heigth / 3 + 25  + GamePanel.bird.getWigth() + (GamePanel.bird.getHeigth() / 2) / 2){
            GamePanel.statys = GamePanel.STATYS.MENU;
        }
        if(Math.abs(noiseXU - GamePanel.bird.getBirdX()) <=  GamePanel.bird.getWigth() + (GamePanel.bird.getHeigth() / 2) / 2 - 10
                && Math.abs(noiseYU - GamePanel.bird.getBirdY()) <= heigth / 3 + 25  + GamePanel.bird.getWigth() + (GamePanel.bird.getHeigth() / 2) / 2){
            GamePanel.statys = GamePanel.STATYS.MENU;
        }

    }

    public void randomForNoise(){
//        for(int d = 0; d < GamePanel.noises.size(); d++){
//            GamePanel.noises.add(new Noise());
//        }
        //noiseXD = (int) Math.round( + Math.random() * 1);

    }

    public void removeAndAdd(){
        if(noiseXD <= 0 && noiseXU <= 0){
            for(int d = 0; d < GamePanel.noises.size(); d++){
                GamePanel.noises.remove(d);
                GamePanel.noises.add(new Noise());
            }
        }
    }

}
