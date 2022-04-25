import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Statistic extends Actor
{
    /**
     * The Counter Bar: The Blue Bar in the top middle of the screen
     * 
     */
    int score;
    int money;
    int time;
    private int gold = 0;
    
    private int kills = 0;
    private int a;
    private int b;
    private int c;
    private int econ = 5;
    public Statistic(boolean side){
        if (side){
            a = 255;
            b = 204;
            c =203;
        }
        else{
            a = 202;
            b = 255;
            c = 255;
            
        }
        setImage(new GreenfootImage("Gold: "+ gold + "\n " + econ + " per 3 seconds",40, Color.BLACK, new Color(a, b, c)));
    }
    public void act()
    {
        //Updates the Counter Bar
        
         setImage(new GreenfootImage("Gold: "+ gold + "\n " + econ + " per 3 seconds",40, Color.BLACK, new Color(a, b, c)));
    }
    public void setGold(int gold){
        this.gold += gold;
        
    }
    public void setKill(){
        this.kills++;
    }
    
    public int getGold(){
        return gold;
    }
    public void setEcon(int econ){
        this.econ += econ;
    }
}
