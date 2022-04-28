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
    int upgradeTimer = 0;
    public ArcherTower(int direction){
        super(direction);
        image = new GreenfootImage("archerTower.png");
        setImage(image);
        getImage().scale(100, 100);
        

        this.hp = 300;
        this.attackSpeed = 5;

 
        this.attackRange = 280;
        this.damage = 5;
        this.triggerRange = 360;
        if (direction == -1) getImage().mirrorHorizontally();
        if (direction == 1) hpBar = new StatBar(hp, hp, this, 75, 7, 50, Color.RED, new Color(255, 204, 203), false, Color.WHITE, 1);
        else hpBar = new StatBar(hp, hp, this, 75, 7, 50, Color.CYAN, new Color(202, 255, 255), false, Color.BLACK, 1);
    }
    
    public void act()
    {
        
        timer++;
        upgradeTimer++;
        if (timer == attackSpeed){
            attack();
            timer = 0;
        }
        if (upgradeTimer == 300){
            upgrade();
        }
        
        super.act();
    }
    public void upgrade(){
        image = new GreenfootImage("ArcherTower2.png");
        setImage(image);
        getImage().scale(116, 100);
        if (attackSpeed >= (attackSpeed - 5)){
            this.attackSpeed -= 5;
        }
        this.damage += 5;
        this.attackRange += 100;
        this.triggerRange += 100;
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
