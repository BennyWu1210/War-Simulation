import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The effect when an entity gets hit by a sword
 * 
 * @author Benny Wu 
 * @version April 27th
 */
public class SwordHitEffect extends Effect
{
    
    // sets the sound effect
    private GreenfootSound sound;
    private static int totalSword;
    
    /**
     * Constructor for SwordHitEffect
     */
    public SwordHitEffect(){
        // calls super constructor
        super(new GifImage("HitEffect01.gif"), 5, 1);
        
        // Adjust image size and sound effect
        for (GreenfootImage img: gifImageList) img.scale(100, 100);
        
        if (totalSword < 3){
            sound = new GreenfootSound("Sword3.wav");
            sound.setVolume(45);
        }
        
        totalSword ++;
    }
    
    /**
     * Act method for SwordHitEffect
     */
    public void act()
    {
        super.act();
        if (sound != null) sound.play();
        if (getWorld() == null) totalSword --;
        
    }
}
