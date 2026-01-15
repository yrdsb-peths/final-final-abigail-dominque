import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class FragmentOne extends Actor
{
    
    private GreenfootImage fragment; 
    
    public FragmentOne()
    {
        // initiates and scales book image
        fragment = new GreenfootImage("fragment1.png");
        fragment.scale(100,100);
        setImage(fragment);
    }
    
    public void openInstructions()
    {
        // Open the world with the fragment image
        Greenfoot.setWorld(new FragmentOneImage(getWorld()));
    }
    
    public void act()
    {
        if(Greenfoot.mouseClicked(this))
        {
            openInstructions();
        }
    }
}
