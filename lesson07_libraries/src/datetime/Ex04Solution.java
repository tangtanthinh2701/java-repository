package datetime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Ex04Solution {
	private static final String PATTERN = "dd/MM/yyyy E";

	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		System.out.println("Number of Sundays: " + count(c));
	}

	private static int count(Calendar c) {
		int count = 0;
		Calendar startDate = getStartDayOfMonth(c);
		Calendar endDate = getEndDayOfMonth(c);
		plusDay(endDate);
		for (Calendar date = startDate; date.before(endDate);)
			if (date.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
				printTime(date, PATTERN);
				count++;
				plusWeek(date);
			} else {
				plusDay(date);
			}
		return count;
	}

	private static void plusDay(Calendar c) {
		c.add(Calendar.DAY_OF_MONTH, 1);
	}

	private static void plusWeek(Calendar c) {
		c.add(Calendar.WEEK_OF_MONTH, 1);
	}

	private static void printTime(Calendar c, String pattern) {
		DateFormat df = new SimpleDateFormat(pattern);
		System.out.println(df.format(c.getTime()));
	}

	private static Calendar getStartDayOfMonth(Calendar c) {
		Calendar result = copy(c);
		result.set(Calendar.DAY_OF_MONTH, 1);
		return result;
	}

	private static Calendar getEndDayOfMonth(Calendar c) {
		Calendar result = copy(c);
		result.set(Calendar.DAY_OF_MONTH, result.getActualMaximum(Calendar.DAY_OF_MONTH));
		return result;
	}

	private static Calendar copy(Calendar c) {
		Calendar result = Calendar.getInstance();
		result.setTime(c.getTime());
		return result;
	}
}
