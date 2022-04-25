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
    
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 700, 1); 
        backgroundImage = new GreenfootImage("Background.jpg");
        backgroundImage.scale(1200, 700);
        setBackground(backgroundImage);
        
        int length = Modifier.timeList.size(); // could cause null pointer
        for(int i=0;i<length;i++){
            time=time*10+Modifier.timeList.get(i);
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
            
            if (soldierChoice == 1){
                soldier = new Bandit(direction);
            }
            else if (soldierChoice == 2){
                soldier = new Knight(direction);
            }
            else if (soldierChoice == 3){
                soldier = new Healer(direction);
            }
            else if (soldierChoice == 4 ){
                soldier = new BeefyBandit(direction);
            }
            else{
                soldier = new Bandit(direction);
            }
            
            addObject(soldier, xSpawn, ySpawn);
        }
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
    
}
