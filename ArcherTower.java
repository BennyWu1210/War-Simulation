import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class ArcherTower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ArcherTower extends Tower
{
    /**
     * Act - do whatever the ArcherTower wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private double attackSpeed, attackRange, triggerRange, damage;
    int timer;
    public ArcherTower(int direction){
        super(direction);
        image = new GreenfootImage("archerTower.png");
        setImage(image);
        getImage().scale(100, 100);
        
        this.attackSpeed = 5;
        this.attackRange = 280;
        this.damage = 0.1;
        this.triggerRange = 360;
        if (direction == -1) getImage().mirrorHorizontally();
        if (direction == 1) hpBar = new StatBar(1000, 1000, this, 125, 7, 100, Color.RED, new Color(255, 204, 203), false, Color.WHITE, 1);
        else hpBar = new StatBar(1000, 1000, this, 125, 7, 100, Color.CYAN, new Color(202, 255, 255), false, Color.BLACK, 1);
    }
    public void act()
    {
        timer++;
        if (timer == 1){
            attack();
            timer = 0;
        }
        
        
    }
    public void attack(){
        if (target == null || target.getWorld() == null){
            List<Soldier> enemies = getObjectsInRange((int)this.triggerRange, Soldier.class);
        
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
                Arrow a = new Arrow(target);
                getWorld().addObject(a, getX(), getY());
            }
        }
    }
}
