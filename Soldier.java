import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Soldiers here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Soldier extends Entity
{
    protected int direction;
    /**
     * Act - do whatever the Soldiers wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Soldier(int direction)
    {
        this.direction = direction;
        if (this.direction == -1)
        {
            getImage().mirrorHorizontally();
        }
    }
    public void act()
    {
        move (1*direction);
    }
}
