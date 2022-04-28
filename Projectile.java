import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Projectile is an abstract class that incorporates the common characteristics for Arrow, 
 * Fireball and HealProjectile
 * 
 * @author Benny Wu
 * @version April 28th, 2022
 */
public abstract class Projectile extends Entity
{
    
    // the target positions / tower for that this projectile is currently attacking
    protected int targetX, targetY;
    protected Tower tower;
    
    /**
     * This creates a new instance of projectile
     * 
     * @param target  Pass in the target as a soldier
     */
    public Projectile(Soldier target){
        // calls super constructor
        super(target);
    }
    
    /**
     * This creates a new instance of projectile
     * 
     * @param target  Pass in the target as a tower
     */
    public Projectile(Tower tower){
        // calls super constructor
        super(null);
        this.tower = tower;
    }

    /**
     * Act method for projectile
     */
    public void act()
    {
        // If you are at edge delete this projectile
        if(isAtEdge()) getWorld().removeObject(this);
    }
}
