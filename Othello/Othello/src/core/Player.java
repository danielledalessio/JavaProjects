
package core;

import java.awt.Color;

/**
 *
 * @author Danielle D'Alessio
 */
public class Player 
{
    private String name;
    private Color discColor;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the discColor
     */
    public Color getDiscColor() {
        return discColor;
    }

    /**
     * @param discColor the discColor to set
     */
    public void setDiscColor(Color discColor) {
        this.discColor = discColor;
    }
}
