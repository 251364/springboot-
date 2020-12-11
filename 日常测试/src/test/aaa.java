package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class aaa {
	public static void main(String[] args) {

		/*
		 * Long a1= new Date().getTime(); System.out.println(a1);
		 * System.out.println(System.currentTimeMillis());
		 */
		/*
		 * List a=new ArrayList(); a.add(0); a.add(1); a.add(0); a.add(0);
		 * System.out.println(a);
		 */
		Set<String> listA = new HashSet<String>();
		listA.add("A");
		listA.add("B");
		listA.add("C");
		listA.add("");
		
		
		
		List<String> list1 = new ArrayList<String>();
		list1.add("A");
		list1.add("B");
        list1.add("C");
		List<String> list2 = new ArrayList<String>();
		list2.add("B");
		list2.add("C");
		List<String> list3 = new ArrayList<String>();
		list3.add("B");
	//	list3.add("C");
		
		
		List<List<String>> li = new ArrayList<List<String>>();
		li.add(list1);
		li.add(list2);
		li.add(list3);
		Set<String> before = getIntersection(li);
		/*
		 * List<String>list3=new ArrayList<String>(list1); Set<String> listB = new
		 * HashSet<String>(listA);
		 */
	//	System.out.println(li);
//		Set<String> after = getUnion(li);
	System.out.println(before);
//		System.out.println(after);
		
	
	}

	private static Set<String> getIntersection(List<List<String>> list) {
		
//		Set <String> set=new HashSet<String>();
//		@SuppressWarnings("unchecked")
//		List<String>  aa=list.stream().reduce((list1,list2) ->{
//			list1.retainAll(list2);
//			return list1;
//		}).orElse(Collections.EMPTY_LIST);
//		
//		set.addAll(aa);
//	    return  set;
		Set<String> set = new HashSet<String>();
	    set.addAll(list.get(0));
		list.forEach(li -> {
			set.retainAll(li);
						
		});
				
		return set;
	}
	private static Set<String> getUnion(List<List<String>> list) {
		Set<String> gr = new HashSet<String>();
		list.forEach(union -> {
			gr.addAll(union);
		});
		return gr;
	}
	
}
