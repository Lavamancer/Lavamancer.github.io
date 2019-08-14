package com.jalbarracin;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Main extends ApplicationAdapter {

	SpriteBatch spriteBatch;
	Stage stage;

	Deck deck;
	Board board;




	@Override
	public void create () {
		spriteBatch = new SpriteBatch();
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);

		deck = new Deck();
		board = new Board(this);


	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();

		for (Player player : board.players) {
			player.update();
		}

		if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
			Gdx.app.exit();
		}
		if (Gdx.input.isKeyPressed(Input.Keys.R)) {
			create();
		}
	}
	
	@Override
	public void dispose () {
		spriteBatch.dispose();
	}

	@Override
	public void resize(int width, int height) {
		stage.getViewport().update(width, height, true);
	}
}
