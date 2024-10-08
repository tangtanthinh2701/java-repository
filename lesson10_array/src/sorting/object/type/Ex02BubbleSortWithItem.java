package sorting.object.type;

import common.Item;
import common.NullOption;
import utils.ArrayUtils;

public class Ex02BubbleSortWithItem {
	public static void main(String[] args) {
		Item[] items = getItems();
		ArrayUtils.printf("items", items);
		// sort items by price ascending
		
		System.out.println("====================");
		bubbleSort(items);
		ArrayUtils.printf("sorted items", items);
	}
	
	// bubble sort with default is NULL_FIRST
	private static void bubbleSort(Item[] elements) {
		bubbleSort(elements, NullOption.NULL_FIRST);
	}

	// bubble sort with default is null option
	private static void bubbleSort(Item[] elements, NullOption no) {
		for (int round = 0; round < elements.length; round++) {
			for (int i = 0; i < elements.length - round - 1; i++) {
				Item i1 = elements[i];
				Item i2 = elements[i + 1];
				// step 1 --> handle null values
				if (NullOption.NULL_FIRST.equals(no)) {
					if (i1 == null) {
						continue;
					}
					if (i2 == null) {
						Item tmp = elements[i];
						elements[i] = elements[i + 1];
						elements[i + 1] = tmp;
						continue;
					}
				} else if (NullOption.NULL_LAST.equals(no)) {
					if (i1 == null && i2 != null) {
						Item tmp = elements[i];
						elements[i] = elements[i + 1];
						elements[i + 1] = tmp;
						continue;
					}
					if (i2 == null) {
						continue;
					}
				}
				// step 1 --> end
				
				// step 2 --> handle non-null values --> ASC
				// swap items --> compare item's price
				
				// c1 và c2 dùng toán tử trừ được vì nó là kiểu nguyên thủy double và int
				// c3 không được xài toán tử vì nó là kiểu dữ liệu đối tượng phải xài compareTo
				// c1 ==> asc by item's price(double) -->  if (i1.getPrice() - i2.getPrice() > 0)
//				if (i1.getPrice() - i2.getPrice() > 0) {
//					Item tmp = elements[i];
//					elements[i] = elements[i + 1];
//					elements[i + 1] = tmp;
//				}
				// c2 ==> asc by item's itemId(itemId) --> if (i1.getId() - i2.getId() > 0)
//				if (i1.getId() - i2.getId() > 0) {
//					Item tmp = elements[i];
//					elements[i] = elements[i + 1];
//					elements[i + 1] = tmp;
//				}
				// c3 ==> desc by item's name --> if (i1.getName().compareTo(i2.getName()) < 0)	
				if (i1.getName().compareTo(i2.getName()) < 0) {
					Item tmp = elements[i];
					elements[i] = elements[i + 1];
					elements[i + 1] = tmp;
				}
			}
		}
	}

	public static Item[] getItems() {
		return new Item[] { 
				new Item(1, "Item 1", 350, 101),
				new Item(8, "Item 8", 120, 102),
				new Item(2, "Item 2", 450, 101),
				new Item(9, "Item 9", 250, 102),
				new Item(5, "Item 5", 620, 102), 
		};
	}
}	
