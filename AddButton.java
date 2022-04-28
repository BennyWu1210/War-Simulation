import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * This add button is used to add the inital gold.
 * 
 * @author Kevin Zhu
 * @version April 28, 2022
 */
public class AddButton extends Button
{
    /**
     * This set the default value for the add button.
     */
    public AddButton()
    {
        initAddButton();//initalize
    }

    /**
     * Initializing the add button image
     */
    public void initAddButton()
    {
        images[0] = new GreenfootImage("AddLight.png"); 
        images[1] = new GreenfootImage("AddDark.png"); 
        setImage(images[0]);
    }
    
    /**
     * Check if mouse hovers on this button
     */
    public void onHover()
    {
        if (Greenfoot.mouseMoved(this))
        {
            setImage(images[1]); //Dark
        }
        else if(Greenfoot.mouseMoved(null))
        {
            setImage(images[0]); //Light
        }
    }
    
    /**
     * Check if mouse clicks this button
     */
    public void onClick()
    {
        // feature to be implemented        
    }
}
