package org.prueba.Utilitarios;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;

public class Utils {
	
	public static double promedioEdades(int[] array) {
		return Arrays.stream(array).average().orElse(Double.NaN);	
	}

	public static double desviacionEstandar( int[] array) {

		int sum = 0; 
		int n = array.length;
		double prom = promedioEdades(array);		    
		for (int i = 0; i < n; i++ ) 
			sum += Math.pow (array[i] - prom, 2);

		return Math.sqrt ( sum / ( double ) n );
	}

	public static Date fechaProbableMuerte() {
		LocalDate randomDate = createRandomDate(2019, 2080);
		return Date.from(randomDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}

	public static int createRandomIntBetween(int start, int end) {
		return start + (int) Math.round(Math.random() * (end - start));
	}

	public static LocalDate createRandomDate(int startYear, int endYear) {
		int day = createRandomIntBetween(1, 28);
		int month = createRandomIntBetween(1, 12);
		int year = createRandomIntBetween(startYear, endYear);
		return LocalDate.of(year, month, day);
	}
	

}
