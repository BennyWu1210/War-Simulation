import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ArrowHitEffect here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
