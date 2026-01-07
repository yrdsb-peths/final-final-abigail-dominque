import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class FamilyWorld extends World
{
    
    
    // Save player position
    private int savedPlayerX;
    private int savedPlayerY;
    
    private Player player;
    private boolean sugarCookiesGiven;
    private PlayerWithFood cookies;
    
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
            player.setLocation(playerX, playerY);
        }
    }
    
    public void started()
    {
        if(sugarCookiesGiven == true && cookies == null && player != null)
        {
            player = getObjects(Player.class).get(0);
            cookies = new PlayerWithFood(player);
            addObject(cookies, player.getX(), player.getY());
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
    
    public void giveSugarCookies()
    {
        sugarCookiesGiven = true;
    }
    
    public boolean hasSugarCookies()
    {
        return sugarCookiesGiven;
    }
}
