import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SoldierSwitchButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SoldierSwitchButton extends Button
{
    /**
     * Act - do whatever the SoldierSwitchButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public boolean state;
    private int idx=1;
    public SoldierSwitchButton()
    {
        super();
        initStartButton();
        
    }

    public void act() 
    {
        onClick();
        
    }    

    /**
     * Initializing the start button image
     */
    public void initStartButton()
    {
        images[0] = new GreenfootImage("On.png"); 
        images[1] = new GreenfootImage("Off.png"); 
        setImage(images[0]);
        state=true;
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
                state=false;
            }else if(idx==0){
                setImage(images[idx]);
                idx=1;
                state=true;
            }
            
        }
    }

}
