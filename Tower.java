import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The tower is a non-moving entity. They attack soldiers that go near them.
 * There are 3 types of towers: the archer tower, the crytal towe and the inferno
 * tower 
 * 
 * @author Benny Wu, Caleb
 * @version April 28th, 2022
 */


public abstract class Tower extends Entity
{
    
    // The fundamental properties of the tower class
    protected StatBar hpBar;
    protected int hp, maxHp;
    protected double attackSpeed, attackRange, triggerRange, damage; // attack properties
    /**
     * Creates a new tower with a given direction
     * 
     * @param direction  the direction this tower is facing
     */
    public Tower(int direction){
        // calls super constructor
        super(direction);
        this.direction = direction;
    }
    
    /**
     * Creates hp bar once this tower is added to the world
     */
    public void addedToWorld(World w){
        // calls super's addedToWorld() method and add health bar
        super.addedToWorld(w);
        w.addObject(hpBar, getX(), getY());
    }
    
    /**
     * Tower's act method - constantly decrease this tower's hp
     */
    public void act()
    {
        // constatnly decrease tower's hp by 1 every tick
        this.hp -= 1;
        hpBar.update(hp);
        //the towers are removed once the hp reaches 0
        if (this.hp <= 0){
            getWorld().removeObject(this);
        }
    }


    /**
     * This method makes the towers lose hp when they are hit
     * 
     * It expects the damage it took as well as the effect (can be null)
     * @param hp The amount of hp that will damage the soldier
     * @param effect The effect that is spawned when hit
     */
    public void getHit(double hp, Effect effect){
        
        // substract hp from current hp
        this.hp -= hp;
        
        // update to new hp
        hpBar.update((int)this.hp);
        
        // add effect if it is not null
        if (effect != null){
            getWorld().addObject(effect, getX(), getY());
        }
        
        if (hp <= 0){
            // if current hp is equal or less than 0, remove this tower
            getWorld().removeObject(this);
        }
    }
    
    /**
     * Returns the percetage of hp left as a dobule
     */
    public double getHpPercentage(){
        return (double)this.hp / this.maxHp;
    }
}
