
public class HashTableDemo {
    public static void main(String[] args) {
        HashTable ht = new HashTable(11);

        System.out.println("Add to key 98873: " + ht.put(98873, "Hugo Hafer "));
        System.out.println("Add to key 98873: " + ht.put(98873, "Fiene Fein ")+ ht.get(98873));
        System.out.println("Key 98873: "+ht.get(98873));
        System.out.println("key 98873 removed: " + ht.remove(98873));
        System.out.println("Key 98873: "+ht.get(98873));
        System.out.println("Add to key 5: " + ht.put(5, "Fischers Fritz "));
        System.out.println("Key 12334: " + ht.get(12334));
        System.out.println("key 5: " + ht.get(5));
        ht.get(98873);
        ht.put(98873, "Ingo Igel ");

    }

}
