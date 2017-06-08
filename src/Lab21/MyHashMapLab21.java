package Lab21;

import java.util.ArrayList;

public class MyHashMapLab21<K, V> implements MyMap<K, V> {
	
	private static int DEFAULT_INITIAL_CAPACITY = 4;

	
	private static int  MAXIMUM_CAPACITY = 1 << 30;

	
	private int capacity;

	
	private static float DEFAULT_MAX_LOAD_FACTOR = 0.5f;

	
	private float loadFactorThreshold;

	
	private int size = 0;

	
	ArrayList<MyMap.Entry<K, V>> table;

	
	public MyHashMapLab21() {
		this(DEFAULT_INITIAL_CAPACITY, DEFAULT_MAX_LOAD_FACTOR);
	}

	
	public MyHashMapLab21(int initialCapacity) {
		this(initialCapacity, DEFAULT_MAX_LOAD_FACTOR);
	}

	
	public MyHashMapLab21(int initialCapacity, float loadFactorThreshold) {
		if (initialCapacity > MAXIMUM_CAPACITY)
			this.capacity = MAXIMUM_CAPACITY;
		else
			this.capacity = trimToPowerOf2(initialCapacity);

		this.loadFactorThreshold = loadFactorThreshold;
		table = new ArrayList<>();
		for (int i = 0; i < capacity; i++)
			table.add(null);
	}

	@Override
	public void clear() {
		size = 0;
		removeEntries();
	}

	@Override 
	public boolean containsKey(K key) {
		if (get(key) != null)
			return true;
		else
			return false;
	}

	@Override 
	public boolean containsValue(V value) {
		for (int i = 0; i < capacity; i++) {
			if (table.get(i) != null && table.get(i).getValue() == value)
				return true;
		}

		return false;
	}

	@Override 
	public java.util.Set<MyMap.Entry<K,V>> entrySet() {
		java.util.Set<MyMap.Entry<K, V>> set = 
			new java.util.HashSet<>();

		for (int i = 0; i < capacity; i++) {
			if (table.get(i) != null) {
				set.add(table.get(i));
			}
		}

		return set;
	}

	@Override 
	public V get(K key) {
		int index = hash(key.hashCode());

		while(table.get(index) != null) {
			if (table.get(index).getKey().equals(key)) {
					return table.get(index).getValue();
			}
			index++;
			index %= capacity;
		}

		return null;
	}

	@Override 
	public boolean isEmpty() {
		return size == 0;
	}

	@Override 
	public java.util.Set<K> keySet() {
		java.util.Set<K> set = new java.util.HashSet<K>();

		for (int i = 0; i < capacity; i++) {
			if (table.get(i) != null)
				set.add(table.get(i).getKey());
		}

		return set;
	}

	@Override 
	public V put(K key, V value) {
		int index = hash(key.hashCode());

		while (table.get(index) != null) {
			
			if (table.get(index).getKey().equals(key)) {
				Entry<K, V> entry = table.get(index);
				V oldvalue = entry.getValue();
				
				entry.value = value;
				table.set(index, entry);
				
				return oldvalue;
			}

			
			index++; 
			index %= capacity;
		}

		// 
		if (size >= capacity * loadFactorThreshold) {
			if (capacity == MAXIMUM_CAPACITY)
				throw new RuntimeException("Exceeding maximum capacity");
			rehash();
		}

		
		table.set(index, new MyMap.Entry<K, V>(key, value));

		size++; 

		return value;
	} 

	@Override 
	public void remove(K key) {
		int index = hash(key.hashCode());
		
		
		while (table != null) {
			if (table.get(index).getKey().equals(key)) {
				table.remove(index);
				size--; 
				break; 
			}
			index++;
			index %= capacity;
		}
	}


	@Override 
	public int size() {
		return size;
	}

	@Override 
	public java.util.Set<V> values() {
		java.util.Set<V> set = new java.util.HashSet<>();

		for (int i = 0; i < capacity; i++) {
			if (table.get(i) != null)
				set.add(table.get(i).getValue());
		}

		return set;
	}

	
	private int hash(int hashCode) {
		return supplementalHash(hashCode) & (capacity - 1);
	}

	
	private static int supplementalHash(int h) {
		h ^= (h >>> 20) ^ (h >>> 12);
		return h ^ (h >>> 7) ^ (h >>> 4);
	}

	
	private int trimToPowerOf2(int initialCapacity) {
		int capacity = 1;
		while (capacity < initialCapacity) {
			capacity <<= 1;
		}

		return capacity;
	}

	
	private void removeEntries() {
		table.clear();
	}

	
	private void rehash() {
		java.util.Set<Entry<K, V>> set = entrySet();
		capacity <<= 1; 
		size = 0; 
		table.clear(); 
		for (int i = 0; i < capacity; i++)
			table.add(null);

		for (Entry<K, V> entry : set) {
			put(entry.getKey(), entry.getValue());
		}
	}

	@Override 
	public String toString() {
		StringBuilder builder = new StringBuilder("[");

		for (Entry<K, V> entry: table) {
			if (entry != null && table.size() > 0)
				builder.append(entry);
		}

		builder.append("]");
		return builder.toString();
	}
}