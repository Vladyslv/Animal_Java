package com.example.sem04_02;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HelloController {
    @FXML private Pane pane;

    private final List<Animal> animals = new ArrayList<>();
    private final Random random = new Random();
    private boolean running = true;

    @FXML public void initialize() {
        AnimationTimer timer = new AnimationTimer() {
            private long last = 0;

            public void handle(long now) {
                if(now - last < 30_000_000) {
                    return;
                }
                last = now;
                for(Animal a : animals) {
                    a.update();
                }
            }
        };
        timer.start();
    }

    private double randX() {
        return Animal.LEFT + random.nextDouble() * (Animal.RIGHT - Animal.LEFT);
    }
    private double randY() {
        return Animal.TOP + random.nextDouble() * (Animal.BOTTOM - Animal.TOP);
    }

    private void addAnimal(Animal a) {
        a.setMoving(running);
        animals.add(a);
        pane.getChildren().add(a.getNode());
    }

    @FXML private void onAddHerbine() {
        addAnimal(new Herbivore(randX(), randY()));
    }

    @FXML private void onAddCarnivore() {
        addAnimal(new Carnivore(randX(), randY()));
    }

    @FXML void onChangeDirection() {
        for(Animal a : animals) {
            if(a instanceof Carnivore) {
                ((Carnivore) a).changeDirection();
            }
        }
    }
    @FXML public void onStopStart() {
        running = !running;
        for(Animal a : animals) {
            a.setMoving(running);
        }
    }

}
