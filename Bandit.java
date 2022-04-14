import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bandit here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bandit extends Soldier
{
    private int test = 0;
    public Bandit (int direction)
    {
        // calls super constructor
        super(direction);
        setImage("Bandit.png");
        image = new GreenfootImage("Bandit.png");
        getImage().scale(50, 52);
        
    }
    
    public void act()
    {
        super.act();
    }
}
