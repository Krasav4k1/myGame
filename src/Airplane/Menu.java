package Airplane;

import java.awt.*;
import java.util.*;

public class Menu {

    //Fields
    private int buttonPlayWidth;
    private int buttonPlayHeight;
    private int buttonRestartWidth;
    private int buttonRestartHeight;
    private Color color1;
    private String textPlay;
    private String textRestart;
    private int transperent = 0;
    TimerfForGame t = new TimerfForGame();
    private Timer timer = new Timer();
    java.util.TimerTask timerTask;

    //Constructor
    public Menu(){
        buttonRestartWidth = 200;
        buttonRestartHeight = 60;

        buttonPlayWidth = 120;
        buttonPlayHeight = 60;

        color1 = new Color(255,255,255,200);
        textPlay = "PLAY";
        textRestart = "RESTART";
    }

    //Functions
    public void update(){
        if(GamePanel.state.equals(GamePanel.STATES.MENUE)) {
            if (GamePanel.mouseX > GamePanel.wigth / 2 - buttonPlayWidth / 2
                    && GamePanel.mouseX < GamePanel.wigth / 2 + buttonPlayWidth / 2
                    && GamePanel.mouseY > GamePanel.heigth / 2 - buttonPlayHeight / 2
                    && GamePanel.mouseY < GamePanel.heigth / 2 + buttonPlayHeight / 2) {
                transperent = 100;
                if (GamePanel.clicOnMenu) {
                    GamePanel.state = GamePanel.STATES.PLAY;
                    t.startTimer();
                }
            } else {
                transperent = 0;
            }
        }
        if(GamePanel.state.equals(GamePanel.STATES.RESTART)) {
            if (GamePanel.mouseX > GamePanel.wigth / 2 - buttonRestartWidth / 2
                    && GamePanel.mouseX < GamePanel.wigth / 2 + buttonRestartWidth/ 2
                    && GamePanel.mouseY > GamePanel.heigth / 2 - buttonRestartHeight / 2
                    && GamePanel.mouseY < GamePanel.heigth / 2 + buttonRestartHeight / 2) {
                transperent = 100;
                if (GamePanel.clicOnMenu){
                    GamePanel.state = GamePanel.STATES.PLAY;
                    t.restartTimer();
                }
            } else {
                transperent = 0;
            }
        }
    }

    public void draw(Graphics2D g) {
        if(GamePanel.state.equals(GamePanel.STATES.MENUE)) {

            g.setColor(color1);
            g.setStroke(new BasicStroke(3));
            g.drawRect(GamePanel.wigth / 2 - buttonPlayWidth / 2,
                    GamePanel.heigth / 2 - buttonPlayHeight / 2,
                    buttonPlayWidth, buttonPlayHeight);

            g.setColor(new Color(255, 255, 255, transperent));
            g.fillRect(GamePanel.wigth / 2 - buttonPlayWidth / 2,
                    GamePanel.heigth / 2 - buttonPlayHeight / 2,
                    buttonPlayWidth, buttonPlayHeight);
            g.setStroke(new BasicStroke(1));

            g.setColor(color1);
            g.setFont(new Font("Consoles", Font.BOLD, 40));
            long length = (int) g.getFontMetrics().getStringBounds(textPlay, g).getWidth();
            g.drawString(textPlay, (int) GamePanel.wigth / 2 - length / 2, (int) GamePanel.heigth / 2 + buttonPlayHeight / 4);
        }
        if (GamePanel.state.equals(GamePanel.STATES.RESTART)) {

            g.setColor(color1);
            g.setStroke(new BasicStroke(3));
            g.drawRect(GamePanel.wigth / 2 - buttonRestartWidth / 2,
                    GamePanel.heigth / 2 - buttonRestartHeight / 2,
                    buttonRestartWidth, buttonRestartHeight);

            g.setColor(new Color(255, 255, 255, transperent));
            g.fillRect(GamePanel.wigth / 2 - buttonRestartWidth / 2,
                    GamePanel.heigth / 2 - buttonRestartHeight / 2,
                    buttonRestartWidth, buttonRestartHeight);
            g.setStroke(new BasicStroke(1));

            g.setColor(color1);
            g.setFont(new Font("Consoles", Font.BOLD, 40));
            long lengthRestart = (int) g.getFontMetrics().getStringBounds(textRestart, g).getWidth();
            g.drawString(textRestart, (int) GamePanel.wigth / 2 - lengthRestart / 2, (int) GamePanel.heigth / 2 + buttonRestartHeight / 4);
        }
    }

}
