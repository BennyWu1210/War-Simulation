import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndWorld extends World
{
    private GreenfootImage backgroundImage;
    /**
     * Constructor for objects of class EndWorld.
     * 
     */
    
    public EndWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
         super(1200, 700, 1); 
        backgroundImage = new GreenfootImage("endWorldBack.png");
        backgroundImage.scale(1200, 700);
        setBackground(backgroundImage);
        prepare();
        
    }
    
    private void prepare(){
        PlayAgainButton pb = new PlayAgainButton();
        addObject(pb,595,500);
        
        ExitButton eb = new ExitButton();
        addObject(eb,595,600);
    }
}
