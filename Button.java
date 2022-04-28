import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * An abstract class that provides properties and functinalities for various buttons
 * 
 * @author Benny Wu, Kevin Zhu
 * @version Apr. 20th, 2022
 */
public abstract class Button extends Actor
{
    //initialized the variable 
    protected GreenfootImage[] images = new GreenfootImage[2];
    private GreenfootSound[] clickSound;
    private int clickSoundIndex;
    
    //Create a play click sound method
    public void clicksSound(){
        //set up and initalize for the sound preparation
        clickSoundIndex=0;
        clickSound=new GreenfootSound [20];
        for(int i=0;i<clickSound.length;i++){
            clickSound[i]=new GreenfootSound("Click.wav");
        }
        
        //output
        clickSound[clickSoundIndex].setVolume(80);
        clickSound[clickSoundIndex].play();
        clickSoundIndex++;
        if(clickSoundIndex>clickSound.length-1){
            clickSoundIndex=0;
        }
    }
    
    public void act(){
        onClick();
        onHover();
        if(Greenfoot.mouseClicked(this)){
            //play the sound
            clicksSound();
        }
        
    }
    
    // Stores the initial image and the image when hovered 
    public abstract void onClick();
    public abstract void onHover();
}
