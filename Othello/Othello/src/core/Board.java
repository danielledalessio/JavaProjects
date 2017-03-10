/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Danielle D'Alessio
 */

public class Board {
    private int darkCount;
    private int lightCount;
    private ArrayList<Player> players;
    private Disc[][] board;
    //set varibles
    
    public Board(){
        initObjects();
    }


    private void initObjects(){
       
       board = new Disc[Constants.ROWS][Constants.COLS];//instantiate array
                    
       for(int i = 0; i<Constants.ROWS; i++ )
       {
         for(int j = 0; j<Constants.COLS; j++)
         {
             board[i][j] = new Disc();
         }
       }
       
       board[3][3].setDiscColor(Constants.LIGHT);
       board[3][4].setDiscColor(Constants.DARK);
       board[4][3].setDiscColor(Constants.DARK);
       board[4][4].setDiscColor(Constants.LIGHT);
      
    }
    
    public void calculateScore(){
        //calculating the score
        darkCount = 0;
        lightCount = 0;
        for(int row = 0; row < Constants.ROWS; row++)
        {
            for(int col = 0; col < Constants.COLS; col++)
            {
                if(board[row][col].getDiscColor() == Constants.DARK)
                {
                   darkCount++; 
                }
                else if(board[row][col].getDiscColor() == Constants.LIGHT)
                {
                   lightCount++;
                }
            } 
        }
        players.get(Constants.PLAYER_ONE).setScore(darkCount);
        players.get(Constants.PLAYER_TWO).setScore(lightCount);
    }
    
    
    public boolean isValidMove(int row, int col, Color color, boolean flip)
    {
        boolean valid = false;
        //checking if move is valid by looking at spaces around clicked area
        if(checkUp(row, col, color, flip))
        {
            valid = true;
        }
        
       if(checkUpLeft(row, col, color, flip))
       {
            valid = true;
       }
        
       if(checkLeft(row, col, color, flip))
       {
            valid = true;
       }
        
       if(checkLeftDown(row, col, color, flip))
       {
            valid = true;
       }
        
       if(checkDown(row, col, color, flip))
       {
            valid = true;
       }
        
       if(checkDownRight(row, col, color, flip))
       {
            valid = true;
       }
        
       if(checkRight(row, col, color, flip))
       {
            valid = true;
       }
        
       if(checkUpRight(row, col, color, flip))
       {
            valid = true;
       }
       
        if(!valid){
        if(isGameOver()){
       //checking if game is over and saying winning
            if(players.get(Constants.PLAYER_ONE).getScore() > players.get(Constants.PLAYER_TWO).getScore())
            {
                JOptionPane.showMessageDialog(null,"The winner is: " + players.get(Constants.PLAYER_ONE).getName());
                System.out.println("The winner is " + players.get(Constants.PLAYER_ONE).getName());
            }
            else if(players.get(Constants.PLAYER_ONE).getScore() < players.get(Constants.PLAYER_TWO).getScore())
            {
                JOptionPane.showMessageDialog(null,"The winner is: " + players.get(Constants.PLAYER_TWO).getName());
                System.out.println("The winner is " + players.get(Constants.PLAYER_TWO).getName());
            }   
            else{
                JOptionPane.showMessageDialog(null,"It's a tie");//
                System.out.println("It's a tie");
            }
            System.exit(0);
        }    
         }
      else if(valid){
            board[row][col].setDiscColor(color);
        }
        calculateScore();
        return valid;    
    }
    
    
    private boolean checkUp(int row, int col, Color color, boolean flip)
    {
        //checking space up
        int flipSquares = 0;
        int checkRow = row - 1;
        boolean matchFound = false;
        boolean validMove = true;
        
        if(board[row][col].getDiscColor() == Constants.DARK || board[row][col].getDiscColor() == Constants.LIGHT)
        {
            return false;
        }
        
        while(checkRow >= 0 && !matchFound)
        {
            if(getBoard()[checkRow][col].getDiscColor() == Constants.EMPTY)
            {
             validMove = false;
             return validMove;
            }   
            else if (getBoard()[checkRow][col].getDiscColor() != color)
            {
             flipSquares++;
            }
            else 
            {
             matchFound = true;
             break;
            }
         
            checkRow--;
            
        }
        
        if(matchFound && flipSquares > 0)
        {
            checkRow = row;        
            do
            {
                checkRow--;
                board[checkRow][col].setDiscColor(color);
                flipSquares--;
            }
            while(flipSquares > 0);
            
            validMove = true;
            
        }
        else
        {
            validMove = false;
        }
        
        return validMove;
       
    }
    
