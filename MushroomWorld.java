import greenfoot.*;

public class MushroomWorld extends World
{
    private Player player;
    private MushroomChibiNPC mushroom;

    // Save player position
    private int savedPlayerX;
    private int savedPlayerY;
    
    private boolean instructionsRead;

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

        GreenfootImage background = new GreenfootImage("background.png");
        background.scale(getWidth(), getHeight());
        setBackground(background);

        addObject(new MushroomHut(), 100, 200);

        mushroom = new MushroomChibiNPC();
        addObject(mushroom, 80, 400);

        player = new Player();
        addObject(player, getWidth() / 2, getHeight() / 2);
        
        //restore position
        if(playerX != -1 && playerY != -1)
        {
            player.setLocation(playerX +40, playerY);
        }
        
        //Adds book after instructions
        if(instructionsRead)
        {
            Book book = new Book();
            addObject(book, 950, 50);
        }
    }

    // Called by Player when touching NPC
    public void openInstructions()
    {
        // Save player position before leaving
        savedPlayerX = player.getX();
        savedPlayerY = player.getY();

        Greenfoot.setWorld(
            new Instructions(player.getX(), player.getY())
        );
    }
}
