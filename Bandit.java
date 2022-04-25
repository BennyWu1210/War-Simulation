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
    private static final int initHp = 50;
    public Bandit (int direction)
    {
        // calls super constructor
        super(direction, initHp);
        setImage("Bandit.png");
        image = new GreenfootImage("Bandit.png");
        getImage().scale(50, 52);
        
        // intialize hp bar
        if (direction == 1) hpBar = new StatBar(100, 100, this, 30, 5, 35, Color.RED, new Color(255, 204, 203), false, Color.WHITE, 1);
        else hpBar = new StatBar(100, 100, this, 30, 5, 35, Color.CYAN, new Color(202, 255, 255), false, Color.BLACK, 1);
        
        // testing
        this.speed = 1.2;
        this.attackSpeed = 3;
        this.attackRange = 35;
        this.damage = 15;
    }
    
    public void act()
    {
        super.act();
        
        
    }
    
    public void attack(){
        if (target == null || target.getWorld() == null){
            List<Soldier> enemies = getObjectsInRange(80, Soldier.class);
        
            if (enemies.size() != 0){
                int index = 0;
                
                while (index < enemies.size()){
                    Soldier nxt = enemies.get(index);
                    if (nxt.getDirection() != this.getDirection()){
                        target = nxt;
                        System.out.println("Target found!");
                        break;
                    }
                    index ++;
                }
            }
        
        } else{
            if (getDistance(target) <= attackRange){
                target.getHit(this.damage, new SwordHitEffect());
            }
        }
        
    }
}
