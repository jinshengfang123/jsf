package nwnu.test;

import java.util.Comparator;
import java.util.TreeMap;

public class ByValueComparator implements Comparator<String> {
    TreeMap<String, Integer> treemap;
	public ByValueComparator(TreeMap<String, Integer> tm) {
        this.treemap = tm;
    }

    @Override
    public int compare(String o1, String o2) {
        // TODO Auto-generated method stub
        if(!treemap.containsKey(o1) || !treemap.containsKey(o2)) {
            return 0;
        }
        if(treemap.get(o1) < treemap.get(o2)) {
            return 1;
        } else if(treemap.get(o1) == treemap.get(o2)) {
            return 0;
        } else {
            return -1;
        }
    }
}
