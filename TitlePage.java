import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 *
 * The title page is the starting page of the whole program.
 * 
 * @author Kevin Zhu, Benny Wu
 * @version April 28, 2022
 */
public class TitlePage extends World
{
    //initialize the variable
    private Modifier mw;
    private MyWorld mworld;
    
    private static GreenfootImage backgroundImage = new GreenfootImage("BeginningPage.jpg");
    /**
     * Constructor for TitlePage - sets the screen size and creates the background
     * 
     */
    public TitlePage()
    {    
        // Create a new world with 1200x700 cells with a cell size of 1x1 pixels.
        super(1200, 700, 1); 
        
        //initialize the variable
        mw = new Modifier(this);
        backgroundImage.scale(1200, 700);
        setBackground(backgroundImage);

        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * Specifically, it creates the initial objects and add them to the world.
     */
    private void prepare()
    {
        StartButton startButton = new StartButton(this);
        addObject(startButton,600,400);

        SettingButton settingButton = new SettingButton(this);
        addObject(settingButton,1130,650);
    }
    
    /**
     * This method switches the current world to the modifier
     */
    public void openModifier(){
        Greenfoot.setWorld(mw);
    }
    
    /**
     * This method starts the simulation
     */
    public void startGame(){
        Greenfoot.setWorld(new MyWorld(mw));
    }
   
}
