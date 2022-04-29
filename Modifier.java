import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * 
 * This Modifier World allows the user to modify the features of the game
 * (The soldiers chosen & the initial coin value)
 * @author Kevin Zhu, Benny Wu
 * @version April 28, 2022
 */
public class Modifier extends World
{

    // Inialize variables for images and state
    private GreenfootImage backgroundImage;
    private int count = 0;
    private boolean keyDown;
    private Stack<Integer> timeList = new Stack<Integer>();;
    
    // The index for the two team
    // Bandit is 0
    // BeffyBandit is 1
    // Healer is 2
    // Knight is 3
    
    // The buttons that are displayed on the screen
    private boolean [] RedSwitch = new boolean [4];
    private boolean [] BlueSwitch = new boolean [4];
    private Text [] redText = new Text [4];
    private Text [] blueText = new Text [4];
    private SoldierSwitchButton [] redSoldier = new SoldierSwitchButton[4];
    private SoldierSwitchButton [] blueSoldier = new SoldierSwitchButton[4];
    
    // Further labels including the coin toggles
    private int rCoin=0, bCoin=0;
    private Label redCoins;
    private Label blueCoins;
    private AddButton abRed;
    private AddButton abBlue;
    private MinusButton mbRed;
    private MinusButton mbBlue;
    private GreenfootSound[] typeSound;
    private int typeSoundIndex;
    private TitlePage tp;
    
    /**
     * This Constructor will initialize the background and button in the Modifier world
     * 
     * @param tp   the reference of its title page
     */
    public Modifier(TitlePage tp)
    {    
        // Create a new world with 1200x700 cells with a cell size of 1x1 pixels.
        super(1200, 700, 1); 
        
        //initializing the background
        backgroundImage = new GreenfootImage("background.png");
        backgroundImage.scale(1200, 700);
        setBackground(backgroundImage);
        prepare();
        this.tp=tp;
    }
    
    /**
     * This method will return the timeList (the time that the user has entered) 
     * 
     * @return a stack copy of the time list
     */
    public Stack<Integer> getTimeList(){
        return timeList;
    }
    
    /**
     * This method will return the total number of coins the red team has
     * 
     * @return the int value of rCoin
     */
    public int getRCoin(){
        return rCoin;
    }
    
    /**
     * This method will return the total number of coins the blue team has
     * 
     * @return the int value of bCoin
     */
    public int getBCoin(){
        return bCoin;
    }
    
    /**
     * This method will return the state of the i-th red switch
     * 
     * @param idx  the index of that soldier
     * @return the boolean value of that soldier
     */
    public boolean getRedSwitch(int idx){
        return RedSwitch[idx];
    }
    
    /**
     * This method will return the state of the i-th blue switch
     * 
     * @param idx  the index of that soldier
     * @return the boolean value of that soldier
     */
    public boolean getBlueSwitch(int idx){
        return BlueSwitch[idx];
    }
    
