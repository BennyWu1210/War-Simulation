import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BeefyBandit here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BeefyBandit extends Soldier
{
    private static final int initHp = 150;
    public BeefyBandit (int direction)
    {
        super(direction, initHp);
        image = new GreenfootImage("BeefyBandit.png");
        getImage().scale(80, 82);
        
        // intialize hp bar
        if (direction == 1) hpBar = new StatBar(100, 100, this, 50, 6, 35, Color.BLUE, Color.YELLOW, false);
        else hpBar = new StatBar(100, 100, this, 50, 6, 35, Color.GREEN, Color.RED, false);
        hpBar.initLevel(1, 10);
    }

    
    public void act()
    {
        super.act();
    }
    private void touchPeople(){
        
    }
}
