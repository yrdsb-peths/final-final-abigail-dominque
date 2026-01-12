import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class PlayerControls extends World
{
    private MushroomWorld returnWorld;
    
    public PlayerControls(MushroomWorld world, int x, int y)
    {    
        super(1000, 700, 1); 
        this.returnWorld = world;
        
        String [] dialogue = {
            "Arrow keys to move",
            "Press space to talk",
            "When you're finished reading, press escape to leave!",
            "..."
        };
        
        String[] playerSounds = {
            "chef1.mp3",
            "chef1.mp3",
            "chef1.mp3",
            "chef1.mp3",
        };
        addObject(new DialogueBox(dialogue, playerSounds), getWidth()/2, getHeight()/2);
    }
    
    public void act()
    {
        if (Greenfoot.isKeyDown("escape"))
        {
            Greenfoot.setWorld(returnWorld);
        }
    }
}
