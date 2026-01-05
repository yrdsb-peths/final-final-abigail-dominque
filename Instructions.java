import greenfoot.*;

public class Instructions extends World
{
    private int returnX;
    private int returnY;
    private boolean dialogueFinished = false;

    private MushroomBigNPC mushroom;
    private MushroomWorld world;
    private MushroomWorld returnWorld;
    
    public Instructions(MushroomWorld world, int stage, int x, int y)
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
                "Welcome to dreamscape... My name is Nita... one of the many dreamguides\nyou'll find in this domain...",
                "As a dreamdiver, your goal is to help our fellow guides complete\ntheir objectives, and retrieve this patient's memories...",
                "As per protocol, please collect three lumenflies so that I\nmay create a lumenguide for you...",
                "Lumenflies will attach themselves to dreamguides\nso that you may easily identify them..."
            };
        }
        else if(stage == 1)
        {
            dialogue = new String[] {
                "Have you collected all the lumenflies..?",
                "You may find them throughout this plane of the dreamscape...",
                "Please bring me all three..."
            };
        }
        else
        {
            dialogue = new String[] {
                "You found them all...",
                "Their light is beautiful...",
                "Take these lumenflies, and this book...",
                "If you ever find yourself lost, these objects will guide the way..."
            };
        }

        mushroom = new MushroomBigNPC();
        addObject(mushroom, 500, 350);

        addObject(new DialogueBox(dialogue), getWidth() / 2, 600);
    }

    public void act()
    {
        DialogueBox box = null;

        if (!dialogueFinished && getObjects(DialogueBox.class).isEmpty())
        {
            dialogueFinished = true;
    
            // Create the return world
            MushroomWorld world = returnWorld;
            
            // FIRST TIME TALK → start quest
            if (world.getDialogueStage() == 0)
            {
                world.setTalkedToChibi(true);
                world.startFireflyQuest();
                world.spawnBookIfNeeded();
            }
    
            // AFTER FIRELIES → give lantern
            if (world.getDialogueStage() == 2 && !world.lanternAlreadyGiven())
            {
                Player p = world.getObjects(Player.class).get(0);
                world.giveLantern(p);
            }
    
            // THIS MUST HAPPEN ONCE
            Greenfoot.setWorld(world);
        }
    }
    
    
}