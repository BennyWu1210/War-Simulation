import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Bandit here.
 * 
 * @author Benny Wu
 * @version (a version number or a date)
 */
public class Bandit extends Soldier
{
    private int test = 0;
    private static final int initHp = 70;
    public Bandit (int direction, Statistic worldStat)
    {
        // calls super constructor
        super(direction, initHp, worldStat);
        setImage("Bandit.png");
        image = new GreenfootImage("Bandit.png");
        getImage().scale(50, 52);
        
        // intialize hp bar
        if (direction == 1) hpBar = new StatBar(initHp, initHp, this, 30, 5, 35, Color.RED, new Color(255, 204, 203), false, Color.WHITE, 1);
        else hpBar = new StatBar(initHp, initHp, this, 30, 5, 35, Color.CYAN, new Color(202, 255, 255), false, Color.BLACK, 1);
        
        // testing
        this.speed = 2.3;
        this.attackSpeed = 5;
        this.attackRange = 35;
        this.damage = 5;
        this.triggerRange = 300;
        this.deathGold = 1;
    }
    
    public void act()
    {
        super.act();
    }
    
    public void attack(){
        if (!attackingTower && (target == null || target.getWorld() == null)){
            CrystalTower c = ((MyWorld)getWorld()).getTargettedCrystal(this.direction);
            if (getDistance(c) <= this.triggerRange * 1.25){
                attackingTower = true;
                targetTower = c;
            }
            else{
                List<Soldier> enemies = getObjectsInRange((int)this.triggerRange, Soldier.class);
            
                if (enemies.size() != 0){
                    int index = 0;
                    
                    while (index < enemies.size()){
                        Soldier nxt = enemies.get(index);
                        if (nxt.getDirection() != this.getDirection()){
                            target = nxt;
                            break;
                        }
                        index ++;
                    }
                }
            }
        
        } else{
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
