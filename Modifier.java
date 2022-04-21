import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Modifier here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Modifier extends World
{

    /**
     * Constructor for objects of class Modifier.
     * 
     */
    private GreenfootImage backgroundImage;
    private int count=0;
    private int newCount=0;
    private int timeValue=0;
    public Modifier()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 
         backgroundImage = new GreenfootImage("Modifer.png");
        backgroundImage.scale(1000, 600);
        setBackground(backgroundImage);
        
        prepare();
        
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    public void act()
    {
        input();
    
    
    }
    
    private void prepare()
    {
        BackButton backButton = new BackButton();
        addObject(backButton,71,53);

    }
    
    public void input(){
        if (Greenfoot.isKeyDown("1") ){
            //count=newCount;
            Label one = new Label(1, 40);
            addObject(one, 380+count*30, 220);
            count++;
           
            
            
        }
        
            
           
    }
}
