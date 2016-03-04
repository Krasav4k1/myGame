package Airplane;

import javax.swing.*;
import java.awt.*;

public class Enemy {

    //Fields
    private double x;
    private double y;
    private int r;

    private double speed;
    private double dx;
    private double dy;

    public double health;

    public int type;
    public int rank;

    Graphics2D g;
    private Color color;
    Image image1;
    Image bom;


    //Constructor
    public Enemy(int type, int rank){
        this.type = type;
        this.rank = rank;
        bom = new ImageIcon("0_1205de_e1ed4085_L.png").getImage();

        switch(rank){
            case 1:
                color = Color.green;
                r = 8;
                health = 2;
                break;
            case 2:
                color = Color.yellow;
                r = 13;
                health = 7;
                break;
            case 3:
                color = Color.BLACK;
                r = 16;
                health = 15;
                break;
        }

        switch (type){
            case 1:
                x = Math.random() * GamePanel.wigth;
                y = 0;
                speed = 5;
                GamePanel.heard.timeVisible = 50;
                double angle = Math.toRadians(Math.random()*360);
                dx = Math.sin(angle) * speed;
                dy = Math.cos(angle) * speed;
                image1 = new ImageIcon("ufo-spaceship.png").getImage();
                break;
            case 2:
                x = Math.random() * GamePanel.wigth;
                y = 0;
                speed = 6;
                GamePanel.heard.timeVisible = 50;
                image1 = new ImageIcon("Another-UFO-icon.png").getImage();
                angle = Math.toRadians(Math.random()*360);
                dx = Math.sin(angle) * speed ;
                dy = Math.cos(angle) * speed ;
                break;
            case 3:
                x = Math.random() * GamePanel.wigth;
                y = 0;
                speed = 8;
                GamePanel.heard.timeVisible = 50;
                image1 = new ImageIcon("ufo.png").getImage();
                angle = Math.toRadians(Math.random()*360);
                dx = Math.sin(angle) * speed ;
                dy = Math.cos(angle) * speed ;
                break;
        }

    }

    //Getter
    public double getX() {return x;}
    public double getY() {return y;}
    public int getR(){return r;}

    //Functions
    public boolean remove(){
        if(health == 10){
            GamePanel.enemies.add(new Enemy(3,2));
            GamePanel.enemies.add(new Enemy(3,2));
        }
        if(health == 4){
            GamePanel.enemies.add(new Enemy(3,1));
        }
        if(health <= 0){

            return true;
        }
        return false;
    }

    public void hit(){
        health--;
    }

    public void update(){
        x += dx;
        y += dy;

        if(x < 0 && dx < 0) dx = -dx;
        if(x > GamePanel.wigth && dx > 0) dx = -dx;

        if(y < 0 && dy < 0) dy = -dy;
        if(y > GamePanel.heigth && dy > 0) dy = -dy;

    }

    public void draw(Graphics2D g){
//        g.setColor(color);
//        g.fillOval((int)x - r,(int) y - r, 2 * r, 2 * r);
//        g.setStroke(new BasicStroke(3));
//        g.setColor(color.darker());
//        g.drawOval((int)x - r,(int) y - r, 2 * r, 2 * r);
//        g.setStroke(new BasicStroke(1));

        g.drawImage(image1,(int) x - r * 2, (int) y - r * 2, r * 4, r * 4, null);



    }




}
