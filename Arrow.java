import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Arrow is a projectile that can follow its target while dealing great damage
 * 
 * @author Benny
 * @version April 28th, 2022
 */
public class Arrow extends Projectile
{
    
    /**
    * This creates a new instance of Arrow
    * 
    * @param target  Pass in the target as a soldier
    */
    public Arrow(Soldier target){
        // calls super constructor
        super(target);
        
        // sets the image and movement properties
        this.image = new GreenfootImage("arrow.png");
        this.speed = 8;
        this.targetX = target.getX();
        this.targetY = target.getY();
        getImage().scale(30, 30);
    }
    
    /**
     * This creates a new instance of Arrow
     * 
     * @param target  Pass in the target as a tower
     */
    public Arrow(Tower tower){
        // calls super constructor
        super(tower);
        this.image = new GreenfootImage("arrow.png");
        this.speed = 8;
        this.targetX = tower.getX();
        this.targetY = tower.getY();
        getImage().scale(30, 30);
    }
    
    /**
     * This calls its parent's addedToWorld() in order to flip the image according to its direction
     */
    public void addedToWorld(World w){
        super.addedToWorld(w);
    }
    
    /**
     * The act method for Arrow:
     * 
     * Mainly responsible for controlling its movement and check whether it is removed from the world
     */
    public void act()
    {
        // move toward its targetted position
        if (target == null || target.getWorld() == null){
            move(targetX, targetY);
        } else if (tower != null){
            move(targetX, targetY);
            turnTowards(tower);
        } else{
            move(target);
            turnTowards(target);
            targetX = target.getX();
            targetY = target.getY();
        }
        
        // Check whether it hits its target
        if (getDistance(targetX, targetY) <= 6){
            if (tower == null && (target == null || target.getWorld() == null)) getWorld().addObject(new ArrowHitEffect(), getX(), getY());
            else {
                if (tower != null) tower.getHit(15, null);
                else target.getHit(15, new ArrowHitEffect());
            }
            // Remove itself from the world
            getWorld().removeObject(this);
            return;
        }
        
        
        
        // Add your action code here.
    }
    

}
