import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class FireflyLight extends Actor
{

    private Player player;
    
    public FireflyLight(Player player)
    {
        this.player = player;
        
        GreenfootImage light = new GreenfootImage("firefly_light.png");
        light.scale(100, 100);
        setImage(light);
    }

    public void act()
    {
        if(player != null && player.getWorld() != null)
        {
            setLocation(player.getX(), player.getY());
        }
    }
}
