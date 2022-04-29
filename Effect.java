import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * The effect class, minimum changes from the original
 * 
 * @author Benny, Kevin Zhu
 * @version April 25th, 2022
 */
public class Effect extends Actor
{
    protected int totalActs, actCounter;
    private boolean fade = true;
    protected GreenfootImage image;
    
    // For gif images
    protected boolean isGif;
    protected List<GreenfootImage> gifImageList;
    protected GifImage gifImage;
    protected int gifCounter, gifIndex, gifChangeRate, gifCycle;
   
    public Effect (int totalActs){
        this.isGif = false;
        this.totalActs = totalActs;
        actCounter = totalActs;
    }
   
    public Effect (int totalActs, boolean fade){
        this.isGif = false;
        this.fade = fade;
        this.totalActs = totalActs;
        actCounter = totalActs;
    }
    
    public Effect(GifImage gifImage, int gifChangeRate, int gifCycle){
        this.isGif = true;
        this.gifImage = gifImage;
        this.gifImageList = gifImage.getImages();
        this.gifChangeRate = this.gifCounter = gifChangeRate;
        this.gifIndex = 0;
        this.gifCycle = gifCycle;
    }
   
    
    public void act()
    {
        if (isGif){
            gifCounter --;
            
            if (gifCounter <= 0){
                getImage();
                gifIndex ++;
                gifCounter = gifChangeRate;
            }
            if (gifIndex == gifImageList.size()){
                gifIndex = 0;
                gifCycle --;
            }
            if (gifCycle == 0){
                getWorld().removeObject(this);
                return;
            }
        } 
        else if (totalActs != -1){
            if (actCounter > 0){
                actCounter--;
                if (actCounter < 60 && fade == true){ // last second
                    image.setTransparency (actCounter * 2);
                }
            } else {
                getWorld().removeObject(this);
               
            }
        } 
    }
    
    public GreenfootImage getImage(){
        return isGif ? gifImageList.get(gifIndex) : image;
    }
   
}