import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Bandit is a soldier that moves incredibly fast. Even though they are not the strongest one among the 4,
 * the are undoubtedly the bravest and attacks incredibly quickly!
 * 
 * 
 * @author Benny Wu, Angus Feng
 * @version April 28th, 2022
 */

public class Bandit extends Soldier
{
    // creates the class-wide initial health for Bandit
    private static final int initHp = 70;
    
    /**
     * Creates a new Bandit with a given direction
     * 
     * @param direction  the direction this Bandit is facing
     */
    public Bandit (int direction)
    {
        // calls super constructor
        super(direction, initHp);
        
        // sets image for bandit
        setImage("Bandit.png");
        image = new GreenfootImage("Bandit.png");
        getImage().scale(50, 52);
        
        // intialize hp bar based on its direction
        if (direction == 1) hpBar = new StatBar(initHp, initHp, this, 30, 5, 35, Color.RED, new Color(255, 204, 203), false, Color.WHITE, 1);
        else hpBar = new StatBar(initHp, initHp, this, 30, 5, 35, Color.CYAN, new Color(202, 255, 255), false, Color.BLACK, 1);
        
        // sets all the properties for this bandit 
        this.speed = 2.3;
        this.attackSpeed = 5;
        this.attackRange = 35;
        this.damage = 8;
        this.triggerRange = 300;
        this.deathGold = 1;
    }
    
    /**
     * The attack method for Bandit: 
     * 
     * It uses a sword with special effects to attack its target
     */
    public void attack(){
        // Locate a new target:
        if (!attackingTower && (target == null || target.getWorld() == null)){
            // Check if the crystal tower is within its attack range
            CrystalTower c = ((MyWorld)getWorld()).getTargettedCrystal(this.direction);
            if (getDistance(c) <= this.triggerRange * 1.25){
                attackingTower = true;
                targetTower = c;
            }
            
            // Otherwise, locate a new enemy
            else{
                // get a list of enemy objects within its range
                List<Soldier> enemies = getObjectsInRange((int)this.triggerRange, Soldier.class);
            
                if (enemies.size() != 0){
                    int index = 0;
                    
                    while (index < enemies.size()){
                        Soldier nxt = enemies.get(index);
                        if (nxt.getDirection() != this.getDirection()){
                            // found new target
                            target = nxt;
                            break;
                        }
                        index ++;
                    }
                }
            }
        
        } else{
            // Otherwise, attack the current tower/target
            Tower c = ((MyWorld)getWorld()).getTargettedCrystal(direction);
            if (attackingTower && getDistance(c) <= attackRange){
                c.getHit(this.damage, new SwordHitEffect());
            }
            else if (target != null && target.getWorld() != null && getDistance(target) <= attackRange){
                target.getHit(this.damage, new SwordHitEffect());
            }
        }
        
    }
    
    
}
