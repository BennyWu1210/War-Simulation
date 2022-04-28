import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ClashRoyaleLaughEffect here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ClashRoyaleLaughEffect extends Effect
{
    /**
     * Act - do whatever the ClashRoyaleLaughEffect wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
     private GreenfootSound sound;
    
    public ClashRoyaleLaughEffect(){
        super(new GifImage("clash-royale-cr.gif"), 5, 5);
        for (GreenfootImage img: gifImageList) img.scale(130, 200);
        sound = new GreenfootSound("ClashRoyaleHaHa.mp3");
        sound.setVolume(50);
    }
    public void act()
    {
        super.act();
        sound.play();
    }
}
