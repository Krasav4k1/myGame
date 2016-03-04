package FlappyBird;

import javax.swing.*;
import java.awt.*;

public class BackGameBackground {

    //Fields
    Image image;
    private int speed;
    private int layer1;
    private int layer2;

    //Constructor
    public BackGameBackground(){
        image = new ImageIcon("flappy_bird_background.png").getImage();
        layer1 = 0;
        layer2 = 500;
        speed = 8;
    }

    //Functions
    public void update(){

        if(layer2 - speed <= 0){
            layer1 = 0;
            layer2 = 500;
        } else {
            layer1 -= speed;
            layer2 -= speed;
        }

    }

    public void draw(Graphics2D g){
        g.drawImage(image, layer1, 0, null);
        g.drawImage(image, layer2, 0, null);
    }


}
