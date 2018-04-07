package com.nyver.opengl.libgdx.game.model;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Disposable;

public class InstanceFactory implements Disposable {
    private static final String MODEL_SHIP = "models/ship.g3db";

    private AssetManager assetManager;
    
    public InstanceFactory(AssetManager assetManager) {
        this.assetManager = assetManager;
    }

    public void load() {
        assetManager.load(MODEL_SHIP, Model.class);
    }

    public boolean update() {
        return assetManager.update();
    }

    public Ship createShip(float x, float y, float z) {
        Model ship = assetManager.get(MODEL_SHIP, Model.class);
        Ship shipInstance = new Ship(ship);
        shipInstance.transform.translate(x, y, z);
        shipInstance.transform.rotate(Vector3.X, -90);
        return shipInstance;
    }

    public void dispose() {
        assetManager.dispose();
    }
}
