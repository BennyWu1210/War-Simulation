import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartButton here.
 * This class is for user to play the game from the BeginingPage world to VehicleWorld. When the mouse move to this object, it will change colour.
 * @Kevin Zhu (your name) 
 * @April 2, 2022 (a version number or a date)
 */
public class StartButton extends Actor
{
    GreenfootImage[] startImage = new GreenfootImage[2]; //Stores "light" and "dark" of start button images

    public StartButton()
    {
        initStartButton();
    }

    public void act() 
    {
        checkHover();
        detectClick();
    }    

    /**
     * Initializing the start button image
     */
    public void initStartButton()
    {
        startImage[0] = new GreenfootImage("StartDark.png"); 
        startImage[1] = new GreenfootImage("StartLight.png"); 
    }

    /**
     * Check if mouse clicks this button
     */
    public void detectClick()
    {
        if(Greenfoot.mouseClicked(this))
        {
            //Switch to the loading page
            MyWorld vw = new MyWorld();
            Greenfoot.setWorld(vw);
        }

    }

    /**
     * Check if mouse hovers on this button
     */
    public void checkHover()
    {
        if (Greenfoot.mouseMoved(this))
        {
            setImage(startImage[1]); //Dark
        }
        else if(Greenfoot.mouseMoved(null))
        {
            setImage(startImage[0]); //Light
        }

    }
}
