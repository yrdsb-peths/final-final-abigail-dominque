import greenfoot.*;

public class DialogueBox extends Actor
{
    private String[] lines;
    private int lineIndex = 0;

    private boolean canPressSpace = true;
    private boolean isFinished = false;

    // Greenfoot fonts
    private greenfoot.Font dialogueFont;
    private greenfoot.Font promptFont;

    public DialogueBox(String[] dialogue)
    {
        lines = dialogue;

        // Set monospace fonts
        dialogueFont = new greenfoot.Font("Monospaced", 20); // bold dialogue
        promptFont = new greenfoot.Font("Monospaced", 15);         // "Press SPACE" message

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
        GreenfootImage img = new GreenfootImage(900, 150);

        img.setColor(Color.WHITE);
        img.fill();

        img.setColor(Color.BLACK);

        // Use monospace font for "Press SPACE"
        img.setFont(promptFont);
        img.drawString("Press SPACE to continue", 345, 130);

        // Use monospace font for dialogue
        img.setFont(dialogueFont);
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
