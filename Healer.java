import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Healer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Healer extends Soldier
{
    private static final int initHp = 70;
    public Healer (int direction, Statistic worldStat)
    {
        super(direction, initHp, worldStat);
        image = new GreenfootImage("Healer.png");
        getImage().scale(50, 52);
        
        
        // testing
        this.speed = 1.2;
        this.attackSpeed = 4;
        this.attackRange = 200;
        this.damage = 3;
        this.triggerRange = 270;
        this.deathGold = 15;
        
        // intialize hp bar
        if (direction == 1) hpBar = new StatBar(initHp, initHp, this, 30, 5, 35, Color.RED, new Color(255, 204, 203), false, Color.WHITE, 1);
        else hpBar = new StatBar(initHp, initHp, this, 30, 5, 35, Color.CYAN, new Color(202, 255, 255), false, Color.BLACK, 1);
        // hpBar.initLevel(1, 10);
    }
 
    
    public void act()
    {
        super.act();
        
        
    }
    
    /*
    public void attack(){
        
    }
    */
    public void die(){
        if (this == null || this.getWorld() == null) return;
        this.getWorld().addObject(new DeathEffect("GrayKnightDead.png", direction), getX(), getY());
        removeSelf();
        
    }
    public void getHit(){
        Actor projectile = getOneIntersectingObject(Projectile.class);
        if (projectile != null){
            hp = hp-4;
            getWorld().removeObject(projectile);
        }
    }
    
    public void attack(){
        if (target == null || target.getWorld() == null){
            List<Soldier> soldiers = getObjectsInRange((int)this.triggerRange, Soldier.class);
        
            if (soldiers.size() != 0){
                int index = 0;
                
                while (index < soldiers.size()){
                    Soldier nxt = soldiers.get(index);
                    if (nxt.getClass() != this.getClass()){
                        target = nxt;
                        break;
                    }
                    index ++;
                }
            }
        
        } else{
            if (getDistance(target) <= attackRange){
                if (target.getDirection() == this.getDirection()){
                    HealProjectile a = new HealProjectile(target, false);
                    getWorld().addObject(a, getX(), getY());
                } else{
                    HealProjectile a = new HealProjectile(target, true);
                    getWorld().addObject(a, getX(), getY());
                }
            }
        }
    }
}
