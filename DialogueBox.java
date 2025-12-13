import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class DialogueBox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DialogueBox extends Actor
{
    // Instance variables
    private String[] lines;
    
    private int lineIndex = 0;
    
    private int charIndex = 0;
    
    private int delay = 3;
    
    private int counter = 0;
    
    private boolean lineFinished = false;
    
    //Dialogue constructor
    public DialogueBox(String[] dialogue)
    {
        lines = dialogue;
        updateImage("");
    }
    
    public void act()
    {
        counter++;
        
        //Makes typing effect 
        if(!lineFinished && counter % delay == 0)
        {
            charIndex++;
            
            if(charIndex >= lines[lineIndex].length())
            {
                charIndex = lines[lineIndex].length();
                lineFinished = true;
            }
        
            updateImage(lines[lineIndex].substring(0, charIndex));
        
        }
        
        //Space to change the dialogue
        if(Greenfoot.isKeyDown("space"))
        {
            //Controls speed
            Greenfoot.delay(10);
            
            if(!lineFinished)
            {
                //Finishes sentence immediately
                charIndex = lines[lineIndex].length();
                updateImage(lines[lineIndex]);
                lineFinished = true;
            }
            else
            {
                //Moves to next sentence
                lineIndex++;
                if (lineIndex < lines.length)
                {
                    charIndex = 0;
                    lineFinished = false;
                    updateImage("");
                }
                else
                {
                    //If all dialogue is done
                    getWorld().removeObject(this);
                }
            }
        }
    }
    
    private void updateImage(String dialogue)
    {
        setImage(new GreenfootImage(dialogue, 30, Color.BLACK, Color.WHITE));
    }
    
}
