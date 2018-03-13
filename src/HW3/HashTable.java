package HW3;

public class HashTable<E> {
	
	int hashType; // 0 <- linear probing, 1 <- double hashing
	double loadFactor;
	public int probeCount;
	public HashObject<E>[] table;
	boolean tableIsFull;
	
	public HashTable(int tableSize) {
		table = new HashObject[tableSize];
		this.hashType = 0;
		loadFactor = 0.0;
		probeCount = 0;
	}
	
	public HashTable(int tableSize, int type) {
		table = new HashObject[tableSize];
		this.hashType = type;
		loadFactor = 0.0;
		probeCount = 0;
	}
	
	public boolean insert(E key) {		
		int i = 0;
		boolean dupeNotFound = true;
		int hi = hash(key, i);	
		while(table[hi] != null && dupeNotFound) {
			if(table[hi].equals(key)) {
				table[hi].frequencyCount++;
				dupeNotFound = false;
			}else {
				i++;
				hi = hash(key, i);
			}					
		}
		if(i >= table.length) {
			// the hash function is messed up. Throw an exception
		}else {
			probeCount += i;
			table[hi] = new HashObject<E>(key, hi);
			loadFactor += 1.0 / (double)table.length;
		}
		return !dupeNotFound;
	}
	
	public E find(E key) {	
		int i = 0;
		int hi = hash(key, i);
		while(!table[hi].object.equals(key)) {
			i++;
			hi = hash(key, i);
		}
		if( i >= table.length ) return null;
		if( table[hi] == null) return null;
		return table[hi].object;
	}
	
	void delete(E key) {		
		int i = 0;
		int hi = hash(key, i);
		while(i < table.length && table[hi].object != key && table[hi] != null) {
			i++;
			hi = hash(key, i);
		}
		if( i >= table.length ) return;
		if( table[hi] == null) return;
		table[hi] = null;
	}
	
	int hash(E key, int i) {
		long m = table.length;
		long k = 1L;
		long il = new Long(i);
		if(key instanceof String) k = (long)Math.abs(key.hashCode());
		if(key instanceof Integer) k = new Long((int)key);
		if(key instanceof Long) k = (long)key;
		if(hashType == 0) {		
			int ret = (int)(((k % m) + i) % m);
			if(ret < 0 || ret >= table.length) ret = 100;
			return ret;
		}
		if(hashType == 1) {
			int ret = (int)( ((k % m) + il*(1L + (k % (m-2L)) )) % m);
			if(ret < 0 || ret >= table.length-1) ret = 100;
			return ret;
		}		
		return -1;		
	}

}
