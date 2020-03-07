import java.util.Scanner; 
import java.util.Random; 

public class BobcatHotel {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Random randGen = new Random(); 
		
		int numGuest; 
		int numRoom; 
		int numNights; 
		int memAAA; 
		int memClub; 
		int randClub = 0; 
		int numMeal;
		double roomPrice = 0;
		double baseCost;
		double mealPrice = 0;
		double mealCost = 0;
		double costTotal;
		double totalCost;
		double disClub = 0;   // changed disNights to disClub
		double disAAA = 0;
		
		
		System.out.println("ROOM OPTIONS");
		System.out.println("1. Single @ $50.50 per night");
		System.out.println("2. Double @ $75.00 per night");
		System.out.println("3. Queen @ $100.75 per night");
		System.out.println("4. King @ $150.25 per night");
		System.out.println("5. Master Suite @ $225.50 per night\n");
		
		
		System.out.print("Number of guests: ");
		numGuest = input.nextInt(); 
		
		System.out.print("Please your choice of room (enter 1/2/3/4/5 corresponding to the options shown above): ");
		numRoom = input.nextInt(); 
			switch(numRoom) {			//added switch
				case 1:
					roomPrice = 50.50;
					break;
				
				case 2:
					roomPrice = 75.00;
					break;
					
				case 3:
					roomPrice = 100.75;
					break;
					
				case 4:
					roomPrice = 150.25;
					break;
					
				case 5:
					roomPrice = 225.50;
					break;
				
				default:
					System.out.println("Unknown Room Option");
					break;
				}
				
		/* if (numRoom == 1)
				roomPrice = 50.50;
				else if (numRoom == 2)
					roomPrice = 75.00;
					else if (numRoom == 3)
						roomPrice = 100.75;
							else if (numRoom == 4)
								roomPrice = 150.25;
									else if (numRoom == 5)
										roomPrice = 225.50; */
			
		
		System.out.print("Please enter the number of nights: ");
		numNights = input.nextInt();
		
		System.out.print("Are you a AAA member (enter 1 for yes, 0 for no)? ");
		memAAA = input.nextInt();
		
		System.out.print("Are you a club member (enter 1 for yes, 0 for no)? "); 
		memClub = input.nextInt();
		System.out.print("\n");
		
			if (memClub == 1) {
				randClub = randGen.nextInt(10);
				 if (randClub >= 4) {
					System.out.print("Congratulations! You've qualified for our ");
					System.out.println("\"Stay 4 nights get 1 free promotion\"");
					System.out.println("Discount will be applied during checkout depending on the number of days\n");
				}
				else {
					System.out.print("Unfortunately, you didn't qualify for our ");
					System.out.print("\"Stay 4 nights get 1 free promotion\". ");
					System.out.println("Better luck\nnext time!\n");
				}
			}
				
		System.out.println("MEAL PACKAGES (PRICES SHOWN ARE PER NIGHT)");
		System.out.println("0. Complementary @ $0 per guest");
		System.out.println("1. Standad @ $30 per guest");
		System.out.println("2. Deluxe @ $50 per guest");
			if (numRoom == 5) {
				System.out.println("3. Indulgence @ $85 per guest\n");
				System.out.print("Please select your desired meal package ");
				System.out.print("(enter 0/1/2/3 corresponding to the options shown\nabove): ");
				numMeal = input.nextInt();
			}
			else {
				System.out.print("\n");
				System.out.print("Please select your desired meal package ");
				System.out.print("(enter 0/1/2 corresponding to the options shown\nabove): "); 
				numMeal = input.nextInt(); 
				
			}
			
				switch(numMeal) {			//added switch
				case 0:
					mealPrice = 0;
					break;
					
				case 1:
					mealPrice = 30.00;
					break;
					
				case 2:
					mealPrice = 50.00;
					break;
					
				case 3:
					mealPrice = 85.00;
					break;
					
				default:
					System.out.println("Unknown Meal Option");
					break;
				}
			/* if (numMeal == 0)
				mealPrice = 0;
				else if (numMeal == 1)
					mealPrice = 30.00;
					else if (numMeal == 2)
						mealPrice = 50.00;
						else if (numMeal == 3)
							mealPrice = 85.00; */
							
		System.out.print("\n");
		System.out.println("CHECKOUT"); 
		
		baseCost = (numNights * roomPrice);
		System.out.println("Room Cost: \t\t\t" + "$" + baseCost);
		
			if (numMeal != 0) {
				mealCost = (numGuest * numNights * mealPrice);
				System.out.println("Meal Cost:\t\t       " + "+$" + mealCost);
			}
			
		costTotal = (double)(baseCost + mealCost);
		System.out.println("Preliminary Total Cost: \t" + "$" + costTotal);
		
			if (memAAA == 1) {
				disAAA = (double)(costTotal * .10);
				System.out.println("AAA Discount:\t\t       " + "-$" + disAAA);
			}
			
			//new set of code
			if (randClub >= 4) { 				
				disClub = 225.5 * (int)(numNights / 4);
				System.out.println("Club Member Discount:\t       " + "-$" + disClub);
				
			}
			if (randClub < 4 && memAAA == 0) {		
				System.out.println("No Discounts Applied ");
			}
		
		totalCost = costTotal - (disAAA + disClub);
		System.out.println("Total Cost of Booking:\t\t" + "$" + totalCost);
		
		
		
		} 
}
