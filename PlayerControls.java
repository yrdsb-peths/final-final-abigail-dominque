import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class PlayerControls extends World
{
    private World returnWorld;
    
    public PlayerControls(World world, int x, int y)
    {    
        super(1000, 700, 1); 
        this.returnWorld = world;
        
        String [] dialogue = {
            "Arrow keys to move",
            "Press space to talk",
            "When you're finished reading, press escape to leave!",
            "..."
        };
            
        addObject(new DialogueBox(dialogue), getWidth()/2, getHeight()/2);
    }
    
    public void act()
    {
        if (Greenfoot.isKeyDown("escape"))
        {
            Greenfoot.setWorld(returnWorld);
        }
    }
}
