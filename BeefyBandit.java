import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class BeefyBandit here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BeefyBandit extends Soldier
{
    private static final int initHp = 180;
    public BeefyBandit (int direction)
    {
        super(direction, initHp);
        image = new GreenfootImage("BeefyBandit.png");
        getImage().scale(80, 82);
        
        // testing
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

    
    public void act()
    {
        super.act();
    }
    
    public void die(){
        getWorld().addObject(new DeathEffect("BanditDead.png", direction), getX(), getY());
        removeSelf();
        
    }
    
    // unnecessary method
    public void getHit(){
        Actor projectile = getOneIntersectingObject(Projectile.class);
        if (projectile != null){
            hp = hp-1;
            getWorld().removeObject(projectile);
        }
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
            CrystalTower c = ((MyWorld)getWorld()).getTargettedCrystal(direction);
            if (attackingTower && getDistance(c) <= attackRange){
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