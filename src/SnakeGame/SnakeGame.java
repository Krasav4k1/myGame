package SnakeGame;

import com.sun.deploy.panel.JavaPanel;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class SnakeGame extends JavaPanel implements ActionListener{

    public static final int scale = 20;
    public static final int width = 30;
    public static final int heigth = 30;
    public static final int speed = 15;
    public static final int newspeed = 5;
    public static final int new2speed = 5;

    Apple apple = new Apple((int) (Math.random()*width),(int) (Math.random()*heigth));
    PoitApple poitApple = new PoitApple((int) (-10), (int)(-10));
    Snake snake = new Snake(15,15,14,15);
    Timer timer = new Timer(1000/speed, this);
    Timer newtimer = new Timer(1000/newspeed, this);
    Timer new2timer = new Timer(1000/newspeed, this);


    public SnakeGame(){
        timer.start();
        addKeyListener(new Keyboard());
        setFocusable(true);
}

    public void paint(Graphics g){
        g.setColor(color(220,220,220));
        g.fillRect(0 , 0 ,width*scale,heigth*scale);
        g.setColor(color(220,220,200));

        for(int xx = 0; xx <= width * scale; xx += scale){
            g.drawLine(xx, 0, xx, heigth*scale);
        }

        for(int yy = 0; yy < heigth * scale; yy += scale){
            g.drawLine(0, yy, width * scale, yy);
        }

       // for(int xx = 0; xx <= width * scale *scale ; xx += scale){
       //     g.drawLine(xx,0 ,0, xx);
       // }

            g.setColor(color(200, 50, 0));
            g.fillRoundRect(snake.snakeX[0] * scale + 1, snake.snakeY[0] * scale + 1, scale - 2, scale - 2, 40, 40);
        if ((snake.length >= 10) & (snake.length <= 20)) {
            g.setColor(color(0, 50, 200));
            g.fillRoundRect(snake.snakeX[0] * scale + 1, snake.snakeY[0] * scale + 1, scale - 2, scale - 2, 20, 20);
        }
        if ((snake.length >= 20) & (snake.length <= snake.length)) {
            g.setColor(color(0, 200, 50));
            g.fillRoundRect(snake.snakeX[0] * scale + 1, snake.snakeY[0] * scale + 1, scale - 2, scale - 2, 20, 20);
        }

        for(int d = 1; d < snake.length; d++) {
            if ((snake.length >= 10) & (snake.length <= 20)) {
                g.setColor(color(255, 100, 150));
                g.fillRoundRect(snake.snakeX[d] * scale + 1, snake.snakeY[d] * scale + 1, scale - 2, scale - 2, 20, 20);
                newtimer.start();
            }
        }
            for(int t = 1; t < snake.length; t++) {
                g.setColor(color(200, 150, 0));
                g.fillRoundRect(snake.snakeX[t] * scale + 1, snake.snakeY[t] * scale + 1, scale - 2, scale - 2,40,40);
            }
        for(int d = 0; d < snake.length; d++){
            if ((snake.length >= 20) & (snake.length <= snake.length)) {
                g.setColor(color(0, 0, 0));
                g.fill3DRect(snake.snakeX[d] * scale + 1, snake.snakeY[d] * scale + 1, scale - 1, scale - 1,true);
                new2timer.start();
            }
        }

        g.setColor(color(0,255,0));
        g.fillRoundRect(apple.posX*scale+1, apple.posY*scale+1,scale-1,scale-1,30,30);
        if((snake.length >= 10) & (snake.length <=20)) {
            g.setColor(color(0, 0, 255));
            g.fillRoundRect(apple.posX * scale + 1, apple.posY * scale + 1, scale - 1, scale - 1,30,30);
        }

        if((snake.length >= 20) & (snake.length <=snake.length)) {
            g.setColor(color(255, 0, 0));
            g.fillRect(apple.posX * scale + 1, apple.posY * scale + 1, scale - 1, scale - 1);
        }
            for(int d = 0; d < 1000; d+=10) {
                if ((snake.length == d)) {
                    g.setColor(color(255, 0, 255));
                    g.fillRoundRect(poitApple.posPX * scale + 1, poitApple.posPY * scale + 1, scale +20, scale +20,40,40);
                }
            }

    }

    public Color color (int red, int green, int blue){

        return new Color(red,green,blue);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(600,600);
        frame.setLocationRelativeTo(null);
        frame.add(new SnakeGame());
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        snake.move();

        if ((snake.snakeX[0] == apple.posX) & (snake.snakeY[0] == apple.posY)) snake.length += 1;

        if ((snake.snakeX[0] == apple.posX) & (snake.snakeY[0] == apple.posY))apple.setRandomPosition();

        for (int d = 0; d < 1000; d += 10) {
            if ((snake.length == d - 1)) {
                for (int k = 1; k < snake.length; k++) {
                    if ((snake.snakeX[k] != poitApple.posPX) & (snake.snakeY[k] != poitApple.posPY)) {
                        poitApple.setPointAppleRandom(1);
                    }
                }
            }
            if (snake.length == d) {
                if ((snake.snakeX[0] == poitApple.posPX) & (snake.snakeY[0] == poitApple.posPY)) {
                    snake.length += 3;
                    poitApple.setPointAppleRandom(0);
                }
                if ((snake.snakeX[0] == poitApple.posPX + 1) & (snake.snakeY[0] == poitApple.posPY)) {
                    snake.length += 3;
                    poitApple.setPointAppleRandom(0);
                }
                if ((snake.snakeX[0] == poitApple.posPX) & (snake.snakeY[0] == poitApple.posPY + 1)) {
                    snake.length += 3;
                    poitApple.setPointAppleRandom(0);
                }
                if ((snake.snakeX[0] == poitApple.posPX + 1) & (snake.snakeY[0] == poitApple.posPY + 1)) {
                    snake.length += 3;
                    poitApple.setPointAppleRandom(0);
                }
            }
        }

        if ((apple.posX == poitApple.posPX) & (apple.posY == poitApple.posPY)){
            apple.setRandomPosition();
            poitApple.setPointAppleRandom(1);
        }

        for (int d = 1; d < snake.length; d++) {
            if ((snake.snakeX[d] == apple.posX) & (snake.snakeY[d] == apple.posY)) apple.setRandomPosition();
            if ((snake.snakeX[d] == poitApple.posPX) & (snake.snakeY[d] == poitApple.posPY)) poitApple.setPointAppleRandom(0);
        }
        for(int d = 1; d <= snake.length; d++) {
            if ((snake.snakeX[0] == snake.snakeX[d]) & (snake.snakeY[0] == snake.snakeY[d])){
                snake.length = 4;
                newtimer.stop();
                new2timer.stop();
                snake.snakeX[0] = width/2;
                snake.snakeY[0] = heigth/2;
            }

            repaint();
        }
    }




    private class Keyboard extends KeyAdapter{
        public void keyPressed(KeyEvent kEvt) {
        int key = kEvt.getKeyCode();

            if((key == KeyEvent.VK_RIGHT) & (snake.diraction != 2)) {
                snake.snakeX[0] += 1;
                snake.diraction = 0;
            }
            if((key == KeyEvent.VK_DOWN) & (snake.diraction != 3)) {
                snake.snakeY[0] += 1;
                snake.diraction = 1;
            }
            if((key == KeyEvent.VK_LEFT) & (snake.diraction != 0)){
                snake.snakeX[0] -= 1;
                snake.diraction = 2;
            }
            if((key == KeyEvent.VK_UP) & (snake.diraction != 1)){
                snake.snakeY[0] -= 1;
                snake.diraction = 3;
            }
        }
    }

}
