package com.nyver.opengl.libgdx.game.input;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.nyver.opengl.libgdx.game.model.Entity;

public class PlayerInputProcessor extends InputAdapter {

    private Entity player;

    public PlayerInputProcessor(Entity player) {
        this.player = player;
    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Input.Keys.LEFT:
                player.moveLeft();
                return true;
            case Input.Keys.RIGHT:
                player.moveRight();
                return true;
            case Input.Keys.UP:
                player.moveUp();
                return true;
            case Input.Keys.DOWN:
                player.moveDown();
                return true;
        }

        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        switch (keycode) {
            case Input.Keys.LEFT:
                player.moveLeft();
                return true;
            case Input.Keys.RIGHT:
                player.moveRight();
                return true;
            case Input.Keys.UP:
                player.moveUp();
                return true;
            case Input.Keys.DOWN:
                player.moveDown();
                return true;
        }

        return false;
    }
}
