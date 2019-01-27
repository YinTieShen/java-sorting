package _160300531chapter9;


public class Node{
	
	Object element;
	Node next;
	
	Node(Object obj,Node nextval){
		element = obj;
		next = nextval;
	}
	
	Node(Node nextval){
		next = nextval;
	}
	
	public Node getNext(){
		return next;
	}
	
	public void setNext(Node nextval){
		next = nextval;
	}
	
	public Object getElement(){
		return element;
	}
	
	public void setElement(Object obj){
		element = obj;
	}
	public String toString(){
		return element.toString();
	}
}