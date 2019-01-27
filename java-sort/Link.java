package _160300531chapter9;


public class Link{
	
	Object element;
	Link next;
	
	Link(Object obj,Link nextval){
		element = obj;
		next = nextval;
	}
	
	Link(Link nextval){
		next = nextval;
	}
	
	public Link getNext(){
		return next;
	}
	
	public void setNext(Link nextval){
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