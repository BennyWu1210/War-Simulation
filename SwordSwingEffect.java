import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * An alternate effect(swordhit) when an entity gets hit by a sword
 * 
 * @author Benny Wu 
 * @version April 28th, 2022
 */
public class SwordSwingEffect extends Effect
{
    // sets the sound effect
    private GreenfootSound sound;
    
    /**
     * Constructor for SwordSwingEffect
     */
    public SwordSwingEffect(){
        // calls super constructor
        super(new GifImage(Greenfoot.getRandomNumber(2) == 0 ? "swordSwing01.gif" : "swordSwing02.gif"), 5, 1);
        
        // Adjust image size and sound effect
        for (GreenfootImage img: gifImageList) img.scale(100, 100);
        String random = Greenfoot.getRandomNumber(2) == 0 ? "Sword.wav" : "Sword2.wav";
        sound = new GreenfootSound(random);
        sound.setVolume(70);
    }
    
    /**
     * Act method for SwordHSwingEffect
     */
    public void act()
    {
        super.act();
        sound.play();
    }
}
