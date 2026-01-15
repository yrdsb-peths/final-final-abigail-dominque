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
                "Hi there... hahaha... it's nice to meet you! My name is Norve... heh... \nand I'm the most famous chef in the Dreamscape!",
                "Just look how many people are here! Haha...huh? No... we don't \nmake pizzas here... why would you even think that...haha...\nthis place aint a pizza restaurant...;-;",
                "Well... haha how about you make me a meal haha ;-; for saying \nsomething so insulting in my own restaurant (michelin star) (on bluh) ",
                "I want some sweet, delectable and soft sugar cookies... with pink icing... haha... \nIf you make them for me, maybe I'll give you that memory fragment \nyou're looking for... haha",
                "No rush or anything...hahahahahahaha..."
            };
        }
        else if(stage == 1)
        {
            dialogue = new String[] {
                "Hahahahahahahaha....no rush..."
            };
        }
        else
        {
            dialogue = new String[] {
                "Let's see what we've got here... hawhawhaw",
                "Well I'll be! These are some scrumptious cookies... haha... The best \nI've ever eaten... after mine of course...",
                "Good effort... but it seems no one will be able to best me \nin this field... haha... ha...",
                "Thankfully your patient didn't eat these... hahaha... why don't we\nleave the baking to me... ha ha ha",
                "Here's your memory fragment... good luck finding the rest...haha...\nYou've successfully obtained one of the keys to regain one's memories.",
                "Bye bye haha...",
                "Make sure to visit again! You outta hone your baking skills...haha\nMaybe I'll cook you something next time...if you improve...haha\n... maybe..."
            };
        }

        chef = new ChefBigNPC();
        addObject(chef, 500, 300);
        
        String[] chefSounds = {
            "chef3.mp3",
            "chef2.mp3",
            "chef1.mp3",
            "chef4.mp3",
            "chef6.mp3",
            "chef5.mp3"
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
