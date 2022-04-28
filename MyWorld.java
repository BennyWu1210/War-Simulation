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
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    //Test test test
    
    private GreenfootImage backgroundImage;
    private SimpleTimer tim = new SimpleTimer();
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
       
                
        redSpawnControl = new ArrayList<>();
        blueSpawnControl = new ArrayList<>();
        int length = modifier.timeList.size(); // could cause null pointer
        for(int i=0;i<length;i++){
            time=time*10+modifier.timeList.get(i);
        }
        addObject(timeCount, 1100, 50);
        if(time==0){
            timeCount.setValue(90);
        }else{
            timeCount.setValue(time);
        }
        existSoldier();
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
        int direction = yDirection;
        if (Greenfoot.getRandomNumber(120) == 0){
            int redIdx = Greenfoot.getRandomNumber(redListLength);
            int blueIdx = Greenfoot.getRandomNumber(blueListLength);
    
            int ySpawn = Greenfoot.getRandomNumber(10)*50 + 70;
            int xSpawn = direction == 1 ? 50 : 950;
            Soldier soldier;
        
            int redChoice = redSpawnControl.get(redIdx);
            int blueChoice = blueSpawnControl.get(blueIdx);
            
            if (redChoice == 0 || blueChoice == 0){
                soldier = new Bandit(direction, statRight);
                addObject(soldier, xSpawn, ySpawn);
            }if (redChoice == 1 || blueChoice == 1){
                soldier = new BeefyBandit(direction, statRight);
                addObject(soldier, xSpawn, ySpawn);
            }if (redChoice == 2 || blueChoice == 2){
                soldier = new Healer(direction, statRight);
                addObject(soldier, xSpawn, ySpawn);
            }if (redChoice == 3 || blueChoice == 3){
                soldier = new Knight(direction, statRight);
                addObject(soldier, xSpawn, ySpawn);
            }
        }
    }
    
    public void spawnTower(){
        int yCoord = Greenfoot.getRandomNumber(10)*70;
        int xCoord = Greenfoot.getRandomNumber(50)+1;
        if (statLeft.getGold() >= 100){
            statLeft.updateGold(-100);
            addObject(new ArcherTower(1), 250+xCoord, yCoord);
        }
        if (statRight.getGold()>=100){
            statRight.updateGold(-100);
            addObject(new ArcherTower(-1),900-xCoord, yCoord);
        }
    }
    public void spawnGold(){
        int yCoord = Greenfoot.getRandomNumber(6) + 1;
    }
    public void act(){
        //timeCount.setValue(tim.millisElapsed()/1000);
        if(timeCount.getValue()==0){
            EndWorld ew = new EndWorld();
            Greenfoot.setWorld(ew);
        
        }else if(tim.millisElapsed()>1000){
            timeCount.add(-1);
            tim.mark();
        }
        spawner(1);
        spawner(-1);
        
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
    
    
}
