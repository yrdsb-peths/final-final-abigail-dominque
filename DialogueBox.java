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

    // Sound for the people :)
    private String[] voiceSounds;
    private GreenfootSound[] voiceClips;
    
    public DialogueBox(String[] dialogue, String[] voiceSounds)
    {
        lines = dialogue;
        this.voiceSounds = voiceSounds;
        
        voiceClips = new GreenfootSound[voiceSounds.length];
        for (int i = 0; i < voiceSounds.length; i++) {
            voiceClips[i] = new GreenfootSound(voiceSounds[i]);
            voiceClips[i].setVolume(100); // volume
        }
    
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
        
        int r = Greenfoot.getRandomNumber(voiceClips.length);
        voiceClips[r].play();

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
