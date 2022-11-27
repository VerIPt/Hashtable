public class HashTableDemo {
    public static void main(String[] args) {
    HashTable ht = new HashTable(11);
        ht.put(98873, "Hugo Hafer");
        ht.put(5, "Fischers Fritz");
        ht.get(12334);
        ht.get(5);
        ht.get(98873);
        ht.put(98873, "Ingo Igel");
        ht.get(98873);
    }
}
