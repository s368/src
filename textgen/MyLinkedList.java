package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		size = 0;
		head = new LLNode<E>();
		tail = new LLNode<E>();

		head.next = tail;
		tail.prev = head;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		boolean done = false;
		if(element == null)
		{
			throw new NullPointerException("Can't store 'null' pointer object!");
		}

		LLNode<E> n = new LLNode<E>(element);
		n.next = this.tail;
		n.prev = this.tail.prev;
		
		this.tail.prev.next = n;
		this.tail.prev = n;
		size++;
		done = true;
		
		return done;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		if(index < 0 || index > size - 1 || size == 0)
		{
			throw new IndexOutOfBoundsException("get(index) - index out of bound");
		}
			
		LLNode<E> n = head.next;
		for(int i = 0;i < index;i++)
		{
			n = n.next; 
		}
		
		return n.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		if(element == null)
		{
			throw new NullPointerException("Can't store 'null' pointer object!");
		}

		if(index < 0 || index > size)
		{
			throw new IndexOutOfBoundsException("get(index) - index out of bound");
		}
	
		LLNode<E> n = new LLNode<E>(element);

		LLNode<E> o = head.next;
		for(int i = 0;i < index;i++)
		{
			o = o.next; 
		}
		
		n.next = o;
		n.prev = o.prev;
		
		o.prev.next = n;
		o.prev = n;
		size++;
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		if(index < 0 || index > size - 1 || size == 0)
		{
			throw new IndexOutOfBoundsException("get(index) - index out of bound");
		}

		LLNode<E> n = head.next;
		for(int i = 0;i < index;i++)
		{
			n = n.next; 
		}

		n.prev.next = n.next;
		n.next.prev = n.prev;
		size--;

		return n.data;

	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		if(element == null)
		{
			throw new NullPointerException("Can't store 'null' pointer object!");
		}

		if(index < 0 || index > size - 1 || size == 0)
		{
			throw new IndexOutOfBoundsException("get(index) - index out of bound");
		}
		
		LLNode<E> n = head.next;
		for(int i = 0;i < index;i++)
		{
			n = n.next; 
		}
		
		E oldE = n.data;
		n.data = element;
		
		return oldE;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode()
	{
		this.data = null;
		this.prev = null;
		this.next = null;
	}
	
	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
