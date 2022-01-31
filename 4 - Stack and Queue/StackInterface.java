package StackAndQueue;

public interface StackInterface<E> extends Iterable<E>{
	public void push(E element);
	public E pop();
	public boolean isEmpty();
	public E top();
}
