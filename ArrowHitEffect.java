import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ArrowHitEffect here.
 * 
 * @author (Benny Wu) 
 * @version (April 26th, 2022)
 */
public class ArrowHitEffect extends Effect
{
    private GreenfootSound sound;
    private static int totalArrows;
    public ArrowHitEffect(){
        super(new GifImage("arrowEffect.gif"), 5, 1);
        for (GreenfootImage img: gifImageList) img.scale(100, 100);
        if (totalArrows < 5){
            sound = new GreenfootSound("Bow Fire.wav");
        sound.setVolume(64);
        }
        
        totalArrows ++;
    }
    
    public void act()
    {
        super.act();
        System.out.println(totalArrows);
        if (sound != null) sound.play();
        if (getWorld() == null){
            totalArrows --;
        }
    }
}
