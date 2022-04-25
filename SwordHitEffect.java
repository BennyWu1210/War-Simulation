import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SwordHitEffect here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SwordHitEffect extends Effect
{
    /**
     * Act - do whatever the SwordHitEffect wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public SwordHitEffect(){
        super(new GifImage("HitEffect01.gif"), 5, 1);
        for (GreenfootImage img: gifImageList) img.scale(100, 100);
    }
    
    public void act()
    {
        super.act();
    }
}
