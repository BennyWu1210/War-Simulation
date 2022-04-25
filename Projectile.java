import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Projectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Projectile extends Entity
{
    /**
     * Act - do whatever the Projectile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Projectile(Soldier target){
        super(target);
    }
    
    public void addedToWorld(){
        super.addedToWorld();
    }
    
    public void act()
    {
        move(8);
        //If you are at edge delete yaself bozo
        if(isAtEdge())
            getWorld().removeObject(this);
    }
}
