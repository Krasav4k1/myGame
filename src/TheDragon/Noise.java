package TheDragon;

import javax.swing.*;
import java.awt.*;

public class Noise {

    //Fields
    public int nX;
    public int nY;

    public int heigth;
    public int wigth;
    public int type;
    public int rang;
    public int dist;

    public Image image;


    //Constructor
    public Noise(int type, int rang){
        this.rang = rang;
        this.type = type;

        switch (type){
            case 1:
                if(rang == 1){
                    heigth = 50;
                    wigth = 30;
                    dist = heigth * wigth;
                    break;
                }
                if(rang == 2){
                    heigth = 50;
                    wigth = 40;
                    dist = heigth * wigth;
                    break;
                }
                if(rang == 3) {
                    heigth = 50;
                    wigth = 80;
                    dist = heigth * wigth;
                    break;
                }
                if(rang == 4) {
                    heigth = 40;
                    wigth = 70;
                    dist = heigth * wigth;
                    break;
                }
                break;
            case 2:
                if(rang == 1){
                    heigth = 40;
                    wigth = 30;
                    dist = heigth * wigth;
                    break;
                }
                if(rang == 2){
                    heigth = 60;
                    wigth = 50;
                    dist = heigth * wigth;
                    break;
                }
                if(rang == 3) {
                    heigth = 60;
                    wigth = 80;
                    dist = heigth * wigth;
                    break;
                }
                if(rang == 4) {
                    heigth = 50;
                    wigth = 70;
                    dist = heigth * wigth;
                    break;
                }
                break;
            case 3:
                heigth = 50;
                wigth = 40;
                dist = heigth * wigth;
                break;
        }
        switch (rang){
            case 1:
                image = new ImageIcon("type 1.png").getImage();
                nX = (int) Math.round(900 + Math.random() * 20);
                //nX = GamePanel.wigth / 2;
                nY = 222;
                break;
            case 2:
                image = new ImageIcon("type 2.png").getImage();
                nX = (int) Math.round(900 + Math.random() * 20);
                nY = 216;
                break;
            case 3:
                nY = 225;
                nX = (int) Math.round(900 + Math.random() * 20);
                image = new ImageIcon("type 3.png").getImage();
                break;
            case 4:
                image = new ImageIcon("type 4.png").getImage();
                nX = (int) Math.round(900 + Math.random() * 20);
                nY = 220;
                break;

        }



    }

    //Functions
    public boolean remove() {
        if (nX <= 0) {
            return true;
        }
        return false;
    }

    public void update(){
        nX -= GamePanel.background.speed;
    }

    public void draw(Graphics2D g){
        g.drawImage(image, nX, nY, wigth, heigth, null);
    }




}
