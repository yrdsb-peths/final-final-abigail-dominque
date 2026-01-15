import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class FragmentTwo extends Actor
{
    private GreenfootImage fragment; 
    
    private boolean used = false; 
    
    public FragmentTwo()
    {
        // initiates and scales book image
        fragment = new GreenfootImage("fragment2.png");
        fragment.scale(100,100);
        setImage(fragment);
    }
    
    public void openInstructions()
    {
        // Open the world with the fragment image
        Greenfoot.setWorld(new CutsceneTwo());
    }
    
    public void act()
    {
        if(used)
        {
            return;
        }
        
        Player player = (Player) getOneIntersectingObject(Player.class);
        
        if (player != null)
        {
            used = true;
            
            GameWorld world = (GameWorld) getWorld();
        }
    }
}