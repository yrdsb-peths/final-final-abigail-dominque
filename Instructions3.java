import greenfoot.*;

public class Instructions3 extends World
{
    private int returnX;
    private int returnY;
    private boolean dialogueFinished = false;

    private GoatBigNPC goat;
    private GameWorld world;
    private GameWorld returnWorld;
    
    public Instructions3(GameWorld world, int stage, int x, int y)
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

        goat = new GoatBigNPC();
        addObject(goat, 500, 350);
        
        String[] chefSounds = {
            "chef3.mp3",
            "chef2.mp3",
            "chef1.mp3",
            "chef4.mp3",
        };
        addObject(new DialogueBox(dialogue, chefSounds), getWidth() / 2, 600);
    }

    public void act()
    {
        
    }
}

