import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ExplosionEffect here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ExplosionEffect extends Effect
{
    /**
     * Act - do whatever the ExplosionEffect wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootSound sound;
    
    public ExplosionEffect(){
        super(new GifImage("CrystalExplosion.gif"), 5, 1);
        for (GreenfootImage img: gifImageList) img.scale(280, 260);
        sound = new GreenfootSound("bomb_sound.mp3");
        sound.setVolume(50);
    }
    public void act()
    {
        super.act();
        sound.play();
    }
}
