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
    protected int level;
    
    // attack variables
    protected double attackSpeed, attackRange, triggerRange, damage;
    
    protected int deathGold;
    //protected Statistic worldStat;
    
    protected boolean attackingTower;
    protected Tower targetTower;
    /**
     * The superclass for all the NPC's inside the game. They share common features such as attacking, dying, getting hit, having health bars, etc.
     * Hence, we put them under the Soldier class.
     */
    public Soldier(int direction, int maxHP)
    {
        //Passes the direction to the Entity class
        super(direction);
        this.direction = direction; 
        this.side = direction;
        this.hp = this.maxHP = maxHP;
        
        // testing
        this.speed = 1.2;
        this.attackSpeed = 3;
        this.attackRange = 40;
        this.damage = 15;
        this.level = 1;
        this.deathGold = 5;
        
    }
    /**
     * Calls the Entity addedTowWorld method which flips the image if "direction" = -1
     */
    
    public void addedToWorld(World w){
        super.addedToWorld(w);
        //Adding an HP Bar
        w.addObject(hpBar, getX(), getY());
        //Adding a level bar
        hpBar.initLevel(1, 17);
    }
    
    public void act()
    {
        
        //Every 200 acts/ attack. Adjusted with the attack speed variable
        if (timer % (200.0 / attackSpeed) == 0) attack();
        
        //If you are set to attack the Crystal and are closer to the Crystal than any other enemy, move towards the Crystal
        if (attackingTower && getDistance(targetTower) > attackRange - 3){
            move(targetTower);
        } 
        //If you are not set to attack the tower and have no soldier target, just move forward
        else if (!attackingTower){
            if (target == null || target.getWorld() == null){
                move((int)((speed + 0.5) * direction));
            //If you have a target, move towards the target
            } else if (getDistance(target) > attackRange - 3){
                move(target);
            } 
        }
        
        if (isAtEdge()){
            getWorld().removeObject(this);
            return;
        }
        timer++;
        
        //If you are dead, update the Statistic bar (the bar at the top displaying gold and kill count
        //Different soldiers give different gold, denoted by the deathGold variable
        //All soldiers give one kill
        if (hp <= 0){
            ((MyWorld)getWorld()).updateStatistic(direction, deathGold);
            die();
            return;
        }
        
        //Every 600 acts, level up
        //Leveling up increases stats 
        if (timer % 600 == 0){
            //The font also becomes bigger
            hpBar.initLevel(++level, 17 + level * 2);
            this.speed *= 1.2;
            this.damage *= 1.2;
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
    /**
     * Calling this method on an object decreases it's health by the parameter and spawns an effect like a sword slash or blood
     */
    
    public void getHit(double hp, Effect effect){
        
        this.hp -= hp;
        
        hpBar.update((int)this.hp);
        
        if (effect != null){
            getWorld().addObject(effect, getX(), getY());
        }
        
    }
    public void goldBagUpdate(){
        //worldStat.updateGold(50);
    }
    
    
    /**
     * Returns direction of this soldier
     */
    public int getDirection(){
        return this.direction;
    }
    
    /**
     * Returns which side you are on
     */
    public int getSide(){
        return side;
    }
    
    
    
    //reminder to make this abstract
    
    public void die(){
        
        this.getWorld().addObject(new DeathEffect("BanditDead.png", direction), getX(), getY());
        removeSelf();
    }
    /**
     * Remove yourself from the world
     */
    public void removeSelf(){
        getWorld().removeObject(this);
    }
    /**
     * Return true if you have full health
     */
    public boolean hasFullHealth(){
        return this.hp == this.maxHP;
    }
    /**
     * Heal the object being called on, used by the "Healer" soldier
     */
    public void heal(double hp){
        if (this.hp + hp >= this.maxHP) this.hp = this.maxHP;
        else this.hp += hp;
        
        hpBar.update(this.hp);
    }
    

}
