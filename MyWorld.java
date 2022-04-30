import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * War Simulation is a game with 2 Crystals. The objective for each side is to destroy the other Crystal. Both sides spawn soldiers
 * and these various soldiers have different features. Moreover, they level up over time, hence, becoming stronger. All the whilst they
 * are fighting, killing a soldier rewards gold which is used to buy Archer Towers to defend the Crystal. When a Crystal is under attack 
 * and is low health, it will spawn Inferno Towers to protect itself.
 * 
 * Image Sources & Audio Sources: (Listed on another document)
 * 
 * @Benny, Angus, Caleb, Kevin, Jerry 
 * @version (April 28 2022)
 */
public class MyWorld extends World
{
    // Initialize image and timer variables
    
    private GreenfootImage backgroundImage;
    private SimpleTimer timeCycle = new SimpleTimer(); // Timer that keep tracks of the counter
    private SimpleTimer totalElapsedTime = new SimpleTimer(); // Timer that keep tracks of the total time elapsed
    private Counter timeCount = new Counter();
    
    // Initialize statistics bar and modifier
    private int start = 0;
    private int time = 0;
    private Modifier modifier;
    private Statistic statLeft ;
    private Statistic statRight ;
    
    // Create two crystals on both ends (direction 1 and -1)
    private CrystalTower crystalRed = new CrystalTower(1);
    private CrystalTower crystalBlue = new CrystalTower(-1);
    
    // Variables to keep track of the available soldiers for both sides (different controls and states)
    private List<Integer> redSpawnControl, blueSpawnControl;
    private int redListLength, blueListLength;
    private int gameStatus;
    private boolean infernoLeft, infernoRight;
    
    // Is the game over yet?
    private boolean gameOver;
    
    // Background music for the game
    private GreenfootSound backgroundMusic = new GreenfootSound("BackgroundMusic.mp3");
    
    /**
     * Constructor for objects of class MyWorld - Intializing the time, statistics, and setting the background
     * 
     * @param modifier  the modifier object that contains the modified information for the simulation
     */
    public MyWorld(Modifier modifier)
    {    
        // Create a new world with 1200x700 cells with a cell size of 1x1 pixels.
        super(1200, 700, 1); 
        this.modifier = modifier;
        
        // Modifiers for both ends
        statLeft = new Statistic(true, modifier.getRCoin());
        statRight = new Statistic(false, modifier.getRCoin());
        
        // Sets background image for the world
        backgroundImage = new GreenfootImage("Background.jpg");
        backgroundImage.scale(1200, 700);
        addObject(statLeft, 400, 50);
        addObject(statRight, 800, 50);
        addObject(crystalRed, 100, 350);
        addObject(crystalBlue, 1100, 350);
        setBackground(backgroundImage);
        
        redSpawnControl = new ArrayList<>();
        blueSpawnControl = new ArrayList<>();
        int length = modifier.getTimeList().size(); // could cause null pointer if user turn off all the options
        
        // mark the time
        totalElapsedTime.mark();
    
        // calculate the total time
        for(int i = 0; i < length; i++){
            time = time * 10 + modifier.getTimeList().get(i);
        }
        
        // add the time in the world
        addObject(timeCount, 1100, 50);
        
        //set the time 
        if(time==0){ // set it to the default value (90) if it's 0
            timeCount.setValue(90);
            time = 90;
        }else{
            timeCount.setValue(time);
        }
        
        // find out how many soldier(s) the user turned on
        existSoldier();
        
        // sets the volume for the music
        backgroundMusic.setVolume(25);
        
        // make sure the stat bar is always on the top
        this.setPaintOrder(StatBar.class);
    }
    
    /**
     * This method will initalize how many soldier from Red and Blue kept
     */
    public void existSoldier(){
        for(int i=0;i<4;i++){
            if(modifier.getRedSwitch(i)){
                redSpawnControl.add(i);
            }
            if(modifier.getBlueSwitch(i)){
                blueSpawnControl.add(i);
            }
        }
        //set the size
        redListLength=redSpawnControl.size();
        blueListLength=blueSpawnControl.size();
    }
    
    /**
     * This method will spawn the soldiers on both side randomly based on the time
     * passed within the simulation
     */
    private void spawner(int yDirection){
        //set the spawn speed depend on the time
        int spawnSpeed;
        if (getTimePassed() < 0.25) spawnSpeed = 210;
        else if (getTimePassed() < 0.50) spawnSpeed = 120;
        else if (getTimePassed() < 0.75) spawnSpeed = 80;
        else spawnSpeed = 50;
        
        //set the direction
        int direction = yDirection;
        if (Greenfoot.getRandomNumber(spawnSpeed) == 0){
            int ySpawn = Greenfoot.getRandomNumber(600) + 50;
            int xSpawn = direction == 1 ? 120 : 1080;
            
            //find the corresponding soldier
            int index = direction == 1 ? Greenfoot.getRandomNumber(redListLength) : Greenfoot.getRandomNumber(blueListLength);
            int choice = direction == 1 ? redSpawnControl.get(index) : blueSpawnControl.get(index);
            Soldier soldier;
        
            if (choice == 0){ //Bandit 
                soldier = new Bandit(direction);
                addObject(soldier, xSpawn, ySpawn);
            }else if (choice == 1 ){ //BeefyBandit
                soldier = new BeefyBandit(direction);
                addObject(soldier, xSpawn, ySpawn);
            }else if (choice == 2){ //Healer
                soldier = new Healer(direction);
                addObject(soldier, xSpawn, ySpawn);
            }else if (choice == 3){ //Knight
                soldier = new Knight(direction);
                addObject(soldier, xSpawn, ySpawn);
            }
        }
    }
    
