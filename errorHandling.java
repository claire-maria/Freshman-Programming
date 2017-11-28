
package errorHandling;
import java.util.Scanner;


public class errorHandling {
	public static void main(String[]args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a number");
		if (input.hasNextInt()){
			{int maxSquare = input.nextInt();
			int maxNumber = (int) Math.sqrt(maxSquare);
			if (maxSquare<0)
				System.out.println("no squares are less than or equal to"+ maxSquare);
				
				else if (maxSquare == 0){
					System.out.println("0 is the only one");}
					
					else
					{
						System.out.println("The numbers whose squares are less than or equal to "+ maxSquare + "are ");
						for (int currentNumber = 0; (currentNumber<= maxNumber); currentNumber++)
						{System.out.print(currentNumber==0 ?"":", " + currentNumber);
						
						
					}
					
			System.out.println(".");
			
					
			}
			}
		}
			else System.out.println("Error: Not a valid number.");
		}
	}
