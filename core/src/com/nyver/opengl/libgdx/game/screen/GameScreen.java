package com.nyver.opengl.libgdx.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.utils.Array;
import com.nyver.opengl.libgdx.game.input.PlayerInputProcessor;
import com.nyver.opengl.libgdx.game.model.InstanceFactory;
import com.nyver.opengl.libgdx.game.model.Ship;

public class GameScreen extends ScreenAdapter {

    private Environment environment;
    private OrthographicCamera camera;
    private ModelBatch modelBatch;
    private InstanceFactory instanceFactory;
    private Ship player;
    private Array<ModelInstance> instances = new Array<ModelInstance>();
    private boolean loading = false;

    @Override
    public void show() {
        modelBatch = new ModelBatch();
        instanceFactory = new InstanceFactory(new AssetManager());
        instanceFactory.load();
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
        camera = new OrthographicCamera(10f, 10f * Gdx.graphics.getWidth() / Gdx.graphics.getHeight());
        camera.position.set(0, 0, -10);
        camera.lookAt(0,0,0);
        camera.update();
    }

    @Override
    public void render(float delta) {
        if (loading && instanceFactory.update()) {
            player = instanceFactory.createShip(0, - camera.viewportHeight / 2, 0);
            instances.add(player);

            PlayerInputProcessor inputProcessor = new PlayerInputProcessor(player);
            Gdx.input.setInputProcessor(inputProcessor);
            
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
        instanceFactory.dispose();
    }
}
