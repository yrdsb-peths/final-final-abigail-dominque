import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FamilyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FamilyWorld extends World
{
    private Player player;
    
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
    
    public FamilyWorld(int playerX, int playerY)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 700, 1); 
        
        CookingPot pot = new CookingPot();
        addObject(pot, 600, 300);
        
        player = new Player();
        addObject(player, getWidth() / 2, getHeight() / 2);
        
        //restore position
        if(playerX != -1 && playerY != -1)
        {
            player.setLocation(playerX + 150, playerY);
        }
        
        chef = new ChefChibiNPC();
        addObject(chef, 900, 650);
    }
    
    // Called by Player when touching CookingPot
    public void startCooking()
    {
        savedPlayerX = player.getX();
        savedPlayerY = player.getY();
        
        Greenfoot.setWorld(new CookingWorld(player.getX(), player.getY()));
    }
    
    public void spawnBook()
    {
        Book book = new Book();
        addObject(book, getWidth() - 60, 60);
    }
    
    public void talkToChef()
    {
        if(!talkedToChef)
        {
            // First time talking
            talkedToChef = true;
            stage = 1;
            instructionsRead = true;
            
            // Opens the instructions
            openInstructions(stage);
            
            // Start cooking quest
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
}
