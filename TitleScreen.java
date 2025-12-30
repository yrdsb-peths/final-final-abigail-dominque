import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class TitleScreen extends World
{
    //Creates title label
    Label titleLabel = new Label("nostalgia sum", 70);
    
    //Creates play button
    Label play = new Label ("Play", 80);
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 700, 1); 
        
        addObject(titleLabel, getWidth() / 2, 200);
        addObject(play, getWidth() / 2, 400);
        prepare();
    }
    
    public void act()
    {
        //if play label is clicked, the world will switch 
        if (Greenfoot.mouseClicked(play))
        {
            Greenfoot.setWorld(new MushroomWorld());
        }
    }
    
    private void prepare()
    {
        
    }
}
