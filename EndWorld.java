import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class EndWorld extends World
{
    // Sets the end screen image
    public EndWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 700, 1); 
        
        // End screen picture
        GreenfootImage background = new GreenfootImage("endscreen.png");
        background.scale(getWidth(), getHeight());
        setBackground(background);
    }
}
