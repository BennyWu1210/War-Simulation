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
    
    public static boolean RedBanditSwitch;
    public static boolean RedBeefyBanditSwitch;
    public static boolean RedHealerSwitch;
    public static boolean RedKnightSwitch;
    
    public static boolean BlueBanditSwitch;
    public static boolean BlueBeefyBanditSwitch;
    public static boolean BlueHealerSwitch;
    public static boolean BlueKnightSwitch;
    
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

        Text setting = new Text("Setting", 60, Color.WHITE);
        addObject(setting, 600, 50);
        
        Text time = new Text("Time:",35, Color.WHITE);
        addObject(time, 325, 220);
        
        Text RedTeam = new Text("Red Team:",35, Color.RED);
        addObject(RedTeam, 300, 300);
        
        Text RedBandit = new Text("Bandit:",29, Color.RED);
        addObject(RedBandit, 300, 350);
        SoldierSwitchButton redBandit = new SoldierSwitchButton();
        addObject(redBandit, 430, 355);
        RedBanditSwitch=redBandit.state;
       
        
        Text RedBeefyBandit = new Text("Beefy Bandit:",29, Color.RED);
        addObject(RedBeefyBandit, 300, 400);
        SoldierSwitchButton redBeefyBandit = new SoldierSwitchButton();
        addObject(redBeefyBandit, 430, 400);
        RedBeefyBanditSwitch=redBeefyBandit.state;
        
        Text RedHealer = new Text("Healer:",29, Color.RED);
        addObject(RedHealer, 300, 450);
        SoldierSwitchButton redHealer = new SoldierSwitchButton();
        addObject(redHealer, 430, 450);
        RedHealerSwitch=redHealer.state;
        
        Text RedKnight = new Text("Knight:",29, Color.RED);
        addObject(RedKnight, 300, 500);
        SoldierSwitchButton redKnight = new SoldierSwitchButton();
        addObject(redKnight, 430, 500);
        RedKnightSwitch=redKnight.state;
        
        Text BlueTeam = new Text("Blue Team:",35, Color.BLUE);
        addObject(BlueTeam, 850, 300);
      
        Text BlueBandit = new Text("Bandit:",29, Color.BLUE);
        addObject(BlueBandit, 850, 350);
        SoldierSwitchButton blueBandit = new SoldierSwitchButton();
        addObject(blueBandit, 980, 350);
        BlueBanditSwitch=blueBandit.state;
        
        Text BlueBeefyBandit = new Text("Beefy Bandit:",29, Color.BLUE);
        addObject(BlueBeefyBandit, 850, 400);
        SoldierSwitchButton blueBeefyBandit = new SoldierSwitchButton();
        addObject(blueBeefyBandit, 980, 400);
        BlueBeefyBanditSwitch=blueBeefyBandit.state;
        
        Text BlueHealer = new Text("Healer:",29, Color.BLUE);
        addObject(BlueHealer, 850, 450);
        SoldierSwitchButton blueHealer = new SoldierSwitchButton();
        addObject(blueHealer, 980, 450);
        BlueHealerSwitch=blueHealer.state;
        
        Text BlueKnight = new Text("Knight:",29, Color.BLUE);
        addObject(BlueKnight, 850, 500);
        SoldierSwitchButton blueKnight = new SoldierSwitchButton();
        addObject(blueKnight, 980, 500);
        BlueKnightSwitch=blueKnight.state;
        
        
        getBackground().drawLine(375, 235, 700, 235);
        

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
