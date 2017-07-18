package com.javarush.task.task23.task2312;

import java.util.*;

/**
 * Created by Java on 12.07.2017.
 */
public class Snake {
    private List<SnakeSection> sections;
    private boolean isAlive;
    private SnakeDirection direction;

    public List<SnakeSection> getSections() {
        return sections;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public SnakeDirection getDirection() {
        return direction;
    }

    public void setDirection(SnakeDirection direction) {
        this.direction = direction;
    }

    public Snake(int x, int y) {
        this.sections = new ArrayList<SnakeSection>();
        this.sections.add(new SnakeSection(x, y));
        this.isAlive = true;

    }

    public int getX(){
        return sections.get(0).getX();
    }

    public int getY(){
        return sections.get(0).getY();
    }

    void move(){
        if (isAlive){
            if (direction == SnakeDirection.UP) move(0,-1);
            if (direction == SnakeDirection.DOWN ) move(0,1);
            if (direction == SnakeDirection.LEFT) move (-1,0);
            if (direction == SnakeDirection.RIGHT) move(1,0);
        }
    }

    void move (int x, int y){
        SnakeSection head = sections.get(0);
        head = new SnakeSection(head.getX()+x, head.getY()+y);
        checkBorders(head);
        checkBody(head);
        if (isAlive) {
            Mouse mouse = Room.game.getMouse();
            if (head.getX() == mouse.getX() && head.getY() == mouse.getY()){
                sections.add(0, head);                  //Добавили новую голову
                Room.game.eatMouse();                   //Хвот не удаляем, но создаем новую мышь.
            } else //просто движется
            {
                sections.add(0, head);                  //добавили новую голову
                sections.remove(sections.size() - 1);   //удалили последний элемент с хвоста
            }
        }

    }

    public void checkBorders(SnakeSection head){
        if (head.getX() < 0 || head.getY() < 0 ||
                head.getX() >= Room.game.getWidth() || head.getY() >= Room.game.getHeight()) isAlive =false;
    }

    public void checkBody(SnakeSection head){
        if(sections.contains(head)) isAlive = false;
    }

}
