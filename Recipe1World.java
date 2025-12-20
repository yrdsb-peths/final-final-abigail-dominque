import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Recipe1World extends World
{
    private DialogueBox dialogue;
    
    private Exit exit;
    
    private boolean ingredientsAdded = false;

    public Recipe1World()
    {    
        // Create a new world with 1000x700 cells with a cell size of 1x1 pixels.
        super(1000, 700, 1);
        
        Exit exit = new Exit(new CookingWorld(500,350));
        addObject(exit, 950, 50);
        
        CookingPotTop pot = new CookingPotTop();
        addObject(pot, 500, 400);
        
        String[] text;
        text = new String[] {
            "Let's make sugar cookies!",
            "Drag the ingredients into the pot."
        };
        
        dialogue = new DialogueBox(text);
        addObject(dialogue, 500, 100);
    }
    
    public void act()
    {
        if(!ingredientsAdded && dialogue.isFinished())
        {
            showIngredients();
            ingredientsAdded = true;
        }
    }
    
    private void showIngredients()
    {
        Icing icing = new Icing();
        addObject(icing, 150, 200);
        
        Sugar sugar = new Sugar();
        addObject(sugar, 150, 600);
        
        Flour flour = new Flour();
        addObject(flour, 850, 600);
        
        Butter butter = new Butter();
        addObject(butter, 850, 200);
    }
}
