package SegmentTree;

public class segmentTreeclient {

	public static void main(String[] args) {
		int[] arr=new int [] {1,-2,3,4,5};
		segmentTree st=new segmentTree(arr);
		//st.display();
       System.out.println(st.query(3, 4));
       st.update(3,-4);
       System.out.println(st.query(3, 4));
	}

}
