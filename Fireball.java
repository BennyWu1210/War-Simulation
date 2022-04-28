import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Arrow here.
 * 
 * @author Benny
 * @version April 27th, 2022
 */
public class Fireball extends Projectile
{
    
    
    public Fireball(Soldier target){
        super(target);
        this.image = new GreenfootImage("flame02.gif");
        this.speed = 8;
        this.targetX = target.getX();
        this.targetY = target.getY();
        getImage().scale(30, 30);
    }
    
    
    public void addedToWorld(){
        super.addedToWorld();
    }
    
    public void act()
    {
        if (target == null || target.getWorld() == null){
            move(targetX, targetY);
        } else{
            move(target);
            turnTowards(target);
            targetX = target.getX();
            targetY = target.getY();
        }
        
        if (getDistance(targetX, targetY) <= 6){
            if (target == null || target.getWorld() == null) getWorld().addObject(new ArrowHitEffect(), getX(), getY());
            else {
                target.getHit(15, new ExplosionEffect());
            }
            getWorld().removeObject(this);
            return;
        }
        
        
        
        // Add your action code here.
    }
    

}
