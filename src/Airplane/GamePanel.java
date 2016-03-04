package Airplane;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GamePanel extends JPanel implements Runnable{

    //Field
    public static int wigth = 1200;
    public static int heigth = 600;

    public static int mouseX;
    public static int mouseY;
    public static boolean clicOnMenu;
    public static int point = 0;
    public static boolean poinBullet = false;

    private Thread thread;

    private BufferedImage image;
    private static Graphics2D g;

    private int FPS;
    private double millisToFPS;
    private long timerFPS;
    private int sleepTime;

    public enum STATES{ MENUE, PLAY, RESTART}
    public static STATES state = STATES.MENUE;

    private static GameBack background;
    public static Player player;
    public static ArrayList<Bullet> bullets;
    public static ArrayList<Enemy> enemies;
    public static List<Person> personsRecord = new ArrayList<>();
    public static Wave wave;
    public static Menu menu;
    public static Record record;
    public static Heard heard = new Heard();
    public static Bom bom;
    public static PointBullet pointBullet;

    //Constructor
    public GamePanel(){
        super();
        setPreferredSize(new Dimension(wigth,heigth));
        setFocusable(true);
        requestFocus();

        addKeyListener(new Listeners());
        addMouseMotionListener(new Listeners());
        addMouseListener(new Listeners());
    }


    //Getter


    //Function
    public synchronized void start(){

        thread = new Thread(this);
        thread.start();
    }



    @Override
    public void run() {

        FPS = 35;
        millisToFPS = 1000 / FPS;
        sleepTime = 0;

        image = new BufferedImage(wigth,heigth,BufferedImage.TYPE_INT_RGB);
        g =(Graphics2D) image.getGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);

        clicOnMenu = false;
        background = new GameBack();
        player = new Player();
        bullets = new ArrayList<Bullet>();
        enemies = new ArrayList<Enemy>();
        wave = new Wave();
        menu = new Menu();
        record = new Record();
        bom = new Bom();
        pointBullet = new PointBullet();


        //Create Cursor
/*
        Toolkit kit = Toolkit.getDefaultToolkit();
        BufferedImage buffered = new BufferedImage(13, 13, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g3 = (Graphics2D) buffered.getGraphics();
        g3.setColor(new Color(255, 255, 255));
        g3.drawOval( 0, 0, 4, 4);
        g3.drawLine( 2, 0, 2, 4);
        g3.drawLine( 0, 2, 4, 2);
        Cursor myCursor = kit.createCustomCursor(buffered, new Point(6, 6),"myCursor");
        g3.dispose();
*/


        while (true) {//TODO States

            //this.setCursor(myCursor);
            timerFPS = System.nanoTime();
            if(state.equals(STATES.MENUE)){
                menu.t.pousaTimer();
                background.update();
                background.draw(g);
                menu.update();
                menu.draw(g);
                gameDraw();
            }
            if(state.equals(STATES.PLAY)) {
                gameUpdate();
                gameRender();
                gameDraw();
            }

            if(state.equals(STATES.RESTART)) {
                menu.t.pousaTimer();
                background.update();
                background.draw(g);
                menu.update();
                menu.draw(g);
                record.draw(g);
                gameDraw();
                wave.waveNumber = 1;
                heard.a = -1;
                pointBullet.a = -1;
                player = new Player();
                enemies.clear();
                point = 0;
                record.showRecord();
            }



            timerFPS = (System.nanoTime() - timerFPS) / 1000000;
            if(millisToFPS > timerFPS){
                sleepTime =(int) (millisToFPS - timerFPS);
            }else sleepTime = 12;

            try {
                thread.sleep(sleepTime);//TODO FPS
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            timerFPS = 0;
            sleepTime = 1;

        }

    }


    public void gameUpdate(){
    //Background update
        background.update();

    //Player update
        player.update();

    //Bullets update
        for (int d = 0; d < bullets.size(); d++){
            bullets.get(d).update();
            boolean remove = bullets.get(d).remove();
            if (remove){
                bullets.remove(d);
                d--;
            }
        }

    //Enemy update
        for (int d = 0; d < enemies.size(); d++){
            enemies.get(d).update();
        }

    //Bullets-enemies collide
        for(int d = 0; d <enemies.size(); d++){
            Enemy e = enemies.get(d);
            double ex = e.getX();
            double ey = e.getY();

            for (int r = 0; r < bullets.size(); r++){
                Bullet b = bullets.get(r);
                double bx = b.getX();
                double by = b.getY();

                double dx = ex - bx;
                double dy = ey - by;

                double dist = Math.sqrt(dx * dx + dy * dy);
                if ((int) dist <= e.getR() + b.getR()){
                    e.hit();
                    bullets.remove(r);
                    r--;
//                    enemies.get(d).image1 = new ImageIcon("0_1205de_e1ed4085_L.png").getImage();
                    boolean remove = e.remove();
                    Bom.x = enemies.get(d).getX();
                    Bom.y = enemies.get(d).getY();
                    Bom.r = enemies.get(d).getR();
                    if(remove){
                        point++;
                        Record.setPoint(point);
                        enemies.remove(d);
                        d--;
                        break;
                    }
                }
            }
        }

        //Player-enemy collides
        for (int d = 0; d < enemies.size(); d++){
            Enemy e = enemies.get(d);
            double ex = e.getX();
            double ey = e.getY();

            double px = player.getX();
            double py = player.getY();

            double dx = ex - px;
            double dy = ey - py;

            double dist = Math.sqrt(dx * dx + dy * dy);
              if ((int) dist <= e.getR() + player.getR()){
                e.hit();
                player.hit();
                boolean remove = e.remove();
                if(remove){
                    enemies.remove(d);
                    d--;
                }
            }
        }

        //Wave update
        wave.update();

        //Record update
        record.update();

        //Heard update
        if (heard.create()) {
            heard.update();
        }
        //Bom update
        bom.update();

        //PointBullet update
        if(pointBullet.createPointBullet()) {
            pointBullet.update();
        }
    }

    public void gameRender(){
    //Background draw
        background.draw(g);

    //Player draw
        player.draw(g);

    //Bullets draw
        for (int d = 0; d < bullets.size(); d++){
            bullets.get(d).draw(g);
        }

    //Enemy draw
        for (int d = 0; d < enemies.size(); d++){
           enemies.get(d).draw(g);
        }

    //Wave draw
        if (wave.showWave()) wave.draw(g);

    //Record draw
        record.draw(g);

    //Heard draw
        if (heard.create()) {
            heard.draw(g);
        }

    //Bom dram
        bom.draw(g);

    //PointBullet draw
        if (pointBullet.createPointBullet()) {
            pointBullet.draw(g);
        }
    }

    private void gameDraw(){
        Graphics g2 = this.getGraphics();
        g2.drawImage(image, 0, 0, null);
        g2.dispose();
    }

    public static void addPerson(){
        if(new File("RecordForBoobleShooter.txt").length() != 0){
            inputStream();
        }
            String person = null;
            person = JOptionPane.showInputDialog(null, "Ваше ім'я");
            try {
                if (person.length() > 0) {
                    personsRecord.add(new Person(person, point));
                    outputStream();
                }
            } catch (NullPointerException e) {
                state = STATES.RESTART;
            }

            outputStream();

        }



    public static void inputStream() {

        try (InputStream is = new FileInputStream("RecordForBoobleShooter.txt");
             ObjectInputStream ois = new ObjectInputStream(is)) {
            personsRecord = (ArrayList) ois.readObject();
            is.close();
            ois.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void outputStream(){
        try(OutputStream os = new FileOutputStream("RecordForBoobleShooter.txt");
            ObjectOutputStream oos = new ObjectOutputStream(os)){
            oos.writeObject(personsRecord);
            oos.flush();
            os.close();
            oos.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
