import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SoldierSwitchButton here.
 * The soldier switch button is used
 * @author (Kevin Zhu) 
 * @version (April 28, 2022)
 */
public class SoldierSwitchButton extends Button
{
    
    private int idx=1;
    
    /**
     * This set the default value for the soldier switch button.
     */
    public SoldierSwitchButton()
    {
        initSoldierSwitchButton();
    }

    /**
     * Initializing the start button image
     */
    public void initSoldierSwitchButton()
    {
        images[0] = new GreenfootImage("On.png"); 
        images[1] = new GreenfootImage("Off.png"); 
        setImage(images[0]);
    }

    /**
     * Check if mouse clicks this button
     */
    public void onClick()
    {
        if(Greenfoot.mouseClicked(this))
        {
            if(idx==1){
                setImage(images[idx]);
                idx=0;
                
            }else if(idx==0){
                setImage(images[idx]);
                idx=1;
            }
        }
    }
    
    public void onHover(){
        // Todo
    }

}
