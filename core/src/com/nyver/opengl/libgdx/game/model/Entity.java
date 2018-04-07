package com.nyver.opengl.libgdx.game.model;

import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;

abstract public class Entity extends ModelInstance {
    public Entity(Model model) {
        super(model);
    }

    abstract public void moveLeft();

    abstract public void moveRight();

    abstract public void moveUp();
    
    abstract public void moveDown();
}
