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

    private void checkNPCInteraction()
    {
        MushroomChibiNPC npc =
            (MushroomChibiNPC)getOneIntersectingObject(MushroomChibiNPC.class);
    
        if (npc != null && canTalk)
        {
            canTalk = false;
    
            MushroomWorld world = (MushroomWorld)getWorld();
    
            // Only trigger instructions the FIRST time
            if (!world.hasTalkedToChibi())
            {
                world.setTalkedToChibi(true);
                world.openInstructions();
            }
            // After fireflies → give lantern
            else if (world.areFirefliesComplete() && !world.lanternAlreadyGiven())
            {
                world.giveLantern(this);
            }
        }
    
        if (npc == null)
        {
            canTalk = true;
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

