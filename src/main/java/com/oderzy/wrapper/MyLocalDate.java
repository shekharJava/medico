package com.oderzy.wrapper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;

public class MyLocalDate {

	public static LocalDateTime now() {

		return LocalDateTime.now().atZone(ZoneId.of("UTC")).withZoneSameInstant(ZoneId.of("Asia/Kolkata"))
				.toLocalDateTime();

	}

	public static LocalDateTime tomorow() {

		return LocalDateTime.now().plusDays(1).atZone(ZoneId.of("UTC")).withZoneSameInstant(ZoneId.of("Asia/Kolkata"))
				.toLocalDateTime();

	}

	public static LocalDateTime todayAt(int hr, int min) {
		LocalDate d = LocalDate.now();
		LocalTime t = LocalTime.of(hr, min);
		LocalDateTime ld = LocalDateTime.of(d, t);

		if (t.isAfter(LocalTime.of(18, 0)))
			ld = ld.plusDays(1);

		return ld.atZone(ZoneId.of("UTC")).withZoneSameInstant(ZoneId.of("Asia/Kolkata")).toLocalDateTime();
	}

	public static LocalDateTime todayAfterMin(int min) {

		return LocalDateTime.now().plusMinutes(min).atZone(ZoneId.of("UTC"))
				.withZoneSameInstant(ZoneId.of("Asia/Kolkata")).toLocalDateTime();
	}

	public static LocalDateTime todayAfterHr(int hr) {

		return LocalDateTime.now().plusHours(hr).atZone(ZoneId.of("UTC")).withZoneSameInstant(ZoneId.of("Asia/Kolkata"))
				.toLocalDateTime();
	}

	public static LocalDateTime convert(LocalDateTime now) {

		return now.atZone(ZoneId.of("UTC")).withZoneSameInstant(ZoneId.of("Asia/Kolkata")).toLocalDateTime();

	}

	public static LocalDate nowDate() {

		return LocalDateTime.now().atZone(ZoneId.of("UTC")).withZoneSameInstant(ZoneId.of("Asia/Kolkata"))
				.toLocalDate();

	}

	public static LocalTime nowTime() {

		return LocalDateTime.now().atZone(ZoneId.of("UTC")).withZoneSameInstant(ZoneId.of("Asia/Kolkata"))
				.toLocalTime();

	}
}
