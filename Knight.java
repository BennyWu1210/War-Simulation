import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Knight here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Knight extends Soldier
{
    private static final int initHp = 130;
    public Knight (int direction)
    {
        super(direction, initHp);
        image = new GreenfootImage("Knight.png");
        getImage().scale(50, 52);
        
        // testing
        this.speed = 1.5;
        this.attackSpeed = 5;
        this.attackRange = 30;
        this.damage = 15;
        this.triggerRange = 300;
        this.deathGold = 2;
        
        // intialize hp bar
        if (direction == 1) hpBar = new StatBar(100, 100, this, 32, 5, 35, Color.RED, new Color(255, 204, 203), false, Color.WHITE, 1);
        else hpBar = new StatBar(100, 100, this, 32, 5, 35, Color.CYAN, new Color(202, 255, 255), false, Color.BLACK, 1);
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
        this.getWorld().addObject(new DeathEffect("GrayKnightDead.png", direction), getX(), getY());
        removeSelf();
        
    }
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
                c.getHit(this.damage, new SwordHitEffect());
            }
            else if (target != null && target.getWorld() != null && getDistance(target) <= attackRange){
                target.getHit(this.damage, new SwordSwingEffect());
            }
        }
        
    }
    
    
}


