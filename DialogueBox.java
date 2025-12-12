import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DialogueBox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DialogueBox extends Actor
{
    /**
     * Act - do whatever the DialogueBox wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public DialogueBox(String dialogue)
    {
        updateImage(dialogue);
    }
    
    private void updateImage(String dialogue)
    {
        GreenfootImage pic = new GreenfootImage(500, 120);
        pic.setColor(new Color(255, 255, 255, 220));
        pic.fillRect(0, 0, 500, 120);
        
        pic.setColor(Color.BLACK);
        pic.setFont(new Font("Arial", 24));
        pic.drawString(dialogue, 20, 60);
        
        setImage(pic);
    }
    
    private void setDialogue(String dialogue)
    {
        updateImage(dialogue);
    }
    
    public void act()
    {
        // Add your action code here.
    }
    
    
}
