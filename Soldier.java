import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Soldiers here.
 * 
 * @author Benny Wu, Angus
 * @version (a version number or a date)
 */
public abstract class Soldier extends Entity
{
    
    //Are you a left side soldier or right side soldier
    protected int side;
    protected StatBar hpBar;
    protected int hp;
    protected int maxHP = 100; // temporary variable

    protected int mySpeed = 10;
    protected int myAge;
    
    protected int timer = 0; 
    protected int timerTest = 30;
    
    // attack variables
    protected double attackSpeed, attackRange, triggerRange, damage;
    
    protected int deathGold;
    protected Statistic worldStat;
    
    protected boolean attackingCrystal;
    /**
     * Act - do whatever the Soldiers wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Soldier(int direction, int maxHP, Statistic worldStat)
    {
        super(direction);
        this.direction = direction; 
        this.side = direction;
        this.hp = this.maxHP = maxHP;
        
        // testing
        this.speed = 1.2;
        this.attackSpeed = 3;
        this.attackRange = 40;
        this.damage = 15;
        
        this.deathGold = 5;
        this.worldStat = worldStat;
    }
    

    public void addedToWorld(World w){
        super.addedToWorld();
        w.addObject(hpBar, getX(), getY());
        hpBar.initLevel(1, 17);
    }
    
    public void act()
    {
        
        CrystalTower c = ((MyWorld)getWorld()).getTargettedCrystal(direction);
        if (timer % (200.0 / attackSpeed) == 0) attack();
        
        if (attackingCrystal && getDistance(c) > attackRange - 3){
            move(c);
        } 
        else if (!attackingCrystal){
            if (target == null || target.getWorld() == null){
                move((int)((speed + 0.5) * direction));
            } else if (getDistance(target) > attackRange - 3){
                move(target);
            } 
        }
        
        if (isAtEdge()){
            getWorld().removeObject(this);
            return;
        }
        timer++;
        // hpBar.update(hp);
        /*
        if (timer == timerTest){
            hp -= 10;
            timer = 0;
        }
        */
        if (hp <= 0){
            worldStat.updateGold(deathGold);
            worldStat.updateKills();
            die();
            return;
        }
        
        
    }
    
    /**
     * Abstract attack method
     */
    // public abstract void attack();
    // for testing purposes
    public void attack(){
        if (target == null || target.getWorld() == null){
            List<Soldier> enemies = getObjectsInRange(100, Soldier.class);
        
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
        
        } else{
            if (getDistance(target) <= attackRange){
                target.getHit(this.damage, null);
            }
        }
        
    }
    public void getHit(double hp, Effect effect){
        
        this.hp -= hp;
        
        hpBar.update((int)this.hp);
        
        if (effect != null){
            getWorld().addObject(effect, getX(), getY());
        }
        
    }
    public void goldBagUpdate(){
        worldStat.updateGold(50);
    }
    
    
    /**
     * Returns direction of this soldier
     */
    public int getDirection(){
        return this.direction;
    }
    
    public int getSide(){
        return side;
    }
    
    protected boolean touchSoldier(){
        //wat dis code?
        return true;
    }
    
    //reminder to make this abstract
    
    public void die(){
        
        this.getWorld().addObject(new DeathEffect("BanditDead.png", direction), getX(), getY());
        removeSelf();
    }
    
    public void removeSelf(){
        getWorld().removeObject(this);
    }
    
    public boolean hasFullHealth(){
        return this.hp == this.maxHP;
    }
    
    public void heal(double hp){
        if (this.hp + hp >= this.maxHP) this.hp = this.maxHP;
        else this.hp += hp;
        
        hpBar.update(this.hp);
    }
    

}
