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
        this.triggerRange = 400;
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
           
            if (attackingTower && getDistance(targetTower) <= attackRange){
                HealProjectile a = new HealProjectile(targetTower);
                getWorld().addObject(a, getX(), getY());
            }
            else if (target != null && target.getWorld() != null && getDistance(target) <= attackRange){
                HealProjectile a = new HealProjectile(target, target.getDirection() != this.getDirection());
                getWorld().addObject(a, getX(), getY());
            }
        }
    }
}
