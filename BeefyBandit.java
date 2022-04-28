import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Beefy Bandit is not only strong, but he can also shoots arrow very well! 
 * 
 * @author Benny Wu, Angus Feng, Caleb
 * @version April 28th, 2022
 */
public class BeefyBandit extends Soldier
{
    // creates the class-wide initial health for Beefy Bandit
    private static final int initHp = 160;
    
    /**
     * Creates a new Beefy Bandit with a given direction
     * 
     * @param direction  the direction this Beefy Bandit is facing
     */
    public BeefyBandit (int direction)
    {
        // calls super constructor
        super(direction, initHp);
        
        // sets image for bandit
        image = new GreenfootImage("BeefyBandit.png");
        getImage().scale(80, 82);
        
        // sets all the properties for this beefy bandit 
        this.speed = 1.1;
        this.attackSpeed = 8;
        this.attackRange = 180;
        this.damage = 5;
        this.triggerRange = 500;
        this.deathGold = 10;
        
        // intialize hp bar
        if (direction == 1) hpBar = new StatBar(initHp, initHp, this, 50, 6, 35, Color.RED, new Color(255, 204, 203), false, Color.WHITE, 1);
        else hpBar = new StatBar(initHp, initHp, this, 50, 6, 35, Color.CYAN, new Color(202, 255, 255), false, Color.BLACK, 1);
    }

    
    /**
     * The die method for Beefy Bandit: 
     * 
     * It leaves a corpse behind and remove itself from the world
     */
    public void die(){
        getWorld().addObject(new DeathEffect("BanditDead.png", direction), getX(), getY());
        removeSelf();
        
    }
 
    
    /**
     * The attack method for Beefy Bandit: 
     * 
     * It uses a sword with special effects to attack its target
     */
    public void attack(){
        if (!attackingTower && (target == null || target.getWorld() == null)){
            CrystalTower c = ((MyWorld)getWorld()).getTargettedCrystal(this.direction);
            if (getDistance(c) <= this.triggerRange * 1.25){
                attackingTower = true;
                targetTower = c;
            }
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
            CrystalTower c = ((MyWorld)getWorld()).getTargettedCrystal(direction);
            if (attackingTower && getDistance(targetTower) <= attackRange){
                Arrow a = new Arrow(targetTower);
                getWorld().addObject(a, getX(), getY());
            }
            else if (target != null && target.getWorld() != null && getDistance(target) <= attackRange){
                Arrow a = new Arrow(target);
                getWorld().addObject(a, getX(), getY());
            }
        }
    }
}