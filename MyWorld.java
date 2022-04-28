import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class MyWorld here.
 * 
 * @Benny, Angus, Caleb, Kevin, Jerry 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    //Test test test
    

    
    private GreenfootImage backgroundImage;
    private SimpleTimer timeCycle = new SimpleTimer();
    private SimpleTimer totalElapsedTime = new SimpleTimer();
    private Counter timeCount = new Counter();
    private int start = 0;
    private int time = 0;
    
    private Modifier modifier;
    
    private Statistic statLeft ;
    private Statistic statRight ;
    
    private CrystalTower crystalRed = new CrystalTower(1);
    private CrystalTower crystalBlue = new CrystalTower(-1);
    
    public List<Integer> redSpawnControl, blueSpawnControl;
    
    public int redListLength, blueListLength;
    private int gameStatus;
    
    private boolean infernoLeft, infernoRight;
    private GreenfootSound sound = new GreenfootSound("BackgroundMusic.mp3");
    public MyWorld(Modifier modifier)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 700, 1); 
        this.modifier=modifier;
        statLeft = new Statistic(true, modifier.rCoin);
        statRight = new Statistic(false, modifier.bCoin);
        backgroundImage = new GreenfootImage("Background.jpg");
        backgroundImage.scale(1200, 700);
        addObject(statLeft, 400, 50);
        addObject(statRight, 800, 50);
        addObject(crystalRed, 100, 350);
        addObject(crystalBlue, 1100, 350);
        setBackground(backgroundImage);
        
        totalElapsedTime.mark();
                
        redSpawnControl = new ArrayList<>();
        blueSpawnControl = new ArrayList<>();
        int length = modifier.timeList.size(); // could cause null pointer
        for(int i=0;i<length;i++){
            time=time*10+modifier.timeList.get(i);
        }
        addObject(timeCount, 1100, 50);
        if(time==0){
            timeCount.setValue(90);
            time = 90;
        }else{
            timeCount.setValue(time);
        }
        existSoldier();
        
        sound.setVolume(25);
    }
    
    public void existSoldier(){
        for(int i=0;i<4;i++){
            if(modifier.RedSwitch[i]){
                redSpawnControl.add(i);
            }
            if(modifier.BlueSwitch[i]){
                blueSpawnControl.add(i);
            }
        }
        redListLength=redSpawnControl.size();
        blueListLength=blueSpawnControl.size();
    }
    
    private void spawner(int yDirection){
        // System.out.println("time passed: " + getTimePassed());
        int spawnSpeed;
        if (getTimePassed() < 0.25) spawnSpeed = 210;
        else if (getTimePassed() < 0.50) spawnSpeed = 120;
        else if (getTimePassed() < 0.75) spawnSpeed = 80;
        else spawnSpeed = 50;
        
        int direction = yDirection;
        if (Greenfoot.getRandomNumber(spawnSpeed) == 0){
    
            int ySpawn = Greenfoot.getRandomNumber(600) + 50;
            int xSpawn = direction == 1 ? 120 : 1080;
            int index = direction == 1 ? Greenfoot.getRandomNumber(redListLength) : Greenfoot.getRandomNumber(blueListLength);
            int choice = direction == 1 ? redSpawnControl.get(index) : blueSpawnControl.get(index);
            Soldier soldier;
        
        
            
            if (choice == 0){
                soldier = new Bandit(direction);
                addObject(soldier, xSpawn, ySpawn);
            }else if (choice == 1 ){
                soldier = new BeefyBandit(direction);
                addObject(soldier, xSpawn, ySpawn);
            }else if (choice == 2){
                soldier = new Healer(direction);
                addObject(soldier, xSpawn, ySpawn);
            }else if (choice == 3){
                soldier = new Knight(direction);
                addObject(soldier, xSpawn, ySpawn);
            }
            
            
        }
    }
    
    public void spawnTower(){
        int yCoord = (Greenfoot.getRandomNumber(8)+2)*70;
        int xCoord = Greenfoot.getRandomNumber(50)+1;
        if (statLeft.getGold() >= 100){
            statLeft.updateGold(-100);
            addObject(new ArcherTower(1), 250+xCoord, yCoord);
        }
        if (statRight.getGold()>=100){
            statRight.updateGold(-100);
            addObject(new ArcherTower(-1),900-xCoord, yCoord);
        }
        
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
    public void spawnGold(){
        int yCoord = (Greenfoot.getRandomNumber(6) + 1) * 70;
        addObject(new GoldBag(), 600, yCoord);
    }
    public void act(){
        sound.play();
        //timeCount.setValue(tim.millisElapsed()/1000);
        if(timeCount.getValue()==0){
            gameStatus=0;
            EndWorld ew = new EndWorld(gameStatus);
            Greenfoot.setWorld(ew);
        
        }else if(timeCycle.millisElapsed()>1000){
            timeCount.add(-1);
            timeCycle.mark();
        }
        spawner(1);
        spawner(-1);
        spawnTower();
    }
    
    public int getRedCoin(){
        return modifier.rCoin;
    }
    
    public CrystalTower getTargettedCrystal(int side){
        return side == 1 ? crystalBlue : crystalRed;
    }

    public void updateStatistic(int direction, int gold){
        if (direction == 1){
            statLeft.updateGold(gold);
            statLeft.updateKills();
        }
        if (direction == -1){
            statRight.updateGold(gold);
            statRight.updateKills();
        }
    }
    
    public double getTimePassed(){
        return (double)(totalElapsedTime.millisElapsed() / 1000.0 / time );
    }
    
    
}
