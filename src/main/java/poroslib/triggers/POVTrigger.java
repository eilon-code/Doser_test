package poroslib.triggers;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public class POVTrigger extends Trigger
{
	private GenericHID joystick;
	private int angle;

	public POVTrigger(GenericHID joystick, int angle) 
	{
		this.joystick = joystick;
		this.angle = angle;
	}
	
	
	@Override
	public boolean get()
	{
		return this.joystick.getPOV() == angle;
	}
	
}
	


