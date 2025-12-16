import greenfoot.*;
import java.util.Random;

public class MushroomWorld extends World
{
    private Player player;
    private MushroomChibiNPC mushroom;

    // Save player position
    private int savedPlayerX;
    private int savedPlayerY;

    // Firefly instance variables
    private FireflyCounter fireflyCounter;
    
    // Normal constructor (first time entering world)
    public MushroomWorld()
    {
        super(1000, 700, 1);
        
        // Sets background
        GreenfootImage background = new GreenfootImage("background.png");
        background.scale(getWidth(), getHeight());
        setBackground(background);
        
        // Adds mushroom hut
        addObject(new MushroomHut(), 100, 200);
        
        // Adds mushroom
        mushroom = new MushroomChibiNPC();
        addObject(mushroom, 80, 400);
        
        // Adds player
        player = new Player();
        addObject(player, getWidth() / 2, getHeight() / 2);
        
        // Adds firefly counter
        fireflyCounter = new FireflyCounter();
        addObject(fireflyCounter, 120, 40);
        
        // Adds three fireflies randomly
        for(int i = 0; i < 3; i++)
        {
            int minX = 250;
            int maxX = getWidth() - 25;
            
            int x = Greenfoot.getRandomNumber(maxX - minX) + minX;
            int y = Greenfoot.getRandomNumber(getHeight() - 100) + 50;
        
            addObject(new Firefly(), x, y);
        }
    }
    
    // Return constructor (after instructions)
    public MushroomWorld(int playerX, int playerY)
    {
        this(); // builds world normally
        player.setLocation(playerX + 40, playerY); // restore position
    }

    // Called by Player when touching NPC
    public void openInstructions()
    {
        // Save player position before leaving
        savedPlayerX = player.getX();
        savedPlayerY = player.getY();

        Greenfoot.setWorld(
            new Instructions(player.getX(), player.getY())
        );
    }
}
