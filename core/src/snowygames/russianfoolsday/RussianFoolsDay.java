package snowygames.russianfoolsday;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import snowygames.russianfoolsday.States.GameStateManager;
import snowygames.russianfoolsday.States.MenuState;

public class RussianFoolsDay extends ApplicationAdapter {

	public static float width;
	public static final float HEIGHT = 800;

	private OrthographicCamera camera;
	//public static final String TITLE = "Russain Fools' Day";
	private GameStateManager gsm;
	private SpriteBatch batch;
	private static Music musicCalm;
	int screenHeight;
	int screenWidth;

	@Override
	public void create () {
	    batch = new SpriteBatch();
	    camera = new OrthographicCamera();
		gsm = new GameStateManager();
		Gdx.gl.glClearColor(0, 0.2f, 0.5f, 1);
		gsm.push(new MenuState(gsm, camera));
		musicCalm = Gdx.audio.newMusic(Gdx.files.internal("Calm.mp3"));
		musicCalm.setLooping(true);
		musicCalm.play();

	}

	public static boolean isItPlaying(){
		return musicCalm.isPlaying();
	}

	public void offMusic(){
		musicCalm.pause();
	}

	public void startMusic(){
		musicCalm.setLooping(true);
		musicCalm.play();
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(batch);

	}

	@Override
	public void resize(int screenWidth, int screenHeight){
        float aspect = screenWidth / (float) screenHeight;
		width = HEIGHT * aspect;
		camera.setToOrtho(false, width, HEIGHT);
        batch.setProjectionMatrix(camera.combined);
	}



	@Override
	public void dispose () {
		musicCalm.dispose();
		batch.dispose();

	}}

