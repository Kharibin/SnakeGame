package com.javarush.task.task23.task2312;

/**
 * Created by Java on 12.07.2017.
 */
public class Room {
    private int width, height;
    private Snake snake;
    private Mouse mouse;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Snake getSnake() {
        return snake;
    }

    public Mouse getMouse() {
        return mouse;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }

    public Room(int width, int height, Snake snake) {
        this.width = width;
        this.height = height;
        this.snake = snake;
    }

    static Room game;

    void run(){

    }

    void print(){

    }

    public static void main(String args[]){
        Snake snake = new Snake(10, 10);
        game = new Room(640, 480, snake);
        snake.setDirection(SnakeDirection.DOWN);
    }

}

