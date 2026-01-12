import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class FragmentTwo extends Actor
{
    private GreenfootImage fragment; 
    
    public FragmentTwo()
    {
        // initiates and scales book image
        fragment = new GreenfootImage("recipe1.jpg");
        fragment.scale(50,50);
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