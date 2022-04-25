import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CrystalTower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CrystalTower extends Tower
{
    
  
    
    public CrystalTower(int direction){
        super(direction);
        image = new GreenfootImage("Crystal.png");
        setImage(image);
        getImage().scale(80, 172);
        
        // intialize hp bar
        if (direction == 1) hpBar = new StatBar(1000, 1000, this, 75, 7, 35, Color.RED, new Color(255, 204, 203), false, Color.WHITE, 1);
        else hpBar = new StatBar(100, 80, this, 75, 7, 35, Color.CYAN, new Color(202, 255, 255), false, Color.BLACK, 1);
        
    }
    
    
    public void act()
    {
        // Add your action code here.
    }
}
