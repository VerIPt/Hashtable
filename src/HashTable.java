import java.util.LinkedList;

// Inner class for Key-Value-Pairs with attributes key and String
class KeyValuePair
{
    int key;
    String value;

    //Getter
    public int getKey() {
        return key;
    }
    public String getValue() {
        return value;
    }

    // Constructor
    public KeyValuePair(int key, String value)
    {
        this.key = key;
        this.value = value;
    }
}
/*
    Class hashtable with linked-lists as an array for implementation
    with variable, chose able size as integer
 */
public class HashTable {
    private int size;
    private LinkedList<KeyValuePair>[] hashtable;

    // Constructor hashtable with size and array of linked-list with KeyValuePairs
    public HashTable(int size) {
        this.size = size;
        hashtable = ((LinkedList<KeyValuePair>[]) new LinkedList[size]);
    }

    // Hash-function to calculate the positive hash for Index (absolute -> Math.abs)
    private int hashFunction(Integer key) {
        return Math.abs(key.hashCode() % size);
    }

    /*
    Method for adding new Key-Value-pairs to the hashtable. With included function
    to avoid doubled keys, in that case the key is saved with the new given value
     */
    public String put(int newKey, String newValue) {
        // determine new index with the hash function
        int index = hashFunction(newKey);
        // empty String vor return Statement
        String value = " ";

        if (hashtable[index] == null) {
            /*
            In case the index in the array (hashtable) is null, there will be
            a new empty linked-list created in witch there can be new Key-Value-Objects
            generated and saved
             */
            hashtable[index] = new LinkedList<KeyValuePair>();
        }
        // saves the linked-list at the index in the hashtable from the given Key-Value-pair
        LinkedList<KeyValuePair> list = hashtable[index];
        // iterating through the linked-list at index to check for doubled-keys
        for (int i = 0; i < list.size(); i++) {
            KeyValuePair keyValuePair = list.get(i);
            int savedKey = keyValuePair.getKey();           // save key to variable
            String savedValue = keyValuePair.getValue();    // save value to variable
            // if a doubled key is found the old value gets removed and the loop interrupted
            if (newKey == savedKey) {
                System.out.println("------------------------------------------------");
                System.out.println("Saved value: " + savedValue + " from key: " + newKey);
                list.remove(i);
                value = savedValue;
                break;
            }
        }
        // Generates and adds a new Key-Value-Pair to hashtable
        KeyValuePair add = new KeyValuePair(newKey, newValue);
        list.add(add);
        System.out.println("------------------------------------------------");
        System.out.println("Key: " + add.getKey() + " , value: " + add.getValue() + " at index: " + index + " saved");
        // if statement for return-value at the end of the loop for test-cases
        if (value.equals(" "))
            return null;
        else return value;
    }

    /*
    Method for getting a value, to a key. It checks if the index is null and goes through all linked-lists
    at the index in the hashtable if the index isn't null. Return value is a string of the value from the
    matching key, or null if not found
     */
    public String get(Integer key) {
        int index = hashFunction(key);
        if (hashtable[index] != null) {
            // saves the linked-list at the index in the hashtable from the given Key-Value-pair
            LinkedList<KeyValuePair> list = hashtable[index];
            for (KeyValuePair keyValuePair : list) {        // iterates through linked-list
                int keyIndex = keyValuePair.getKey();       // saves every key for checking
                // check for matching keys and returns value as String if found
                if (key == keyIndex) {
                    System.out.println("------------------------------------------------");
                    System.out.println("Key: " + key + ", value : " + keyValuePair.getValue());
                    return keyValuePair.getValue();
                }
            }

        } else {
            // Output if the key isn't found, in both cases -> index null and if not in linked-list at index
            System.out.println("------------------------------------------------");
            System.out.println("Error, Key: " + key + " not found");
            return null;
        }
        return null;
    }


    /*
    Method to remove objects from the hashtable, with return as String from removed value
    or null if not found
     */
    public String remove(Integer key) {
        int index = hashFunction(key);
        if (hashtable[index] != null) {
            // saves the linked-list at the index in the hashtable from the given Key-Value-pair
            LinkedList<KeyValuePair> list = hashtable[index];
            for (int i = 0; i < list.size(); i++) {         //iterating through linked-list at index
                KeyValuePair keyValuePair = list.get(i);
                int keyIndex = keyValuePair.getKey();       // saves every key for checking
                String indexValue = keyValuePair.getValue();// saves every value for checking
                // checks for matching keys, and removes the Key-Value-pair -> returns removed value
                if (key == keyIndex) {
                    list.remove(i);
                    return indexValue;
                }
            }
        }
        return null;
    }

}




