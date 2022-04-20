import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Soldiers here.
 * 
 * @author Benny Wu, Angus
 * @version (a version number or a date)
 */
public abstract class Soldier extends Entity
{
    protected int direction;
    //Are you a left side soldier or right side soldier
    protected int side;
    protected StatBar hpBar;
    protected int hp;
    protected int maxHP;

    protected int mySpeed = 10;
    protected int myAge;
    /**
     * Act - do whatever the Soldiers wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Soldier(int direction, int maxHP)
    {
        this.direction = direction; 
        this.side = direction;
        this.hp = this.maxHP = maxHP;
    }
       
    public void addedToWorld(World w){
        if (direction == -1) getImage().mirrorHorizontally();
        w.addObject(hpBar, getX(), getY());
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
