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
    //Are you a left side soldier or right side soldier
    protected int side;
    /**
     * Act - do whatever the Soldiers wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Soldier(int direction)
    {
        this.direction = direction;
        this.side = direction;
        if (this.direction == -1)
        {
            getImage().mirrorHorizontally();
        }
    }
    public void act()
    {
        move (1*direction);
        if (isAtEdge()){
            getWorld().removeObject(this);
        }
    }
    public int getSide(){
        return side;
    }
    protected boolean touchSoldier(){
        return true;
    }
}
