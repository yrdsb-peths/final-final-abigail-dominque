import greenfoot.*;

public class Instructions2 extends World
{
    private int returnX;
    private int returnY;
    private boolean dialogueFinished = false;

    private ChefBigNPC chef;
    private FamilyWorld world;
    private FamilyWorld returnWorld;
    
    public Instructions2(FamilyWorld world, int stage, int x, int y)
    {
        super(1000, 700, 1);
        this.returnWorld = world;
        returnX = x;
        returnY = y;
        
        GreenfootImage background = new GreenfootImage("mushroom_background.png");
        background.scale(getWidth(), getHeight());
        setBackground(background);
        
        String[] dialogue;
        
        if(stage == 0)
        {
            dialogue = new String[] {
                "welcome to the best place on earth",
                "everyone start gooning",
            };
        }
        else if(stage == 1)
        {
            dialogue = new String[] {
                "raise one hand if you love to live",
                "me personally i love to live",
            };
        }
        else
        {
            dialogue = new String[] {
                "start cooking you hard nut",
                "who said you could stop working",
            };
        }

        chef = new ChefBigNPC();
        addObject(chef, 500, 350);

        addObject(new DialogueBox(dialogue), getWidth() / 2, 600);
    }

    public void act()
    {
        DialogueBox box = null;

        if (!dialogueFinished && getObjects(DialogueBox.class).isEmpty())
        {
            dialogueFinished = true;
            
            // Create the return world
            FamilyWorld world = returnWorld;
            returnWorld.spawnCookingPot();
            Greenfoot.setWorld(world);
        }
    }
    
    
}
