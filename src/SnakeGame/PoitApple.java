package SnakeGame;

public class PoitApple {

    SnakeGame snakeGame;

    public int posPX;
    public int posPY;

    public PoitApple(int startPX, int startPY) {
        this.posPX = startPX;
        this.posPY = startPY;
    }

    public void setPointAppleRandom(int i) {
        if (i==1){
          do {
               posPX = (int) (Math.random() * snakeGame.width-1);
              posPY = (int) (Math.random() * snakeGame.heigth-1);
              i++;

          }
          while (i == 1);
        }else {
            posPX = -10;
            posPY = -10;
        }
    }

}
