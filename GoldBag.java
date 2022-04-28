import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * A death effect that deletes the referenced actor and replaces it with a png in the project files.
 *
 * @author Angus Feng
 */
public class GoldBag extends Effect
{
    // defines directory of the image and direction of this effect
    private String file;
    private int direction;
    
    /**
     * Constructor for GoldBag
     */
    public GoldBag (){
        // calls super constructor
        super(500, false);
        direction = 1;
        
        // Sets image
        image = new GreenfootImage("goldbag.png");
        setImage(image);
        getImage().scale(100, 69);
        
    }
    
    public void addedToWorld(){
        if (direction == -1) getImage().mirrorHorizontally();
    }
    
    /**
     * Act method for GoldBag
     */
    public void act()
    {
        checkPickedUp();
    }
    
    /**
     * Check if it has been picked up
     */
    public void checkPickedUp(){
        List<Soldier> enemies = getObjectsInRange(120, Soldier.class);
        Soldier s = null;
        if (enemies.size() != 0 ){
             s = enemies.get(0);
        }
            
        if (s!= null && s.hasFullHealth()){
            //possibly add  gold effect
            
            getWorld().removeObject(this);
        }
    }
}