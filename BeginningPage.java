import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BeginningPage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BeginningPage extends World
{

    /**
     * Constructor for objects of class BeginningPage.
     * 
     */
    private GreenfootImage backgroundImage;
    public BeginningPage()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 
        backgroundImage = new GreenfootImage("BeginningPage.jpg");
        backgroundImage.scale(1000, 600);
        setBackground(backgroundImage);

        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        StartButton startButton = new StartButton();
        addObject(startButton,500,450);

       
    }
}
