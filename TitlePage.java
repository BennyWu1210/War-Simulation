import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BeginningPage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitlePage extends World
{

    /**
     * Constructor for objects of class BeginningPage.
     * 
     */
    public Modifier mw;
    public MyWorld mworld;
    private static GreenfootImage backgroundImage = new GreenfootImage("BeginningPage.jpg");
    public TitlePage()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 700, 1); 
        mw=new Modifier(this);
        
        backgroundImage.scale(1200, 700);
        setBackground(backgroundImage);

        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        StartButton startButton = new StartButton(this);
        addObject(startButton,600,400);

        SettingButton settingButton = new SettingButton(this);
        addObject(settingButton,1130,650);
        
    }
    
    public void openModifier(){
        Greenfoot.setWorld(mw);
    }
    
    
    public void startGame(){
        Greenfoot.setWorld(new MyWorld(mw));
    }
   
}
