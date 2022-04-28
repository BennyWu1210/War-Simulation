import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AddButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AddButton extends Button
{
    public AddButton()
    {
        super();
        initStartButton();
    }

     

    /**
     * Initializing the start button image
     */
    public void initStartButton()
    {
        images[0] = new GreenfootImage("AddLight.png"); 
        images[1] = new GreenfootImage("AddDark.png"); 
        setImage(images[0]);
    }

    /**
     * Check if mouse clicks this button
     */
    public void onClick()
    {
        
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
}
