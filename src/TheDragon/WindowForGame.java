package TheDragon;

import javax.swing.*;

public class WindowForGame extends JFrame{

    public WindowForGame(){
        super("TheDragon");
        GamePanel panel = new GamePanel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setContentPane(panel);
        setSize(GamePanel.wigth, GamePanel.heigth);
        setLocationRelativeTo(null);
        panel.start();
    }


}
