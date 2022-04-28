import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * The Inferno Tower is a tower which shoot fireballs at a fast rate when
 * soldiers get near it. It also loses hp automatically.
 * 
 * @author Benny Wu
 * @version (a version number or a date)
 */
public class InfernoTower extends Tower
{
    /**
     * Act - do whatever the ArcherTower wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    int timer;
    public InfernoTower(int direction){
        super(direction);
        image = new GreenfootImage("Inferno_Tower1.png");
        setImage(image);
        getImage().scale(80, 100);
        
        //the tower shoots 4 times per second
        this.attackSpeed = 15;
        this.attackRange = 280;
        this.damage = 0.1;
        this.triggerRange = 390;
        this.hp = this.maxHp = 900;
        if (direction == -1) getImage().mirrorHorizontally();
        if (direction == 1) hpBar = new StatBar(hp, hp, this, 75, 7, 50, Color.RED, new Color(255, 204, 203), false, Color.WHITE, 1);
        else hpBar = new StatBar(hp, hp, this, 75, 7, 50, Color.CYAN, new Color(202, 255, 255), false, Color.BLACK, 1);
    }
    public void act()
    {
        
        timer++;
        if (timer == attackSpeed){
            attack();
            timer = 0;
        }
        super.act();
        
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
                Fireball f = new Fireball(target);
                getWorld().addObject(f, getX(), getY());
            }
        }
    }
}
