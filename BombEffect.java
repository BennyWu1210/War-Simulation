import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ArrowHitEffect here.
 * 
 * @author (Benny Wu) 
 * @version (April 27th, 2022)
 */
public class BombEffect extends Effect
{
    
    public BombEffect(){
        super(new GifImage("explosion01.gif"), 5, 1);
        for (GreenfootImage img: gifImageList) img.scale(30, 30);
    }
    
    public void act()
    {
        super.act();
    }
}
