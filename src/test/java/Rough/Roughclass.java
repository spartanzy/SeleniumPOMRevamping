package Rough;

public class Roughclass {

	public static void main(String[] args) {


		String date = "16/07/2019";
		
		String [] datesplit= date.split("/");
		
		String targetDay = datesplit[0];
		String targetMonth = datesplit[1];
		String targetYear = datesplit[2];
		
		System.out.println(targetDay +" "+targetMonth+" "+targetYear );
	}

}
