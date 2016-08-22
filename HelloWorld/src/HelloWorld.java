
public class HelloWorld 
{

	public static void main(String[] args)
	{
		System.out.println("HelloWorld");
		int count = 5;
		System.out.println(count);
		long total = 0 ;
		for (int i = 0 ; i< 1000000000; i++)
		{
			total = total + i;
		}
		System.out.print(total); 
	}
}
