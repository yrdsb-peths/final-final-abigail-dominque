import greenfoot.*;

public class DialogueBox extends Actor
{
    private String[] lines;
    private int lineIndex = 0;

    private boolean canPressSpace = true;
    private boolean isFinished = false;
    
    public DialogueBox(String[] dialogue)
    {
        lines = dialogue;
        showLine();
    }

    public void act()
    {
        if (Greenfoot.isKeyDown("space") && canPressSpace)
        {
            canPressSpace = false;
            lineIndex++;

            if (lineIndex < lines.length)
            {
                showLine();
            }
            else
            {
                isFinished = true;
                getWorld().removeObject(this);
            }
        }

        if (!Greenfoot.isKeyDown("space"))
        {
            canPressSpace = true;
        }
    }

    private void showLine()
    {
        // Create a larger image so we can draw two lines
        GreenfootImage img = new GreenfootImage(900, 150);
    
        img.setColor(Color.WHITE);
        img.fill();
    
        img.setColor(Color.BLACK);
    
        // Top message
        img.setFont(new Font(20));
        img.drawString("Press SPACE to continue", 345, 130);
    
        // Dialogue line
        img.setFont(new Font(30));
        img.drawString(lines[lineIndex], 20, 30);
    
        setImage(img);
    }

    public int getLineIndex()
    {
        return lineIndex;
    }
    
    public boolean isFinished()
    {
        return isFinished;
    }
}
