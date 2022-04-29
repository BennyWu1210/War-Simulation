import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * The Crystal Tower is a tower which shoots fireballs when soldiers are in its
 * range. It is also the most important tower as whichever side is able to kill
 * their opponent's crystal tower first wins.
 * 
 * @author Benny Wu, Angus Feng, Kevin Zhu
 * @version April 28th, 2022
 */
public class CrystalTower extends Tower
{
    
    // creates timer to keep track of the tick
    private int timer;
    
    /**
     * Creates a new Crystal tower with a given direction
     * 
     * @param direction  the direction this crystal tower is facing
     */
    public CrystalTower(int direction){
        // calls super constructor
        super(direction);
        
        // sets image for archer tower
        image = new GreenfootImage("Crystal.png");
        setImage(image);
        getImage().scale(80, 172);
        
        // sets all the properties for this archer tower
        this.hp = this.maxHp = 860;
        this.attackSpeed = 5;
        this.attackRange = 400;
        this.damage = 10;
        this.triggerRange = 360;
        
        // creates hp bar (statbar) based on the direction
        if (direction == -1) getImage().mirrorHorizontally();
        if (direction == 1) hpBar = new StatBar(maxHp, maxHp, this, 125, 7, 100, Color.RED, new Color(255, 204, 203), false, Color.WHITE, 1);
        else hpBar = new StatBar(maxHp, maxHp, this, 125, 7, 100, Color.CYAN, new Color(202, 255, 255), false, Color.BLACK, 1);
        
    }
    
    /**
     * Crystal tower's act method
     */
    public void act()
    {
        timer++;
        //the tower attacks every half second
        if (timer == 30){
            attack();
            timer = 0;
        }
    }
    
    /**
     * The attack method for archer tower:
     * 
     * It first locates a target if it does not have one originally, then it shoots a fire ball toward this target
     */
    public void attack(){
        // if there is no current target 
        if (target == null || target.getWorld() == null){
            // first, it gets a list of enemies that is within its close proximity
            List<Soldier> enemies = getObjectsInRange((int)this.triggerRange / 3, Soldier.class);
            
            // if there is no enemy that is close to it, extend the radius to search for more enemies
            if (enemies.size() == 0) enemies = getObjectsInRange((int)this.triggerRange, Soldier.class);
            if (enemies.size() != 0){
                int index = 0;
                
                // looks for the next target
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
                getWorld().addObject(f, getX(), getY() - 75);
            }
        }
    }
}
