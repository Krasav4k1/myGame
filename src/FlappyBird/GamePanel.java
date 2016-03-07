package FlappyBird;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GamePanel extends JPanel implements Runnable{

    //Fields        //SizeForWindow

    public static int wigth = 600;
    public static int heigth = 700;


                    //Objects

    public Thread thread;
    public Graphics2D g;
    public BufferedImage image;
    public BackGameBackground background;
    public static Bird bird;
    public static ArrayList<Noise> noises;

                    //FPS for Game

    private int FPS;
    private double millisToFPS;
    private long timerFPS;
    private int sleepTime;
    public enum STATYS {MENU,PLAY}
    public static STATYS statys = STATYS.MENU;

    //Constructor
    public GamePanel(){
        super();

        setFocusable(true);
        requestFocus();

        addKeyListener(new Listenes());
    }


    //Functions
    public void start(){
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {

        FPS = 35;
        millisToFPS = 1000 / FPS;
        sleepTime = 0;

        image = new BufferedImage(wigth, heigth, BufferedImage.TYPE_INT_RGB);
        g = (Graphics2D) image.getGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        background = new BackGameBackground();
        bird = new Bird();
        noises = new ArrayList<>();

        noises.add(new Noise());

        while(true){

        if(statys.equals(STATYS.MENU)){

            renderGame();
            drawGame();
        }
        if(statys.equals(STATYS.PLAY)){
            updateGame();
            renderGame();
            drawGame();
        }


            timerFPS = (System.nanoTime() - timerFPS) / 1000000;
            if(millisToFPS > timerFPS){
                sleepTime = (int) (sleepTime - timerFPS);
            }else sleepTime = 12;

            try {
                thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            timerFPS = 0;
            sleepTime = 1;
        }



    }

    public void updateGame(){
        //Background update
        background.update();
        //Bird update
        bird.update();
        //Noise update
        for(int d = 0; d < noises.size(); d++){
            noises.get(d).update();
        }
    }

    public void renderGame(){
        //Background draw
        background.draw(g);
        //Bird draw
        bird.draw(g);
        //Noise draw
        for(int d = 0; d < noises.size(); d++){
            noises.get(d).draw(g);
        }
    }

    public void drawGame(){
        Graphics g2 = this.getGraphics();
        g2.drawImage(image, 0, 0, null);
        g2.dispose();
    }


}
