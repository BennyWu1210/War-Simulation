import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MinusButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MinusButton extends Button
{
    public MinusButton()
    {
        super();
        initStartButton();
    }

    public void act() 
    {
        onHover();

    }    

    /**
     * Initializing the start button image
     */
    public void initStartButton()
    {
        images[0] = new GreenfootImage("minusLight.png"); 
        images[1] = new GreenfootImage("minusDark.png"); 
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
