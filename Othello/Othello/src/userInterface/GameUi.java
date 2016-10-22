/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
/**
 *
 * @author Danielle D'Alessio
 */
public class GameUi extends JPanel {
    private JLabel nameOne;
    private JLabel nameTwo;
    private JLabel scoreOne;
    private JLabel scoreTwo;
    
    public GameUi()
    {
        initComponents();
    }
    
    //create dimensions, UI of game
    private void initComponents()
    {
        this.setPreferredSize(new Dimension (50, 50));
        this.setMinimumSize(new Dimension (40, 40));
        this.setBackground(Color.LIGHT_GRAY);
        
        nameOne = new JLabel("Danielle");
        nameOne.setPreferredSize(new Dimension(100, 50));
        nameOne.setBackground(Color.yellow);
        nameOne.setMinimumSize(new Dimension(100, 50));
        nameOne.setFont(new Font("arial", Font.BOLD, 22));
        
        nameTwo = new JLabel("Josh");
        nameTwo.setPreferredSize(new Dimension(100, 50));
        nameTwo.setBackground(Color.LIGHT_GRAY);
        nameTwo.setMinimumSize(new Dimension(100, 50));
        nameTwo.setFont(new Font("arial", Font.BOLD, 22));
        
        scoreOne = new JLabel("45");
        scoreOne.setMinimumSize(new Dimension(100, 50));
        scoreOne.setBackground(Color.LIGHT_GRAY);
        scoreOne.setPreferredSize(new Dimension(100, 50));
        scoreOne.setFont(new Font("arial", Font.BOLD, 22));
        
        scoreTwo = new JLabel("43");
        scoreTwo.setMinimumSize(new Dimension(100, 50));
        scoreTwo.setBackground(Color.LIGHT_GRAY);
        scoreTwo.setPreferredSize(new Dimension(100, 50));
        scoreTwo.setFont(new Font("arial", Font.BOLD, 22));
        
        
        this.add(nameOne);
        this.add(scoreOne);
        this.add(nameTwo);
        this.add(scoreTwo);
    }
}
