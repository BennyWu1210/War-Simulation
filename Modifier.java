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
    
    //remember to put getter
    private boolean keyDown;
    public Stack<Integer> timeList = new Stack<Integer>();;
    
    public boolean RedBanditSwitch;
    public boolean RedBeefyBanditSwitch;
    public boolean RedHealerSwitch;
    public boolean RedKnightSwitch;
    
    public boolean BlueBanditSwitch;
    public boolean BlueBeefyBanditSwitch;
    public boolean BlueHealerSwitch;
    public boolean BlueKnightSwitch;
    
    public SoldierSwitchButton redBandit;
    public SoldierSwitchButton redBeefyBandit;
    public SoldierSwitchButton redHealer;
    public SoldierSwitchButton redKnight;
    
    public SoldierSwitchButton blueBandit;
    public SoldierSwitchButton blueBeefyBandit;
    public SoldierSwitchButton blueHealer;
    public SoldierSwitchButton blueKnight;
    
    private TitlePage tp;
    public Modifier(TitlePage tp)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 700, 1); 
        backgroundImage = new GreenfootImage("background.png");
        backgroundImage.scale(1200, 700);
        setBackground(backgroundImage);
        prepare();
        this.tp=tp;
        
    }
    
    public boolean getRedBanditSwitch(){
        return RedBanditSwitch;
    }
    
    public boolean getRedBeefyBanditSwitch(){
        return RedBeefyBanditSwitch;
    }
    
    public boolean getRedHealerSwitch(){
        return RedHealerSwitch;
    }
    
    public boolean getRedKnightSwitch(){
        return RedKnightSwitch;
    }
    
    public boolean getBlueBanditSwitch(){
        return BlueBanditSwitch;
    }
    
    public boolean getBlueBeefyBanditSwitch(){
        return BlueBeefyBanditSwitch;
    }
    
    public boolean getBlueHealerSwitch(){
        return BlueHealerSwitch;
    }
    
    public boolean getBlueKnightSwitch(){
        return BlueKnightSwitch;
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    public void act()
    {
        input();
        RedBanditSwitch=onClick(RedBanditSwitch,redBandit);
        RedBeefyBanditSwitch=onClick(RedBeefyBanditSwitch,redBeefyBandit);
        RedHealerSwitch=onClick(RedHealerSwitch,redHealer);
        RedKnightSwitch=onClick(RedKnightSwitch,redKnight);
        
        BlueBanditSwitch=onClick(BlueBanditSwitch,blueBandit);
        BlueBeefyBanditSwitch=onClick(BlueBeefyBanditSwitch,blueBeefyBandit);
        BlueHealerSwitch=onClick(BlueHealerSwitch,blueHealer);
        BlueKnightSwitch=onClick(BlueKnightSwitch,blueKnight);
        
        
    
    }
    
    private void prepare()
    {
        BackButton backButton = new BackButton(this);
        addObject(backButton,71,53);

        Text setting = new Text("Setting", 60, Color.WHITE);
        addObject(setting, 600, 50);
        
        Text time = new Text("Time:",35, Color.WHITE);
        addObject(time, 325, 220);
        
        Text RedTeam = new Text("Red Team:",35, Color.RED);
        addObject(RedTeam, 300, 300);
        
        Text RedBandit = new Text("Bandit:",29, Color.RED);
        addObject(RedBandit, 300, 350);
        redBandit=new SoldierSwitchButton();
        addObject(redBandit, 430, 355);
        RedBanditSwitch=true;
       
        
        Text RedBeefyBandit = new Text("Beefy Bandit:",29, Color.RED);
        addObject(RedBeefyBandit, 300, 400);
        redBeefyBandit = new SoldierSwitchButton();
        addObject(redBeefyBandit, 430, 400);
        RedBeefyBanditSwitch=true;
        
        Text RedHealer = new Text("Healer:",29, Color.RED);
        addObject(RedHealer, 300, 450);
        redHealer = new SoldierSwitchButton();
        addObject(redHealer, 430, 450);
        RedHealerSwitch=true;
        
        Text RedKnight = new Text("Knight:",29, Color.RED);
        addObject(RedKnight, 300, 500);
        redKnight = new SoldierSwitchButton();
        addObject(redKnight, 430, 500);
        RedKnightSwitch=true;
        
        Text BlueTeam = new Text("Blue Team:",35, Color.BLUE);
        addObject(BlueTeam, 850, 300);
      
        Text BlueBandit = new Text("Bandit:",29, Color.BLUE);
        addObject(BlueBandit, 850, 350);
        blueBandit = new SoldierSwitchButton();
        addObject(blueBandit, 980, 350);
        BlueBanditSwitch=true;
        
        Text BlueBeefyBandit = new Text("Beefy Bandit:",29, Color.BLUE);
        addObject(BlueBeefyBandit, 850, 400);
        blueBeefyBandit = new SoldierSwitchButton();
        addObject(blueBeefyBandit, 980, 400);
        BlueBeefyBanditSwitch=true;
        
        Text BlueHealer = new Text("Healer:",29, Color.BLUE);
        addObject(BlueHealer, 850, 450);
        blueHealer = new SoldierSwitchButton();
        addObject(blueHealer, 980, 450);
        BlueHealerSwitch=true;
        
        Text BlueKnight = new Text("Knight:",29, Color.BLUE);
        addObject(BlueKnight, 850, 500);
        blueKnight = new SoldierSwitchButton();
        addObject(blueKnight, 980, 500);
        BlueKnightSwitch=true;
        
        
        
        getBackground().drawLine(375, 235, 700, 235);
        

    }
    
    public boolean onClick(boolean state, SoldierSwitchButton sb)
    {
        if(Greenfoot.mouseClicked(sb)) {
            state = !state;
        }
        return state;
    } 
    
    public void returnTitlePage(){
        Greenfoot.setWorld(tp);
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
