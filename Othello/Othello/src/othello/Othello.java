/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package othello;

import core.Game;//import game from core package
import userInterface.OthelloUI;

/**
 *
 * @author Josue Martinez
 */
public class Othello {

   // private Game game;
    /**
     * @param args the command line arguments
     */
    
       
    public static void main(String[] args) {
        //get game to work
     Game game = new Game();
     
     OthelloUI ui = new OthelloUI(game);
    } 
}
