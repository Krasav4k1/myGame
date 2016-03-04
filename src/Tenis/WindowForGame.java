package Tenis;

import javax.swing.*;

public class WindowForGame extends JFrame{
    WindowForGame(){
        super("Tenis");
        GamePanel panel = new GamePanel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel);
        pack();
        setLocationRelativeTo(null);
        panel.start();
    }
}
