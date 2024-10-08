package localdatetime;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;

public class Ex06DatingTime {
	public static void main(String[] args) {
		// Period: LocalDate
		// Duration: LocalTime
		LocalDateTime start = LocalDateTime.of(2018, 8, 1, 23, 10, 10);
		LocalDateTime end = LocalDateTime.now();

		if (end.isBefore(start)) {
			throw new IllegalArgumentException("StartDay must less than EndDay");
		}

		Period period = Period.between(start.toLocalDate(), end.toLocalDate());
		Duration duration = Duration.between(start.toLocalTime(), end.toLocalTime());

		if (duration.isNegative()) {
			duration = duration.plusDays(1);
			period = period.minusDays(1);
		}

		System.out.println("Dating Time: \n" + "+Period: " + period + "\n+Duration: " + duration);
		System.out.println("ToString --> \n" + period.getYears() + " years\n" + period.getMonths() + " months\n"
				+ period.getDays() + " days\n" + duration.toHoursPart() + " hours\n" + duration.toMinutesPart()
				+ " minutes\n" + duration.toSecondsPart() + " seconds");
	}
}
