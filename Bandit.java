import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bandit here.
 * 
 * @author Benny Wu
 * @version (a version number or a date)
 */
public class Bandit extends Soldier
{
    private int test = 0;
    private static final int initHp = 50;
    public Bandit (int direction)
    {
        // calls super constructor
        super(direction, initHp);
        setImage("Bandit.png");
        image = new GreenfootImage("Bandit.png");
        getImage().scale(50, 52);
        
        // intialize hp bar
        if (direction == 1) hpBar = new StatBar(100, 100, this, 30, 5, 35, Color.RED, new Color(255, 204, 203), false, Color.WHITE, 1);
        else hpBar = new StatBar(100, 80, this, 30, 5, 35, Color.CYAN, new Color(202, 255, 255), false, Color.BLACK, 1);
        hpBar.initLevel(1, 10);
    }
    
    public void act()
    {
        super.act();
    }
    public void isDead(){
        getWorld().addObject(new DeathEffect("BanditDead.png"), getX(), getY());
        getWorld().removeObject(this);
        
    }
    public void getHit(){
        Actor projectile = getOneIntersectingObject(Projectile.class);
        if (projectile != null){
            hp = hp-2;
            getWorld().removeObject(projectile);
        }
    }
}
