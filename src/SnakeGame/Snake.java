package SnakeGame;

import SnakeGame.SnakeGame;


public class Snake {

    public int diraction = 0;
    public int length = 4;

    public int snakeX[] = new int[SnakeGame.heigth*SnakeGame.width];
    public int snakeY[] = new int[SnakeGame.heigth*SnakeGame.width];


    public Snake(int x0, int y0, int x1, int y1) {
        snakeX[0] = x0;
        snakeY[0] = y0;
        snakeX[1] = x1;
        snakeY[1] = y1;

    }

    public void move() {

        for (int d = length; d > 0; d--) {
            snakeX[d] = snakeX[d - 1];
            snakeY[d] = snakeY[d - 1];
        }

        if (diraction == 0) snakeX[0]++;
        if (diraction == 1) snakeY[0]++;
        if (diraction == 2) snakeX[0]--;
        if (diraction == 3) snakeY[0]--;

        if(snakeX[0] >= SnakeGame.width) snakeX[0] = 0;
        if(snakeX[0] < 0) snakeX[0] = SnakeGame.width-1;
        if(snakeY[0] >= SnakeGame.heigth) snakeY[0] = 0;
        if(snakeY[0] < 0) snakeY[0] = SnakeGame.heigth-1;

    }

    public int random(int max, int min){
        int v = (int) (Math.random() * (min) + (max - min));
            return v;

    }


}


