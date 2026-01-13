import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Player extends Actor
{
    // Sets the players height and width
    private static final int PLAYER_WIDTH = 230;
    private static final int PLAYER_HEIGHT = 230;
    
    // Sets image variables
    private GreenfootImage idleImage;
    private GreenfootImage leftImage;
    private GreenfootImage rightImage;
    
    // Tracks way the player is facing
    private boolean facingRight = true;
    
    // Prevents retrigger for MushroomWorld
    private boolean canTalk = true;
    
    // Prevents retrigger for FamilyWorld
    private boolean canTalk2 = true;
    
    //Prevent retrigger for pot
    private boolean canCook = true;
    
    //prevents retrigger for goat
    private boolean canTalkGoat = true;
    
    
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
        checkDoor();
        checkChefInteraction();
        checkFireDoor();
        checkGoatInteraction();
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
        if(isTouching(CookingPot.class) && canCook && Greenfoot.isKeyDown("space"))
        {
            canCook = false;
            ((FamilyWorld) getWorld()).startCooking();
        }
        
        if(!isTouching(CookingPot.class))
        {
            canCook = true;
        }
    }
    
    private void checkDoor()
    {
        if(isTouching(Door.class))
        {
            World world = getWorld();
            Greenfoot.setWorld(new FamilyWorld(getX(), getY()));
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
    
    private void checkChefInteraction()
    {
        ChefChibiNPC npc = (ChefChibiNPC)getOneIntersectingObject(ChefChibiNPC.class);

        if (npc != null && canTalk2 && Greenfoot.isKeyDown("space"))
        {
            canTalk2 = false;
    
            FamilyWorld world = (FamilyWorld)getWorld();
    
            // If quest not started, start instructions cutscene
            if (!world.isQuestStarted())
            {
                world.talkToChef(); // this opens Instructions2
            }
            // If quest started and cookie made
            else if (world.isQuestStarted() && !world.isQuestCompleted() && world.hasSugarCookies())
            {
                world.chefReceivesCookiesFromPlayer(); // opens post-cooking dialogue
            }
            
            // quest is completed, post quest dialogue
            else if (world.isQuestCompleted())
            {
                world.talkToChef();
            }
        }
    
        if (npc == null)
        {
            canTalk2 = true;
        }
    }
    
    private void checkFireDoor()
    {
        if(isTouching(FireDoor.class))
        {
            World world = getWorld();
            Greenfoot.setWorld(new GameWorld(getX(), getY()));
        }
    }
    
    private void checkGoatInteraction()
    {
        GoatChibiNPC npc = (GoatChibiNPC)getOneIntersectingObject(GoatChibiNPC.class);
        
        if (npc != null && canTalkGoat && Greenfoot.isKeyDown("space"))
        {
            canTalkGoat = false;
            GameWorld world = (GameWorld) getWorld();
            world.openInstructions(world.getStage());   // choose stage 0, 1, or 2 here
        }
        
        if (npc == null)
        {
            canTalkGoat = true;
        }
    }
}

