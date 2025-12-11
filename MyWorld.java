import greenfoot.*;

public class MyWorld extends World {
    public MyWorld() {
        super(600, 400, 1);
        
        GreenfootImage background = new GreenfootImage();
        background.scale(getWidth(), getHeight());
        setBackground(background);
    }
}
