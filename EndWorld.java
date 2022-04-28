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
    private int status;
    public EndWorld(int status)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 700, 1); 
        this.status=status;
        backgroundImage = new GreenfootImage("endWorldBack.png");
        backgroundImage.scale(1200, 700);
        setBackground(backgroundImage);
        prepare();
        
        if(status==0){
            Label tie = new Label("Tie", 100);
            addObject(tie, 595, 200);
        }
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
    
    private void prepare(){
        PlayAgainButton pb = new PlayAgainButton();
        addObject(pb,595,500);
        
        ExitButton eb = new ExitButton();
        addObject(eb,595,600);
        
        
    }
}
