import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class TitleScreen extends World
{
    // Creates play button
    GreenfootImage playButton;
    
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
        
        GreenfootImage background = new GreenfootImage("title_screen.png");
        background.scale(getWidth(), getHeight());
        setBackground(background);

        PlayButton button = new PlayButton();
        addObject(button, 530, 500);
    }

}
