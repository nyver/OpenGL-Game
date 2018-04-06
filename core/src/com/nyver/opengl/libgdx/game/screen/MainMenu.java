package com.nyver.opengl.libgdx.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.utils.Array;
import com.nyver.opengl.libgdx.game.model.ModelInstanceFactory;

public class MainMenu extends ScreenAdapter {

    private Environment environment;
    private PerspectiveCamera camera;
    private ModelBatch modelBatch;
    private ModelInstanceFactory modelInstanceFactory;
    private Array<ModelInstance> instances = new Array<ModelInstance>();
    private boolean loading = false;

    @Override
    public void show() {
        modelBatch = new ModelBatch();
        modelInstanceFactory = new ModelInstanceFactory(new AssetManager());
        modelInstanceFactory.load();
        loading = true;

        initEnvironment();
        initCamera();
    }

    private void initEnvironment() {
        environment = new Environment();
        environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.4f, 0.4f, 0.4f, 1f));
        environment.add(new DirectionalLight().set(0.8f, 0.8f, 0.8f, -1f, -0.8f, -0.2f));
    }

    private void initCamera() {
        camera = new PerspectiveCamera(60, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.position.set(7f, 7f, 7f);
        camera.lookAt(0,0,0);
        camera.near = 1f;
        camera.far = 300f;
        camera.update();
    }

    @Override
    public void render(float delta) {
        if (loading && modelInstanceFactory.update()) {
            instances.add(modelInstanceFactory.createShipInstance(0, 0, -5f));
            loading = false;
        }

        Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

        modelBatch.begin(camera);
        modelBatch.render(instances, environment);
        modelBatch.end();
    }

    @Override
    public void dispose() {
        modelBatch.dispose();
        instances.clear();
        modelInstanceFactory.dispose();
    }
}
