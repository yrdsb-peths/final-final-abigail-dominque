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
                "Hi there, it's nice to meet you! My name is pitbull and I am the \nmost famous chef in the Dreamscape!",
                "My high rated restaurants span the scope of dreams, making sure every \ndreamguide can eat a tasty meal.",
                "Including me! I, a fellow dreamguide, could really use a meal...",
                "I want some sweet, delictable and soft sugar cookies... with pink icing. \nIf you make them for me, I will reward you with the most precious \ncurrency in this world... a memory fragment!",
                "Quick!!! Make them now!!! Quick!!!!!!!!"
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
                "Let's see what we've got here...",
                "Woah! These are some scrumptious cookies... The best I've ever \neaten, after mine of course...",
                "Great job! This is just what I've been craving...",
                "Here's your memory fragment, make sure to take care of it. It is \nthe key to regaining ones memories.",
                "Bye bye! Make sure to visit again! Maybe I'll cook you \nsomething next time...\n... maybe"
            };
        }

        chef = new ChefBigNPC();
        addObject(chef, 500, 350);
        
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
        DialogueBox box = null;

        if (!dialogueFinished && getObjects(DialogueBox.class).isEmpty())
        {
            dialogueFinished = true;
            
            if(returnWorld.isQuestStarted() && !returnWorld.isQuestCompleted())
            {
                returnWorld.spawnCookingPot();
                returnWorld.showReminderText();
            }
            
            
            if (returnWorld.removePotAfterText)
            {
                returnWorld.removeCookingPot();
                returnWorld.removePotAfterText = false;
            }
            // Create the return world
            FamilyWorld world = returnWorld;
            Greenfoot.setWorld(world);
        }
    }
}
