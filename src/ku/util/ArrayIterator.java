package ku.util;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIterator<T> implements Iterator<T> {
	private T[] array;
	private int cursor;
	private boolean canRemove;

	public ArrayIterator(T[] array) {
		this.canRemove = false;
		this.array = array;
	}

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

	@Override
	public T next() {
		if (this.hasNext() == true) {
			this.canRemove = true;
			cursor++;
			return array[cursor-1];
		}
		throw new NoSuchElementException();
	}

	public void remove() {
		if (this.canRemove == true) {
			array[cursor - 1] = null;
			this.canRemove = false;
		} else
			throw new IllegalStateException();

	}

}
