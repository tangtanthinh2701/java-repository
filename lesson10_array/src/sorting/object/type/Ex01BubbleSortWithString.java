package sorting.object.type;

import common.NullOption;
import utils.ArrayUtils;

public class Ex01BubbleSortWithString {
	public static void main(String[] args) {
		String[] data = {"a1", "c3", "b2", "f5", "d4"};
//		String[] data = {"a", "C", "b", "F", "D"};
		bubbleSort(data);
		ArrayUtils.printf("data", data);
		
		System.out.println("===============");
		data = new String[]{null, "a1", "c3", null, "b2", "f5", null, "d4", null, null};
		bubbleSort(data, NullOption.NULL_FIRST);
		ArrayUtils.printf("data", data);
		bubbleSort(data, NullOption.NULL_LAST);
		ArrayUtils.printf("data", data);
	}
	
	// null last, null first
	// handle NULL values
	// NULL first ==> ASC, DESC
	// NULL last  ==> ASC, DESC
	// require: NULL first, ASC
	private static void bubbleSort(String[] elements, NullOption no) {
		// Array has N elements --> N rounds
		// Each round --> find max, min(asc/desc) per round

		// Loop left --> right
		// if (a[left] > a[right]) --> swap --> ASC
		// if (a[left] < a[right]) --> swap --> DESC
		// Process 2 jobs
		// 1. Handle sort for null values --> first, last
		// 2. others will not be null --> sort by asc, desc
		// Vì element thứ i là kiểu dữ liệu đối tượng (String) nên các 
		// biểu thức số học không  có tác dụng => xài hàm compareTo
		for (int round = 0; round < elements.length; round++) {
			for (int i = 0; i < elements.length - round - 1; i++) {
				String s1 = elements[i]; // pre
				String s2 = elements[i+1]; // next
				// step 1 --> handle null values --> null first
				if (NullOption.NULL_FIRST.equals(no)) {
					// expected ==> null null null ...others...
					// pre(NULL), next(NULL || !NULL) --> no-swap
					// pre(!NULL), next(NULL) --> swap
					if (s1 == null) {
						continue; // nâng i tạo vòng lặp mới
					}
					// sure --> s1(!null)
					if (s2 == null) {
						String tmp = elements[i];
						elements[i] = elements[i + 1];
						elements[i + 1] = tmp;
						continue;
					}
					// sure --> s1(!null) s2(!null)
				} else if(NullOption.NULL_LAST.equals(no)) {
					// expected ==> ...others... null null null
					// pre(NULL), next(!NULL) --> swap
					// pre(!NULL), next(!NULL || NULL) --> no-swap
					if (s1 == null && s2 != null) {
						String tmp = elements[i];
						elements[i] = elements[i + 1];
						elements[i + 1] = tmp;
						continue;
					}
					// sure --> s1(!null)
					if (s2 == null) {
						continue;
					}
				}
				// step 2 --> handle non-null values --> ASC
				// if (elements[i] > elements[i + 1])
				// if (elements[i] - elements[i + 1] > 0)
				
				// elements[i].compareTo(elements[i + 1]) = x
				// x > 0 ==> pre > next --> asc
				// x < 0 ==> pre < next --> desc
				if (s1.compareTo(s2) > 0) {
					// swap ==> ASC
					// i: previous
					// i+1: next
					String tmp = elements[i];
					elements[i] = elements[i + 1];
					elements[i + 1] = tmp;
				}
			}
		}
	}

	// sorting ascending
	// not handle NULL values
	// Có thể bị lỗi nullpointerException
	private static void bubbleSort(String[] elements) {
		// Array has N elements --> N rounds
		// Each round --> find max, min(asc/desc) per round

		// Loop left --> right
		// if (a[left] > a[right]) --> swap --> ASC
		// if (a[left] < a[right]) --> swap --> DESC
		for (int round = 0; round < elements.length; round++) {
			for (int i = 0; i < elements.length - round - 1; i++) {
				// if (elements[i] > elements[i + 1])
				// if (elements[i] - elements[i + 1] > 0)  //giống đối tượng hơn
				
				// elements[i].compareTo(elements[i + 1]) = x
				// x > 0 ==> pre > next --> asc
				// x < 0 ==> pre < next --> desc
				// String implement Comparable<String>
				// copareTo là một hàm trừu tượng (Comparable)
				if (elements[i].compareTo(elements[i + 1]) < 0) {
					// swap ==> ASC
					// i: previous
					// i+1: next
					String tmp = elements[i];
					elements[i] = elements[i + 1];
					elements[i + 1] = tmp;
				}
			}
		}
	}
}
