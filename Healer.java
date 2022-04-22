import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Healer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Healer extends Soldier
{
    private static final int initHp = 40;
    public Healer (int direction)
    {
        super(direction, initHp);
        image = new GreenfootImage("Healer.png");
        getImage().scale(50, 52);
        
        // intialize hp bar
        if (direction == 1) hpBar = new StatBar(100, 100, this, 30, 5, 35, Color.RED, new Color(255, 204, 203), false, Color.WHITE, 1);
        else hpBar = new StatBar(100, 50, this, 30, 5, 35, Color.CYAN, new Color(202, 255, 255), false, Color.BLACK, 1);
        hpBar.initLevel(1, 10);
    }
 
    
    public void act()
    {
        super.act();
    }
    public void isDead(){
        getWorld().addObject(new DeathEffect("GrayKnightDead.png", direction), getX(), getY());
        getWorld().removeObject(this);
        
    }
    public void getHit(){
        Actor projectile = getOneIntersectingObject(Projectile.class);
        if (projectile != null){
            hp = hp-4;
            getWorld().removeObject(projectile);
        }
    }
}
