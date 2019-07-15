package maplist;

import java.util.LinkedHashSet;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class TreeListMap<K extends Comparable<? super K>,V> extends AbstractListMap<K, V> {

	public TreeListMap() {
		super(new TreeMap<K,TreeSet<V>>());
	}

	@Override
	public LinkedHashSet<V> getInRange(K min, K max) {
		LinkedHashSet<V> result = new LinkedHashSet<>();
		SortedMap<K, TreeSet<V>> sub = ((TreeMap<K,TreeSet<V>>)map).subMap(min, max);
		for (TreeSet<V> tree : sub.values()) result.addAll(tree);
		return result;
	}
	
	

}
