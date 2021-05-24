package lab06;

public class Metric {

	static int day;
	static int month;
	static int year;

	public static void main(String[] args) {
		// Testing
		System.out.println(convertJulianToMetric(2450502));
		System.out.printf("Metric to Julian: %d", convertMetricToJulian(day, month, year));
	}

	/*
	 * Convert Julian date to Metric date
	 */

	public static int convertJulianToMetric(int julianDate) {

		int JD = julianDate;

		day = JD % 10;
		month = (JD % 1000) / 100;
		year = JD / 1000;

		return day + month + year;

	}

	public static int convertMetricToJulian(int mDay, int mMonth, int mYear) {

		return mDay + (mMonth * 100) + (mYear * 1000);
	}
}
