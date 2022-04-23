import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Modifier here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Modifier extends World
{

    
    private GreenfootImage backgroundImage;
    public int count = 0;
    
    private boolean keyDown;
    public static Stack<Integer> timeList;
    
    
    public Modifier()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 700, 1); 
        backgroundImage = new GreenfootImage("background.png");
        backgroundImage.scale(1200, 700);
        setBackground(backgroundImage);
        timeList = new Stack<Integer>();
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

        Text setting = new Text("Setting", 60);
        addObject(setting, 600, 50);
        
        Text time = new Text("Time:",35);
        addObject(time, 325, 220);
        
        getBackground().drawLine(370, 235, 700, 235);
        

    }
    
    public void input(){
        
        String key = Greenfoot.getKey();
        
        if (key != null){
            if(key == "backspace"){
                removeObjects(getObjectsAt(380+(count-1)*30, 220, null));
                count--;
                timeList.pop();
            }else{
                int value = Integer.parseInt(key);
                timeList.push(value);
                Label label = new Label(key, 35);
                addObject(label, 380 + count * 30, 220);
                count ++;
                
            }
        }
 
    }
}
