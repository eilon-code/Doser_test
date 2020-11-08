package poroslib.util;

public class BooleanExam 
{
    private boolean is;
    private double value;
    
    
    public BooleanExam() {

    }
	public BooleanExam(boolean is, double value)
	{
        this.is = is;
        this.value = value;
	}
	
	public void SetBooleanExam(boolean is, double value)
	{
        this.is = is;
        this.value = value;	}
	
	public boolean GetIs()
	{
		return this.is;
    }
    
    public double GetValue()
	{
		return this.value;
	}
}