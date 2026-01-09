import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class FragmentOne extends Actor
{
    
    private GreenfootImage fragment; 
    
    public FragmentOne()
    {
        // initiates and scales book image
        fragment = new GreenfootImage("recipe1.jpg");
        fragment.scale(50,50);
        setImage(fragment);
    }
    
    public void openInstructions()
    {
        FamilyWorld world = (FamilyWorld)getWorld();
        
        // Open the world with the fragment image
        Greenfoot.setWorld(new FragmentOneImage(world));
    }
    
    public void act()
    {
        if(Greenfoot.mouseClicked(this))
        {
            openInstructions();
        }
    }
}
