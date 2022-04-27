import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * A death effect that deletes the referenced actor and replaces it with a png in the project files.
 *
 *
 */
public class GoldBag extends Effect
{
    private String file;
    private int direction;
    
    public GoldBag (){
        super(500, false);
        direction = 1;
        image = new GreenfootImage("goldbag.png");
        setImage(image);
        getImage().scale(100, 69);
        
    }
    
    public void addedToWorld(){
        if (direction == -1) getImage().mirrorHorizontally();
    }
    
    public void act()
    {
        
        checkPickedUp();
    }
    public void checkPickedUp(){
        List<Soldier> enemies = getObjectsInRange(120, Soldier.class);
        Soldier s = null;
        if (enemies.size() != 0 ){
             s = enemies.get(0);
        }
            
        if (s!= null && s.hasFullHealth()){
            //possibly add a gold effect
            s.goldBagUpdate();
            getWorld().removeObject(this);
        }
    }
}