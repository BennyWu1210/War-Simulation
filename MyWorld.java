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
    private int goldBagTime = 0;
    private CrystalTower crystalRed = new CrystalTower(1);
    private CrystalTower crystalBlue = new CrystalTower(-1);
    
    
    int spawnSpeed = 240;
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
        
        if (Greenfoot.getRandomNumber(spawnSpeed) == 0){
            int soldierChoice = Greenfoot.getRandomNumber(4) + 1;
            int ySpawn = Greenfoot.getRandomNumber(9)*50 + 120;
            int xSpawn = direction == 1 ? 250 : 950;
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
        
        if (Greenfoot.getRandomNumber(spawnSpeed) == 0){
            int soldierChoice = Greenfoot.getRandomNumber(4) + 1;
            int ySpawn = Greenfoot.getRandomNumber(9)*50 + 120;
            int xSpawn = direction == 1 ? 250 : 950;
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
        int yCoord = Greenfoot.getRandomNumber(5)*100 + 200;
        int xCoord = Greenfoot.getRandomNumber(50)+1;
        if (statLeft.getGold() >= 200){
            statLeft.updateGold(-200);
            addObject(new ArcherTower(1), 250+xCoord, yCoord);
        }
        if (statRight.getGold()>=200){
            statRight.updateGold(-200);
            addObject(new ArcherTower(-1),900-xCoord, yCoord);
        }
    }
    
    public void spawnGold(){
        int yCoord = ( (Greenfoot.getRandomNumber(10)+1) * 50) + 100;
        addObject(new GoldBag(), 600, yCoord);
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
        goldBagTime++;
        if (goldBagTime == 300){
            spawnGold();
            goldBagTime = 0;
        }
            
    }
    
    
    
}
