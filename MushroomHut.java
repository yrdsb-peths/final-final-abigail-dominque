import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MushroomHut extends Actor
{
    private static final int HUT_WIDTH = 600;
    private static final int HUT_HEIGHT = 500;
    
    public MushroomHut()
    {
        GreenfootImage hutImage = new GreenfootImage("mushroom_hut.png");
        hutImage.scale(HUT_WIDTH, HUT_HEIGHT);
        setImage(hutImage);
    }
}

