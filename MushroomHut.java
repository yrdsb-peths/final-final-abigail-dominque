import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MushroomHut here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MushroomHut extends Actor
{
    private static final int HUT_WIDTH = 100;
    private static final int HUT_HEIGHT = 100;
    
    public MushroomHut()
    {
        GreenfootImage hutImage = new GreenfootImage("mushroom_hut.png");
        hutImage.scale(HUT_WIDTH, HUT_HEIGHT);
        setImage(hutImage);
    }
}

