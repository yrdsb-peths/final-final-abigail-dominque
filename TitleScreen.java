import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{
    Label titleLabel = new Label("Fairyland", 130);
    
    Label play = new Label ("Play", 80);
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 600, 1); 
        
        GreenfootImage background = new GreenfootImage("background.png");
        background.scale(getWidth(), getHeight());
        setBackground(background);
        
        addObject(titleLabel, getWidth() / 2, 200);
        addObject(play, getWidth() / 2, 400);
        prepare();
    }
    
    
    
    private void prepare()
    {
        
    }
}
