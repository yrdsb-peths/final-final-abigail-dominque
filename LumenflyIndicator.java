import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class LumenflyIndicator extends Actor
{
    // Sets image for firefly
    public LumenflyIndicator()
    {
        GreenfootImage firefly = new GreenfootImage("firefly_light.png");
        firefly.scale(100, 100);
        setImage(firefly);
    }
}

