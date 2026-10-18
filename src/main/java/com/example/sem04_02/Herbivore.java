package com.example.sem04_02;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.Random;

public class Herbivore extends Animal {

    public Herbivore(double x, double y) {
        super(new Circle(15), x, y, Color.GREEN);
        if (new Random().nextBoolean()) {
            dx = 2;
            dy = 0;
        } else {
            dx = 0;
            dy = 2;
        }
    }

    @Override
    protected void move() {
        double x = shape.getLayoutX() + dx;
        double y = shape.getLayoutY() + dy;

        if (x >= RIGHT) {
            x = RIGHT;
            dx = -Math.abs(dx);
        } else if (x <= LEFT) {
            x = LEFT;
            dx = Math.abs(dx);
        }
        if (y >= BOTTOM) {
            y = BOTTOM;
            dy = -Math.abs(dy);
        } else if (y <= TOP) {
            y = TOP;
            dy = Math.abs(dy);
        }

        shape.setLayoutX(x);
        shape.setLayoutY(y);
    }
}