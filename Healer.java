import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Healer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Healer extends Soldier
{
    /**
     * Act - do whatever the Healer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Healer (int direction)
    {
        super(direction);
        getImage().scale(50, 52);
    }
    public void act()
    {
        super.act();
    }
}
