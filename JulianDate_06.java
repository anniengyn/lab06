package lab06;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

/*
 * author: Dai Fischer & Anh Nguyen Huong
 */

public class JulianDate_06 {

	static int year;
	static int month;
	static int day;
	String julianDate;

	public void JulianDate(Calendar c) {
		year = c.get(Calendar.YEAR);
		month = c.get(Calendar.MONTH);
		day = c.get(Calendar.DAY_OF_MONTH);
		julianDate = calculateJD(c);
	}

	public static void main(String[] args) throws ParseException {
		System.out.println("Please enter your birthday (dd.mm.yyyy):");
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();

		Calendar cal = Calendar.getInstance();
		cal.setTime(new SimpleDateFormat("dd.MM.yyyy").parse(input));

		System.out.println(calculateJD(cal));
		System.out.println(dayOfYear(cal) + " Day Of Year");

	}

	// format (cyyddd) Source:
	// https://docs.oracle.com/cd/E26228_01/doc.93/e21961/julian_date_conv.htm#WEAWX261
	private static String calculateJD(Calendar c) {

		// century from 1900 - 2099
		String jd = new String();
		String i = new String();
		String y = new String();
		String d = new String();
		if (c.get(Calendar.YEAR) >= 2000) {
			i = "1";
		} else {
			i = "0";
		}
		// year
		if (c.get(Calendar.YEAR) >= 2000) {
			int k = c.get(Calendar.YEAR) - 2000;
			if (k < 10) {
				y = "0" + String.valueOf(k);
			} else {
				y = String.valueOf(k);
			}
		} else {
			int l = c.get(Calendar.YEAR) - 1900;
			if (l < 10) {
				y = "0" + String.valueOf(l);
			} else {
				y = String.valueOf(l);
			}
		}
		// days
		d = String.valueOf(dayOfYear(c));

		// add 0 if days of year < 100 to keep format
		if (dayOfYear(c) < 100) {
			d = "0" + d;
		}
		jd = i + y + d;
		return jd;

	}

	public static int dayOfYear(Calendar c) {
		int month = c.get(Calendar.MONTH);
		int year = c.get(Calendar.YEAR);
		int day = c.get(Calendar.DAY_OF_MONTH);

		int sum = 0;
		for (int i = 1; i < month; i++) {
			if (thirtyoneDays(i)) {
				sum = sum + 31;

			} else {
				sum = sum + 30;

			}
			if (specialFeb(i)) {
				sum = sum - 2;
			}
			if (schaltjahr(year)) {
				sum = sum + 1;
			}
		}
		sum = sum + day;
		return sum;
	}

	public static boolean thirtyoneDays(int a) {

		if (a == 2 || a == 4 || a == 6 || a == 9 || a == 11) {
			return false;
		}
		return true;
	}

	public static boolean specialFeb(int a) {
		if (a != 2) {
			return false;
		}
		return true;
	}

	public static boolean schaltjahr(int a) {
		// 1. Ein Jahr ist ein Schaltjahr, wenn es restlos durch 4 teilbar ist.
		if (a % 4 != 0) {
			return false;
			// 2. Falls sich die Jahrzahl durch 100 restlos teilen lässt, ist es kein
			// Schaltjahr.
			// 3. Falls auch eine Teilung durch 400 ganzzahlig möglich ist, dann ist es ein
			// Schaltjahr.
		}
		if (a % 100 == 0 && a % 400 != 0) {
			return false;
		}
		return true;
	}

}
