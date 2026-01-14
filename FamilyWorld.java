import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class FamilyWorld extends World
{
    // BACKGROUND MUSIC
    private GreenfootSound bgMusic = new GreenfootSound("familyworld_music.mp3");
    
    // Save player position
    private int savedPlayerX;
    private int savedPlayerY;
    
    // Spawns the chibi
    private ChefChibiNPC chef;
    
    // Instructions that chef gives to player
    private boolean chefIntro = false;
    private boolean talkedToChef = false;
    private boolean instructionsRead = false;
    private boolean questStarted = false;
    private boolean questCompleted = false;
    private int stage = 0;

    // Checks if you've talked to the chibi so it can add the pot
    private boolean talkedToChibi = false;

    // Player variable
    private Player player;
    
    // Checks if sugar cookies are made (for the quest)
    private boolean sugarCookiesGiven;
    private boolean sugarCookieMade = false;
    
    //for the reminder text after instructions
    private CookingText reminder;
    private boolean reminderTextShown = false;
    
    // Cooking pot variables
    private CookingPot pot;
    public boolean removePotAfterText = false;
    private boolean cookingInProgress = false;

    public FamilyWorld(int playerX, int playerY)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 700, 1); 
 
        // Background music
        bgMusic.setVolume(40);
        bgMusic.playLoop();
        
        // Sets background
        GreenfootImage background = new GreenfootImage("familyworld_bg.jpg");
        background.scale(getWidth(), getHeight());
        setBackground(background);
        
        // adds randoms into the world because the chef is so cheeky
        FamilyWorldNPC2 npc5 = new FamilyWorldNPC2();
        addObject(npc5, 538, 255);
        
        FamilyWorldNPC npc = new FamilyWorldNPC();
        addObject(npc, 420, 257);
        
        FamilyWorldNPC2 npc1 = new FamilyWorldNPC2();
        addObject(npc1, 502, 389);
        
        FamilyWorldNPC npc2 = new FamilyWorldNPC();
        addObject(npc2, 590, 333);
        
        FamilyWorldNPC2 npc3 = new FamilyWorldNPC2();
        addObject(npc3, 743, 325);
        
        FamilyWorldNPC npc4 = new FamilyWorldNPC();
        addObject(npc4, 312, 396);
        
        
        
        // PLACEHLODER
        // PLACEHLODER
        // PLACEHLODER
        // PLACEHLODER
        // adds chef npc
        chef = new ChefChibiNPC();
        addObject(chef, 200, 500);
        
        // Adds the lumenfly onto the chef
        LumenflyIndicator lumen = new LumenflyIndicator();
        addObject(lumen, 230, 410);
        
        // adds the instructions book
        Book book = new Book();
        addObject(book, 950, 50);

        // adds the player
        player = new Player();
        addObject(player, getWidth() / 2, getHeight() / 2);
          
        // Checks if player is cooking
        cookingInProgress = false;
        
        //restore position
        if(playerX != -1 && playerY != -1)
        {
            player.setLocation(playerX - 50, playerY + 100);
        }
    }
    
    public void act()
    {
        
    }

    // Called by Player when touching CookingPot
    public void startCooking()
    {
        if (cookingInProgress)
        {   
            return;
        }
        
        cookingInProgress = true;
        
        savedPlayerX = player.getX();
        savedPlayerY = player.getY();
        
        //slightly moves player so the pot is not triggered again 
        player.setLocation(player.getX(), player.getY() + 200);
        
        Greenfoot.setWorld(new CookingWorld(this, savedPlayerX, savedPlayerY));
    }
    
    public void spawnBook2()
    {
        // spawns book
        Book book = new Book();
        addObject(book, getWidth() - 60, 60);
    }
    
    public void talkToChef()
    {
        if(!talkedToChef)
        {
            // First time talking → show stage 0 dialogue
            talkedToChef = true;
            stage = 0; // <-- first time dialogue
            instructionsRead = true;
    
            openInstructions(stage);
    
            // Start cooking quest AFTER dialogue is complete
            questStarted = true;
        }
        else if(questStarted && !questCompleted)
        {
            // Quest is active but not yet completed → reminder dialogue
            stage = 1;
            openInstructions(stage);
        }
        else if(questCompleted)
        {
            //removes reminder message
            removeReminder();
        
            removePotAfterText = true;
            
            // Quest already done → show completion message
            stage = 2;
            openInstructions(stage);
        }
    }

    public void openInstructions(int stage)
    {
        // Save player position before leaving
        savedPlayerX = player.getX();
        savedPlayerY = player.getY();
        
        Greenfoot.setWorld(new Instructions2(this, stage, player.getX(), player.getY()));
    }
    
    public boolean isQuestStarted()
    {
        return questStarted;
    }
    
    public boolean isQuestCompleted()
    {
        return questCompleted;
    }
    
    public void spawnCookingPot()
    {
        pot = new CookingPot();
        addObject(pot, 900, 600);
    }

    public void giveSugarCookies()
    {
        // makes food follow the player
        if(!sugarCookiesGiven)
        {
            sugarCookiesGiven = true;
            
            SugarCookies cookies = new SugarCookies(player);
            addObject(cookies, player.getX(), player.getY());
        }
        
        sugarCookiesGiven = true;
    }
    
    public boolean hasSugarCookies()
    {
        return sugarCookiesGiven;
    }
    
    public void showReminderText()
    {
        // shows reminder text
        if (!reminderTextShown && questStarted && !questCompleted)
        {
            reminder = new CookingText();
            addObject(reminder, 500, 50);
            reminderTextShown = true;
        }
    }
    
    public void chefReceivesCookiesFromPlayer()
    {
        // after completing the final dialogue, removes reminder and adds door to next world
        if (!questCompleted)
        {
            questCompleted = true;
            stage = 3; // New stage for after giving cookies
            
            removeReminder(); 
            removeCookingPot();
            
            FragmentOne frag = new FragmentOne();
            addObject(frag, 800, 50);
            
            openInstructions(stage); // Opens a new dialogue sequence
            spawnFireDoor(); // Create the door immediately after dialogue is done
        }
    }
    
    private void removeReminder()
    {
        // removes reminder
        if (reminder != null)
        {
            removeObject(reminder);
            reminder = null;
        }
    }
    
    public void removeCookingPot()
    {
        if (pot != null)
        {
            removeObject(pot);
            pot = null;
        }   
    }
    
    // Spawns the door to the next world when you've completed the quest
    public void spawnFireDoor()
    {
        // spawns fire door
        FireDoor door = new FireDoor();
        addObject(door, 800, 350);
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
    
