import greenfoot.*;

public class FragmentOneImage extends World
{
    private World previousWorld;
    
    public FragmentOneImage(World previous)
    {
        super(1000, 700, 1);
        previousWorld = previous;
        
        // Set background to the image
        GreenfootImage fragment = new GreenfootImage("fragment1.png");
        fragment.scale(getWidth(), getHeight());
        setBackground(fragment);
        
        // Add an Exit button
        Exit exit = new Exit(previousWorld);
        addObject(exit, getWidth() - 80, 50);
    }
}
