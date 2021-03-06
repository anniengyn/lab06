package lab06;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

/*
 * author: Anh Nguyen Huong & Dai Fischer
 */

public class JulianDate {

<<<<<<< HEAD:JulianDate.java
	static int year;
	static int month;
	static int day;
	static int julianDate;

	public JulianDate(Calendar c) {
=======
    int year;
	int month;
	int day;
	int julianDate;
	int century;


	
	public JulianDate (Calendar c) {
>>>>>>> 53ad8d93dd71e70045d094f70660d1dc31a45a06:lab06/JulianDate.java
		year = c.get(Calendar.YEAR);
		month = c.get(Calendar.MONTH) + 1;
		day = c.get(Calendar.DAY_OF_MONTH);
		century = Integer.parseInt(Integer.toString(year).substring(0, 2));
		julianDate = calculateJD();
	}

<<<<<<< HEAD:JulianDate.java
	public static void main(String[] args) {

		System.out.println("Please enter your birthday (dd.mm.yyyy):");
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();

		Calendar c = Calendar.getInstance();
		Calendar t = Calendar.getInstance();

		// https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/text/SimpleDateFormat.html
		try {
			c.setTime(new SimpleDateFormat("dd.MM.yyyy").parse(input));
		} catch (ParseException e1) {
			System.out.println("Error: Wrong format. Please try again.");
		}

		JulianDate jd = new JulianDate(c);
		JulianDate today = new JulianDate(t);

		if (t.get(Calendar.DAY_OF_MONTH) == c.get(Calendar.DAY_OF_MONTH)
				&& t.get(Calendar.MONTH) + 1 == c.get(Calendar.MONTH) + 1) {
			System.out.printf("\nHappy Birthday! It seems like you survived another year.");
		}
		System.out.printf("\nYour Julian date is : " + jd.calculateJD() + ".");
		System.out.printf("\nYou were born on a beautiful %s.", jd.weekday());
		System.out.printf("\nAnd guess what... you are %d days old. :)", (today.calculateJD() - jd.calculateJD()));
		if ((today.calculateJD() - jd.calculateJD()) % 100 == 0) {
			System.out.printf(
					"\nOh by the way it seems like today is a special day, since your number of lived days is divisible by 100!");
		}

		System.out.printf("\nMetric-Date: %d.", Metric.convertJulianToMetric(jd.calculateJD()));

	}

	/*
	 * Calculate Julian date
	 */ // Source: https://www.hermetic.ch/cal_stud/jdn.htm

	public int calculateJD() {
		return (1461 * (year + 4800 + (month - 14) / 12)) / 4 + (367 * (month - 2 - 12 * ((month - 14) / 12))) / 12
				- (3 * ((year + 4900 + (year - 14) / 12) / 100)) / 4 + day - 32075;
	}

	/*
	 * Get weekday, return "nice day" if it can not find weekday.
	 */// https://java.meritcampus.com/core-java-questions/Print-week-days-using-switch-statement

	public String weekday() {
		int w = (julianDate % 7) + 2;
		switch (w) {
		case 1:
			return "Monday";
		case 2:
			return "Tuesday";
		case 3:
			return "Wednesday";
		case 4:
			return "Thursday";
		case 5:
			return "Friday";
		case 6:
			return "Saturday";
		case 7:
			return "Sunday";
		default:
			return "nice day";
		}
	}

=======

    public static void main(String[] args) {
    	
        System.out.println("Please enter your birthday (dd.mm.yyyy):");
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        
        Calendar c = Calendar.getInstance();
        Calendar t = Calendar.getInstance();
        
        // https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/text/SimpleDateFormat.html
        try {
            c.setTime(new SimpleDateFormat("dd.MM.yyyy").parse(input));
        } catch (ParseException e1) {
            System.out.println("Please try again.");
        }

        JulianDate jd = new JulianDate(c);
        JulianDate today = new JulianDate(t);

        System.out.printf("\nYour Julian date is : " + jd.calculateJD() + ".");
        System.out.printf("\nYou were born on a beautiful %s.", jd.weekday());
        if(t.get(Calendar.DAY_OF_MONTH) == c.get(Calendar.DAY_OF_MONTH) && t.get(Calendar.MONTH)+1 == c.get(Calendar.MONTH)+1){
            System.out.printf("\nHappy Birthday! It seems like you survived another year.");
        }
        System.out.printf("\nAnd guess what... you are %d days old. :)", (today.calculateJD() - jd.calculateJD()));
        if( (today.calculateJD() - jd.calculateJD())%100 == 0){
            System.out.printf("\nOh by the way it seems like today is a special day, since your number of lived days is divisible by 100.");
        }
        
    }


    
    // https://www.hermetic.ch/cal_stud/jdn.htm
    private int calculateJD(){
        return ( 1461 * ( year + 4800 + ( month - 14 ) / 12 )) / 4 +
               ( 367 * ( month - 2 - 12 * (( month - 14 ) / 12 ))) / 12 -
               ( 3 * (( year + 4900 + ( year - 14 ) / 12 ) / 100 )) / 4 + day - 32075 +1; // +1 because we start with the day so the number will be XXXX.5 rounded down, which would be wrong
    }
    
    // https://java.meritcampus.com/core-java-questions/Print-week-days-using-switch-statement
    
    public String weekday(){
        int  wDay = (int) ((day + (2.6*month - 0.2) - 2*century + year + (year/4) + (century/4))%7);
        switch (wDay){
            case 1: return "Sunday";
            case 2: return "Monday";
            case 3: return "Tuesday";
            case 4: return "Wednesday";
            case 5: return "Thursday";
            case 6: return "Friday";
            case 7: return "Saturday";
            default: return "nice day";
        }
    }
    
>>>>>>> 53ad8d93dd71e70045d094f70660d1dc31a45a06:lab06/JulianDate.java
}