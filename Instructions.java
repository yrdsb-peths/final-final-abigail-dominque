import greenfoot.*;

public class Instructions extends World
{
    private int returnX;
    private int returnY;
    
    private int dialogueIndex = 0;
    
    private MushroomBigNPC mushroom;

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

        mushroom = new MushroomBigNPC();
        addObject(mushroom, 500, 350);         
        addObject(new DialogueBox(dialogue), getWidth()/2, getHeight()/2);
    }

    public void act()
    {
        if(getObjects(DialogueBox.class).isEmpty())
        {

            MushroomWorld world = new MushroomWorld(returnX, returnY);
            world.startFireflyQuest();
            Greenfoot.setWorld(world);

            Greenfoot.setWorld(new MushroomWorld(true, returnX, returnY));

        }
        
        if(Greenfoot.isKeyDown("space"))
        {
            dialogueIndex++;
            
            if (dialogueIndex > 2)
            {
                dialogueIndex = 0;
            }
            
            if (dialogueIndex == 0)
            {
                mushroom.setImage1();
            }
            else if (dialogueIndex == 1)
            {
                mushroom.setImage2();
            }
            else if (dialogueIndex == 2)
            {
                mushroom.setImage3();
            }
        }
    }
}