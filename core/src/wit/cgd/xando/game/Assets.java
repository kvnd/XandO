package wit.cgd.xando.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetErrorListener;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.utils.Disposable;

import wit.cgd.xando.game.util.Constants;

public class Assets implements Disposable, AssetErrorListener {
	
	public static final String TAG = Assets.class.getName();
	
	public static final Assets instance = new Assets();
	
	private AssetManager assetManager;
	
	public Asset board;
	public Asset x;
	public Asset o;
	
	// Inner class to store texture for later use
	public class Asset {
		
		public final AtlasRegion region;
		
		public Asset (TextureAtlas atlas, String imageName) {
			region = atlas.findRegion(imageName);
		}
		
	}
	
	// Singleton: to prevent instantiation from other classes
	private Assets() {}
	
	public void init(AssetManager assetManager) {
		
		this.assetManager = assetManager;
		// Set asset manager error handler
		assetManager.setErrorListener(this);
		// Load texture atlas
		assetManager.load(Constants.TEXTURE_ATLAS_OBJECTS, TextureAtlas.class);
		// Start loading assets and wait until finished
		assetManager.finishLoading(); // Blocking method to ensure all assets are fully loaded
		
		Gdx.app.debug(TAG, "# of assets loaded: " + assetManager.getAssetNames().size);
		for (String a : assetManager.getAssetNames())
			Gdx.app.debug(TAG, "asset: " + a);
		
		TextureAtlas atlas = assetManager.get(Constants.TEXTURE_ATLAS_OBJECTS);
		
		// Iterate over all textures in atlas & enable linear texture filtering for pixel smoothing
		for (Texture t : atlas.getTextures()) {
			t.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		}
		
		board = new Asset(atlas, "board");
		x = new Asset(atlas, "x");
		o = new Asset(atlas, "o");
	}
	
	
	@Override
	public void error(AssetDescriptor asset, Throwable throwable) {
		Gdx.app.error(TAG, "Couldn't load asset '" + asset.fileName + "'", (Exception)throwable);
	}
	
	@Override
	public void dispose() {
		assetManager.dispose();
	}

}
