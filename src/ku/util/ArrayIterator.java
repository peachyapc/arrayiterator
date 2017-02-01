package ku.util;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Provide an Iterator to iterate over all the array in the collection without
 * knowing the structure of the array.
 * 
 * @author Apichaya Tiwcharoensakul
 *
 * @param <T>
 */
public class ArrayIterator<T> implements Iterator<T> {

	/** attribute for the array we want to iterate over */
	private T[] array;
	/** attribute for index of the element */
	private int cursor;
	/** attribute for call method remove() if canRemove is true */
	private boolean canRemove;

	/**
	 * Initialize a new array iterator with the array to process.
	 * 
	 * @param array
	 *            is the array to iterate over
	 */
	public ArrayIterator(T[] array) {
		this.canRemove = false;
		this.array = array;
	}

	/**
	 * This method decide if there is another element available and move the
	 * cursor to the start of the next (non-null) element. hasNext() may also
	 * advance the cursor to skip null elements.
	 * 
	 * @return true if next() can return another non-null array element, false
	 *         if no more elements.
	 */
	@Override
	public boolean hasNext() {
		for (int i = this.cursor; i < array.length; i++) {
			if (this.array[i] != null) {
				this.cursor = i;
				return true;
			}
		}
		return false;
	}

	/**
	 * Return the next non-null element from array, if any.
	 * 
	 * @return the next non-null element in the array.
	 * @throws NoSuchElementException
	 *             if there are no more elements to return.
	 */
	@Override
	public T next() {
		if (this.hasNext() == true) {
			this.canRemove = true;
			cursor++;
			return array[cursor - 1];
		}
		throw new NoSuchElementException();
	}

	/**
	 * Remove most recent element returned by next() from the array by setting
	 * it to null. This method may only be called once after a call to next().
	 * 
	 * @throws NoSuchElementException
	 *             If this method is called without calling next(). or called
	 *             more than once after calling next(),
	 */
	public void remove() {
		if (this.canRemove == true) {
			array[cursor - 1] = null;
			this.canRemove = false;
		} else
			throw new IllegalStateException();

	}

}
