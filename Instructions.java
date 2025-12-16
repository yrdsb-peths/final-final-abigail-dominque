import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Instructions extends World
{
    private int returnX;
    private int returnY;
    
    private int dialogueIndex = 0;
    
    private MushroomBigNPC mushroom;

    public Instructions(int playerX, int playerY)
    {
        super(1000, 700, 1);

        mushroom = new MushroomBigNPC();
        addObject(mushroom, 500, 350); 
        
        
        returnX = playerX;
        returnY = playerY;

        String[] lines = {
            "Welcome to Fairyland!",
            "Use arrow keys to move.",
            "Talk to characters to learn things."
        };

        DialogueBox instructions = new DialogueBox(lines);
        
        addObject(instructions, getWidth() / 2, 300);
    }

    public void act()
    {
        // When dialogue finishes, go back
        if (getObjects(DialogueBox.class).isEmpty())
        {
            Greenfoot.setWorld(new MushroomWorld(returnX, returnY));
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
