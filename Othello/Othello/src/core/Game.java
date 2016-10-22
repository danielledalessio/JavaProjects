/*
 * Karin Whiting
 * COP 3330 Object Oriented Programming
 * University of Central Florida
 */
package core;


import java.util.ArrayList;
import javax.swing.JOptionPane;


/**
 *
 * @author kwhiting
 */
public class Game 
{
    private ArrayList<Player> players;
    private Board board;
    
    public Game()
    {
        initObjects();
    }
    
    private void initObjects()
    {
        board = new Board();
        createPlayers();
        // temp function to prove objects were created properly
        printPlayers();
    }
    
    private void createPlayers()
    {
        players = new ArrayList<Player>();
        
        for(int i = 0; i < Constants.MAX_PLAYERS; i++)
        {
            String name = JOptionPane.showInputDialog(null, "Enter player's name");
            Player player = new Player();
            player.setName(name);
            
            if(i == Constants.PLAYER_ONE)
                player.setDiscColor(Constants.DARK);
            else if(i == Constants.PLAYER_TWO)
                player.setDiscColor(Constants.LIGHT);
            
            players.add(player);
        }
    }
    
    private void printPlayers()
    {
        System.out.println("The game has the following players:");
        
        for(Player player : getPlayers())
        {
            System.out.println("Player " + player.getName() +
                    " is playing disc color " + player.getDiscColor());
        }
    }

    /**
     * @return the players
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }

    /**
     * @param players the players to set
     */
    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    /**
     * @return the board
     */
    public Board getBoard() {
        return board;
    }

    /**
     * @param board the board to set
     */
    public void setBoard(Board board) {
        this.board = board;
    }
}
