import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * The Entity class controls most of the objects that will be displayed in the simulation.
 * It implements gif methods as well as cost, health bar option, damage, upgrade, move, etc.
 * 
 * @author (Benny Wu) 
 * @version April 14th, 2022
 */
public class Entity extends Actor
{
    
    // For gif images
    protected boolean isGif;
    protected List<GreenfootImage> gifImageList;
    protected GifImage gifImage;
    protected int gifCounter, gifIndex, gifChangeRate, gifCycle;
    protected GreenfootImage image;
    
    // keep track of the duration
    protected int actCounter;
    
    // coordinates and movements
    protected double xPos, yPos;
    protected double speed;
    
    
    
    public Entity(){
        this.isGif = false;
    }
    
    public void act()
    {
        // Add your action code here.
    }
    

    /**
     * Override getImage for gif purposes
     */
    public GreenfootImage getImage(){
        return isGif ? gifImageList.get(gifIndex) : image;
    }
    
    /**
     * Return distance from a coordinate 
     * 
     * @return double  the distance from a location, as a double
     */
    public double getDistance(double x, double y){
        return Math.sqrt(x * x + y * y);
    }
    
    /**
     * Return distance from an actor 
     * 
     * @return double  the distance from another actor, as a double
     */
    public double getDistance(Actor actor){
        double x = actor.getX(), y = actor.getY();
        return Math.sqrt(x * x + y * y);
    }
    
    /**
     * 
     */
    public void move(double x, double y){
        // TODO
    }
    
    
}
