import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The effect when an entity gets healed 
 * 
 * @author (Benny Wu) 
 * @version (April 26th, 2022)
 */
public class HealingEffect extends Effect
{
    
    // sets the sound effect
    private GreenfootSound sound;
    private static int totalHealing = 0;
    
    /**
     * Constructor for HealingEffect
     */
    public HealingEffect(){
        // calls super constructor
        super(new GifImage("healingEffect.gif"), 5, 1);
        
        // Adjust image size and sound effect
        for (GreenfootImage img: gifImageList) img.scale(100, 60);

        if (totalHealing < 5){
            sound = new GreenfootSound("Heal.wav");
            sound.setVolume(62);
        }
        totalHealing ++;
        
    }
    
    /**
     * Act method for healing effect
     */
    public void act()
    {
        super.act();
        if (sound != null) sound.play();
        if (getWorld() == null) totalHealing --;
    }
}
