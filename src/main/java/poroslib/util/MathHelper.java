package poroslib.util;

public class MathHelper 
{	

	public static double normalizeThrottleSin(double throttle)
	{
		return Math.sin((Math.PI / 2) * (throttle * throttle));		
	}
	public static double normalizeTurnSin(double turn)
	{
		return Math.copySign((turn * turn), turn);	
	}
	public static double mapRange(double oldMin, double oldMax, double newMin , double newMax, double value)
	{

		double newSlope = (newMax - newMin) / (oldMax - oldMin);
		double newB = newMax - (newSlope*oldMax);

		double output = (newSlope * value) + newB;
		
		return output;
	}
	
    public static double handleDeadband(double value, double deadband) 
    {
    	double newValue = 0;
    	
    	if(Math.abs(value) > Math.abs(deadband))
    	{
    		newValue = value;
    	}
    	
        return newValue;
	}
	
}

