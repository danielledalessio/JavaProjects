/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;
import core.Constants;
import core.Game;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;
/**
 *
 * @author Danielle D'Alessio
 */
public class GameUi extends JPanel 
{
    //set jlabels
    private JLabel nameOne;
    private JLabel nameTwo;
    private JLabel scoreOne;
    private JLabel scoreTwo;
    private Game game;
    
    public GameUi(Game game)
    {
        this.game = game;
        initComponents();
    }
    
    private void initComponents()
    {
        //sizes and images
        this.setPreferredSize(new Dimension (50, 50));
        this.setMinimumSize(new Dimension (40, 40));
        this.setBackground(Color.LIGHT_GRAY);
        
        ImageIcon discOne = new ImageIcon(getClass().getResource("../images/blueCoin.png"));
        discOne = imageResize(discOne);
        ImageIcon discTwo = new ImageIcon(getClass().getResource("../images/redCoin.png"));
        discTwo = imageResize(discTwo);
        
        setNameOne(new JLabel());
        getNameOne().setIcon(discOne);
        getNameOne().setText(game.getPlayers().get(Constants.PLAYER_ONE).getName());
        getNameOne().setPreferredSize(new Dimension(100, 50));
        getNameOne().setBackground(Color.yellow);
        getNameOne().setMinimumSize(new Dimension(100, 50));
        getNameOne().setFont(new Font("arial", Font.BOLD, 22));
        
        setNameTwo(new JLabel());
        getNameTwo().setIcon(discTwo);
        getNameTwo().setText(game.getPlayer().get(Constants.PLAYER_TWO).getName());
        getNameTwo().setPreferredSize(new Dimension(100, 50));
        getNameTwo().setBackground(Color.LIGHT_GRAY);
        getNameTwo().setMinimumSize(new Dimension(100, 50));
        getNameTwo().setFont(new Font("arial", Font.BOLD, 22));
        
        setScoreOne(new JLabel());
        getScoreOne().setMinimumSize(new Dimension(100, 50));
        getScoreOne().setBackground(Color.LIGHT_GRAY);
        getScoreOne().setPreferredSize(new Dimension(100, 50));
        getScoreOne().setFont(new Font("arial", Font.BOLD, 22));
        
        setScoreTwo(new JLabel());
        getScoreTwo().setMinimumSize(new Dimension(100, 50));
        getScoreTwo().setBackground(Color.LIGHT_GRAY);
        getScoreTwo().setPreferredSize(new Dimension(100, 50));
        getScoreTwo().setFont(new Font("arial", Font.BOLD, 22));
        
        
        this.add(getNameOne());
        this.add(getScoreOne());
        this.add(getNameTwo());
        this.add(getScoreTwo());
    }

    
    private ImageIcon imageResize(ImageIcon icon)
    {
        //change image sizes
        Image image = icon.getImage();
        Image newImage = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newImage);
        return icon;
    }
    
    
    
    /**
     * @return the nameOne
     */
    public JLabel getNameOne() {
        return nameOne;
    }

    /**
     * @param nameOne the nameOne to set
     */
    public void setNameOne(JLabel nameOne) {
        this.nameOne = nameOne;
    }

    /**
     * @return the nameTwo
     */
    public JLabel getNameTwo() {
        return nameTwo;
    }

    /**
     * @param nameTwo the nameTwo to set
     */
    public void setNameTwo(JLabel nameTwo) {
        this.nameTwo = nameTwo;
    }

    /**
     * @return the scoreOne
     */
    public JLabel getScoreOne() {
        return scoreOne;
    }

    /**
     * @param scoreOne the scoreOne to set
     */
    public void setScoreOne(JLabel scoreOne) {
        this.scoreOne = scoreOne;
    }

    /**
     * @return the scoreTwo
     */
    public JLabel getScoreTwo() {
        return scoreTwo;
    }

    /**
     * @param scoreTwo the scoreTwo to set
     */
    public void setScoreTwo(JLabel scoreTwo) {
        this.scoreTwo = scoreTwo;
    }

    /**
     * @return the game
     */
    public Game getGame() {
        return game;
    }

    /**
     * @param game the game to set
     */
    public void setGame(Game game) {
        this.game = game;
    }
}
