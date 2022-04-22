import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Soldiers here.
 * 
 * @author Benny Wu, Angus
 * @version (a version number or a date)
 */
public abstract class Soldier extends Entity
{
    
    //Are you a left side soldier or right side soldier
    protected int side;
    protected StatBar hpBar;
    protected int hp;
    protected int maxHP = 5;

    protected int mySpeed = 10;
    protected int myAge;
    
    protected int timer = 0;
    protected int timerTest = 30;
    /**
     * Act - do whatever the Soldiers wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Soldier(int direction, int maxHP)
    {
        super(direction);
        this.direction = direction; 
        this.side = direction;
        this.hp = this.maxHP = maxHP;
    }
    
    
       
    public void addedToWorld(World w){
        super.addedToWorld();
        hpBar.initLevel(1, 15);
        w.addObject(hpBar, getX(), getY());
    }
    
    public void act()
    {
        move (1*direction);
        if (isAtEdge()){
            getWorld().removeObject(this);
        }
        timer++;
        hpBar.update(hp);
        if (timer == timerTest){
            hp -= 10;
            timer = 0;
        }
        if (hp <= 0){
            this.isDead();
        }
    }
    public int getSide(){
        return side;
    }
    protected boolean touchSoldier(){
        return true;
    }
    //reminder to make this abstract
    public void isDead(){
        getWorld().addObject(new DeathEffect("BanditDead.png", direction), getX(), getY());
        getWorld().removeObject(this);
    }
}
