package maplist;
 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;
 
public class HashListMap<K,V> extends AbstractListMap<K, V>{
 
    public HashListMap() {
        super(new HashMap<K, TreeSet<V>>());
    }
     
    @Override
    public ArrayList<V> getInRange(K min, K max) {
        ArrayList<V> result = new ArrayList<>();
         
        for (K key : map.keySet()) {
            if (((Comparable<K>) key).compareTo(min) >= 0 && 
                ((Comparable<K>)key).compareTo(max) <= 0)
                    result.addAll(map.get(key));
        }
        return result;
    }
     
 
}