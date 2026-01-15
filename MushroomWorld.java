import greenfoot.*;
import java.util.Random;

public class MushroomWorld extends World
{
    private Player player;
    
    // BACKGROUND MUSIC
    private GreenfootSound bgMusic = new GreenfootSound("mushroom_music.mp3");
    
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
    
    // Message for player (when they complete firefly quest)
    private Label fireflyCompleteMsg;
    
    // Firefly quest variables
    private boolean questStarted = false;
    private boolean questCompleted = false; // MIGHT NOT NEED HTHIS BUT DON"T DELETE YET
    private boolean fireflyQuestActive = false;
    private boolean firefliesComplete = false;
    
    // Firefly light thing (lantern)
    private boolean lanternGiven = false;
    private boolean lanternDialogueSeen = false;
    
    private boolean bookSpawned = false;
    
    // Normal constructor (first time entering world)
    public MushroomWorld()
    {
        this(false, -1, -1);
    }
    
    // Return constructor (after instructions)
    public MushroomWorld(boolean instructionsRead, int playerX, int playerY)
    {
        super(1000, 700, 1);
        
        // Background music
        bgMusic.setVolume(60);
        bgMusic.playLoop();
        
        this.instructionsRead = instructionsRead;
        
        // Sets background
        GreenfootImage background = new GreenfootImage("mushroom_background.png");
        background.scale(getWidth(), getHeight());
        setBackground(background);
        
        // Adds mushroom hut
        addObject(new MushroomHut(), 240, 200);
        
        // Adds mushroom
        mushroom = new MushroomChibiNPC();
        addObject(mushroom, 80, 450);
        
        
        //Adds door and book after lantern is given
        if(instructionsRead && lanternGiven == true)
        {
            Door door = new Door();
            addObject(door, 500, 500);
        }
        
        // Adds player
        player = new Player();
        addObject(player, getWidth() / 2, getHeight() / 2);
    }

    public void openControls()
    {
        savedPlayerX = player.getX();
        savedPlayerY = player.getY();
            
        Greenfoot.setWorld(new PlayerControls(this, savedPlayerX, savedPlayerY));
    }
    
    // Called by Player when touching NPC
    public void openInstructions()
    {
        // Save player position before leaving
        savedPlayerX = player.getX();
        savedPlayerY = player.getY();
        
        int stage = getDialogueStage();
        
        if(stage == 2)
        {
            lanternDialogueSeen = true;
        }
        Greenfoot.setWorld(new Instructions(this, stage, player.getX(), player.getY()));
    }
    
    // Starts the quest
    public void startFireflyQuest()
    {
        if (fireflyQuestActive) return;
    
        fireflyQuestActive = true;
    
        fireflyCounter = new FireflyCounter();
        addObject(fireflyCounter, 80, 670);
    
        spawnFireflies();
    }
    
    // Spawns the fireflies
    private void spawnFireflies()
    {
        int half = 20;
        
        for (int i = 0; i < 3; i++)
        {
            int minX = 500 + half;                 // 500 → but shifted right 20px
            int maxX = getWidth() - half;          // 1000 - 20 = 980
            int x = minX + Greenfoot.getRandomNumber(maxX - minX + 1);
    
            int minY = half;                       // 20
            int maxY = getHeight() - half;         // 700 - 20 = 680
            int y = minY + Greenfoot.getRandomNumber(maxY - minY + 1);
            addObject(new Firefly(), x, y);
        }
    }
    
    // Collects fireflies
    public void collectFirefly()
    {
        if (fireflyCounter == null) return;
        
        fireflyCounter.addFirefly();
        
        int count = fireflyCounter.getCount();
        
        //checks if quest is completed
        if(count == 3 && !firefliesComplete)
        {
            firefliesComplete = true;
            
            if(fireflyCompleteMsg == null)
            {
                FireflyHint hint = new FireflyHint();
                addObject(hint, getWidth() / 2, 30);
            }
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
        
        // Remove firefly counter safely
        if (fireflyCounter != null)
        {
            removeObject(fireflyCounter);
            fireflyCounter = null;
        }

    
        // Add lantern light
        addObject(new FireflyLight(player), player.getX(), player.getY());
        
        //adds door after lantern is given
        lanternGiven = true;
        
        // Remove "go talk to the girl" message
        if (lanternGiven == true)
        {
            removeObject(fireflyCompleteMsg);
        }
        
        // Spawns the new door
        Door door = new Door();
        addObject(door, 240, 230);
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
    
    public boolean hasSeenLanternDialogue()
    {
        return lanternDialogueSeen;
    }
    
    public void setLanternDialogueSeen()
    {
        lanternDialogueSeen = true;
    }
    
    public void setPlayerPosition(int x, int y)
    {
        if (player != null)
        {
            player.setLocation(x, y);
        }
    }
    
    //spawns book after dialogue
    public void spawnBookIfNeeded()
    {
        if(!bookSpawned)
        {
            Book book = new Book();
            addObject(book, getWidth() - 60, 60);
            bookSpawned = true;
        }
    }
    
    // Stops and starts music when entering and leaving world
    public void stopMusic() 
    {
        bgMusic.stop();
    }
    
    public void started() 
    {
        bgMusic.playLoop();
    }
}
