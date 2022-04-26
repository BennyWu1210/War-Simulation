import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tower here.
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
    public Tower(int direction){
        super(direction);
        this.direction = direction;

    }
    
    public void addedToWorld(World w){
        super.addedToWorld(w);
        
        w.addObject(hpBar, getX(), getY());
        hpBar.initLevel(1, 30);
    }
    public void act()
    {
        // Add your action code here.
    }
    public int getDirection(){
        return direction;
    }
}
