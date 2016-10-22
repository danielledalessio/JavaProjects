/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;
import core.Constants;
import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.GridLayout;


/**
 *
 * @author Danielle D'Alessio
 */
public class BoardUi extends JPanel{
    
    BoardListener listener;
    JButton[][] board;
        
    public BoardUi()
    {
        initComponents();  
    }
    
    private void initComponents()
    {
        
        //sets the size of grid
        this.setPreferredSize(new Dimension (8000, 8000));
        this.setMinimumSize(new Dimension (500, 500));
        this.setBackground(Color.LIGHT_GRAY);
        
        this.setLayout(new GridLayout(Constants.ROWS, Constants.COLUMNS));
        board = new JButton[Constants.ROWS][Constants.COLUMNS];
        
        listener = new BoardListener();
        
        //set grid colors and buttons
        for(int row = 0; row < Constants.ROWS; row++)
        {
            for(int col = 0; col<Constants.COLUMNS; col++)
            {
                board[row][col] = new JButton();
                board[row][col].putClientProperty("row", row);
                board[row][col].putClientProperty("col", col);
                board[row][col].putClientProperty("color", Constants.EMPTY);
                board[row][col].addActionListener(listener);
                board[row][col].setBackground(Color.GREEN);
                this.add(board[row][col]);        
            }
        }
    
    }
    
   private class BoardListener implements ActionListener 
   {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if(ae.getSource() instanceof JButton){//makes sure for the instanceof JButton
                JButton button = (JButton)ae.getSource();
                int row = (int)button.getClientProperty("row");
                int col = (int)button.getClientProperty("col");
                Color color = (Color)button.getClientProperty("color");
                if(color == null)
                    board[row][col].setIcon(new ImageIcon(getClass().getResource("../images/blueCoin.png")));
            }
        } 
    }
        
}
