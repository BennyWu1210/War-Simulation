import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SwordHitEffect here.
 * 
 * @author Benny Wu 
 * @version April 27th
 */
public class SwordHitEffect extends Effect
{
    
    public SwordHitEffect(){
        super(new GifImage("HitEffect01.gif"), 5, 1);
        for (GreenfootImage img: gifImageList) img.scale(100, 100);
        
    }
    
    public void act()
    {
        super.act();
        
        
    }
}
