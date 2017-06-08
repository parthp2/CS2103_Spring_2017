package Lab22;

public class Driver{
	public static void main(String[] args) {
		
		MyMap<String, Integer> map = new MyHashMap<>();
		map.put("Parth", 15);
	    map.put("Anderson", 31);
		map.put("chintan", 14);
		map.put("Shivam", 14);
		map.put("Jainee", 9);
		map.put("Dhvani", 9);
		map.put("Acharya", 45);
		map.put("Amee", 9);

		System.out.println("Entries in map: " + map);

		System.out.println("The age of chintan is " +
			map.get("chintan"));

		System.out.println("The age of Amee is " +
			map.get("Amee"));

		System.out.println("Is Achraya in the map? " +
			map.containsKey("Acharya"));

		System.out.println("Is Jay in the map? " +
			map.containsKey("Jay"));

		System.out.println("Is age 33 in the map? " +
			map.containsValue(33));

		System.out.println("Is age 31 in the map? " +
			map.containsValue(31));

		System.out.print("Keys in map: ");
		for (String key : map.keySet()) {
			System.out.print(key + " ");
		}
		System.out.println();

		System.out.print("Values in map: ");
		for (int value : map.values()) {
			System.out.print(value + " ");
		}
		System.out.println();

		map.remove("Acharya");
		System.out.println("Entries in map " + map);

		map.clear();
		System.out.println("Entries in map " + map);

	}
}
