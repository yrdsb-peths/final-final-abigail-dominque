import greenfoot.*;

public class MushroomWorld extends World {
    public MushroomWorld() {
        super(600, 600, 1);
        
        // Sets background
        GreenfootImage background = new GreenfootImage("background.png");
        background.scale(getWidth(), getHeight());
        setBackground(background);
        
        // Adds item
        MushroomHut hut = new MushroomHut();
        addObject(hut, 100, 200);
        
        // Add player
        Player player = new Player();
        addObject(player, 300, 200);
    }
}
