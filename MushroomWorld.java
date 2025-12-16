import greenfoot.*;
import java.util.Random;

public class MushroomWorld extends World
{
    private Player player;
    private MushroomChibiNPC mushroom;

    // Save player position
    private int savedPlayerX;
    private int savedPlayerY;
    
    private boolean instructionsRead;

    // Firefly instance variables
    private FireflyCounter fireflyCounter;
    
    // Firefly quest variables
    private boolean questStarted = false;
    private boolean questCompleted = false;
    
    // Normal constructor (first time entering world)
    public MushroomWorld()
    {
        this(false, -1, -1);
    }
    
    // Return constructor (after instructions)
    public MushroomWorld(boolean instructionsRead, int playerX, int playerY)
    {
        super(1000, 700, 1);
       
        this.instructionsRead = instructionsRead;
        
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
        
        //restore position
        if(playerX != -1 && playerY != -1)
        {
            player.setLocation(playerX +40, playerY);
        }
        
        //Adds book after instructions
        if(instructionsRead)
        {
            Book book = new Book();
            addObject(book, 950, 50);
        }
    
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
    
    // Starts the quest
    public void startFireflyQuest()
    {
        if (questStarted) return;
    
        questStarted = true;
    
        fireflyCounter = new FireflyCounter();
        addObject(fireflyCounter, 120, 40);
    
        spawnFireflies();
    }
    
    // Spawns the fireflies
    private void spawnFireflies()
    {
        for (int i = 0; i < 3; i++)
        {
            int x = Greenfoot.getRandomNumber(getWidth() - 500) + 500;
            int y = Greenfoot.getRandomNumber(getHeight() - 100) + 50;
    
            addObject(new Firefly(), x, y);
        }
    }
    
    // Collects fireflies
    public void collectFirefly()
    {
        if (fireflyCounter != null)
        {
            fireflyCounter.addFirefly();
        }
    }
    
    public boolean hasAllFireflies()
    {
        return fireflyCounter != null && fireflyCounter.getCount() >= 3;
    }

    public boolean lanternAlreadyGiven()
    {
        return lanternGiven;
    }

    public void giveLantern(Player player)
    {
        lanternGiven = true;
    
        // Remove counter
        removeObject(fireflyCounter);
    
        // Give lantern
        addObject(new FireflyLantern(), player.getX(), player.getY() - 50);
    }
}
