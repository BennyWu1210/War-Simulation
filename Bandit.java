import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bandit here.
 * 
 * @author Benny Wu
 * @version (a version number or a date)
 */
public class Bandit extends Soldier
{
    private int test = 0;
    private static final int initHp = 50;
    public Bandit (int direction)
    {
        // calls super constructor
        super(direction, initHp);
        setImage("Bandit.png");
        image = new GreenfootImage("Bandit.png");
        getImage().scale(50, 52);
        
        // intialize hp bar
        if (direction == 1) hpBar = new StatBar(100, 100, this, 30, 5, 35, Color.BLUE, Color.YELLOW, false);
        else hpBar = new StatBar(100, 100, this, 30, 5, 35, Color.GREEN, Color.RED, false);
        hpBar.initLevel(1, 10);
    }
    
    public void act()
    {
        super.act();
    }
}
