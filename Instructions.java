import greenfoot.*;

public class Instructions extends World
{
    private int returnX;
    private int returnY;
    private boolean dialogueFinished = false;

    private MushroomBigNPC mushroom;
    private MushroomWorld world;
    
    public Instructions(int stage, int x, int y)
    {
        super(1000, 700, 1);
        returnX = x;
        returnY = y;
        
        String[] dialogue;
        
        if(stage == 0)
        {
            dialogue = new String[] {
            "Hello!",
            "Welcome to Fairyland.",
            "Use arrow keys to move.",
            "Press SPACE to talk."
            };
        }
        else if(stage == 1)
        {
            dialogue = new String[] {
                "You're still looking for fireflies.",
                "They glow deeper in the forest.",
                "Please bring me all three."
            };
        }
        else
        {
            dialogue = new String[] {
                "You found them all!",
                "Their light is beautiful...",
                "Here — take this lantern.",
                "May it guide you."
            };
        }

        mushroom = new MushroomBigNPC();
        addObject(mushroom, 500, 350);

        addObject(new DialogueBox(dialogue), getWidth()/2, getHeight()/2);
    }

    public void act()
    {
        DialogueBox box = null;

        if (!dialogueFinished && getObjects(DialogueBox.class).isEmpty())
        {
            dialogueFinished = true;
    
            MushroomWorld world =
                new MushroomWorld(true, returnX, returnY);
    
            // FIRST TIME TALK
            if (world.getDialogueStage() == 0)
            {
                world.setTalkedToChibi(true);
                world.startFireflyQuest();
            }
            // AFTER FIRELIES
            else if (world.getDialogueStage() == 2)
            {
                Player p = world.getObjects(Player.class).get(0);
                world.giveLantern(p);
            }
    
            Greenfoot.setWorld(world);
        }
    }
}