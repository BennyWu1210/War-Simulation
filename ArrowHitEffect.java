import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ArrowHitEffect here.
 * 
 * @author (Benny Wu) 
 * @version (April 26th, 2022)
 */
public class ArrowHitEffect extends Effect
{
    
    public ArrowHitEffect(){
        super(new GifImage("arrowEffect.gif"), 5, 1);
        for (GreenfootImage img: gifImageList) img.scale(100, 100);
    }
    
    public void act()
    {
        super.act();
    }
}
