import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Firefly extends Actor
{
    // Sets image for firefly
    public Firefly()
    {
        GreenfootImage firefly = new GreenfootImage("firefly.png");
        firefly.scale(24, 24);
        setImage(firefly);
    }
}
