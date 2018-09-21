import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class CreditCard
	{
		static long [] array = new long [16];
		static int digit1;
		static int didgit2;
		static long sum;
		static long rem;
		static long cardNumber;
		static int cardCount = 0;
		static Scanner userInput1 = new Scanner(System.in);
		
		public static void main (String[] args) throws FileNotFoundException
			{
//				takeNumber();
//				alternateDigits();
//				checkFinal();
				print100();
			}
		
		public static void takeNumber() throws FileNotFoundException
		{
			Scanner userInput2 = new Scanner(System.in);
			System.out.println("Would you like to input 16 didgits or import a file?");
			System.out.println("1. enter digits");
			System.out.println("2. file ");
			int choice = userInput2.nextInt();
			if (choice == 1)
				{
					Scanner userInput = new Scanner(System.in);
					System.out.println("Input the digits from the credit card number.");
					cardNumber = userInput.nextLong();
					
					for (int i =15; i>=0; i--)
						{	
							rem = cardNumber%10;
							array [i] = rem;	
							cardNumber = cardNumber / 10;
						}
				}
			else
				{
					Scanner cards = new Scanner (new File ("creditCardNumbers.txt"));
					while (cards.hasNextLong())
						{
							
//							System.out.println(cards.next());
							cardNumber = cards.nextLong();
							for (int i =15; i>=0; i--)
								{	
									rem = cardNumber%10;
									array [i] = rem;	
									cardNumber = cardNumber / 10;
								}
//							sum=0;
//							digit1=0;
							
							alternateDigits();
							checkFinal();
							
						}
					System.out.println("There were " + cardCount + " valid card numbers.");
				}
			
				
		}
		
	public static void alternateDigits()
		{
			for (int i =0; i<16; i=i+2)
				{
					array[i] = array[i]*2;
					if(array[i] >=10)
						{
							digit1 = (int)array[i]%10;
							array[i]=array[i]/10;
							array[i] = array[i] + digit1;
							
						}
					
				}
//			for (int i =0; i<16; i++)
//				{
//					sum = sum + array[i];
//				}
//			System.out.println("The sum is " + sum);
			
		
		}
	
	public static void checkFinal()
		{
			if (sum%10==0)
				{
					System.out.println("VALIDDDDDDD!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
					cardCount++;
				}
			else
				{
					System.out.println("This is not a valid card number.");
				}
			sum=0;
			digit1=0;
		}
	public static void print100()
		{

			int [] randomArray = new int [16];
			boolean run = true;
			int counter = 0;
			int countTimes =0;
			System.out.println("Would you like the computer to create 100 card numbers?");
			String create100 = userInput1.nextLine();
			if (create100 .equals("Yes") || create100.equals("yes"))
				{
					run = true;
				}
			else 
				{
					run= false;
				}
			
		while (run)
			{
			System.out.println("Card number is ");
			sum=0;
			digit1=0;
			
			for (int i = 0; i<16; i++)
				{
					 randomArray[i] = (int)(Math.random()*10);
					 
					 System.out.print( randomArray[i]);
				}
			
			System.out.println();
			
			for (int i =0; i<16; i=i+2)
				{
					randomArray[i] = randomArray [i]*2;
					if(array[i] >=10)
						{
							digit1 = randomArray[i]%10;
							randomArray[i]= randomArray[i]/10;
							randomArray[i] = randomArray[i] + digit1;
							
						}
					
				}
			for (int i =0; i<16; i++)
				{
					sum = sum + randomArray[i];
				}
			
			
			if (sum%10==0)
				{
					System.out.println("VALID");
					System.out.println();
					counter++;
					countTimes++;
					
					if (counter==100)
						{
							run=false;
						}
					
				}
			else
				{
					System.out.println("This is not a valid card number.");
					System.out.println();
					countTimes++;
				}
		}
		System.out.println("This generated " + countTimes + " credit card numbers in order to produce 100 valid credit card numbers.");
		}
		
	}
