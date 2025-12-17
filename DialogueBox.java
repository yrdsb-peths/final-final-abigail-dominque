import greenfoot.*;

public class DialogueBox extends Actor
{
    private String[] lines;
    private int lineIndex = 0;

    private boolean canPressSpace = true;

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
        setImage(new GreenfootImage(
            lines[lineIndex],
            30,
            Color.BLACK,
            Color.WHITE
        ));
    }

    public int getLineIndex()
    {
        return lineIndex;
    }
}
