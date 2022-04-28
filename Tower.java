import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The tower is a non-moving entity. They attack soldiers that go near them.
 * There are 4 types of towers: the archer tower, the crytal tower, the inferno
 * tower and the gold mine.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */


public abstract class Tower extends Entity
{
    /**
     * Act - do whatever the Tower wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    protected StatBar hpBar;
    protected int hp, maxHp;
    protected double attackSpeed, attackRange, triggerRange, damage;
    public Tower(int direction){
        super(direction);
        this.direction = direction;

    }
    //add health bar
    public void addedToWorld(World w){
        super.addedToWorld(w);
        
        w.addObject(hpBar, getX(), getY());
        hpBar.initLevel(1, 30);
    }
    public void act()
    {
        this.hp -= 1;
        hpBar.update(hp);
        //the towers are removed once the hp reaches 0
        if (this.hp <= 0){
            getWorld().removeObject(this);
        }
    }
    public int getDirection(){
        return direction;
    }
    //this method makes the towers lose hp when they are hit
    public void getHit(double hp, Effect effect){
        
        this.hp -= hp;
        
        hpBar.update((int)this.hp);
        
        if (effect != null){
            getWorld().addObject(effect, getX(), getY());
        }
        
        if (hp <= 0){
            // implement lose feature>
            getWorld().removeObject(this);
        }
    }
    
    public double getHpPercentage(){
        return (double)this.hp / this.maxHp;
    }
}
