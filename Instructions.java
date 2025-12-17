import greenfoot.*;

public class Instructions extends World
{
    private int returnX;
    private int returnY;
    private boolean dialogueFinished = false;

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
        DialogueBox box = null;

        if (!getObjects(DialogueBox.class).isEmpty())
        {
            box = getObjects(DialogueBox.class).get(0);
        }

        if (box != null)
        {
            int index = box.getLineIndex();

            if (index == 0) mushroom.setImage1();
            else if (index == 1) mushroom.setImage2();
            else mushroom.setImage3();
        }

        if (!dialogueFinished && getObjects(DialogueBox.class).isEmpty())
        {
            dialogueFinished = true;

            MushroomWorld world =
                new MushroomWorld(true, returnX, returnY);

            world.startFireflyQuest();
            Greenfoot.setWorld(world);
        }
    }
}
