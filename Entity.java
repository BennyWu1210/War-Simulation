import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * The Entity class controls most of the objects that will be displayed in the simulation.
 * It implements gif methods as well as cost, health bar option, damage, upgrade, move, etc.
 * 
 * @author (Benny Wu) 
 * @version April 21th, 2022
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
    protected int direction;
    
    // Target of this entity
    protected Soldier target;
    
    
    
    public Entity(int direction){
        this.isGif = false;
        this.direction = direction;
    }
    
    public Entity(boolean isGif){
        this.direction = 1;
        this.isGif = isGif;
    }
    
    public void act()
    {
        // Add your action code here.
    }
    
    public void addedToWorld(){
        if (direction == -1) getImage().mirrorHorizontally();
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
        double xDif = getX() - x, yDif = getY() - y;
        return Math.sqrt(xDif * xDif + yDif * yDif);
    }
    
    /**
     * Return distance from an actor 
     * 
     * @return double  the distance from another actor, as a double
     */
    public double getDistance(Actor actor){
        return getDistance(actor.getX(), actor.getY());
    }
    
    /**
     * Move toward a coordinate
     */
    public void move(double x, double y){
        double dis = getDistance(x, y);
        double blocks = dis / speed;
        double xDif = (x - getX()) / blocks;
        double yDif = (y - getY()) / blocks;
        setLocation(getX() + (int)xDif, getY() + (int)(yDif + 0.5));
    }
    
    /**
     * Move toward an actor
     */
    public void move(Actor actor){
        move(actor.getX(), actor.getY());
    }
    
    
}
