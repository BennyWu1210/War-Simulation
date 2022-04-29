import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Fireball is the projectile of the crystal and Inferno tower. 
 * It deals the most damage out of the 3 projectiles
 * 
 * @author Benny, Kevin Zhu
 * @version April 28th, 2022
 */
public class Fireball extends Projectile
{
    
    // Creates the sound effect for this fireball
    private GreenfootSound sound;
    private static int totalFireball; // keep track of the total amount of fireball to avoid too much sound
    
    /**
    * This creates a new instance of Fireball
    * 
    * @param target  Pass in the target as a soldier
    */
    public Fireball(Soldier target){
        // calls super constructor
        super(target);
        
        // sets the image and movement properties
        this.image = new GreenfootImage("flame02.gif");
        this.speed = 9;
        this.targetX = target.getX();
        this.targetY = target.getY();
        getImage().scale(30, 30);
        
        // initialize the sound effect
        if (totalFireball < 5){
            sound = new GreenfootSound("Fireball_sound.mp3");
            sound.setVolume(27);
        }
        
        // increment the total number of fireball
        totalFireball ++;
    }
    
    /**
     * This calls its parent's addedToWorld() in order to flip the image according to its direction
     */
    public void addedToWorld(World w){
        super.addedToWorld(w);
    }
    
    /**
     * The act method for Fireball:
     * 
     * Mainly responsible for controlling its movement and check whether it is removed from the world
     */
    
    public void act()
    {
        // play the sound effect
        if (sound != null) sound.play();
        
        // move toward its targetted position
        if (target == null || target.getWorld() == null){
            move(targetX, targetY);
        } else{
            move(target);
            turnTowards(target); // ensure that it faces the target at all time
            targetX = target.getX();
            targetY = target.getY();
        }
        
        // Check whether it hits its target
        if (getDistance(targetX, targetY) <= 6){
            
            if (target == null || target.getWorld() == null){
                // remove itself from the world
                getWorld().addObject(new BombEffect(), getX(), getY());
                getWorld().removeObject(this);
                totalFireball --;
                return;
            }
            
            // check for intersecting enemies (splash damage)
            int direction = target.getDirection();
            List<Soldier> soldiers = getIntersectingObjects(Soldier.class);
            
            for (Soldier s: soldiers){
                if (direction != target.getDirection()) continue;
                s.getHit(6, null);
            }
            
            // Create a new explosion effect
            soldiers.get(0).getHit(19, new BombEffect());
            
            // remove itself from the world
            getWorld().removeObject(this);
            totalFireball --;
            return;
        }
        
    }
    

}
