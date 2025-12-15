import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Instructions extends World
{
    private int returnX;
    private int returnY;

    public Instructions(int playerX, int playerY)
    {
        super(1000, 700, 1);

        MushroomBigNPC mushroom = new MushroomBigNPC();
        addObject(mushroom, 500, 350); 
        
        
        returnX = playerX;
        returnY = playerY;

        String[] lines = {
            "Welcome to Fairyland!",
            "Use arrow keys to move.",
            "Talk to characters to learn things."
        };

        addObject(new DialogueBox(lines), getWidth() / 2, 300);
    }

    public void act()
    {
        // When dialogue finishes, go back
        if (getObjects(DialogueBox.class).isEmpty())
        {
            Greenfoot.setWorld(new MushroomWorld(returnX, returnY));
        }
    }
}
