package d.collection;

import java.util.ArrayList;
import java.util.Stack;

public class ListSample {
	public static void main(String[] args) {
		ListSample sample=new ListSample();
		sample.checkArrayList1();
		sample.checkArrayList3();
		sample.checkArrayList4();
		sample.checkStack();
	}
	public void checkArrayList1() {
		ArrayList<String> list=new ArrayList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");
		list.add(2,"A1"); //두번 째에 출력 되도록 내가 순서를 정함
		
		for(String tempData:list) {
			System.out.println(tempData);
		}
		
		ArrayList<String> list2 = list; //치환 수행 List2A, List2B...;
		list.add("Ooops");
		for(String tempData : list2) {
			System.out.println("List2" + tempData);
		}	
	}
	
	public void checkArrayList3() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");
		
//		int listSize=list.size();
//		for(int loop=0; loop<listSize; loop++) { //loop-데이터가 들어있는 위치
//			System.out.println("list.get("+loop+")=" + list.get(loop));
//		}
		String[]tempArray=new String[5]; //5개를 넘으면 null 값이 나온다.
		String[]strList=list.toArray(tempArray);
		for(String temp : strList) {
			System.out.println(temp);
		}
	}
	public void checkArrayList4() {
		ArrayList<String>list=new ArrayList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");
		list.add("A");
		//System.out.println("Removed" + list.remove(0)); //-->romove사용해서 A를 지움(B,C,D,E)
		//System.out.println("Removed" + list.remove(1));  //현재 (B,C,D,E)에서 첫번 째 값을 지움
		//System.out.println(list.remove("A"));
		ArrayList<String>temp=new ArrayList<String>();
		temp.add("A");
		list.removeAll(temp); //A를 가지고 있는 값 모두 지움
		
		for(int loop=0; loop<list.size(); loop++) {
			System.out.println("list.get("+ loop +")=" + list.get(loop) );
		}
	}
	public void checkStack() {
		Stack<Integer> intStack=new Stack<Integer>();
		for(int loop=0; loop<5; loop++) {
			intStack.push(loop);
			System.out.println(intStack.peek());
		}
		while(!intStack.empty()) {
			System.out.println(intStack.pop());
		}
	}

}
