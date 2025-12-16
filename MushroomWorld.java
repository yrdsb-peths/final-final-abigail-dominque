import greenfoot.*;

public class MushroomWorld extends World
{
    private Player player;
    private MushroomChibiNPC mushroom;

    // Save player position
    private int savedPlayerX;
    private int savedPlayerY;

    // Normal constructor (first time entering world)
    public MushroomWorld()
    {
        super(1000, 700, 1);

        GreenfootImage background = new GreenfootImage("background.png");
        background.scale(getWidth(), getHeight());
        setBackground(background);

        addObject(new MushroomHut(), 100, 200);

        mushroom = new MushroomChibiNPC();
        addObject(mushroom, 80, 400);

        player = new Player();
        addObject(player, getWidth() / 2, getHeight() / 2);
    }

    // Return constructor (after instructions)
    public MushroomWorld(int playerX, int playerY)
    {
        this(); // builds world normally
        player.setLocation(playerX + 40, playerY); // restore position
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
