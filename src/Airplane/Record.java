package Airplane;

import java.awt.*;
import java.util.Collections;
import java.util.Comparator;

public class Record {

    //Fields
    private int tableWidth;
    private int tableHeigth;

    private int tableX;
    private int tableY;

    private Color color;

    private static String point;
    private static String health;
    private static String cointEnemy;
    private static int coitEn;


    //Constructor
    public Record(){
        tableWidth = 70;
        tableHeigth = 30;

        tableX = GamePanel.wigth - tableWidth / 2;
        tableY = 40;

        color = new Color(0,0,255,125);

        if(GamePanel.point == 0){
            this.setPoint(0);
        }
        if(Wave.counter == 0){
            this.setCointEnemy(0);
        }

//        int a = Integer.getInteger(Record.point);
//        int b = Integer.getInteger(Record.cointEnemy);
//        Record.cointEnemy = Integer.toString(b-a);
//        System.out.println(Record.cointEnemy);


    }

    //Getter & Setter
    public static int getPoint(){return Integer.getInteger(point);}
    public static void setPoint(int point){
        Record.point = Integer.toString(point);
    }

    public static String getHealth(){return health;}
    public static void setHealth(int health){
        Record.health = Integer.toString(health);
    }

    public static int getCointEnemy(){return Integer.getInteger(cointEnemy);}
    public static void setCointEnemy(int cointEnemy) {
        Record.cointEnemy = Integer.toString(cointEnemy);
    }

    //Functions

    public static void showRecord(){
        Collections.sort(GamePanel.personsRecord, new Comparator<Person>(){
            @Override
            public int compare(Person o1, Person o2) {
                return o2.getRecord() - o1.getRecord();
            }
        });

    }

    public void update() {
        if (GamePanel.state.equals(GamePanel.STATES.RESTART)){
            GamePanel.addPerson();
        }
    }

    public void draw(Graphics2D g){
        if(GamePanel.state.equals(GamePanel.STATES.PLAY)) {
                g.setColor(color);
                g.setFont(new Font("Consoles", Font.BOLD, 40));
                long lengthPlay = (int) g.getFontMetrics().getStringBounds(point, g).getWidth();
                g.drawString(point, (int) GamePanel.wigth - lengthPlay, (int) tableY);

            g.setColor(new Color(255,100,10,155));
            g.setFont(new Font("Consoles", Font.BOLD, 40));
            long lengthHealth = (int) g.getFontMetrics().getStringBounds(health, g).getWidth();
            g.drawString(health, (int) 0 + lengthHealth, (int) tableY);

        g.setColor(new Color(255,255,255,125));
        g.setFont(new Font("Consoles", Font.BOLD, 40));
        long lengthCointEnemy = (int) g.getFontMetrics().getStringBounds(cointEnemy, g).getWidth();
        g.drawString(cointEnemy, (int) GamePanel.wigth / 2 - lengthCointEnemy / 2, (int) tableY);


        }
        if(GamePanel.state.equals(GamePanel.STATES.RESTART)) {
            g.setColor(new Color(0,0,165,100));
            g.setFont(new Font("Consoles", Font.BOLD, 40));
            long length = (int) g.getFontMetrics().getStringBounds("Ваш рекорд - " + point, g).getWidth();
            g.drawString("Ваш рекорд - " + point, (int) GamePanel.wigth / 2 - length + tableWidth * 2 + 10,
                    (int) GamePanel.heigth / 2 - tableHeigth * 2);

            if(GamePanel.personsRecord.size() >= 1) {
                g.setColor(new Color(60, 60, 60));
                g.setFont(new Font("Consoles", Font.ITALIC, 20));
                long lengthTable = (int) g.getFontMetrics().getStringBounds("Рекорди :  " + " 1 - " + GamePanel.personsRecord.get(0).getNikName() +
                        " - " + GamePanel.personsRecord.get(0).getRecord(), g).getWidth();
                g.drawString("Рекорди :  " + " 1 - " + GamePanel.personsRecord.get(0).getNikName() + " - " + GamePanel.personsRecord.get(0).getRecord(),
                        (int) GamePanel.wigth - lengthTable - 10, (int) 50);
            }
            if(GamePanel.personsRecord.size() >= 2) {
                g.setColor(new Color(90, 90, 90));
                g.setFont(new Font("Consoles", Font.ITALIC, 20));
                long lengthTable1 = (int) g.getFontMetrics().getStringBounds("2 - " + GamePanel.personsRecord.get(1).getNikName() +
                        " - " + GamePanel.personsRecord.get(1).getRecord(), g).getWidth();
                g.drawString("2 - " + GamePanel.personsRecord.get(1).getNikName() + " - " + GamePanel.personsRecord.get(1).getRecord(),
                        (int) GamePanel.wigth - lengthTable1 - 10, (int) 80);
            }
            if(GamePanel.personsRecord.size() >= 3) {
                g.setColor(new Color(120, 120, 120));
                g.setFont(new Font("Consoles", Font.ITALIC, 20));
                long lengthTable2 = (int) g.getFontMetrics().getStringBounds("3 - " + GamePanel.personsRecord.get(2).getNikName() +
                        " - " + GamePanel.personsRecord.get(2).getRecord(), g).getWidth();
                g.drawString("3 - " + GamePanel.personsRecord.get(2).getNikName() + " - " + GamePanel.personsRecord.get(2).getRecord(),
                        (int) GamePanel.wigth - lengthTable2 - 10, (int) 110);
            }
        }


    }
}
