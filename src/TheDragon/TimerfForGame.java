package TheDragon;

import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

class TimerForGame extends JLabel {


    private Timer timer = new Timer();
    private TimerTask timerTask;
    public int time = -1;
    public int miliTime = -1;
    public int timeAddNoise = -1;
    public TimerForGame() {

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
                timeAddNoise++;

                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        int t = time;
                        if(time >= 3) {
                            if (timeAddNoise % 3 == 0) {
                                GamePanel.noises.add(new Noise((int) Math.round(1 + Math.random() * 1),
                                        (int) Math.round(1 + Math.random() * 3)));
                            }
                            if (timeAddNoise % 3 == 1) {
                                GamePanel.noises.add(new Noise((int) Math.round(1 + Math.random() * 1),
                                        (int) Math.round(1 + Math.random() * 3)));
                            }

                            if (timeAddNoise % 3 == 2) {
                                GamePanel.noises.add(new Noise((int) Math.round(1 + Math.random() * 1),
                                        (int) Math.round(1 + Math.random() * 3)));
                            }
                            if (timeAddNoise % 3 == 3) {
                                GamePanel.noises.add(new Noise((int) Math.round(1 + Math.random() * 1),
                                        (int) Math.round(1 + Math.random() * 3)));
                            }
                        }
                        //System.out.println(timeAddNoise);
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
//                        if(t % 15 == 0){
//                            GamePanel.noises.add(new Noise((int) Math.round(1 + Math.random() * 1),
//                                    (int) Math.round(1 + Math.random() * 3)));
//                        }
                       // System.out.println(t);
                    }
                });
            }
        };
        timer.schedule(timerTask, 0, 200);

    }


    public void pousaTimer() {
        if (timerTask != null)
            timerTask.cancel();
    }
}



