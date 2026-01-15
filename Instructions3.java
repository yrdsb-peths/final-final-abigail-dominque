import greenfoot.*;

public class Instructions3 extends World
{
    // Return coordinates after you leave the world
    private int returnX;
    private int returnY;
    
    // Checks if the dialogue is finished
    private boolean dialogueFinished = false;

    // Variables for the NPC and world so you can return
    private GoatBigNPC goat;
    private GameWorld world;
    private GameWorld returnWorld;
    
    // Variable for dialogue so you don't gotta keep initializing
    private DialogueBox dialogueBox;
    
    public Instructions3(GameWorld world, int stage, int x, int y)
    {
        super(1000, 700, 1);
        this.returnWorld = world;
        returnX = x;
        returnY = y;
        
        // bg
        GreenfootImage background = new GreenfootImage("mushroom_background.png");
        background.scale(getWidth(), getHeight());
        setBackground(background);
        
        // dialogue
        String[] dialogue;
        
        if(stage == 0)
        {
            dialogue = new String[] {
                "HAHAHAH THESE DAWGS ARE CRAZYYYY DAWGGG",
                "GUESS YOUR PATIENT REALLY DON'T LIKE DAWGS HAHAHAHAAHAHA",
                "AAAAAAAACKKK WHY DON'T YOU TRY YOUR HAND AT DODGING THEM BLUDDYO",
                "THE FRAGMENT IS RIGHT THERE AAAHAHAHAHAHAHA",
                "MAYBE YOU'LL HAVE BETTER LUCK DODGING THEM THAN ME YAAHOOOO"
            };
        }
        else if(stage == 1)
        {
            dialogue = new String[] {
                "HAAAHAAAAHAAAA"
            };
        }
        else
        {
            dialogue = new String[] {
                "WOOOOOHHOOOOOO"
            };
        }

        goat = new GoatBigNPC();
        addObject(goat, 500, 250);
        
        String[] chefSounds = {
            "goat1.mp3",
            "goat2.mp3",
            "goat1.mp3",
            "goat2.mp3",
            "goat1.mp3"
        };
        
        dialogueBox = new DialogueBox(dialogue, chefSounds);
        addObject(dialogueBox, getWidth() /2, 600);
        
    }
    
    public void act()
    {
        // exits out of dialogue when done talking
        if (!dialogueFinished && dialogueBox != null && dialogueBox.isFinished())
        {
            dialogueFinished = true;
            
            returnWorld.setStage(returnWorld.getStage() + 1);
        }
        
        if (dialogueFinished && Greenfoot.isKeyDown("space"))
        {
            Greenfoot.setWorld(returnWorld);
            returnWorld.getPlayer().setLocation(returnX, returnY);
            
            //adds fragment two after instructions are done
            returnWorld.spawnFragmentTwo();
        }
    }
}

