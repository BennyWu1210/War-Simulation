import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SwordHitEffect here.
 * 
 * @author Benny Wu 
 * @version April 25th
 */
public class SwordSwingEffect extends Effect
{
    private GreenfootSound sound;
    
    public SwordSwingEffect(){
        super(new GifImage(Greenfoot.getRandomNumber(2) == 0 ? "swordSwing01.gif" : "swordSwing02.gif"), 5, 1);
        for (GreenfootImage img: gifImageList) img.scale(100, 100);
        String random = Greenfoot.getRandomNumber(2) == 0 ? "Sword.wav" : "Sword2.wav";
        sound = new GreenfootSound(random);
        sound.setVolume(70);
    }
    
    public void act()
    {
        super.act();
        sound.play();
    }
}
