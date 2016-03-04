package Tenis;

import java.awt.*;

public class Ability{

    //Fields
    public static double x;
    public static double y;

    private static int width = GamePanel.wigth;
    private static int height = GamePanel.heigth;

    private static int r;

    private Color color;

    //Constructor
    public Ability(){
        color = Color.orange;
        r = 10;
        x = (int) (30 + Math.random() * (((width - 30)  - 30) + 30));
        y = (int) (70 + Math.random() * (((height - 70)  - 70) + 70));
    }

    //Functions
    public void update(){
    }

    public void draw(Graphics2D g){
        g.setColor(color);
        g.fillOval((int) x ,(int) y, r , r);
    }
}
