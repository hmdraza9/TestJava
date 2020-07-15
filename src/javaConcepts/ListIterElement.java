package javaConcepts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class ListIterElement {

	public static void main(String[] args) {
		List<Integer> al = new ArrayList<Integer>(List.of(10,100,20,20,20,20,10,20,20,20,20,30,20,10,30,10,30,20,10,30,10,10));
		Set<Integer> newSet = new HashSet<Integer>();
		HashMap<Integer,Integer> hmap = new HashMap<Integer, Integer>();
		newSet.addAll(al);
		
		for(Integer i:newSet) {
			int count=0;
			int num=0;
			for(int j=0;j<al.size();j++) {
				if(i.equals(al.get(j))) {
					count=count+1;
					num=al.get(j);
				}
			}
			hmap.put(num, count);
			hmap.entrySet();
		}
		int maxVal = (Collections.max(hmap.values()));
		for(Entry<Integer, Integer> entry:hmap.entrySet()) {
			if(entry.getValue().equals(maxVal)) {
				System.out.println(entry.getKey()+"-"+maxVal);
			}
		}
	}
}
