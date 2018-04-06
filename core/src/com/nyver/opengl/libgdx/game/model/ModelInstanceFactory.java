package com.nyver.opengl.libgdx.game.model;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.utils.Disposable;

public class ModelInstanceFactory implements Disposable {
    private static final String MODEL_SHIP = "models/ship.g3db";

    private AssetManager assetManager;


    public ModelInstanceFactory(AssetManager assetManager) {
        this.assetManager = assetManager;
    }

    public void load() {
        assetManager.load(MODEL_SHIP, Model.class);
    }

    public boolean update() {
        return assetManager.update();
    }

    public ModelInstance createShipInstance(float x, float y, float z) {
        Model ship = assetManager.get(MODEL_SHIP, Model.class);
        ModelInstance shipInstance = new ModelInstance(ship);
        shipInstance.transform.setToTranslation(x, y, z);
        return shipInstance;
    }

    public void dispose() {
        assetManager.dispose();
    }
}
