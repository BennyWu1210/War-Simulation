import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Arrow here.
 * 
 * @author Benny
 * @version April 27th, 2022
 */
public class HealProjectile extends Projectile
{
    private Soldier target;
    private int targetX, targetY;
    private boolean isEnemy;
    public HealProjectile(Soldier target, boolean isEnemy){
        super(target);
        this.isEnemy = isEnemy;
        String file = isEnemy ? "healProjectile02.png" : "healProjectile.png";
        this.image = new GreenfootImage(file);
        this.speed = 5;
        this.target = target;
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
        
        if (getDistance(targetX, targetY) <= 4){
            if (target != null && target.getWorld() == null) {
                if (!isEnemy && !target.hasFullHealth()){
                    target.heal(15);
                } else{
                    target.getHit(15, null);
                }
            }
            
            getWorld().addObject(new HealingEffect(), getX(), getY());
            getWorld().removeObject(this);
            return;
        }
        
        
        
        // Add your action code here.
    }
    

}
