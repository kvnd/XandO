package wit.cgd.xando.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;

import wit.cgd.xando.game.util.Constants;

public class WorldRenderer implements Disposable {

	private static final String TAG = WorldRenderer.class.getName();
	
	public OrthographicCamera camera;
	private SpriteBatch batch;
	private WorldController worldController;
	
	public WorldRenderer(WorldController worldController) {
		this.worldController = worldController;
		init();
	}
	
	private void init() {
		batch = new SpriteBatch();
		camera = new OrthographicCamera(Constants.VIEWPORTH_WIDTH, Constants.VIEWPORT_HEIGHT);
		camera.position.set(0, 0, 0);
		camera.update();
	}
	
	public void resize(int width, int height) {
		camera.viewportWidth = (Constants.VIEWPORT_HEIGHT / height) * width;
		camera.update();
	}
	
	public void render() {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		// TODO Implement drawing command
		batch.end();
		
		worldController.board.render(batch);
	}

	@Override
	public void dispose() {
		batch.dispose();
	}

}
