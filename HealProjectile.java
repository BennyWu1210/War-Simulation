import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * HealProjectile can either heal the target if it's an ally, or deal damage to the target
 * if it's an enemy.
 * 
 * @author Benny
 * @version April 28th, 2022
 */
public class HealProjectile extends Projectile
{
    // keep track of whether the target is an enemy
    private boolean isEnemy;
    
    /**
    * This creates a new instance of HealProjectile
    * 
    * @param target  Pass in the target as a soldier
    * @param isEnemy  The state of this target (true/false)
    */
    public HealProjectile(Soldier target, boolean isEnemy){
        // calls super constructor
        super(target);
        this.isEnemy = isEnemy;
        
        // sets the image and movement properties
        String file = isEnemy ? "healProjectile02.png" : "healProjectile.png";
        this.image = new GreenfootImage(file);
        this.speed = 5;
        this.targetX = target.getX();
        this.targetY = target.getY();
        getImage().scale(30, 30);
    }
    
    /**
     * This creates a new instance of HealProjectile
     * 
     * @param target  Pass in the target as a tower
     */
    public HealProjectile(Tower tower){
        super(tower);
        this.targetX = tower.getX();
        this.targetY = tower.getY();
        this.image = new GreenfootImage("healProjectile.png");
        this.speed = 5;
        this.isEnemy = true;
        getImage().scale(30, 30);
    }
    
    /**
     * This calls its parent's addedToWorld() in order to flip the image according to its direction
     */
    public void addedToWorld(World w){
        super.addedToWorld(w);
    }
    
    /**
     * The act method for HealProjectile:
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
        if (getDistance(targetX, targetY) <= 4){
            if (target != null && target.getWorld() != null) {
                // heal/damage the target according to its status
                if (!isEnemy){
                    target.heal(5);
                } else{
                    target.getHit(5, null);
                }
            }
            
            // check if the target is a tower instead
            if (tower != null) {
                tower.getHit(10, null);
            }
            
            // remove itself from the world
            getWorld().addObject(new HealingEffect(), getX(), getY());
            getWorld().removeObject(this);
            return;
        }
        
    }
    

}
