import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ArrowHitEffect here.
 * 
 * @author (Benny Wu) 
 * @version (April 26th, 2022)
 */
public class HealingEffect extends Effect
{
    
    private GreenfootSound sound;
    private static int totalHealing = 0;
    
    public HealingEffect(){
        super(new GifImage("healingEffect.gif"), 5, 1);
        for (GreenfootImage img: gifImageList) img.scale(100, 60);
        
        
        if (totalHealing < 5){
            sound = new GreenfootSound("Heal.wav");
            sound.setVolume(62);
        }
        totalHealing ++;
        
    }
    
    public void act()
    {
        super.act();
        System.out.println(totalHealing);
        if (sound != null) sound.play();
        if (getWorld() == null) totalHealing --;
    }
}
