import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SettingButton here.
 * The setting button is used to switch from the title page to the modifier
 * @author (Kevin Zhu) 
 * @version (April 28, 2022)
 */
public class SettingButton extends Button
{
    
    private TitlePage page;
    /**
     * This set the default value for the setting button.
     * 
     * @param page  The TitlePage world to follow around
     */
    public SettingButton(TitlePage page)
    {
        //initialization
        initSettingButton();
        this.page = page;
    }

    /**
     * Initializing the setting button image
     */
    public void initSettingButton()
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
            //Switch to the modifier page
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
            setImage(images[1]); //Light
        }
        else if(Greenfoot.mouseMoved(null))
        {
            setImage(images[0]); //Dark
        }
    }
}
