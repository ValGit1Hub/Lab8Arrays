import java.util.Scanner;

public class LabNum8 {
	public static void main(String[] args) {
		Scanner scan1 = new Scanner(System.in);
		int atBats = 0;
		String choice = "Y";
		String next = "Y";
		
		System.out.println("Welcome to Batting Average Calulator!");
		while (choice.equalsIgnoreCase("y")) {
			atBats = getAtBats(scan1);
			if (atBats < 1){
				System.out.println("You can only enter in positive integers. Try again");
				atBats = getAtBats(scan1);
			}
			getBatResults(scan1, atBats,next);
			System.out.println("Another batter? Y or N");
			choice = scan1.nextLine();
		}//end of while
		System.out.println("Thanks for Playing");
	}//end of main

	/**
	 * @param scan1
	 * @param atBats
	 */
	private static String getBatResults(Scanner scan1, int atBats,String cont) {
		int bats =0;
		cont = "Y";
		int[] atBatResult = new int [atBats];
		
		System.out.println("0=out, 1=single, 2=double, 3=triple, 4= home run");
		for(int i=0; i<atBats;i++){
			System.out.println("Result for at-bat " + i+":");
			bats = scan1.nextInt();
			scan1.nextLine();
			if (bats >4 || bats<0){
				try {
					 throw new Exception();
				}catch(Exception e){
					System.out.println("You must enter an integer from 0 to 4. ");
					System.out.println("Result for at-bat " + i+":");
					bats = scan1.nextInt();
					scan1.nextLine();
				}
			}
			//fill array
			atBatResult[i]= bats;
		}//end of loop
		
		//get totals 
		getBattingTotals(atBats, atBatResult);
		return cont;
		
	}

	/**
	 * @param atBats
	 * @param atBatResult
	 */
	private static void getBattingTotals(int atBats, int[] atBatResult) {
		
		double sum = 0d;
		double cnt =0d;
		int base = 0;
		double battingAvr = 0d;
		double sluggingPercent = 0d;
		for(int m =0;m<atBats;m++){
			base  = atBatResult[m];
			switch(base){
			case 1:case 2:case 3:case 4:
				cnt++; 
				sum+=base;
				break;
			default:
				break;
			}
		}
		//calculate the batting average
		battingAvr = cnt/atBats;
		//calculate the percentage
		sluggingPercent = sum/atBats;
		System.out.println("Batting average: "+battingAvr);
		System.out.println("Slugging Percentage: "+sluggingPercent);
	}
	
	/**
	 * @param scan1
	 * @return
	 */
	private static int getAtBats(Scanner scan1) {
		int atBats;
		System.out.println("Enter number of times at bat:");
		atBats = scan1.nextInt();
		scan1.nextLine();
		return atBats;
		
	}

}
