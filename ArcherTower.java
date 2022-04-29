import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * 
 * The Archer Tower is a tower which shoots arrows when soldiers are in their
 * range. They are also able to upgrade to a higher level, making them stronger.
 * 
 * @author Benny, Angus, Caleb, Kevin Zhu
 * @version April 28th, 2022
 */
public class ArcherTower extends Tower
{
    // create private timer variables to keep track of their ticks
    private int timer;
    private int upgradeTimer = 0;
    
    /**
     * Creates a new Archer tower with a given direction
     * 
     * @param direction  the direction this archer tower is facing
     */
    public ArcherTower(int direction){
        // calls super constructor
        super(direction);
        
        // sets image for archer tower
        image = new GreenfootImage("archerTower.png");
        setImage(image);
        getImage().scale(100, 100);
        
        // sets all the properties for this archer tower
        this.hp = this.maxHp = 600;
        this.attackSpeed = 30;
        this.attackRange = 280;
        this.damage = 5;
        this.triggerRange = 360;
        
        // creates hp bar (statbar) based on the direction
        if (direction == -1) getImage().mirrorHorizontally();
        if (direction == 1) hpBar = new StatBar(hp, hp, this, 75, 7, 50, Color.RED, new Color(255, 204, 203), false, Color.WHITE, 1);
        else hpBar = new StatBar(hp, hp, this, 75, 7, 50, Color.CYAN, new Color(202, 255, 255), false, Color.BLACK, 1);
    }
    
    /**
     * Archer tower's act method
     */
    public void act()
    {
        // Increment the timers
        timer++;
        upgradeTimer++;
        
        //The tower shoots every half second
        if (timer == attackSpeed){
            attack();
            timer = 0;
        }
        
        //It takes 300 ticks (5 seconds) for the tower to upgrade
        if (upgradeTimer == 300){
            upgrade();
        }
        
        // calls super's act method
        super.act();
    }
    
    /**
     * The upgraded tower now shoots quicker, deals more damage and has a greater range
     */
    public void upgrade(){
        // upgrades this tower and sets new properties
        image = new GreenfootImage("ArcherTower2.png");
        setImage(image);
        getImage().scale(100, 140);
        if (attackSpeed >= (attackSpeed - 5)){
            this.attackSpeed -= 5;
        }
        
        // Increase damage and attack range
        this.damage += 5;
        this.attackRange += 200;
        this.triggerRange += 200;
    }
    
    /**
     * The attack method for archer tower:
     * 
     * It first locates a target if it does not have one originally, then it shoots an arrow toward this target
     */
    public void attack(){
        // if there is no current target:
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
                Arrow a = new Arrow(target);
                getWorld().addObject(a, getX(), getY());
            }
        }
    }
}
