import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * The Exist Button is used to end the game
 * @author (Kevin Zhu) 
 * @version (April 28, 2022)
 */
public class ExitButton extends Button
{
    /**
     * This set the default value for the exist button.
     */
    public ExitButton()
    {
        initExitButton();
    }

    /**
     * Initializing the exit button image
     */
    public void initExitButton()
    {
        images[0] = new GreenfootImage("ExitDark.png"); 
        images[1] = new GreenfootImage("ExitLight.png"); 
        setImage(images[0]);
    }

    /**
     * Check if mouse clicks this button
     */
    public void onClick()
    {
        if(Greenfoot.mouseClicked(this))
        {
            //stop the game
            Greenfoot.stop();
        }
    }

    /**
     * Check if mouse hovers on this button
     */
    public void onHover()
    {
        if (Greenfoot.mouseMoved(this))
        {
            setImage(images[1]); //Light
        }
        else if(Greenfoot.mouseMoved(null))
        {
            setImage(images[0]); //Dark
        }
    }
}