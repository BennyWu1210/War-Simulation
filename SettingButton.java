import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SettingButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SettingButton extends Button
{
    /**
     * Act - do whatever the SettingButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private TitlePage page;
    public SettingButton(TitlePage page)
    {
        super();
        initStartButton();
        this.page = page;
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
        images[0] = new GreenfootImage("SetDark.png"); 
        images[1] = new GreenfootImage("SetLight.png"); 
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
            page.openModifier();
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
