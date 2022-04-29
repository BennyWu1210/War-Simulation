import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * The healer heals its allies and attacks its enemies while shooting different projectiles! 
 * She is very useful in the team
 * 
 * 
 * @author Benny Wu, Angus Feng, Caleb, Kevin Zhu
 * @version April 28th, 2022
 */
public class Healer extends Soldier
{
    // creates the class-wide initial health for Healer
    private static final int initHp = 70;
    
    /**
     * Creates a new Healer with a given direction
     * 
     * @param direction  the direction this Healer is facing
     */
    public Healer (int direction)
    {
        // calls super constructor
        super(direction, initHp);
        
        // sets image for healer
        image = new GreenfootImage("Healer.png");
        getImage().scale(50, 52);
        
        
        // sets all the properties for this beefy healer
        this.speed = 1.2;
        this.attackSpeed = 4;
        this.attackRange = 200;
        this.damage = 8;
        this.triggerRange = 400;
        this.deathGold = 15;
        
        // intialize hp bar
        if (direction == 1) hpBar = new StatBar(initHp, initHp, this, 30, 5, 35, Color.RED, new Color(255, 204, 203), false, Color.WHITE, 1);
        else hpBar = new StatBar(initHp, initHp, this, 30, 5, 35, Color.CYAN, new Color(202, 255, 255), false, Color.BLACK, 1);
    }

    
    /**
     * The die method for Healer: 
     * 
     * It leaves a corpse behind and remove itself from the world
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
    
    
    /**
     * The attack method for Healer
     * 
     * It uses a sword with special effects to attack its target
     */
    public void attack(){
        if (!attackingTower && (target == null || target.getWorld() == null)){
            CrystalTower c = ((MyWorld)getWorld()).getTargettedCrystal(this.direction);
            if (getDistance(c) <= this.triggerRange * 1.25){
                attackingTower = true;
                targetTower = c;
            }
            else{
                // get a list of enemy objects within its range
                List<Soldier> enemies = getObjectsInRange((int)this.triggerRange, Soldier.class);
            
                if (enemies.size() != 0){
                    int index = 0;
                    
                    while (index < enemies.size()){
                        Soldier nxt = enemies.get(index);
                        if (nxt.getClass() != this.getClass()){
                            // found new target
                            target = nxt;
                            break;
                        }
                        index ++;
                    }
                }
            }
        
        } else{
            // Otherwise, attack the current tower/target
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
