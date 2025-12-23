import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Recipe1World extends World
{
    private DialogueBox dialogue1;
    
    private boolean ingredientsAdded = false;
    
    private int ingredientsAddedCount = 0;
    private final int TOTAL_INGREDIENTS = 4;
    
    private boolean recipeMade = false;
    private boolean lastDialogueShown = false;

    public Recipe1World()
    {    
        // Create a new world with 1000x700 cells with a cell size of 1x1 pixels.
        super(1000, 700, 1);
        
        Exit exit = new Exit(new CookingWorld(500,350));
        addObject(exit, 950, 50);
        
        CookingPotTop pot = new CookingPotTop();
        addObject(pot, 500, 400);
        
        String[] text1;
        text1 = new String[] {
            "Let's make sugar cookies!",
            "Click the ingredients to put them in the pot."
        };
        
        dialogue1 = new DialogueBox(text1);
        addObject(dialogue1, 500, 100);
    }
    
    public void act()
    {
        if(!ingredientsAdded && dialogue1.isFinished())
        {
            showIngredients();
            ingredientsAdded = true;
        }
        
        if(recipeMade && !lastDialogueShown)
        {
            showLastDialogue();
            lastDialogueShown = true;
        }
    }
    
    private void showLastDialogue()
    {
        String[] text2;
        text2 = new String[] {
            "Good job, you baked sugar cookies!",
            "Give them to your fairy friends."
        };
        
        DialogueBox dialogue2 = new DialogueBox(text2);
        addObject(dialogue2, 500, 100);
    }
    
    private void showIngredients()
    {
        Icing icing = new Icing(this);
        addObject(icing, 150, 200);
        
        Sugar sugar = new Sugar(this);
        addObject(sugar, 150, 600);
        
        Flour flour = new Flour(this);
        addObject(flour, 850, 600);
        
        Butter butter = new Butter(this);
        addObject(butter, 850, 200);
    }
    
    public void ingredientAdded()
    {
        ingredientsAddedCount++;
        
        if(ingredientsAddedCount == TOTAL_INGREDIENTS)
        {
            finishRecipe();
        }
    }
    
    private void finishRecipe()
    {
        removeObjects(getObjects(Ingredient.class));
        removeObjects(getObjects(CookingPotTop.class));
        
        SugarCookies cookie = new SugarCookies();
        addObject(cookie, 500, 400);
        
        recipeMade = true;
    }
}
