package SegmentTree;

public class segmentTree {
private class Node{
    int data;
	int startinterval;
	int endinterval;
	Node left;
	Node right;
}
Node root;
public segmentTree(int[] arr) {
	this.root=this.constructTree(arr,0,arr.length-1);
}
private Node constructTree(int[] arr, int si, int ei) {
	if(si==ei) {
		Node leafNode=new Node();
		leafNode.data=arr[si];
		leafNode.startinterval=si;
		leafNode.endinterval=ei;
		return leafNode;
	}
	Node node=new Node();
	node.startinterval=si;
	node.endinterval=ei;
	int mid=(si+ei)/2;
	node.left=constructTree(arr,si,mid);
	node.right=constructTree(arr,mid+1,ei);
	node.data=node.left.data+node.right.data;
	return node;
}
public void display() {
	this.display(this.root);
}
private void display(Node node) {
	String str="";
	if(node.left!=null) {
		str=str+"interval = ["+node.left.startinterval+"-"+node.left.endinterval+"] and data ="
			+node.left.data+"=>";	
	}else {
		str=str+"No left child";
	}
	str=str+"interval = ["+node.startinterval+"-"+node.endinterval+"] and data = "+node.data;
	if(node.right!=null) {
		str=str+"<= data is = "+node.right.data+"and interval is ["+node.right.startinterval+"-"+node.right.endinterval+"]";
	}else {
		str=str+"No right child";
	}
	System.out.println(str);
	if(node.left!=null) {
		this.display(node.left);
	}
	if(node.right!=null) {
		this.display(node.right);
	}
}
public int query(int qsi,int qei) {
	return this.query(this.root,qsi, qei);
}
private int query(Node node, int qsi, int qei) {
	//node is completely lying inside query
	if(node.startinterval>=qsi && node.endinterval<=qei) {
		return node.data;
	}else if(node.startinterval>qei || node.endinterval<qsi) {
		return 0;
	}else {
		// overlapping case.
		int leftans=query(node.left,qsi,qei);
		int rightans=query(node.right,qsi,qei);
		return leftans+rightans;
	}
}
public void update(int index,int value) {
	this.update(this.root,index,value);
}
private int update(Node node, int index, int value) {
	if(index>=node.startinterval && index<=node.endinterval) {
		if(index==node.startinterval && index==node.endinterval) {
			node.data=value;
		}else {
			int leftans=update(node.left,index,value);
			int rightans=update(node.right,index,value);
			return leftans+rightans;
		}
	}
		
	return node.data;
	
	
}
}
