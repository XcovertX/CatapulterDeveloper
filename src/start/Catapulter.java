package start;
import game.Game;
import java.io.IOException;


public class Catapulter {

    public static void main( String[] args ) throws IOException {
    	
    	boolean t = true;
    	boolean f = false;
    	
        boolean mapBuilderMode = f;
        boolean newGame = true;
        
        Game game = new Game( mapBuilderMode, newGame );
        
        if ( mapBuilderMode != true ) {
        	
        	new Thread( new GameLoop( game ) ).start();
        	game.showIntro();
        	game.getInputProcessor().updateOutput( 0 ); // change this update once new login process implemented

        }
    }

}
