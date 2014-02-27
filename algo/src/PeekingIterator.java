/*public interface Iterator<T> {
  boolean hasNext(); // returns true if we're not at the end
  T next() throws Exception; // returns the next value, unless we're at the end, when it throws an Exception
}

peek = new PeekingIterator([1 2 3 4 5].iterator());

peek.hasNext()  -- true
peek.peek() == 1
peek.peek() == 1
peek.next() == 1
peek.peek() == 2
peek.next() == 2
peek.next() == 3

Next returns next element
Peek returns next element but do*/ 
public class PeekingIterator<T> {
  private Iterator<T> it;
  private T nextElement;

  public PeekingIterator(Iterator<T> it) {
    this.it = it;
    nextElement = it.next();
  }

  boolean hasNext() {
    return it.hasNext();
  }

  T next() throws Exception {
    T result;
    if (nextElement == null) {
      nextElement = it.next();
      result = nextElement;
    } else {
      result = nextElement;
      nextElement = null;
    }
    return result;
  }

  // Returns what next would return, or null if next would throw an exception
  T peek() {
    if (it.hasNext()) {
      nextElement = it.next();
    } else {
      nextElement = null;
    }
    return nextElement;
  }

}
