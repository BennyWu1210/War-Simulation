import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartButton here.
 * This class is for user to play the game from the BeginingPage world to VehicleWorld. When the mouse move to this object, it will change colour.
 * @Kevin Zhu, Benny Wu
 * @April 2, 2022 
 */
public class StartButton extends Button
{
    private TitlePage page;
    
    /**
     * This set the default value for the start button.
     */
    public StartButton(TitlePage page)
    {
        super();
        initStartButton();
        this.page = page;
    }

    /**
     * Initializing the start button image
     */
    public void initStartButton()
    {
        images[0] = new GreenfootImage("StartDark.png"); 
        images[1] = new GreenfootImage("StartLight.png"); 
        setImage(images[0]);
    }

    /**
     * Check if mouse clicks this button
     */
    public void onClick()
    {
        if(Greenfoot.mouseClicked(this))
        {
            page.startGame();
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
