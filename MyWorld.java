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
            int xSpawn = 50;
            if (direction == -1)
                xSpawn = 950;
            if (soldierChoice == 1){
                addObject(new Bandit(direction),xSpawn, ySpawn);
            }
            else if (soldierChoice == 2){
                addObject(new Knight(direction), xSpawn, ySpawn);
            }
            else if (soldierChoice == 3){
                addObject(new Healer(direction), xSpawn, ySpawn);
            }
            else if (soldierChoice == 4){
                addObject(new BeefyBandit(direction), xSpawn, ySpawn);
            }
        }
    }
    public void act(){
        spawner(1);
        spawner(-1);
    }
}
