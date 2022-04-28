import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SwordHitEffect here.
 * 
 * @author Benny Wu 
 * @version April 27th
 */
public class SwordHitEffect extends Effect
{
    private GreenfootSound sound;
    private static int totalSword;
    public SwordHitEffect(){
        super(new GifImage("HitEffect01.gif"), 5, 1);
        for (GreenfootImage img: gifImageList) img.scale(100, 100);
        
        if (totalSword < 3){
            sound = new GreenfootSound("Sword3.wav");
            sound.setVolume(45);
        }
        
        totalSword ++;
    }
    
    public void act()
    {
        super.act();
        if (sound != null) sound.play();
        if (getWorld() == null) totalSword --;
        
    }
}
