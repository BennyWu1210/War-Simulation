import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CrystalTower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CrystalTower extends Tower
{
    
  
    private static int maxHp = 1000;    
    public CrystalTower(int direction){
        super(direction);
        this.hp = maxHp;
        image = new GreenfootImage("Crystal.png");
        setImage(image);
        getImage().scale(80, 172);
        if (direction == -1) getImage().mirrorHorizontally();
        // intialize hp bar
        if (direction == 1) hpBar = new StatBar(maxHp, maxHp, this, 125, 7, 100, Color.RED, new Color(255, 204, 203), false, Color.WHITE, 1);
        else hpBar = new StatBar(maxHp, maxHp, this, 125, 7, 100, Color.CYAN, new Color(202, 255, 255), false, Color.BLACK, 1);
        
    }
    
    
    public void act()
    {
        // Add your action code here.
    }
}
