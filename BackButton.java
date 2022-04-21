import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BackButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BackButton extends Button
{
    /**
     * Act - do whatever the BackButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public BackButton()
    {
        super();
        initStartButton();
    }

    public void act() 
    {
        onHover();
        onClick();
    }    

    /**
     * Initializing the start button image
     */
    public void initStartButton()
    {
        images[0] = new GreenfootImage("BackButtonDark.png"); 
        images[1] = new GreenfootImage("BackButtonLight.png"); 
        setImage(images[0]);
    }

    /**
     * Check if mouse clicks this button
     */
    public void onClick()
    {
        if(Greenfoot.mouseClicked(this))
        {
            //Switch to the loading page
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
            setImage(images[1]); //Dark
        }
        else if(Greenfoot.mouseMoved(null))
        {
            setImage(images[0]); //Light
        }

    }
}