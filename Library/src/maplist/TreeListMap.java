package maplist;

import java.util.ArrayList;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class TreeListMap<K,V> extends AbstractListMap<K, V> {

	public TreeListMap() {
		super(new TreeMap<K,TreeSet<V>>());
	}

	@Override
	public ArrayList<V> getInRange(K min, K max) {
		ArrayList<V> result = new ArrayList<>();
		SortedMap<K, TreeSet<V>> sub = ((TreeMap<K,TreeSet<V>>)map).subMap(min, max);
		for (TreeSet<V> tree : sub.values()) result.addAll(tree);
		return result;
	}
	
	

}
