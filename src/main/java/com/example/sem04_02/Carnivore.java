package com.example.sem04_02;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Carnivore extends Animal{
    private boolean clockwise = true;

    public Carnivore(double x, double y) {
        super(new Rectangle(40, 25), x, y,Color.RED);
        dx = 3;
        dy = 0;
    }

    public void changeDirection() {
        clockwise = !clockwise;
        dx = -dx;
        dy = -dy;
    }

    protected void move() {
        double x = shape.getLayoutX() + dx;
        double y = shape.getLayoutY() + dy;

        if (dx > 0 && x >= RIGHT) {
            x = RIGHT;
            dx = 0;
            dy = clockwise ? 3 : -3;
        } else if (dx < 0 && x <= LEFT) {
            x = LEFT;
            dx = 0;
            dy = clockwise ? -3 : 3;
        } else if (dy > 0 && y >= BOTTOM) {
            y = BOTTOM;
            dy = 0;
            dx = clockwise ? -3 : 3;
        } else if (dy < 0 && y <= TOP) {
            y = TOP;
            dy = 0;
            dx = clockwise ? 3 : -3;
        }

        shape.setLayoutX(x);
        shape.setLayoutY(y);
    }
}