import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A death effect that deletes the referenced actor and replaces it with a png in the project files.
 *
 * @author Angus Feng
 * @version ?
 */
public class DeathEffect extends Effect
{
    // defines directory of the image and direction of this effect
    private String file;
    private int direction;
    
    /**
     * Constructor for DeathEffect
     */
    public DeathEffect (String file, int direction){
        // calls super constructor
        super(200);
        this.file = file;
        this.direction = direction;
        
        // Sets image
        image = new GreenfootImage(file);
        setImage(image);
        
        
    }
    
    /**
     * Flips the image if it is facing in the negative direction
     */
    public void addedToWorld(){
        if (direction == -1) getImage().mirrorHorizontally();
    }

}