    /**
     * This method will instantiate all the buttons and add them to the modifer page
     */
    private void prepare()
    {
        //create a backbutton
        BackButton backButton = new BackButton(this);
        addObject(backButton,71,53);

        //initializing the text
        Text setting = new Text("Setting", 60, Color.WHITE);
        addObject(setting, 600, 50);
        Text time = new Text("Time:",35, Color.WHITE);
        addObject(time, 325, 220);
        
        //Creating the soldier switch button for the red and blue soldiers
        for(int i=0;i<4;i++){
            redSoldier[i]=new SoldierSwitchButton();
            blueSoldier[i]=new SoldierSwitchButton();
        }
        
        //The features in the RedTeam
        Text RedTeam = new Text("Red Team:",35, Color.RED);
        addObject(RedTeam, 300, 300);
        
        //initialize the red text
        redText[0] = new Text("Bandit:",29, Color.RED);
        redText[1] = new Text("Beefy Bandit:",29, Color.RED);
        redText[2] = new Text("Healer:",29, Color.RED);
        redText[3] = new Text("Knight:",29, Color.RED);
        Text redCoin = new Text("Initial Coins:", 29, Color.RED);
        addObject(redCoin, 300, 550);
        
        //using for loop to put the text and buttons in proper format
        for(int i=0;i<4;i++){
            addObject(redText[i],300,350+50*i);
            addObject(redSoldier[i], 430, 350+50*i);
            RedSwitch[i]=true;
        }
        
        //The features in the BlueTeam
        Text BlueTeam = new Text("Blue Team:",35, Color.BLUE);
        addObject(BlueTeam, 850, 300);
      
        //initialize the bluetext
        blueText[0] = new Text("Bandit:",29, Color.BLUE);
        blueText[1] = new Text("Beefy Bandit:",29, Color.BLUE);
        blueText[2] = new Text("Healer:",29, Color.BLUE);
        blueText[3] = new Text("Knight:",29, Color.BLUE);
        Text blueCoin = new Text("Initial Coins:", 29, Color.BLUE);
        addObject(blueCoin, 850, 550);
        
        //using for loop to put the text and buttons in proper format
        for(int i=0;i<4;i++){
            addObject(blueText[i],850,350+50*i);
            addObject(blueSoldier[i], 980, 350+50*i);
            BlueSwitch[i]=true;
        }
        
        //draw a line for user to input the time 
        getBackground().drawLine(375, 235, 700, 235);
        
        //creating the add button and minus button for both team to set the initial gold value
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
    
    /**
     * This method will add 10 gold for that value
     * 
     * @param ab   the AddButton to follow around
     * @param coin the int value to add the 10 gold to
     * return      the result after adding the coins
     */
    public int clickAdd(AddButton ab, int coin){
        if(Greenfoot.mouseClicked(ab)){
            coin+=10;
        }
        return coin;
    }
    
    /**
     * This method will minus 10 gold for that value
     * 
     * @param mb    a reference to the minus button
     * @param coin  the original value of the coin to be subtracted
     * @return int  the new coin value after subtracting
     */
    public int clickMinus(MinusButton mb, int coin){
        if(Greenfoot.mouseClicked(mb)){
            coin -= 10;
        }
        return coin;
    }

    /**
     * This method will updating the status of the 8 buttons based on user interactions
     */
    public void updateButton(){
        RedSwitch[0] = onClick(RedSwitch[0],redSoldier[0]);
        RedSwitch[1] = onClick(RedSwitch[1],redSoldier[1]);
        RedSwitch[2] = onClick(RedSwitch[2],redSoldier[2]);
        RedSwitch[3] = onClick(RedSwitch[3],redSoldier[3]);
        
        BlueSwitch[0] = onClick(BlueSwitch[0],blueSoldier[0]);
        BlueSwitch[1] = onClick(BlueSwitch[1],blueSoldier[1]);
        BlueSwitch[2] = onClick(BlueSwitch[2],blueSoldier[2]);
        BlueSwitch[3] = onClick(BlueSwitch[3],blueSoldier[3]);
    }
    
    /**
     * This method will updating the value of the coins from both team 
     */
    public void updateCoin(){
        rCoin = clickAdd(abRed, rCoin);
        bCoin = clickAdd(abBlue, bCoin);
        rCoin = clickMinus(mbRed, rCoin);
        bCoin = clickMinus(mbBlue, bCoin);
    }
    
    /**
     * The act method for the modifier that keeps track of the user interactions
     * (button clicks, coin updates, etc.)
     */
    public void act()
    {
        //the time input from the user
        input();
        
        //updating the status of the 8 buttons
        updateButton();
        
        //updating the value of the 2 gold value
        updateCoin();
        
        //the value of the gold could not be less than 0
        if(rCoin<0) rCoin = 0;
        redCoins.setValue(rCoin);//update the gold value
        
        if(bCoin<0) bCoin = 0;
        blueCoins.setValue(bCoin);//update the gold value
    }
    
    /**
     * This method will play a sound effect when the user inputs the time
     */
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
    
    /**
     * This method will change the state of the specific soldier
     * 
     * @param state   the boolean value for that specific soldier
     * @param sb      the SoldierSwitchButton to change the state of
     * return         the boolean value after changing the state
     */
    public boolean onClick(boolean state, SoldierSwitchButton sb)
    {
        if(Greenfoot.mouseClicked(sb)) {
            state = !state;
        }
        return state;
    } 
    
    /**
     * This method will change the world to TitlePage world
     */
    public void returnTitlePage(){
        Greenfoot.setWorld(tp);
    }
    
    /**
     * This method is for user to input the time by keyboard
     */
    public void input(){
        //The keyboard input from the user
        String key = Greenfoot.getKey();
        if (key != null){
            //if user type back space, remove the character
            if(key == "backspace"){
                removeObjects(getObjectsAt(380+(count-1)*30, 220, null));
                count--;
                timeList.pop();
                typesSound();
            }else{
                //to check if the value is between 0~9, inclusively 
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