    private boolean checkUpLeft(int row, int col, Color color, boolean flip)
    {
        //checking space in upper left
        int flipSquares = 0;
        int checkRow = row - 1;
        int checkCol = col -1;
        boolean matchFound = false;
        boolean validMove = true;
        
        if(board[row][col].getDiscColor() == Constants.DARK || board[row][col].getDiscColor() == Constants.LIGHT)
        {
            return false;
        }
        
        while(checkRow >= 0 && checkCol >=0 && !matchFound)
        {
            if(getBoard()[checkRow][checkCol].getDiscColor() == Constants.EMPTY)
            {
                validMove = false;
                return validMove;
            }   
            else if (getBoard()[checkRow][checkCol].getDiscColor() != color)
            {
                flipSquares++;
            }
            else 
            {
                matchFound = true;
                break;
            }
         
            checkRow--;
            checkCol--;
        }
        
        if(matchFound && flipSquares > 0)
        {
            checkRow = row;
            checkCol = col;
            
            do
            {
                checkRow--;
                checkCol--;
                board[checkRow][checkCol].setDiscColor(color);
                flipSquares--;
            }
            while(flipSquares > 0);
            
            validMove = true;
            
        }
        else
        {
            validMove = false;
        }
    
        return validMove;
    }

    private boolean checkLeft(int row, int col, Color color, boolean flip)
    {
        //checking space left
        int flipSquares = 0;
        int checkRow = row;
        int checkCol = col -1;
        boolean matchFound = false;
        boolean validMove = true;
        
        if(board[row][col].getDiscColor() == Constants.DARK || board[row][col].getDiscColor() == Constants.LIGHT)
        {
            return false;
        }
        
        while(checkCol >= 0 && !matchFound)
        {
            if(getBoard()[row][checkCol].getDiscColor() == Constants.EMPTY)
            {
             validMove = false;
             return validMove;
            }   
            else if (getBoard()[row][checkCol].getDiscColor() != color)
            {
             flipSquares++;
            }
            else 
            {
             matchFound = true;
            }
            
         checkCol--;
         
        }
        
        if(matchFound && flipSquares > 0)
        {
            checkRow = row;
            checkCol = col;
            
            do
            {
                checkCol--;
                board[row][checkCol].setDiscColor(color);
                flipSquares--;
            }
            while(flipSquares > 0);
            
            validMove = true;
            
        }
        else
        {
            validMove = false;
        }
    
       return validMove; 
    }

    
    private boolean checkLeftDown(int row, int col, Color color, boolean flip)
    {
        //checkng space lower left
        int flipSquares = 0;
        int checkRow = row + 1;
        int checkCol = col - 1;
        boolean matchFound = false;
        boolean validMove = true;
        
        if(board[row][col].getDiscColor() == Constants.DARK || board[row][col].getDiscColor() == Constants.LIGHT)
        {
            return false;
        }
        
        while(checkRow < Constants.ROWS && checkCol >= 0 && !matchFound)
        {
            if(getBoard()[checkRow][checkCol].getDiscColor() == Constants.EMPTY)
            {
                validMove = false;
                return validMove;
            }   
            else if (getBoard()[checkRow][checkCol].getDiscColor() != color)
            {
             flipSquares++;
            }
            else 
            {
             matchFound = true;
             break;
            }
         
            checkCol--;
            checkRow++;
        }
       
        if(matchFound && flipSquares > 0)
        {
            checkRow=row;
            checkCol=col;
            
            do
            {
                checkCol--;
                checkRow++;
                board[checkRow][checkCol].setDiscColor(color);
                flipSquares--;
            }
            while(flipSquares > 0);
            
            validMove = true;
            
        }
        else
        {
            validMove = false;
        }
        
        return validMove;
    }

    private boolean checkDown(int row, int col, Color color, boolean flip)
    {
        //checking space down
        int flipSquares = 0;
        int checkRow = row + 1;
        int checkCol = col;
        boolean matchFound = false;
        boolean validMove = true;
        
        if(board[row][col].getDiscColor() == Constants.DARK || board[row][col].getDiscColor() == Constants.LIGHT)
        {
            return false;
        }
        
        while(checkRow < Constants.ROWS && !matchFound)
        {
            if(getBoard()[checkRow][col].getDiscColor() == Constants.EMPTY)
            {
                validMove = false;
                return validMove;
            }   
            else if (getBoard()[checkRow][col].getDiscColor() != color)
            {
             flipSquares++;
            }
            else 
            {
             matchFound = true;
             break;
            }
            
         checkRow++;
        }
    
        if(matchFound && flipSquares > 0)
        {
            checkRow = row;
            checkCol = col;
            
            do
            {
                checkRow++;
                board[checkRow][col].setDiscColor(color);
                flipSquares--;
            }
            while(flipSquares > 0);
            
            validMove = true;
        }
        else{
                validMove = false;
            }
    
        return validMove;
    }
        
                
                
        
    private boolean checkDownRight(int row, int col, Color color, boolean flip)
    {
        //checking space lower right
        int flipSquares = 0;
        int checkRow = row+ 1;
        int checkCol = col+ 1;
        boolean matchFound = false;
        boolean validMove = true;
            
        if(board[row][col].getDiscColor() == Constants.DARK || board[row][col].getDiscColor() == Constants.LIGHT)
        {
            return false;
        }
        
        while(checkRow < Constants.ROWS && checkCol < Constants.COLS && !matchFound)
        {
            if(getBoard()[checkRow][checkCol].getDiscColor() == Constants.EMPTY)
            {
                validMove = false;
                return validMove;
            }   
            else if (getBoard()[checkRow][checkCol].getDiscColor() != color)
            {
                flipSquares++;
            }
            else 
            {
                matchFound = true;
                break;
            }
            checkCol++;
            checkRow++;
        }
            
        if(matchFound && flipSquares > 0)
        {
            checkRow=row;
            checkCol=col;
            
            do
            {
                checkCol++;
                checkRow++;
                board[checkRow][checkCol].setDiscColor(color);
                flipSquares--;
            }
            while(flipSquares > 0);
            
            validMove = true;
        }
        else
        {
                validMove = false;
        }
        
        return validMove;
        
    }
    

