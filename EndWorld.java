import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndWorld here.
 * This is world will be appeared when the game is finished
 * @author (Kevin Zhu, Benny Wu) 
 * @version (April 28, 2022)
 */
public class EndWorld extends World
{
    private GreenfootImage backgroundImage;
    private int status;
    /**
     * Constructor for objects of class EndWorld (End screen)
     * 
     * @param status  this paremeter determines the result of the game
     */
    public EndWorld(int status)
    {    
        // Create a new world with 1200x700 cells with a cell size of 1x1 pixels.
        super(1200, 700, 1); 
        
        // initialize the variable
        this.status=status;
        backgroundImage = new GreenfootImage("endWorldBack.png");
        backgroundImage.scale(1200, 700);
        setBackground(backgroundImage);
        prepare();

        //set the label on the screen
        if(status==1){
            Label RedWin = new Label("RED WIN", 100);
            RedWin.setFillColor(Color.RED);
            addObject(RedWin, 595, 200);
        }
        if(status==2){
            Label BlueWin = new Label("BLUE WIN", 100);
            BlueWin.setFillColor(Color.BLUE);
            addObject(BlueWin, 595, 200);
        }
    }
    
    /**
     * This method initializes all the necessary buttons onto the screen, including
     * the play again button and the exit button
     */
    public void prepare(){
        PlayAgainButton pb = new PlayAgainButton();
        addObject(pb,595,500);
        
        ExitButton eb = new ExitButton();
        addObject(eb,595,600);
    }
}