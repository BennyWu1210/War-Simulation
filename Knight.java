import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Knight here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Knight extends Soldier
{
    private static final int initHp = 80;
    public Knight (int direction, Statistic worldStat)
    {
        super(direction, initHp, worldStat);
        image = new GreenfootImage("Knight.png");
        getImage().scale(50, 52);
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
    
    
}
