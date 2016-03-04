package TheDragon;

import java.awt.*;

public class Menu {

    //Fields
    public int x;
    public int y;

    public int wigth;
    public int heigth;
    public static int mouseX;
    public static int mouseY;
    public boolean pressMouse = false;

    public String text;

    private int transperent = 0;

    //Constructor
    public Menu(){
        x = GamePanel.wigth / 2;
        y = GamePanel.heigth / 3;

        wigth = 100;
        heigth = 40;

        text = "PLAY";
    }

    //Functions
    public void update(){
        if(GamePanel.states.equals(GamePanel.STATES.MENUE)){
            if (mouseX > x - wigth / 2
                    && mouseX < x + wigth / 2
                    && mouseY > y - heigth / 2
                    && mouseY < y + heigth / 2) {
                transperent = 100;
                if (pressMouse) {
                    GamePanel.states = GamePanel.STATES.PLAY;
                }
            } else {
                transperent = 0;
            }
        }
    }

    public void draw(Graphics2D g) {
        if (GamePanel.states.equals(GamePanel.STATES.MENUE)) {
            g.setColor(new Color(130, 130, 130));
            g.setStroke(new BasicStroke(3));
            g.drawRect(x - wigth / 2, y - heigth / 2, wigth, heigth);
            g.setColor(new Color(130, 130, 130, transperent));
            g.fillRect(x - wigth / 2, y - heigth / 2, wigth, heigth);

            g.setColor(new Color(150, 150, 150));
            g.setFont(new Font("Consoles", Font.BOLD, 30));
            long length = (int) g.getFontMetrics().getStringBounds(text, g).getWidth();
            g.drawString(text, x - length / 2, y + heigth / 4);
        } else {
            g.setColor(new Color(150,150,150));
            g.setFont(new Font("Consoles", Font.BOLD, 20));
            long length = (int) g.getFontMetrics().getStringBounds("RUN", g).getWidth();
            g.drawString("RUN", x + 10- length  / 2, y  / 4);
        }
    }


}
