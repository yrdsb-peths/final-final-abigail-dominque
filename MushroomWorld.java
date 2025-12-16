import greenfoot.*;

public class MushroomWorld extends World {
    private Player player;
    private MushroomChibiNPC mushroom;
    
    public MushroomWorld()
    {
        super(1000, 700, 1);
    
        GreenfootImage background = new GreenfootImage("background.png");
        background.scale(getWidth(), getHeight());
        setBackground(background);
    
        addObject(new MushroomHut(), 100, 200);
    
        mushroom = new MushroomChibiNPC();
        addObject(mushroom, 130, 150);
    
        player = new Player();
        addObject(player, getWidth() / 2, getHeight() / 2);
    }
    
    public MushroomWorld(int playerX, int playerY)
    {
        this(); // calls the normal constructor
        player.setLocation(playerX, playerY);
    }

    public void openInstructions()
    {
        Greenfoot.setWorld(
            new Instructions(player.getX(), player.getY())
        );
    }
}
