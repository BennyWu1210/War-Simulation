import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Knight here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Knight extends Soldier
{
    private static final int initHp = 80;
    public Knight (int direction)
    {
        super(direction, initHp);
        image = new GreenfootImage("Knight.png");
        getImage().scale(50, 52);
        
        // intialize hp bar
        if (direction == 1) hpBar = new StatBar(100, 100, this, 32, 5, 35, Color.BLUE, Color.YELLOW, false);
        else hpBar = new StatBar(100, 100, this, 32, 5, 35, Color.GREEN, Color.RED, false);
        hpBar.initLevel(1, 10);
    }
  
    
    public void act()
    {
        super.act();
    }
}
