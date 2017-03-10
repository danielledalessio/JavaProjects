/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;
import core.Constants;
import core.Disc;
import core.Game;
import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.JOptionPane;


/**
 *
 * @author Danielle D'Alessio
 */
public class BoardUi extends JPanel
{
    BoardListener listener;
    JButton[][] board;
    private Game game;
    private GameUi gameUi;
        
        
    public BoardUi(Game game, GameUi gameUi)
    {
        this.game = game;
        this.gameUi = gameUi;
        initComponents();
        listener.updateUi();
    }
    
    private void initComponents()
    {
        
        //sets the size of the grid
        this.setPreferredSize(new Dimension (8000, 8000));
        this.setMinimumSize(new Dimension (500, 500));
        this.setBackground(Color.LIGHT_GRAY);
        
        this.setLayout(new GridLayout(Constants.ROWS, Constants.COLS));
        board = new JButton[Constants.ROWS][Constants.COLS];
        
        listener = new BoardListener();
        
        for(int row = 0; row < Constants.ROWS; row++)
        {
            for(int col = 0; col<Constants.COLS; col++){
                board[row][col] = new JButton();
                board[row][col].putClientProperty("row", row);
                board[row][col].putClientProperty("col", col);
                board[row][col].putClientProperty("color", Constants.EMPTY);
                board[row][col].addActionListener(listener);
                board[row][col].setBackground(Color.GREEN);
                this.add(board[row][col]);        
            }
        }
        
        board[4][4].putClientProperty("color", Constants.LIGHT);
        board[3][4].putClientProperty("color", Constants.DARK);
        board[4][3].putClientProperty("color", Constants.DARK);
        board[3][3].putClientProperty("color", Constants.LIGHT);
        board[3][3].setIcon(new ImageIcon(getClass().getResource("../images/redCoin.png")));
        board[3][4].setIcon(new ImageIcon(getClass().getResource("../images/blueCoin.png")));
        board[4][3].setIcon(new ImageIcon(getClass().getResource("../images/blueCoin.png")));
        board[3][3].setIcon(new ImageIcon(getClass().getResource("../images/redCoin.png")));
    }
    
   private class BoardListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if(ae.getSource() instanceof JButton)
            {//makes sure for the instanceof JButton
                JButton button = (JButton)ae.getSource();
                int row = (int)button.getClientProperty("row");
                int col = (int)button.getClientProperty("col");
                Color color = (Color)button.getClientProperty("color");
                
                if(isValidMove(row, col, game.getCurrentPlayers().getDiscolor()))
                {
                    
                    if(game.getCurrentPlayers().getDiscolor() == Constants.DARK)
                    {
                      
                       board[row][col].putClientProperty("color", Constants.DARK); 
                       board[row][col].setIcon(new ImageIcon(getClass().getResource("../images/blueCoin.png")));//places the blue image on the sport thta is clicked
                    }
                    else{
                        board[row][col].putClientProperty("color", Constants.LIGHT);
                        board[row][col].setIcon(new ImageIcon(getClass().getResource("../images/redCoin.png")));//places the blue image on the sport thta is clicked
                    }
                    
                    updateUi();
                    changePlayer();
                }
     
            else 
            {
                JOptionPane.showMessageDialog(button, "Move is not valid, selct another");
            }
               
                   
            }
        }
        
        
    private void updateUi()
    {
        Disc[][] discs = game.getBoard().getBoard();
        ImageIcon disc = null;
        //set coins
        for(int row =0; row < Constants.ROWS; row++)
        {
            for(int col =0; col < Constants.COLS; col++)
            {
                    if(discs[row][col].getDiscColor() == Constants.DARK)
                    {
                        disc = new ImageIcon(getClass().getResource("../images/blueCoin.png"));
                        disc = imageResize(disc);
                        board[row][col].setIcon(new ImageIcon(getClass().getResource("../images/blueCoin.png")));
                        board[row][col].putClientProperty("color", Constants.DARK);
                        board[row][col].setIcon(disc);
                        
                    }
                    else if(discs[row][col].getDiscColor() == Constants.LIGHT)
                    {
                        disc = new ImageIcon(getClass().getResource("../images/redCoin.png"));
                        disc = imageResize(disc);
                        board[row][col].setIcon(new ImageIcon(getClass().getResource("../images/redCoin.png")));
                        board[row][col].setIcon(disc);
                        board[row][col].putClientProperty("color", Constants.LIGHT);
                    }
                    
                    gameUi.getScoreOne().setText(String.valueOf(game.getPlayer().get(Constants.PLAYER_ONE).getScore()));
                    gameUi.getScoreTwo().setText(String.valueOf(game.getPlayer().get(Constants.PLAYER_TWO).getScore()));
                }
            }                 
        }
        
        private ImageIcon imageResize(ImageIcon icon)
        {
            Image image = icon.getImage();
            Image newImage = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
            icon = new ImageIcon(newImage);
            return icon;
        }
    }
   
    private boolean isValidMove(int row, int col, Color color)
    {
        //see if valid move
        boolean valid = false;
        boolean flip = false;
        
        if(color == Constants.EMPTY)
        {
            valid = false;
        }
        else if(game.getBoard().isValidMove(row, col, color, flip))
        {
            valid = true;
        }
                   
        return valid;
    }  
    
    private void changePlayer()
    {
        //change the player
        if(game.getCurrentPlayers() == game.getPlayer().get(Constants.PLAYER_ONE))
        {
            game.setCurrentPlayers(game.getPlayer().get(Constants.PLAYER_TWO));
        }
        else
        {
            game.setCurrentPlayers(game.getPlayer().get(Constants.PLAYER_ONE));
        }
    }
    
    
        
}
