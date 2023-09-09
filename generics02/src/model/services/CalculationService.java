package model.services;

import java.util.List;

public class CalculationService {
	
	/*
	 * Generics:
	 * 'Generic' types allow classes, interfaces and methods to be parameterized by type. Its benefits are: 
	 * • Reuse
	 * • Type safety
	 * • Performance
	 */

	/*
	 *  <T extends Comparable<? super T>> T means that the generic type <T> will work
	 *  with any <T> type SUBclass and any <T> type SUPERclass
	 */
	public static <T extends Comparable<? super T>> T max(List<T> list) {
		if (list.isEmpty())
			throw new IllegalStateException("List can't be empty");

		T max = list.get(0);

		for (T item : list) {
			if (item.compareTo(max) > 0)
				max = item;
		}

		return max;
	}

}