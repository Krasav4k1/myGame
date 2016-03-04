package Airplane;

import java.awt.*;

public class Wave {

    //Fields
    public int waveNumber;
    public static int waveMultiplayer;
    public static int counter = 0;

    private long waveTimer;
    private long waveDelay;
    private long waveTimerDiff;

    private String waveText;

    public int rank;
    public int type;

    //Constructor
    public Wave(){
        waveNumber = 1;
        waveMultiplayer = 5;

        waveTimer = 0;
        waveDelay = 2000;
        waveTimerDiff = 0;

        waveText = "Х В И Л Я -";
    }

    //Functions
    public void createEnemies(){
        int enemyCount = waveNumber * waveMultiplayer;
        if(waveNumber <= 4) {
            while (enemyCount > 0) {
                counter++;
                type = 1;
                rank = 1;
                GamePanel.enemies.add(new Enemy(type, rank));
                enemyCount -= type;

            }
        }
        if (waveNumber > 4 && waveNumber <= 6){
            while (enemyCount > 0){
                counter++;
                type = 2;
                rank = 1;
                GamePanel.enemies.add(new Enemy(type,rank));
                enemyCount -= type;
            }


        }
        if (waveNumber > 6 && waveNumber <= 8){
            while (enemyCount > 0){
                counter++;
                type = 3;
                rank = 1;
                GamePanel.enemies.add(new Enemy(type,rank));
                enemyCount -= type;
            }

        }
        if (waveNumber > 8 && waveNumber <= 10){
            counter -=20;
            while (enemyCount > 0){
                counter++;
                type = 1;
                rank = 2;
                GamePanel.enemies.add(new Enemy(type,rank));
                enemyCount -= type;
            }

        }
        if (waveNumber > 10 && waveNumber <= 12){
            while (enemyCount > 0){
                counter++;
                type = 2;
                rank = 2;
                GamePanel.enemies.add(new Enemy(type,rank));
                enemyCount -= type;
            }

        }
        if (waveNumber > 12 && waveNumber <= 14){
            while (enemyCount > 0){
                counter++;
                type = 3;
                rank = 2;
                GamePanel.enemies.add(new Enemy(type,rank));
                enemyCount -= type;
            }

        }
        if (waveNumber > 14 && waveNumber <= 16){
            enemyCount = 25;
            while (enemyCount > 0){
                counter++;
                type = 1;
                rank = 3;
                GamePanel.enemies.add(new Enemy(type,rank));
                enemyCount -= type;
            }

        }
        if (waveNumber > 16 && waveNumber <= 18){
            enemyCount = 25;
            while (enemyCount > 0){
                counter++;
                type = 2;
                rank = 3;
                GamePanel.enemies.add(new Enemy(type,rank));
                enemyCount -= type;
            }

        }

        if (waveNumber > 18){
            enemyCount = 60;
            while (enemyCount > 0){
                counter++;
                type = 3;
                rank = 3;
                GamePanel.enemies.add(new Enemy(type,rank));
                enemyCount -= type;
            }

        }
        Record. setCointEnemy(counter);
        waveNumber++;
    }

    public void update(){
        if(GamePanel.enemies.isEmpty() && waveTimer == 0){
            counter = 0;
            waveTimer = System.nanoTime();
        }
        if(waveTimer > 0){
            waveTimerDiff += (System.nanoTime()-waveTimer) / 1000000;
            waveTimer = System.nanoTime();
        }
        if(waveTimerDiff > waveDelay){
            createEnemies();
            waveTimer = 0;
            waveTimerDiff = 0;
        }

    }

    public boolean showWave(){
        if (waveTimer != 0) {
            return true;
        }else return false;
    }

    public void draw(Graphics2D g){
        double divider = waveDelay / 180;
        double alpha = waveTimerDiff / divider;
        alpha = 255 * Math.sin(Math.toRadians(alpha));
        if(alpha < 0) alpha = 0;
        if(alpha > 255) alpha = 255;
        g.setFont(new Font("consolas", Font.PLAIN, 20));
        g.setColor(new Color(255,255,255,(int) alpha));
        String s = " - " + waveNumber + " - " + waveText;
        long length =(int) g.getFontMetrics().getStringBounds(s,g).getWidth();
        g.drawString(s, GamePanel.wigth / 2 - (int) length / 2, GamePanel.heigth / 2);
    }

}
