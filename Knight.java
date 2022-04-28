import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Knight is the coolest soldier of all - it fights fearlessly with that mighty sword!
 * 
 * @author Benny Wu
 * @version April 28th, 2022
 */

public class Knight extends Soldier
{
    // creates the class-wide initial health for Knight
    private static final int initHp = 130;
    
    /**
     * Creates a new Knight with a given direction
     * 
     * @param direction  the direction this Knight is facing
     */
    public Knight (int direction)
    {
        // calls super constructor
        super(direction, initHp);
        
        // sets image for Knight
        image = new GreenfootImage("Knight.png");
        getImage().scale(50, 52);
        
        // sets all the properties for this knight
        this.speed = 1.5;
        this.attackSpeed = 5;
        this.attackRange = 30;
        this.damage = 12;
        this.triggerRange = 300;
        this.deathGold = 2;
        
        // intialize hp bar
        if (direction == 1) hpBar = new StatBar(initHp, initHp, this, 32, 5, 35, Color.RED, new Color(255, 204, 203), false, Color.WHITE, 1);
        else hpBar = new StatBar(initHp, initHp, this, 32, 5, 35, Color.CYAN, new Color(202, 255, 255), false, Color.BLACK, 1);
    }
  
    
     /**
     * The die method for Knight: 
     * 
     * It leaves a corpse behind and remove itself from the world
     */
    public void die(){
        this.getWorld().addObject(new DeathEffect("GrayKnightDead.png", direction), getX(), getY());
        removeSelf();
        
    }
    
    
    /**
     * The attack method for Knight:
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
            if (attackingTower && getDistance(c) <= attackRange){
                c.getHit(this.damage, new SwordHitEffect());
            }
            else if (target != null && target.getWorld() != null && getDistance(target) <= attackRange){
                target.getHit(this.damage, new SwordSwingEffect());
            }
        }
        
    }
    
    
}


