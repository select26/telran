package maplist;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class HashListMap<K extends Comparable<? super K>,V> extends AbstractListMap<K, V>{

	public HashListMap() {
		super(new HashMap<K, TreeSet<V>>());
	}
	
	@Override
	public LinkedHashSet<V> getInRange(K min, K max) {
		LinkedHashSet<V> result = new LinkedHashSet<>();
		
		for (K key : map.keySet()) {
			if (key.compareTo(min) >= 0 && key.compareTo(max) <= 0) result.addAll(map.get(key));
		}
		return result;
	}
	

}
