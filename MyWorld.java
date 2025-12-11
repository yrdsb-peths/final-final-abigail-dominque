import greenfoot.*;

public class MyWorld extends World {
    public MyWorld() {
        super(600, 600, 1);
        
        GreenfootImage background = new GreenfootImage("background.png");
        background.scale(getWidth(), getHeight());
        setBackground(background);
    }
}
