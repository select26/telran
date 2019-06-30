package model;

public interface IMyStack<T> {
	
	void push (T data);		// push data into stack
	T peek();				// get, but not remove the uppe element
	T pop();				// get and removes the upper element 

	int deep (T data);		// returns deep of the first searching of the {data}	
							// if {data} not exists, returns -1
	int size();				// returns the number of the elements in stack
}
