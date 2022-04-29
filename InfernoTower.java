import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * The Inferno Tower is a tower which shoot fireballs at a fast rate when
 * soldiers get near it. It also loses hp automatically.
 * 
 * @author Benny Wu
 * @version April 28th, 2022
 */
public class InfernoTower extends Tower
{
    
    // create a private timer variable to keep track of the ticks
    int timer;
    
    /**
     * Creates a new Inferno tower with a given direction
     * 
     * @param direction  the direction this Inferno tower is facing
     */
    public InfernoTower(int direction){
        // calls super constructor
        super(direction);
        
        // sets image for Inferno tower
        image = new GreenfootImage("Inferno_Tower1.png");
        setImage(image);
        getImage().scale(80, 100);
        
        // the tower shoots 4 times per second
        // sets all the properties for this archer tower
        this.attackSpeed = 15;
        this.attackRange = 280;
        this.damage = 0.1;
        this.triggerRange = 380;
        this.hp = this.maxHp = 900;
        
        // creates hp bar (statbar) based on the direction
        if (direction == -1) getImage().mirrorHorizontally();
        if (direction == 1) hpBar = new StatBar(hp, hp, this, 75, 7, 50, Color.RED, new Color(255, 204, 203), false, Color.WHITE, 1);
        else hpBar = new StatBar(hp, hp, this, 75, 7, 50, Color.CYAN, new Color(202, 255, 255), false, Color.BLACK, 1);
    }
    
    /**
     * Inferno tower's act method
     */
    public void act()
    {
        // Increment the timers
        timer++;
        if (timer == attackSpeed){
            attack();
            timer = 0;
        }
        
        // calls super's act method
        super.act();
        
    }
    
    /**
     * The attack method for Inferno tower:
     * 
     * It first locates a target if it does not have one originally, then it shoots a fireball toward this target
     */
    public void attack(){
        // if there is no current target 
        if (target == null || target.getWorld() == null){
            // get a list of enemies that is within its close proximity
            List<Soldier> enemies = getObjectsInRange((int)this.triggerRange, Soldier.class);
        
            if (enemies.size() != 0){
                int index = 0;
                
                // finds the next target
                while (index < enemies.size()){
                    Soldier nxt = enemies.get(index);
                    if (nxt.getDirection() != this.getDirection()){
                        target = nxt;
                        break;
                    }
                    index ++;
                }
            }
        
        } else{
            // Otherwise, detect if it is close enough to shoot at target
            if (getDistance(target) <= attackRange){
                Fireball f = new Fireball(target);
                getWorld().addObject(f, getX(), getY());
            }
        }
    }
}
