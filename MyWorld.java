import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
    private SimpleTimer tim = new SimpleTimer();
    private Counter timeCount = new Counter();
    private int start = 0;
    private int time = 0;
    
    private Modifier modifier;
    
    private Statistic statLeft = new Statistic(true);
    private Statistic statRight = new Statistic(false);
    
    private CrystalTower crystalRed = new CrystalTower(1);
    private CrystalTower crystalBlue = new CrystalTower(-1);
    public MyWorld(Modifier modifier)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 700, 1); 
        this.modifier=modifier;
        backgroundImage = new GreenfootImage("Background.jpg");
        backgroundImage.scale(1200, 700);
        addObject(statLeft, 400, 50);
        addObject(statRight, 800, 50);
        addObject(crystalRed, 100, 350);
        addObject(crystalBlue, 1100, 350);
        setBackground(backgroundImage);
        System.out.println(modifier.timeList);
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
    }
    private void spawner(int yDirection){
        int direction = yDirection;
        
        if (Greenfoot.getRandomNumber(120) == 0){
            int soldierChoice = Greenfoot.getRandomNumber(4) + 1;
            int ySpawn = Greenfoot.getRandomNumber(10)*50 + 70;
            int xSpawn = direction == 1 ? 50 : 950;
            Soldier soldier;
            
            if (soldierChoice == 1 && modifier.getRedBanditSwitch()){
                soldier = new Bandit(direction, statRight);
                addObject(soldier, xSpawn, ySpawn);
            }if (soldierChoice == 2 && modifier.RedKnightSwitch){
                soldier = new Knight(direction, statRight);
                addObject(soldier, xSpawn, ySpawn);
            }if (soldierChoice == 3 && modifier.RedHealerSwitch){
                soldier = new Healer(direction, statRight);
                addObject(soldier, xSpawn, ySpawn);
            }if (soldierChoice == 4 && modifier.RedBeefyBanditSwitch){
                soldier = new BeefyBandit(direction, statRight);
                addObject(soldier, xSpawn, ySpawn);
            }
            
            
            
            
        }
    }
    
    private void spawnerBlue(int yDirection){
        int direction = yDirection;
        
        if (Greenfoot.getRandomNumber(120) == 0){
            int soldierChoice = Greenfoot.getRandomNumber(4) + 1;
            int ySpawn = Greenfoot.getRandomNumber(10)*50 + 70;
            int xSpawn = direction == 1 ? 50 : 950;
            Soldier soldier;
            
            if (soldierChoice == 1 && modifier.getBlueBanditSwitch()){
                soldier = new Bandit(direction, statLeft);
                addObject(soldier, xSpawn, ySpawn);
            }if (soldierChoice == 2 && modifier.BlueKnightSwitch){
                soldier = new Knight(direction, statLeft);
                addObject(soldier, xSpawn, ySpawn);
            }if (soldierChoice == 3 && modifier.BlueHealerSwitch){
                soldier = new Healer(direction, statLeft);
                addObject(soldier, xSpawn, ySpawn);
            }if (soldierChoice == 4 && modifier.BlueBeefyBanditSwitch){
                soldier = new BeefyBandit(direction, statLeft);
                addObject(soldier, xSpawn, ySpawn);
            }
        }
    }
    public void spawnTower(){
        if (statLeft.getGold() >=25){
            statLeft.setGold(-25);
            addObject(new ArcherTower(1), 300, 350);
        }
        if (statRight.getGold()>=25){
            statRight.setGold(-25);
            addObject(new ArcherTower(-1),900, 350);
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
        spawnerBlue(-1);
        spawnTower();
        
    }
    
    
    
}
