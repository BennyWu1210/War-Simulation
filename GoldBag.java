import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
        super(200);
        this.file = file;
        this.direction = direction;
        image = new GreenfootImage(file);
        setImage(image);
        
        
    }
    
    public void addedToWorld(){
        if (direction == -1) getImage().mirrorHorizontally();
    }
    
    public void act()
    {
        super.act();
    }
}