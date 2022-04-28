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
    
    public Arrow(Tower tower){
        
        super(tower);
        System.out.println("BRUHADFUHDS");
        this.image = new GreenfootImage("arrow.png");
        this.speed = 8;
        this.targetX = tower.getX();
        this.targetY = tower.getY();
        getImage().scale(30, 30);
    }
    
    public void addedToWorld(World w){
        super.addedToWorld(w);
    }
    
    public void act()
    {
        if (target == null || target.getWorld() == null){
            move(targetX, targetY);
        } else if (tower != null){
            move(targetX, targetY);
            turnTowards(tower);
        } else{
            move(target);
            turnTowards(target);
            targetX = target.getX();
            targetY = target.getY();
        }
        
        if (getDistance(targetX, targetY) <= 6){
            if (tower == null && (target == null || target.getWorld() == null)) getWorld().addObject(new ArrowHitEffect(), getX(), getY());
            else {
                if (tower != null) tower.getHit(15, null);
                else target.getHit(15, new ArrowHitEffect());
            }
            getWorld().removeObject(this);
            return;
        }
        
        
        
        // Add your action code here.
    }
    

}
