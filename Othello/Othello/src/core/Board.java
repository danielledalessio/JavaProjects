
package core;

/**
 *
 * @author Danielle D'Alessio
 */
public class Board 
{
    private Disc[][] board;
    
    public Board()
    {
        initObjects();
    }
    
    private void initObjects()
    {
        // declare the size of the array
        board = new Disc[Constants.ROWS][Constants.COLUMNS];        
        
        // initialize each object in the array
        for(int row = 0; row < Constants.ROWS; row++)
        {
            for(int col = 0; col < Constants.COLUMNS; col++)
            {
                board[row][col] = new Disc();
            }
        }
        
        // initial setup of the board is the following:
        
        // position 3,3 is white
        // position 3,4 is black
        // position 4,3 is black
        // position 4,4 is white
        board[3][3].setColor(Constants.LIGHT);
        board[3][4].setColor(Constants.DARK);
        board[3][3].setColor(Constants.DARK);
        board[3][4].setColor(Constants.LIGHT);
    }

    /**
     * @return the board
     */
    public Disc[][] getBoard() {
        return board;
    }

    /**
     * @param board the board to set
     */
    public void setBoard(Disc[][] board) {
        this.board = board;
    }
}
