import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The effect when a bomb explodes
 * 
 * @author (Benny Wu) 
 * @version (April 28th, 2022)
 */
public class BombEffect extends Effect
{
    
    /**
     * Constructor for BombEffect
     */
    public BombEffect(){
        // calls super constructor
        super(new GifImage("explosion01.gif"), 5, 1);
        
        // Adjust image size
        for (GreenfootImage img: gifImageList) img.scale(30, 30);
    }
}
