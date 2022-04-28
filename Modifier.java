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
    private int count = 0;
    
    //remember to put getter
    private boolean keyDown;
    public Stack<Integer> timeList = new Stack<Integer>();;
    
    //Bandit =0;
    //BeffyBandit = 1;
    //Healer = 2;
    //Knight = 3;
    
    public boolean [] RedSwitch = new boolean [4];
    public boolean [] BlueSwitch = new boolean [4];
    private Text [] redText = new Text [4];
    private Text [] blueText = new Text [4];
    private SoldierSwitchButton [] redSoldier = new SoldierSwitchButton[4];
    private SoldierSwitchButton [] blueSoldier = new SoldierSwitchButton[4];
    public int rCoin=0, bCoin=0;
    private Label redCoins;
    private Label blueCoins;
    private AddButton abRed;
    private AddButton abBlue;
    private MinusButton mbRed;
    private MinusButton mbBlue;
    private GreenfootSound[] typeSound;
    private int typeSoundIndex;
    
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
     private void prepare()
    {
        BackButton backButton = new BackButton(this);
        addObject(backButton,71,53);

        Text setting = new Text("Setting", 60, Color.WHITE);
        addObject(setting, 600, 50);
        
        Text time = new Text("Time:",35, Color.WHITE);
        addObject(time, 325, 220);
        
        for(int i=0;i<4;i++){
            redSoldier[i]=new SoldierSwitchButton();
            blueSoldier[i]=new SoldierSwitchButton();
        }
        
        Text RedTeam = new Text("Red Team:",35, Color.RED);
        addObject(RedTeam, 300, 300);
        
        redText[0] = new Text("Bandit:",29, Color.RED);
        redText[1] = new Text("Beefy Bandit:",29, Color.RED);
        redText[2] = new Text("Healer:",29, Color.RED);
        redText[3] = new Text("Knight:",29, Color.RED);
        Text redCoin = new Text("Initial Coins:", 29, Color.RED);
        addObject(redCoin, 300, 550);
        for(int i=0;i<4;i++){
            addObject(redText[i],300,350+50*i);
            addObject(redSoldier[i], 430, 350+50*i);
            RedSwitch[i]=true;
        }
        
        Text BlueTeam = new Text("Blue Team:",35, Color.BLUE);
        addObject(BlueTeam, 850, 300);
      
        blueText[0] = new Text("Bandit:",29, Color.BLUE);
        blueText[1] = new Text("Beefy Bandit:",29, Color.BLUE);
        blueText[2] = new Text("Healer:",29, Color.BLUE);
        blueText[3] = new Text("Knight:",29, Color.BLUE);
        Text blueCoin = new Text("Initial Coins:", 29, Color.BLUE);
        addObject(blueCoin, 850, 550);
        for(int i=0;i<4;i++){
            addObject(blueText[i],850,350+50*i);
            addObject(blueSoldier[i], 980, 350+50*i);
            BlueSwitch[i]=true;
        }
        getBackground().drawLine(375, 235, 700, 235);
        
        abRed = new AddButton();
        addObject(abRed, 400, 550);
        
        mbRed = new MinusButton();
        addObject(mbRed, 490, 548);
        
        redCoins = new Label(rCoin,35);
        addObject(redCoins, 445, 550);
    
        abBlue = new AddButton();
        addObject(abBlue, 950, 550);
        
        mbBlue = new MinusButton();
        addObject(mbBlue, 1040, 548);
        
        blueCoins = new Label(bCoin,35);
        addObject(blueCoins, 995, 550);
        
        
    }
    public int clickAdd(AddButton ab, int coin){
        if(Greenfoot.mouseClicked(ab)){
            coin+=10;
        }
        return coin;
    }
    public int clickMinus(MinusButton mb, int coin){
        if(Greenfoot.mouseClicked(mb)){
            coin-=10;
        }
        
        return coin;
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    public void act()
    {
        input();
        RedSwitch[0]=onClick(RedSwitch[0],redSoldier[0]);
        RedSwitch[1]=onClick(RedSwitch[1],redSoldier[1]);
        RedSwitch[2]=onClick(RedSwitch[2],redSoldier[2]);
        RedSwitch[3]=onClick(RedSwitch[3],redSoldier[3]);
        
        BlueSwitch[0]=onClick(BlueSwitch[0],blueSoldier[0]);
        BlueSwitch[1]=onClick(BlueSwitch[1],blueSoldier[1]);
        BlueSwitch[2]=onClick(BlueSwitch[2],blueSoldier[2]);
        BlueSwitch[3]=onClick(BlueSwitch[3],blueSoldier[3]);
        
        rCoin=clickAdd(abRed, rCoin);
        bCoin=clickAdd(abBlue, bCoin);
        rCoin=clickMinus(mbRed, rCoin);
        bCoin=clickMinus(mbBlue, bCoin);
        
        if(rCoin<0) rCoin=0;
        redCoins.setValue(rCoin);
        
        if(bCoin<0) bCoin=0;
        blueCoins.setValue(bCoin);
        
    }
    
    public void typesSound(){
        //set up and initalize for the sound preparation
        typeSoundIndex=0;
        typeSound=new GreenfootSound [20];
        for(int i=0;i<typeSound.length;i++){
            typeSound[i]=new GreenfootSound("Type.wav");
        }
        
        //output
        typeSound[typeSoundIndex].setVolume(70);
        typeSound[typeSoundIndex].play();
        typeSoundIndex++;
        if(typeSoundIndex>typeSound.length-1){
            typeSoundIndex=0;
        }
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
                typesSound();
            }else{
                int v = key.charAt(0) - '0';
                if (v >= 0 && v < 10){
                    int value = Integer.parseInt(key);
                    timeList.push(value);
                    Label label = new Label(key, 35);
                    addObject(label, 380 + count * 30, 220);
                    count ++;
                    typesSound();
                }
            }
        }
 
    }
    
}
