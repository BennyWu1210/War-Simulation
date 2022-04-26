import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ArrowHitEffect here.
 * 
 * @author (Benny Wu) 
 * @version (April 26th, 2022)
 */
public class HealingEffect extends Effect
{
    
    public HealingEffect(){
        super(new GifImage("healingEffect.gif"), 5, 1);
        for (GreenfootImage img: gifImageList) img.scale(100, 60);
    }
    
    public void act()
    {
        super.act();
    }
}
