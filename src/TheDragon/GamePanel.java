package TheDragon;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GamePanel extends JPanel implements Runnable {

    //Fileds
    public static int wigth = 900;
    public static int heigth = 400;

    private Graphics2D g;
    private BufferedImage image;
    public static GameBack background;
    public static TheDragon theDragon;
    public static ArrayList<Noise> noises;
    public enum STATES {MENUE, PLAY}
    public static STATES states = STATES.MENUE;
    public static Menu menu;

    private Thread thread;

    private int FPS;
    private double millisToFPS;
    private long timerFPS;
    private int sleepTime;
    public static boolean addNoise = false;

    //Constructor
    public GamePanel(){
        super();
        setFocusable(true);
        requestFocus();

        addKeyListener(new Listenes());
        addMouseListener(new Listenes());
        addMouseMotionListener(new Listenes());
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

        background = new GameBack();
        theDragon = new TheDragon();
        noises = new ArrayList<Noise>();
        noises.add(new Noise((int) Math.round(1 + Math.random() * 1),(int) Math.round(1 + Math.random() * 3)));
        noises.add(new Noise((int) Math.round(1 + Math.random() * 1),(int) Math.round(1 + Math.random() * 3)));
        menu = new Menu();


        while (true){

            if(states.equals(STATES.MENUE)){
                background.draw(g);
                background.speed = 12;
                menu.update();
                menu.draw(g);
                noises.clear();
                theDragon.y = theDragon.nullY;
                noises.add(new Noise(1,1));
                gameDraw();
            }

            if(states.equals(STATES.PLAY)) {
                gameUpdate();
                gameRender();
                gameDraw();
            }
            timerFPS = (System.nanoTime() - timerFPS) / 1000000;
            if(millisToFPS > timerFPS){
                sleepTime = (int) (millisToFPS - timerFPS);
            }else sleepTime = 12;

            try {
                thread.sleep(sleepTime);//TODO FPS
            }catch (InterruptedException e){
                e.printStackTrace();
            }

            timerFPS = 0;
            sleepTime = 1;
        }

    }

    public void gameUpdate() {
        //Background update
        background.update();
        //TheDragon update
        theDragon.update();
        //Noise update
        for (int d = 1; d < noises.size(); d++) {
            noises.get(d).update();
            boolean remove = noises.get(d).remove();
            if (remove) {
                noises.remove(d);
                d--;
            }
        }

        //Menu update
        menu.update();
    }




    public void gameRender(){
        //Background draw
        background.draw(g);
        //TheDragon draw
        theDragon.draw(g);
        //Noise draw
        for(int d = 0; d < noises.size(); d++){
            noises.get(d).draw(g);
        }
        //Menu draw
        menu.draw(g);
    }


    public void gameDraw(){
        Graphics g2 = this.getGraphics();
        g2.drawImage(image, 0, 0, null);
        g2.dispose();

    }

}
