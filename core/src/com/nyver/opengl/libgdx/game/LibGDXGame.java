package com.nyver.opengl.libgdx.game;

import com.badlogic.gdx.Game;
import com.nyver.opengl.libgdx.game.screen.MainMenu;

public class LibGDXGame extends Game {
	
	@Override
	public void create () {
		setScreen(new MainMenu());
	}
}
