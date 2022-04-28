import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BackButton here.
 * This back button is used to return from the Modifier world to TitlePage world.
 * @author (Kevin) 
 * @version (April 28, 2022)
 */
public class BackButton extends Button
{
    private Modifier page;
    
    /**
     * This set the default value for the back button.
     * 
     * @param page  The Modifier world to follow around
     */
    public BackButton(Modifier page)
    {
        initBackButton();//initialize the button
        this.page=page;//initialize the page
    }

    /**
     * Initializing the back button image
     */
    public void initBackButton()
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
            //Switch to the Title page
            page.returnTitlePage();
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
