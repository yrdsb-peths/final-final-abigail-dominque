import greenfoot.*;

public class Mushroom extends World {
    public Mushroom() {
        super(600, 600, 1);
        
        GreenfootImage background = new GreenfootImage("background.png");
        background.scale(getWidth(), getHeight());
        setBackground(background);
        
        Player player = new Player();
        addObject(player, 300, 200);
    }
}
