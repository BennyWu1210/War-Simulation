import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * The Crystal Tower is a tower which shoots fireballs when soldiers are in its
 * range. It is also the most important tower as whichever side is able to kill
 * their opponent's crystal tower first wins.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CrystalTower extends Tower
{
    
  
    private int timer;
    public CrystalTower(int direction){
        super(direction);
        this.hp = this.maxHp = 860;
        this.attackSpeed = 5;
        this.attackRange = 400;
        this.damage = 10;
        this.triggerRange = 360;
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
        timer++;
        //the tower attacks every half second
        if (timer == 30){
            attack();
            timer = 0;
        }
    }
    public void attack(){
        if (target == null || target.getWorld() == null){
            
        
            List<Soldier> enemies = getObjectsInRange((int)this.triggerRange / 3, Soldier.class);
            
            if (enemies.size() == 0) enemies = getObjectsInRange((int)this.triggerRange, Soldier.class);
            if (enemies.size() != 0){
                int index = 0;
                
                while (index < enemies.size()){
                    Soldier nxt = enemies.get(index);
                    if (nxt.getDirection() != this.getDirection()){
                        target = nxt;
                        break;
                    }
                    index ++;
                }
            }
        
        } else{
            if (getDistance(target) <= attackRange){
                Fireball f = new Fireball(target);
                getWorld().addObject(f, getX(), getY() - 75);
            }
        }
    }
}
