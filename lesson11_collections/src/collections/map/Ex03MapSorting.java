package collections.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import utils.CollectionUtils;

public class Ex03MapSorting {
	public static void main(String[] args) {
		 Map<Integer, String> model = getModel();
		 
		 // map --> map.entrySet: set<entry> --> list<entry> --> sort
		 // sortedList<entry> --> sortedMap
		 CollectionUtils.printf(sort(model));
	}
	
	private static Map<Integer, String> sort(Map<Integer, String> map) {
		Set<Entry<Integer, String>> set = map.entrySet();
		
		
//		List<Entry<Integer, String>> list = new ArrayList<>(set);
		List<Entry<Integer, String>> list = new LinkedList<>(set);
		list.sort((e1, e2) -> e1.getValue().compareTo(e2.getValue()));
		
//		Map<Integer, String> sortedMap = new HashMap<>();
		Map<Integer, String> sortedMap = new LinkedHashMap<>();
		for(Entry<Integer, String> entry: list) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		return sortedMap;
	}

	private static Map<Integer, String> getModel() {
//		Map<Integer, String> model = new HashMap<>();
//		model.put(92, "Quảng Nam");
//		model.put(43, "Đà Nẵng");
//		model.put(75, "Thừa Thiên Huế");
//		model.put(74, "Quảng Trị");
//		model.put(73, "Quảng Bình");
//		return model;
		
//		Map<Integer, String> model = new HashMap<>(){{
//			put(92, "Quảng Nam");
//			put(43, "Đà Nẵng");
//			put(75, "Thừa Thiên Huế");
//			put(74, "Quảng Trị");
//			put(73, "Quảng Bình");
//		}};
//		return model;
		
		return new HashMap<>() {
			private static final long serialVersionUID = 415442841421280617L;
			{
				put(92, "Quảng Nam");
				put(43, "Đà Nẵng");
				put(75, "Thừa Thiên Huế");
				put(74, "Quảng Trị");
				put(73, "Quảng Bình");
			}
		};
	}
}
