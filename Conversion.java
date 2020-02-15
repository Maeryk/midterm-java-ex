//Authors: Gordon Bittner
//		   Bronson Batad
// Midterm Cit 230

public class Conversion
{
	
	private double convertOut = 0.0;
	
	private double[] convertNumbers={1,3,6,48,96,192,768};
	
	public Conversion()
	{
		convertOut = 0.0;
	}
	
	public void convertMeasurement(double amount, int from, int to)
	{
		try
		{
			convertOut = (amount*convertNumbers[from])/convertNumbers[to];
		}
		catch(ArithmeticException e)
		{
			System.out.println("You shouldn't divide by zero.");
		}
	}
	
	public double getConvertOut()
	{
		return convertOut;
	}
	
}
