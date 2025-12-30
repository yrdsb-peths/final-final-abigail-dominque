import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Player extends Actor
{
    // Sets the players height and width
    private static final int PLAYER_WIDTH = 80;
    private static final int PLAYER_HEIGHT = 80;
    
    // Sets image variables
    private GreenfootImage idleImage;
    private GreenfootImage leftImage;
    private GreenfootImage rightImage;
    
    // Tracks way the player is facing
    private boolean facingRight = true;
    
    // Prevents retrigger
    private boolean canTalk = true;
    
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
        checkNPCInteraction();
        checkFireflyPickup();
        checkCookingPot();
    }
    // Player movements
    private void movePlayer()
    {
        boolean moving = false;
        
        if(Greenfoot.isKeyDown("a"))
        {
            setLocation(getX() - 3, getY());
            setImage(leftImage);
            facingRight = false;
            moving = true;
        }
        
        if(Greenfoot.isKeyDown("d"))
        {
            setLocation(getX() + 3, getY());
            setImage(rightImage);
            facingRight = true;
            moving = true;
        }
        
        if(Greenfoot.isKeyDown("w"))
        {
            setLocation(getX(), getY() - 3);
            setImage(rightImage);
            facingRight = true;
            moving = true;
        }
        
        if(Greenfoot.isKeyDown("s"))
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

    private void checkNPCInteraction()
    {
        MushroomChibiNPC npc = (MushroomChibiNPC)getOneIntersectingObject(MushroomChibiNPC.class);
    
        if (npc != null && canTalk && Greenfoot.isKeyDown("space"))
        {
            canTalk = false;
        
            MushroomWorld world = (MushroomWorld)getWorld();
        
            // Give lantern AFTER dialogue was shown
            if (world.areFirefliesComplete()
                && world.hasSeenLanternDialogue()
                && !world.lanternAlreadyGiven())
            {
                world.giveLantern(this);
            }
            else
            {
                world.openInstructions();
            }
        }
        
        if (npc == null)
        {
            canTalk = true;
        }
    }

    private void checkCookingPot()
    {
        if(isTouching(CookingPot.class))
        {
            ((MushroomWorld) getWorld()).startCooking();
        }
    }
    
    private void checkFireflyPickup()
    {
        Firefly firefly = (Firefly)getOneIntersectingObject(Firefly.class);
    
        if (firefly != null)
        {
            MushroomWorld world = (MushroomWorld)getWorld();
            world.collectFirefly();
    
            world.removeObject(firefly);
        }
    }
}

