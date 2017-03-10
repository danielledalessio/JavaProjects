/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import javax.swing.JOptionPane;
import java.util.ArrayList;
/**
 *
 * @author Danielle D'Alessio
 */


public class Game {
    private Board board;
    private ArrayList<Player> players = new ArrayList<>();
    private Player currentPlayer;
    
    public Game()
    {
        initObjects();
    }
    
    private void initObjects()
    {
        setBoard(new Board());
        
        createPlayers();
        getBoard().setPlayers(getPlayers());
        setCurrentPlayers(getPlayers().get(Constants.PLAYER_ONE));       
        printPlayers();
        calculateScore();
    }
    
    public void createPlayers()
    {
        //set players names
        for(int i=0; i<Constants.MAX_PLAYERS;i++)
        {
            String strName = JOptionPane.showInputDialog(null, "Enter player's name");
            
                getPlayers().add(new Player());
                getPlayers().get(i).setName(strName);
                if(i == 0)
                {
                    getPlayers().get(i).setDiscolor(Constants.DARK);
                }
                else
                {
                    getPlayers().get(i).setDiscolor(Constants.LIGHT);
                }
        }
    }
    
    
    
    public void printPlayers()
    {
        System.out.println("The game has the following players:");
        
        for(int i=0; i<Constants.MAX_PLAYERS; i++)
        {
           System.out.println("Player " + getPlayers().get(i).getName() + " is playing disc color " + getPlayers().get(i).getDiscolor());
        }
        
    }
    
    public void calculateScore()
    {
        board.calculateScore();   
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

    /**
     * @return the player
     */
    public ArrayList<Player> getPlayer() {
        return board.getPlayers();
    }

    /**
     * @param player the player to set
     */
    public void setPlayer(ArrayList<Player> player) {
        this.board.setPlayers(player);
        
    }

    /**
     * @return the currentPlayers
     */
    public Player getCurrentPlayers() {
        return getCurrentPlayer();
    }

    /**
     * @param currentPlayers the currentPlayers to set
     */
    public void setCurrentPlayers(Player currentPlayers) {
        this.setCurrentPlayer(currentPlayers);
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
     * @return the currentPlayer
     */
    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * @param currentPlayer the currentPlayer to set
     */
    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

   
}

