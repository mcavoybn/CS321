package HW3;

public class HashObject<E>{

	public E object;
	public int frequencyCount;
	int key;
	
	public HashObject(E object, int key) {
		this.object = object;
		frequencyCount = 0;
	}
	
	@Override
	public boolean equals(Object compareObject) {
		return object == compareObject;
	}
	
	public int getKey() {
		return key;
	}
	
	@Override
	public String toString() {
		return object.toString();
	}
	
	
}
