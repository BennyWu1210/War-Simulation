import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class will present explosion effect
 * 
 * @author (Kevin Zhu) 
 * @version (April 28, 2022)
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
