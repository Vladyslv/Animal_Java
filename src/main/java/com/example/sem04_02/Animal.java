package com.example.sem04_02;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public abstract class Animal {
    protected static double TOP = 60;
    protected static double BOTTOM = 480;
    protected static double LEFT = 30;
    protected static double RIGHT = 860;

    protected Shape shape;
    protected double dx, dy;
    private boolean moving = true;

    public Animal(Shape shape, double x, double y, Color color) {
        this.shape = shape;
        shape.setFill(color);
        shape.setLayoutX(x);
        shape.setLayoutY(y);
    }

    public Node getNode() {
        return shape;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    protected  abstract void move();

    public void update() {
        if(moving) {
            move();
        }
    }
}