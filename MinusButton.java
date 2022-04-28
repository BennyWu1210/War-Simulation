import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MinusButton here.
 * This add button is used to add the inital gold.
 * @author (Kevin Zhu) 
 * @version (April 28, 2022)
 */
public class MinusButton extends Button
{
    /**
     * This set the default value for the minus button.
     */
    public MinusButton()
    {
        initMinusButton();
    }

    /**
     * Initializing the start button image
     */
    public void initMinusButton()
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
