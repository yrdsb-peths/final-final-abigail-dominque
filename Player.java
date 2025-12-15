import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Player extends Actor
{
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    // Sets the players height and width
    private static final int PLAYER_WIDTH = 80;
    private static final int PLAYER_HEIGHT = 80;
    
    // Sets image variables
    private GreenfootImage idleImage;
    private GreenfootImage leftImage;
    private GreenfootImage rightImage;
    
    // Tracks way the player is facing
    private boolean facingRight = true;
    
    // Sets Player image
    public Player()
    {
        // Load and scale images
        idleImage = new GreenfootImage("player.png");
        idleImage.scale(PLAYER_WIDTH, PLAYER_HEIGHT);

        rightImage = new GreenfootImage("player_right.png");
        rightImage.scale(PLAYER_WIDTH, PLAYER_HEIGHT);

        leftImage = new GreenfootImage("player_left.png");
        leftImage.scale(PLAYER_WIDTH, PLAYER_HEIGHT);

        // Start idle facing right
        setImage(idleImage);
    }
    
    public void act()
    {
        movePlayer();
    }
    // Player movements
    private void movePlayer()
    {
        boolean moving = false;
        
        if(Greenfoot.isKeyDown("left"))
        {
            setLocation(getX() - 3, getY());
            setImage(leftImage);
            facingRight = false;
            moving = true;
        }
        
        if(Greenfoot.isKeyDown("right"))
        {
            setLocation(getX() + 3, getY());
            setImage(rightImage);
            facingRight = true;
            moving = true;
        }
        
        if(Greenfoot.isKeyDown("up"))
        {
            setLocation(getX(), getY() - 3);
            setImage(rightImage);
            facingRight = true;
            moving = true;
        }
        
        if(Greenfoot.isKeyDown("down"))
        {
            setLocation(getX(), getY() + 3);
            setImage(leftImage);
            facingRight = false;
            moving = true;
        }
        
        if (!moving) {
            setImage(idleImage);
        }
    }
}
