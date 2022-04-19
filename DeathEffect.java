import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A death effect that deletes the referenced actor and replaces it with a png in the project files.
 *
 *
 */
public class DeathEffect extends Effect
{
    private String file;
    public DeathEffect (String file){
        super(200);
        this.file = file;
        image = new GreenfootImage(file);
        setImage(image);
    }
    public void act()
    {
        super.act();
    }
}