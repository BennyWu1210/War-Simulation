import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The text class will allow user to create text
 * 
 * @author Kevin Zhu
 * @version April 28, 2022
 */
public class Text extends Actor
{
    /**
     * This constructor will set the text 
     * 
     * @param text   this is the text that user want to create
     * @param font   this is the size of the text
     * @param colour this is the colour of the text
     */
     public Text(String text, int font, Color colour){
        setImage(new GreenfootImage(text, font, colour, null));
    }
}
