
package othello;

import core.Game;
import userInterface.OthelloUi;

/**
 *
 * @author Danielle D'Alessio
 */
public class Othello 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Game game = new Game();
        // when the UI is developed we will pass object game
        // to the main UI class
        OthelloUi othelloUi = new OthelloUi(game);
        
    }
    
}
