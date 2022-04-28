import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayAgainButton here.
 * The Play Again Button is used to play the game again
 * @author (Kevin Zhu) 
 * @version (April 28, 2022)
 */
public class PlayAgainButton extends Button
{
    /**
     * This set the default value for the play again button.
     */
    public PlayAgainButton()
    {
        initPlayAgainButton();
    }

    /**
     * Initializing the start button image
     */
    public void initPlayAgainButton()
    {
        images[0] = new GreenfootImage("AgainDark.png"); 
        images[1] = new GreenfootImage("AgainLight.png"); 
        setImage(images[0]);
    }

    /**
     * Check if mouse clicks this button
     */
    public void onClick()
    {
        if(Greenfoot.mouseClicked(this))
        {
            //Switch to the title page
            TitlePage tp = new TitlePage();
            Greenfoot.setWorld(tp);
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
