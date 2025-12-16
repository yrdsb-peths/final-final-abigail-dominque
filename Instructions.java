import greenfoot.*;

public class Instructions extends World
{
    private int returnX;
    private int returnY;

    public Instructions(int x, int y)
    {
        super(1000, 700, 1);
        returnX = x;
        returnY = y;

        String[] dialogue = {
            "Hello!",
            "Welcome to Fairyland.",
            "Use arrow keys to move.",
            "Press SPACE to talk."
        };

        addObject(new DialogueBox(dialogue), getWidth()/2, getHeight()/2);
    }

    public void act()
    {
        if (getObjects(DialogueBox.class).isEmpty())
        {
            Greenfoot.setWorld(new MushroomWorld(returnX, returnY));
        }
    }
}