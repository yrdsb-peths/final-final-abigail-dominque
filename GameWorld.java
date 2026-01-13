import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class GameWorld extends World
{
    // Variable for the NPC
    private GoatChibiNPC goat;
    
    private Player player;
    
    // As long as this is true the enemies will be on screen
    private boolean activateEnemy = true;
    
    private boolean talkedToChibi = false;
    
    private int stage = 0;
    public GameWorld(int playerX, int playerY)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 700, 1); 
        
        // adds goat npc
        goat = new GoatChibiNPC();
        addObject(goat, 800, 500);
        
        // Adds the enemies to the world
        Enemy enemy1 = new Enemy();
        addObject(enemy1, 500, 200);
        
        Enemy enemy2 = new Enemy();
        addObject(enemy2, 300, 500);
        
        Enemy enemy3 = new Enemy();
        addObject(enemy3, 233, 129);
        
        Enemy enemy4 = new Enemy();
        addObject(enemy4, 210, 580);
        
        Enemy enemy5 = new Enemy();
        addObject(enemy5, 467, 580);
        
        Enemy enemy6 = new Enemy();
        addObject(enemy6, 676, 676);
        
        Enemy enemy7 = new Enemy();
        addObject(enemy7, 0, 300);
        
        // adds the instructions book
        Book book = new Book();
        addObject(book, 950, 50);
        
        // adds the player
        player = new Player();
        addObject(player, getWidth() / 2, getHeight() / 2);
    }
    
    public Player getPlayer()
    {
        return player;
    }
    
    public void openInstructions(int stage)
    {
        Greenfoot.setWorld(new Instructions3(this, stage, player.getX(), player.getY()));
    }
    
    public int getStage()
    {
        return stage;
    }
    
    public void setStage(int newStage)
    {
        stage = newStage;
    }
    
    public void spawnFragmentTwo()
    {
        FragmentTwo frag = new FragmentTwo();
        addObject(frag, 100, 200);
    }
    
    //opens cutscene2
    public void openCutsceneTwo()
    {
        Greenfoot.setWorld(new CutsceneTwo());
    }

    public void getTalkedToChibi()
    {
        talkedToChibi = true;
        return talkedToChibi;
    }
    public void spawnFragment()
    {
        if(talkedToChibi)
        {
            FragmentTwo fragment = new FragmentTwo();
            addObject(fragment, 200, 200);
        }
    }
}
