import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The effect when an arrow hits its target
 * 
 * @author (Benny Wu) 
 * @version (April 28th, 2022)
 */
public class ArrowHitEffect extends Effect
{
    // sets the sound effect
    private GreenfootSound sound;
    private static int totalArrows;
    
    /**
     * Constructor for ArrowHitEffect
     */
    public ArrowHitEffect(){
        // calls super constructor
        super(new GifImage("arrowEffect.gif"), 5, 1);
        
        // Adjust image size and sound effect
        for (GreenfootImage img: gifImageList) img.scale(100, 100);
        if (totalArrows < 5){
            sound = new GreenfootSound("Bow Fire.wav");
            sound.setVolume(64);
        }
        
        totalArrows ++;
    }
    
    /**
     * Act method for ArrowHitEffect
     */
    public void act()
    {
        super.act();
        if (sound != null) sound.play(); // play sound
        if (getWorld() == null){
            totalArrows --;
        }
    }
}
