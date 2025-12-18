import greenfoot.*;
import java.util.Random;

public class MushroomWorld extends World
{
    private Player player;
    
    // Chibi instance variable
    private MushroomChibiNPC mushroom;
    
    // Checks if you talked to the chibi
    private boolean talkedToChibi = false;
    
    // Save player position
    private int savedPlayerX;
    private int savedPlayerY;
    
    // Checks if instructions were read
    private boolean instructionsRead;

    // Firefly instance variables
    private FireflyCounter fireflyCounter;
    
    // Firefly quest variables
    private boolean questStarted = false;
    private boolean questCompleted = false; // MIGHT NOT NEED HTHIS BUT DON"T DELETE YET
    private boolean fireflyQuestActive = false;
    private boolean firefliesComplete = false;
    
    // Firefly light thing (lantern)
    private boolean lanternGiven = false;
    
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
            player.setLocation(playerX + 150, playerY);
        }
        
        //Adds book and cooking pot after instructions
        if(instructionsRead)
        {
            Book book = new Book();
            addObject(book, 950, 50);
            
            CookingPot pot = new CookingPot();
            addObject(pot, 600, 300);
        }
    }

    // Called by Player when touching NPC
    public void openInstructions()
    {
        // Save player position before leaving
        savedPlayerX = player.getX();
        savedPlayerY = player.getY();
        
        int stage = getDialogueStage();
        
        Greenfoot.setWorld(new Instructions(stage, player.getX(), player.getY()));
    }
    
    // Called by Player when touching CookingPot
    public void startCooking()
    {
        savedPlayerX = player.getX();
        savedPlayerY = player.getY();
        
        Greenfoot.setWorld(new CookingWorld(player.getX(), player.getY()));
    }
    
    // Starts the quest
    public void startFireflyQuest()
    {
        if (fireflyQuestActive) return;
    
        fireflyQuestActive = true;
    
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
        if (fireflyCounter == null) return;
    
        fireflyCounter.addFirefly();
    
        if (fireflyCounter.getCount() >= 3)
        {
            firefliesComplete = true;
    
            Label msg = new Label(
                "You've collected all the fireflies! Go talk to the girl.",
                24
            );
            addObject(msg, getWidth()/2, 30);
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
        if(lanternGiven) return;
        
        lanternGiven = true;
        
        // Remove counter
        removeObject(fireflyCounter);
        
        // Add light
        addObject(new FireflyLight(player), player.getX(), player.getY());
        
        // Safety just in case fireflyCounter is null
            if (fireflyCounter != null)
        {
            removeObject(fireflyCounter);
        }
    }
    
    public boolean isQuestStarted()
    {
        return questStarted;
    }
    
    public boolean hasTalkedToChibi()
    {
        return talkedToChibi;
    }
    
    public void setTalkedToChibi(boolean value)
    {
        talkedToChibi = value;
    }
    
    public boolean areFirefliesComplete()
    {
        return firefliesComplete;
    }

    public int getDialogueStage()
    {
        if (!talkedToChibi)
            return 0; // first time (intro)
    
        if (firefliesComplete && !lanternGiven)
            return 2; // after collecting fireflies
    
        return 1; // reminder dialogue (during quest)
    }
}
