
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList linkedList = new LinkedList();
		DoubleLinkedList linkedList2 = new DoubleLinkedList();
		
		linkedList.add(0,"1");
		linkedList.add(1,"3");
		linkedList.add(2,"4");
		linkedList.add(3,"5");
		linkedList.add(1,"2");
		
		System.out.println(linkedList);
		
		linkedList.remove(2);
		System.out.println(linkedList);
		
		linkedList2.add(0,"1");
		linkedList2.add(1,"3");
		linkedList2.add(2,"4");
		linkedList2.add(3,"5");
		linkedList2.add(1,"2");
		System.out.println(linkedList2);
	}

}
