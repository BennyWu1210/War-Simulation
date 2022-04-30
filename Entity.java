import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * The Entity class controls most of the objects that will be displayed in the simulation.
 * It implements gif methods as well as cost, health bar option, damage, upgrade, move, etc.
 * 
 * @author (Benny Wu) 
 * @version April 28th, 2022
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
    protected boolean faceLeft;
    
    // Target of this entity
    protected Soldier target;
    
    
    /**
    * The superclass for all entities inside the game. They share common features such as moving and dealing damage.
    * It can be seen as a modified (optimized) version of the actor class.
    * 
    * @param direction  the direction this sodlier is facing  
    */
    
    public Entity(int direction){
        this.faceLeft = direction == -1;
        this.isGif = false;
        this.direction = direction;
    }
    
    /**
    * An alternate constructor for entities with gifs
    * 
    * @param isGif  the direction this sodlier is facing  
    */
    public Entity(boolean isGif){
        this.direction = 1;
        this.isGif = isGif;
    }
    
    /**
    * An alternate constructor for entities 
    * 
    * @param target  the target of this entity
    */
    public Entity(Soldier target){
        this.target = target;
    }
    
    /**
     * Mirrors the image if it is facing in the opposite direction
     */
    public void addedToWorld(World w){
        if (direction == -1) getImage().mirrorHorizontally();
    }
    

    /**
     * Override getImage for gif purposes
     */
    public GreenfootImage getImage(){
        return isGif ? gifImageList.get(gifIndex) : image;
    }
    
    /**
     * Returns distance from a coordinate 
     * 
     * return double  the distance from a location, as a double
     */
    public double getDistance(double x, double y){
        double xDif = getX() - x, yDif = getY() - y;
        return Math.sqrt(xDif * xDif + yDif * yDif);
    }
    
    /**
     * Returns distance from an actor 
     * 
     * @param return double  the distance from another actor, as a double
     */
    public double getDistance(Actor actor){
        return getDistance(actor.getX(), actor.getY());
    }
    
    /**
     * Move toward a coordinate
     * 
     * param x, y - the coordinates of the destination
     */
    public void move(double x, double y){
        // Basic calculations to get the distance in both directions
        double dis = getDistance(x, y);
        double blocks = dis / speed;
        double xDif = (x - getX()) / blocks;
        double yDif = (y - getY()) / blocks;
        
        // Adjust the movement
        double xAdjust = xDif > 0 ? 0.5 : -0.5, yAdjust = yDif > 0 ? 0.5 : -0.5;
        setLocation(getX() + (int)(xDif + xAdjust), getY() + (int)(yDif + yAdjust));
        
        // cHanges its direction when moving in opposite directions
        if (xDif < 0) {
            if (!faceLeft) getImage().mirrorHorizontally();
            faceLeft = true;
        }
        else {
            if (faceLeft) getImage().mirrorHorizontally();
            faceLeft = false;
        }
    }
    
    /**
     * Move toward an actor
     * 
     */
    public void move(Actor actor){
        move(actor.getX(), actor.getY());
    }

    
    /**
     * Turn toward a specified actor
     */
    public void turnTowards(Actor actor){
        turnTowards(actor.getX(), actor.getY());
    }
    
    /**
     * Returns direction of this soldier
     * 
     * @param return int  the direction this enetity is facing
     */
    public int getDirection(){
        return this.direction;
    }
    
}
