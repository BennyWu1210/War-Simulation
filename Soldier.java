import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * The soldier is a moving entity that has special possess various attack abilities
 * depending on its type. There are 4 types of soldiers: Bandit, BeefyBandit, Healer and Knight
 * 
 * @author Benny Wu, Angus, Caleb, Kevin Zhu
 * @version April 28th, 2022
 */
public abstract class Soldier extends Entity
{
    
    // The fundamental properties of the sodlier class
    protected int side; //Are you a left side soldier or right side soldier
    protected StatBar hpBar;
    protected int hp, maxHp = 100, level, myAge, mySpeed = 10, deathGold;

    // variables that keep track of its ticks
    protected int timer = 0, timerTest; 
    
    // variables that controls its movement and attack abilities
    protected double attackSpeed, attackRange, triggerRange, damage;

    // variables that defines its target tower
    protected boolean attackingTower;
    protected Tower targetTower;
    
    /**
     * The superclass for all the NPC's inside the game. They share common features such as attacking, dying, getting hit, having health bars, etc.
     * Hence, we put them under the Soldier class.
     * 
     * @direction  the direction this sodlier is facing  
     * @maxHp  the maximum health of this soldier
     */
    public Soldier(int direction, int maxHp)
    {
        //Passes the direction to the Entity class
        super(direction);
        this.direction = direction; 
        this.side = direction;
        this.hp = this.maxHp = maxHp;
        
        // the default movement properties for all soldiers (can be overwritten)
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
        // Adding an HP Bar
        w.addObject(hpBar, getX(), getY());
        // Adding a level bar
        hpBar.initLevel(1, 17);
    }
    
    /**
     * Sodlier's act method - mainly responsible for the movement and attack of all soldiers
     */
    public void act()
    {
        
        // Every 200 acts, the soldier attacks -- adjusted with the attack speed variable
        if (timer % (200.0 / attackSpeed) == 0) attack();
        
        // If you are set to attack the Crystal and are closer to the Crystal than any other enemy, move towards the Crystal
        if (attackingTower && getDistance(targetTower) > attackRange - 3) move(targetTower);
        else if (!attackingTower){ //If you are not set to attack the tower and have no soldier target, just move forward
            if (target == null || target.getWorld() == null){
                move((int)((speed + 0.5) * direction));
                
                // controls the direction of this image
                if (direction == -1) {
                    if (!faceLeft) getImage().mirrorHorizontally();
                    faceLeft = true;
                }
                else {
                    if (faceLeft) getImage().mirrorHorizontally();
                    faceLeft = false;
                }
            }
            
            //If you have a target, move towards the target
            else if (getDistance(target) > attackRange - 3){
                move(target);
            } 
        }
        
        // remove this object if it touches the edge (reduces uneccessary memory)
        if (isAtEdge()){
            getWorld().removeObject(this);
            return;
        }
        timer++;
        
        // If you are dead, update the Statistic bar (the bar at the top displaying gold and kill count
        // Different soldiers give different gold, denoted by the deathGold variable
        // All soldiers give one kill
        if (hp <= 0){
            ((MyWorld)getWorld()).updateStatistic(direction, deathGold);
            die();
            return;
        }
        
        // Every 600 acts, level up
        // Leveling up increases stats 
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
    public abstract void attack();
    
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
    
    
    /**
     * Returns which side you are on
     */
    public int getSide(){
        return side;
    }
    
    
    /**
     * Remove this object from the world along with a corpse
     */
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
     * Return true if you have full health, false otherwise
     */
    
    public boolean hasFullHealth(){
        return this.hp == this.maxHp;
    }
    
    /**
     * Heal the object being called on, used by the "Healer" soldier
     */
    public void heal(double hp){
        if (this.hp + hp >= this.maxHp) this.hp = this.maxHp;
        else this.hp += hp;
        
        hpBar.update(this.hp);
    }
    

}
