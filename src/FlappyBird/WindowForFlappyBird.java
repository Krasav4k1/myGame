package FlappyBird;

import javax.swing.*;

public class WindowForFlappyBird extends JFrame{
    WindowForFlappyBird(){
     super("Flappy Bird");
        GamePanel panel = new GamePanel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(GamePanel.wigth,GamePanel.heigth);
        setLocationRelativeTo(null);
        setContentPane(panel);
        panel.start();
        setVisible(true);
    }

}