    /**
     * Method that is responsible for spawning towers 
     */
    public void spawnTower(){
        int yCoord = (Greenfoot.getRandomNumber(8)+2)*70;
        int xCoord = Greenfoot.getRandomNumber(50)+1;
        
        // Spawns archer towers when the gold reaches 75
        if (statLeft.getGold() >= 75){
            statLeft.updateGold(-75);
            addObject(new ArcherTower(1), 250+xCoord, yCoord);
        }
        if (statRight.getGold()>=75){
            statRight.updateGold(-75);
            addObject(new ArcherTower(-1),900-xCoord, yCoord);
        }
        
        // Spawns two inferno towers when the crystal's hp get below 70% (make the game more balanced)
        if (!infernoRight && crystalBlue.getHpPercentage() < 0.7){
            infernoRight = true;
            addObject(new InfernoTower(-1), 1050, 220);
            addObject(new InfernoTower(-1), 1050, 480);
        }
        if (!infernoLeft && crystalRed.getHpPercentage() < 0.7){
            infernoLeft = true;
            addObject(new InfernoTower(1), 150, 220);
            addObject(new InfernoTower(1), 150, 480);
        }
    }
    /**
     * Gold feature (unused feature that could be implemented in the future)
     */
    public void spawnGold(){
        int yCoord = (Greenfoot.getRandomNumber(6) + 1) * 70;
        addObject(new GoldBag(), 600, yCoord);
    }
    
    /**
     * Start the music when the simulation is started
     */
    public void started(){
        // Start the music and set its volume to 25
        backgroundMusic.setVolume(25);
        backgroundMusic.playLoop();
    }
    
    /**
     * Opposite to "started()", this method pauses the music when the simulation is paused
     */
    public void stopped(){
        // pause music
        backgroundMusic.stop();
    }
    
    /**
     * The act method for MyWorld
     * 
     * Responsible for spawing enemies, towers, and keeping control of the overall state
     */
    public void act(){
        //play the background music
        backgroundMusic.playLoop();
        
        //if times runs out 
        if(!gameOver && timeCount.getValue()==0){
            removeObjects(getObjects(Soldier.class));//remove all the soldier
            if(crystalRed.getHpPercentage()<crystalBlue.getHpPercentage()){//if red team tower have less hp than blue team, blue team win
                gameStatus=2;//set status to blue team win
                //add the effect
                addObject(new ClashRoyaleLaughEffect(),1100, 100);
                addObject(new ExplosionEffect(), crystalRed.getX()-30, crystalRed.getY()-80);
                removeObject(crystalRed);
            }else{//else, red team win
                gameStatus=1;//set status to red team win
                //add the effect
                addObject(new ClashRoyaleLaughEffect(),100, 100);
                addObject(new ExplosionEffect(), crystalBlue.getX()-30, crystalBlue.getY()-80);
                removeObject(crystalBlue);
            }
            //mark the time
            timeCycle.mark();
            //change the status of the gameOver to true
            gameOver = true;
        }else if(!gameOver && timeCycle.millisElapsed()>1000){//if the game has not finished, minus 1 seconds of the time
            timeCount.add(-1);
            timeCycle.mark();
        }
        
        if(!gameOver && crystalRed.getHpPercentage()<=0){//if blue team tower have less hp than red team, red team win
            gameOver = true;
            timeCycle.mark();
            removeObjects(getObjects(Soldier.class));
            
            // Creates laughing effect
            addObject(new ClashRoyaleLaughEffect(),1100, 100);
            addObject(new ExplosionEffect(), crystalRed.getX()-30, crystalRed.getY()-80);
            removeObject(crystalRed);
            gameStatus=2;
        }
        else if(!gameOver && crystalBlue.getHpPercentage()<=0){//else, blue team wins
            gameOver = true;
            removeObjects(getObjects(Soldier.class));
            
            // Creates laughing effect
            addObject(new ClashRoyaleLaughEffect(),100, 100);
            addObject(new ExplosionEffect(), crystalBlue.getX()-30, crystalBlue.getY()-80);
            timeCycle.mark();
            removeObject(crystalBlue);
            gameStatus=1;
        }
        
        //if the game is over and 3.5 seconds has passed, it will switched to the end world screen
        if (gameOver && timeCycle.millisElapsed() >= 3500){
            EndWorld ew = new EndWorld(gameStatus);
            Greenfoot.setWorld(ew);
        }
        
        //if the simulatino is still running, continue to spawn  soldiers and towers
        if (!gameOver){
            spawner(1);
            spawner(-1);
            spawnTower();
        }
    }
    
    /**
     * This method returns the targetted crystal that a side is currently attacking
     * 
     * @return CrystalTower  the crystal that a certain side is targetting
     */
    public CrystalTower getTargettedCrystal(int side){
        return side == 1 ? crystalBlue : crystalRed;
    }

    /**
     * This method will update the gold in the statistic bar
     * 
     * @param direction  the facing determine whether it is blue team or red team
     * @param gold       the int value for the gold that specific team  
     */
    public void updateStatistic(int direction, int gold){
        if (direction == 1){ // red
            statLeft.updateGold(gold);
            statLeft.updateKills();
        }
        if (direction == -1){ // blue
            statRight.updateGold(gold);
            statRight.updateKills();
        }
    }
    
    /**
     * Returns the total time passed as a percentage 
     * (number of milliseconds left / total milliseconds since the clock started)
     * 
     * @return double  total time passed
     */
    public double getTimePassed(){
        return (double)(totalElapsedTime.millisElapsed() / 1000.0 / time );
    }
    
    
}
