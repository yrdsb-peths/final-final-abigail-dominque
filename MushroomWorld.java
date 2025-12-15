import greenfoot.*;

public class MushroomWorld extends World {
    public MushroomWorld() {
        super(1000, 700, 1);
        
        // Sets background
        GreenfootImage background = new GreenfootImage("background.png");
        background.scale(getWidth(), getHeight());
        setBackground(background);
        
        // Adds item
        MushroomHut hut = new MushroomHut();
        addObject(hut, 100, 200);

       
        // Add Mushroom NPC
        MushroomChibiNPC mushroom = new MushroomChibiNPC();
        addObject(mushroom, 50, 300);
        
        // Add player
        Player player = new Player();
        addObject(player, getWidth() / 2, getHeight() / 2);
    }
}
