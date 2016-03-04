package SnakeGame;

public class Apple {

    SnakeGame snakeGame;

    public int posX;
    public int posY;

    public Apple (int startX, int startY){
        posX = startX;
        posY = startY;
    }

    public void setRandomPosition(){
            posX = (int) (Math.random() * snakeGame.width);
            posY = (int) (Math.random() * snakeGame.heigth);
    }
}