    private boolean checkRight(int row, int col, Color color, boolean flip)
    {
        //checking space right
        int flipSquares = 0;
        int checkRow = row;
        int checkCol = col + 1;
        boolean matchFound = false;
        boolean validMove = true;
            
        if(board[row][col].getDiscColor() == Constants.DARK || board[row][col].getDiscColor() == Constants.LIGHT)
        {
            return false;
        }
            
        while(checkCol < Constants.COLS && !matchFound)
        {
            if(getBoard()[row][checkCol].getDiscColor() == Constants.EMPTY)
            {
               validMove = false;
               return validMove;
            }   
            else if (getBoard()[checkRow][checkCol].getDiscColor() != color)
            {
                flipSquares++;
            }
            else 
            {
                matchFound = true;
                break;
            }
            checkCol++;
        }
               
        if(matchFound && flipSquares > 0)
        {
            checkRow = row;
            checkCol = col;
            
            do
            {
                checkCol++;
                board[row][checkCol].setDiscColor(color);
                flipSquares--;
            }
            while(flipSquares > 0);
            
            validMove = true; 
        }
        else
        {
                validMove = false;
        }
            
        return validMove;
    }

    private boolean checkUpRight(int row, int col, Color color, boolean flip)
    {
        //checking space upper right
        int flipSquares = 0;
        int checkRow = row-1;
        int checkCol = col+1;
        boolean matchFound = false;
        boolean validMove = true;
            
        if(board[row][col].getDiscColor() == Constants.DARK || board[row][col].getDiscColor() == Constants.LIGHT)
        {
        return false;
        }
        
        while(checkRow >= 0 && checkCol < Constants.COLS && !matchFound)
        {
            if(getBoard()[checkRow][checkCol].getDiscColor() == Constants.EMPTY)
            {
                validMove = false;
                return validMove;
            }   
            else if (getBoard()[checkRow][checkCol].getDiscColor() != color)
            {
                flipSquares++;
            }
            else 
            {
                matchFound = true;
                break;
            }
            
                checkCol++;
                checkRow--;
            }
    
            if(matchFound && flipSquares > 0)
            {
                checkRow=row;
                checkCol=col;
                
                do
                {
                    checkCol++;
                    checkRow--;
                    board[checkRow][checkCol].setDiscColor(color);
                    flipSquares--;
                }
                while(flipSquares > 0);
            
                validMove = true;
            }
            else
            {
                validMove = false;
            }
            
        return validMove;
    }
         
    
    public boolean isGameOver()
    {
        
        boolean gameOver = false;
       // if the players’ scores add up to 64 then the game is over
        if(players.get(Constants.PLAYER_ONE).getScore()+players.get(Constants.PLAYER_TWO).getScore()==64)
        {
            gameOver = true;  
        }
        // neither player can move
        if(hasMove(Constants.DARK) && hasMove(Constants.LIGHT))
        {
            gameOver = true;
        }
	return gameOver;
    }
    
    public boolean hasMove(Color color)
    {
        //does a player have a move
        boolean isMove = false;
        for (int i = 0; i < Constants.ROWS; i++)
        {
            for (int j = 0; j < Constants.COLS; j++)
            {
                if (board[i][j].getDiscColor() == null && isMove == true)
                {
                    isMove = (isValidMove(i, j, color, false));
                }
            }
        }
        return isMove;
    }

    
    public Disc[][] getBoard() {
        return board;
    }

    /**
     * @param board the board to set
     */
    public void setBoard(Disc[][] board) {
        this.board = board;
    }

    /**
     * @return the darkCount
     */
    public int getDarkCount() {
        return darkCount;
    }

    /**
     * @param darkCount the darkCount to set
     */
    public void setDarkCount(int darkCount) {
        this.darkCount = darkCount;
    }

    /**
     * @return the lightCount
     */
    public int getLightCount() {
        return lightCount;
    }

    /**
     * @param lightCount the lightCount to set
     */
    public void setLightCount(int lightCount) {
        this.lightCount = lightCount;
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
}
