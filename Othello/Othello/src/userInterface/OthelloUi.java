/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import core.Game;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
/**
 *
 * @author Danielle D'Alessio
 */
public class OthelloUi extends JFrame{
    private Game game;
    private GameUi gameUi;
    private BoardUi boardUi;
    
    public OthelloUi (Game game){
        
        this.game = game;
        initComponents();
    }
    
    private void initComponents(){
        //dimensions and the game will exit when closed
        this.setPreferredSize(new Dimension(600, 600));
        this.setMinimumSize(new Dimension(600, 600));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        gameUi = new GameUi();
        boardUi = new BoardUi();
        
        //sets positions
        this.add(boardUi, BorderLayout.CENTER);
        this.add(gameUi, BorderLayout.NORTH);
        this.setVisible(true);                
    }
    
    
    
}
