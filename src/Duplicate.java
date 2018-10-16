import java.util.*;
public class Duplicate {
	public static void main(String[] args)
	{
	List<Integer> list = new ArrayList<Integer>();
	list.add(2);
	list.add(3);
	list.add(5);
	list.add(5);
	list.add(7);
	System.out.println(list);
	Set<Integer> set = new LinkedHashSet<Integer>(list);
	list.clear();
	list.addAll(set);
	System.out.println(set);
	
	
	}

}
