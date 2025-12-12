import greenfoot.*;

public class MushroomWorld extends World {
    public MushroomWorld() {
        super(600, 600, 1);
        
        GreenfootImage background = new GreenfootImage("background.png");
        background.scale(getWidth(), getHeight());
        setBackground(background);
        
        Player player = new Player();
        addObject(player, 300, 200);
    }
}
