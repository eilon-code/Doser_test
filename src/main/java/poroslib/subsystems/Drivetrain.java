package poroslib.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 *
 */
public abstract class Drivetrain extends SubsystemBase  
{

	private boolean isReversed = false;
		
	private boolean isRanged = false;
	
	private boolean enabled = false;

	
    public void SetIsReversed(boolean isReversed)
    {
    	this.isReversed = isReversed;
    }
    
    public boolean IsReversed()
    {
    	return this.isReversed;
    }
    
    public void SetIsEnabled(boolean enabled)
    {
    	this.enabled = enabled;
    }
    
    public boolean IsEnabled()
    {
    	return this.enabled;
    }
    
    public void SetIsRanged(boolean isRanged)
    {
    	this.isRanged = isRanged;
    }
    
    public boolean IsRanged()
    {
    	return this.isRanged;
    }

	

	
}

