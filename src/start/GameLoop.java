package start;

import java.io.IOException;

import game.Game;

public class GameLoop implements Runnable {
	
	private boolean running;
	private final double updateRate = 1.0d/60.0d;
	
	private long nextStatTime;
	private int fps;
	private int ups;
	
	private Game game;
	
	public GameLoop( Game game ) {
		
		this.game = game;
	}
	

	@Override
	public void run() {

		running = true;
		double accumulator = 0;
		long currentTime = System.currentTimeMillis();
		long lastUpdate = System.currentTimeMillis();
		nextStatTime = System.currentTimeMillis() + 1000;
		
		while( running ) {
			
			currentTime = System.currentTimeMillis();
			double lastRenderTimeInSeconds = ( currentTime - lastUpdate ) / 1000d;
			accumulator += lastRenderTimeInSeconds;
			lastUpdate = currentTime;
			
			while( accumulator > updateRate ) {
				
				update();
				accumulator -= updateRate;
			}
			render();
//			printStats();
		}
	}
	
	private void update() {
		
		try {
			
			game.updateWorld();
			game.getInputProcessor().update();
			Thread.sleep(250); // TODO not sure how to appropriately free up the thread. Fix when build thread-pool
			
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		ups++;
	}
	
	private void render() {
		
		game.getInputProcessor().render();
		fps++;
	}
	
	private void printStats() {
		
		if( System.currentTimeMillis() > nextStatTime ) {
			
			System.out.println( "FPS: " + fps + " UPS: " + ups );
			fps = 0;
			ups = 0;
			nextStatTime = System.currentTimeMillis() + 1000;
		}
	}

}
