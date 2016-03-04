package TheDragon;

import javax.swing.*;
import java.awt.*;

public class GameBack {

    //Fields
    private Image image1;
    public int speed;
    public int layer1;
    public int layer2;
    int timerspeed = 0;
    TimerForGame t = new TimerForGame();

    //Constructor
    public GameBack(){
        image1 = new ImageIcon("DragonRoal.png").getImage();
        speed = 12;
        t.startTimer();
        layer1 = 0;
        layer2 = 1200;
    }

    //Functions
    public void update(){
            if (t.time == 5) {
                t.time = 0;
                timerspeed++;
                speed = speed + timerspeed;
                timerspeed = 0;
                if (speed >= 19) {
                    speed = 19;
                }
            }
       // System.out.println(speed);
        if(layer2 - speed <= 0){
            layer1 = 0;
            layer2 = 1200;
        }else {
            layer1 -= speed;
            layer2 -= speed;
        }

    }

    public void draw(Graphics2D g){
        g.drawImage(image1, layer1, 0, null);
        g.drawImage(image1, layer2, 0, null);
    }

}
