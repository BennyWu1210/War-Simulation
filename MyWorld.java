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
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 
        backgroundImage = new GreenfootImage("Background.jpg");
        backgroundImage.scale(1000, 600);
        setBackground(backgroundImage);
  
    }
    private void spawner(int yDirection){
        int direction = yDirection;
        if (Greenfoot.getRandomNumber(60) == 0){
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
            else if (soldierChoice == 4){
                soldier = new BeefyBandit(direction);
            }
            else{
                soldier = new Bandit(direction);
            }
            
            addObject(soldier, xSpawn, ySpawn);
        }
    }
    public void act(){
        spawner(1);
        spawner(-1);
    }
    
}
