import greenfoot.*;

public class FragmentTwoImage extends World
{
    private World previousWorld;
    
    public FragmentTwoImage(World previous)
    {
        super(1000, 700, 1);
        previousWorld = previous;
        
        // Set background to the image
        GreenfootImage fragment = new GreenfootImage("fragment2.png");
        fragment.scale(getWidth(), getHeight());
        setBackground(fragment);
        
        // Add an Exit button
        Exit exit = new Exit(previousWorld);
        addObject(exit, getWidth() - 80, 50);
    }
}
