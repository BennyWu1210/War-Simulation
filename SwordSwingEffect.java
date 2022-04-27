import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SwordHitEffect here.
 * 
 * @author Benny Wu 
 * @version April 25th
 */
public class SwordSwingEffect extends Effect
{
    /**
     * Act - do whatever the SwordHitEffect wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public SwordSwingEffect(){
        super(new GifImage(Greenfoot.getRandomNumber(2) == 0 ? "swordSwing01.gif" : "swordSwing02.gif"), 5, 1);
        for (GreenfootImage img: gifImageList) img.scale(100, 100);
    }
    
    public void act()
    {
        super.act();
    }
}
