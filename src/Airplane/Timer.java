package Airplane;

import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

class TimerfForGame extends JLabel {


    private Timer timer = new Timer();
    private TimerTask timerTask;
    public int time = -1;
    public int miliTime = -1;
    public int tForBullet = -1;
    public TimerfForGame() {

    }

    public void restartTimer(){
        time = -1;
        startTimer();
    }

    public void startTimer() {
        timerTask = new TimerTask() {
            @Override
            public void run() {
               time++;
                if(GamePanel.poinBullet) tForBullet++;
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        int t = time;
                        //System.out.println(t);
                        //For Game boobleschoter
                        if(t == 6)GamePanel.heard.a = 4;
                        if(t == 6)GamePanel.pointBullet.a = 4;
                        if(GamePanel.poinBullet){
                            if(tForBullet == 20){
                                GamePanel.poinBullet = false;
                                tForBullet = -1;
                            }
                        }
                    }
                });
            }
        };

        timer.schedule(timerTask, 0, 1000);
    }

    public void startMilisTimer() {
        timerTask = new TimerTask() {
            @Override
            public void run() {
                miliTime++;
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        int t = miliTime;
                    }
                });
            }
        };
        timer.schedule(timerTask, 0, 100);

    }


    public void pousaTimer() {
        if (timerTask != null)
            timerTask.cancel();
    }
}



