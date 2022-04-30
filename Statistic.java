import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class keeps track of all the statistics 
 */

public class Statistic extends Actor
{
    /**
     * The Counter Bar: The Bar in the top middle of the screen
     * Angus Feng 
     */
    int score;
    int money;
    int time;
    private int gold = 0;
    
    private int kills = 0;
    private int a;
    private int b;
    private int c;
    
    public Statistic(boolean side, int gold){
        if (side){
            a = 255;
            b = 204;
            c =203;
            this.gold=gold;
        }
        else{
            a = 202;
            b = 255;
            c = 255;
            this.gold=gold;
        }
        setImage(new GreenfootImage("Gold: "+ gold + "\n Kills: " + kills,40, Color.BLACK, new Color(a, b, c)));
    }
    public void act()
    {
        //Updates the Counter Bar
        
         setImage(new GreenfootImage("Gold: "+ gold + "\n Kills: " + kills,40, Color.BLACK, new Color(a, b, c)));
    }
    /**
     * These update the stats displayed
     */
    public void updateGold(int gold){
        this.gold += gold;
        
    }
    public void updateKills(){
        this.kills++;
    }
    
    public int getGold(){
        return gold;
    }
    
}
