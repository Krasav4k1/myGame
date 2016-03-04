package Tenis;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GamePanel extends JPanel implements Runnable{

    //Fields
    public static int wigth = 500;
    public static int heigth = 500;

    private Thread thread;
    private BufferedImage image;
    private Graphics2D g;

    private static GameBack background;
    public static Platform platform;
    public static Platform2 platform2;
    public static Boll boll;
    public static ArrayList<Ability> abilities;



    //Constructor
    public GamePanel(){
        super();
        setPreferredSize(new Dimension(wigth,heigth));
        setFocusable(true);
        requestFocus();

        addKeyListener(new Listenes());
    }

    //Functions
    public void start(){
        thread =  new Thread(this);
        thread.start();

    }

    @Override
    public void run() {
        image = new BufferedImage(wigth, heigth, BufferedImage.TYPE_INT_RGB);
        g = (Graphics2D) image.getGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        background = new GameBack();
        platform = new Platform();
        platform2 = new Platform2();
        boll = new Boll();
        abilities = new ArrayList<Ability>();
        abilities.add(new Ability());


        while (true) {// TODO States
            gameUpdate();
            gameRender();
            gameDraw();
            try {
                thread.sleep(25);//TODO FPS
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }


    }

    public void gameUpdate(){
        //Background
        background.update();
        //Platform
        platform.update();
        //Boll
        boll.update();
        //Platform2
        platform2.update();
        //Ability
        for (int d = 0; d < abilities.size(); d++){
            abilities.get(d).update();
        }
    }

    public void gameRender(){
        //Background
        background.draw(g);
        //Platform
        platform.draw(g);
        //Boll
        boll.draw(g);
        //Platform2
        platform2.draw(g);
        //Ability
        for (int d = 0; d < abilities.size(); d++){
            abilities.get(d).draw(g);
        }

    }

    public void gameDraw(){
        Graphics g2 = this.getGraphics();
        g2.drawImage(image, 0, 0, null);
        g2.dispose();
    }



}
