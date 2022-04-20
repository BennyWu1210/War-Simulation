import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * An abstract class that provides properties and functinalities for various buttons
 * 
 * @author Benny Wu, Kevin Zhu
 * @version Apr. 20th, 2022
 */
public abstract class Button extends Actor
{
    // Stores the initial image and the image when hovered 
    protected GreenfootImage[] images = new GreenfootImage[2];
    
    public Button(){
        
    }
    
    public abstract void onClick();
    public abstract void onHover();
}
