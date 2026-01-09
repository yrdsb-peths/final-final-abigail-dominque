import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class FamilyWorld extends World
{
    // Save player position
    private int savedPlayerX;
    private int savedPlayerY;
    
    // Spawns the chibi
    private ChefChibiNPC chef;
    
    private boolean chefIntro = false;
    
    private boolean talkedToChef = false;
    private boolean instructionsRead = false;
    private boolean questStarted = false;
    private boolean questCompleted = false;
    private int stage = 0;
    
    private boolean talkedToChibi = false;

    private Player player;
    private boolean sugarCookiesGiven;
    private boolean sugarCookieMade = false;
    
    //for the reminder text after instructions
    private CookingText reminder;
    private boolean reminderTextShown = false;
    
    public FamilyWorld(int playerX, int playerY)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 700, 1); 
        
        // Sets background
        GreenfootImage background = new GreenfootImage("mushroom_background.png");
        background.scale(getWidth(), getHeight());
        setBackground(background);
        
        // adds chef npc
        chef = new ChefChibiNPC();
        addObject(chef, 200, 200);
        
        // adds the player
        player = new Player();
        addObject(player, getWidth() / 2, getHeight() / 2);
        
        //restore position
        if(playerX != -1 && playerY != -1)
        {
            player.setLocation(playerX - 50, playerY + 100);
        }
    }
    
    // Called by Player when touching CookingPot
    public void startCooking()
    {
        savedPlayerX = player.getX();
        savedPlayerY = player.getY();
        
        //slightly moves player so the pot is not triggered again 
        player.setLocation(player.getX(), player.getY() + 50);
        
        Greenfoot.setWorld(new CookingWorld(this, savedPlayerX, savedPlayerY));
    }
    
    public void spawnBook()
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
    
    public void completeSugarCookie()
    {
        questCompleted = true;
    
        // Optionally, add sugar cookie image to player
        SugarCookies food = new SugarCookies();
        addObject(food, player.getX(), player.getY());
        
        if (reminder != null)
        {
            removeObject(reminder);
            reminder = null;
        }
    }
    
    public void spawnCookingPot()
    {
        // spawns cooking pot
        CookingPot pot = new CookingPot();
        addObject(pot, 300, 300);
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
            addObject(reminder, 500, 100);
            reminderTextShown = true;
        }
    }
    
    public void chefReceivesCookies()
    {
        // after completing the final dialogue, removes reminder and adds door to next world
        if (!questCompleted)
        {
            questCompleted = true;
            
            removeReminder(); 
            
            stage = 3; // New stage for after giving cookies
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
    
    public void spawnFireDoor()
    {
        // spawns fire door
        FireDoor door = new FireDoor();
        addObject(door, 800, 350); // Wherever you want the door to appear
    }

}
    
