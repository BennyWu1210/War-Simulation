import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Arrow here.
 * 
 * @author Benny
 * @version April 25th, 2022
 */
public class Arrow extends Projectile
{
    
    
    public Arrow(Soldier target){
        super(target);
        this.image = new GreenfootImage("arrow.png");
        this.speed = 8;
        this.targetX = target.getX();
        this.targetY = target.getY();
        getImage().scale(30, 30);
    }
    
    public Arrow(CrystalTower crystal){
        super(crystal);
        this.image = new GreenfootImage("arrow.png");
        this.speed = 8;
        this.targetX = crystal.getX();
        this.targetY = crystal.getY();
        getImage().scale(30, 30);
    }
    
    public void addedToWorld(){
        super.addedToWorld();
    }
    
    public void act()
    {
        if (target == null || target.getWorld() == null){
            move(targetX, targetY);
        } else if (crystal != null){
            move(targetX, targetY);
            turnTowards(crystal);
        } else{
            move(target);
            turnTowards(target);
            targetX = target.getX();
            targetY = target.getY();
        }
        
        if (getDistance(targetX, targetY) <= 6){
            if (target == null || target.getWorld() == null) getWorld().addObject(new ArrowHitEffect(), getX(), getY());
            else {
                if (crystal != null) crystal.getHit(10, null);
                else target.getHit(10, new ArrowHitEffect());
            }
            getWorld().removeObject(this);
            return;
        }
        
        
        
        // Add your action code here.
    }
    

}
