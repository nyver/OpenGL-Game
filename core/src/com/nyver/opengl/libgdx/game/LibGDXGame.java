package com.nyver.opengl.libgdx.game;

import com.badlogic.gdx.Game;
import com.nyver.opengl.libgdx.game.screen.GameScreen;

public class LibGDXGame extends Game {
	
	@Override
	public void create () {
		setScreen(new GameScreen());
	}
}
