import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * The effect class, minimum changes from the original
 */
public class Effect extends Actor
{
    protected int totalActs, actCounter;
    private boolean fade = true;
    protected GreenfootImage image;
   
    public Effect (int totalActs){
        this.totalActs = totalActs;
        actCounter = totalActs;
    }
   
    public Effect (int totalActs, boolean fade){
        this.fade = fade;
        this.totalActs = totalActs;
        actCounter = totalActs;
    }
   
    public void act()
    {
        if (actCounter > 0){
            actCounter--;
            if (actCounter < 60 && fade == true){ // last second
                image.setTransparency (actCounter * 2);
            }
        } else {
            getWorld().removeObject(this);
           
        }
    }
   
}