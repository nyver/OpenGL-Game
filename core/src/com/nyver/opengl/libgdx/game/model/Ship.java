package com.nyver.opengl.libgdx.game.model;

import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;

public class Ship extends Entity {
    public Ship(Model model) {
        super(model);
    }

    @Override
    public void moveLeft() {
        transform.translate(0.1f, 0, 0);
    }

    @Override
    public void moveRight() {
        transform.translate(-0.1f, 0, 0);
    }

    @Override
    public void moveUp() {
        transform.translate(0, 0, 0.1f);
    }

    @Override
    public void moveDown() {
        transform.translate(0, 0, -0.1f);
    }


}
