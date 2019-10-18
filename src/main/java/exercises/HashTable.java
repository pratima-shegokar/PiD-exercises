package exercises;

class Entry {
    Object key;
    Object value;
    Entry next;
    Entry(Object key, Object value, Entry next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }
}

public class HashTable {
    private static final int SIZE = 1024;
    private Entry[] table = new Entry[SIZE];

    public void insert(Object key, Object value) {
        if (key == null) {
            throw new IllegalArgumentException("null key not permitted");
        }
        int hc = Math.abs(key.hashCode());
        // need to use Math.absolute function
        // to convert negative value of hashCode
        // this happens because hashCode returns 64 bit value
        // which overflows integer range
        System.out.println(hc);
        int index = hc % SIZE;
        // now insert a new Entry object into
        // the "table" array
        Entry e = new Entry(key, value, null);
        // best way: handle two cases separately
        if (table[index] == null) {
            // have not inserted anything yet
            // at that index!
            // all we need to do:
            // create a chain with a single Entry
            // object containing our key and value.
            table[index] = e;
        } else {
            Entry nextPosition = table[index];
            while(nextPosition.next != null)
                nextPosition = nextPosition.next;
            nextPosition.next = e;
        }
    }

    public Object lookup(Object keyToFind) {
        int hc = Math.abs(keyToFind.hashCode());
        int index = hc % SIZE;
        if(table[index] != null) {
            Entry foundPosition = table[index];
            while(foundPosition.next != null) {
                if (foundPosition.key.equals(keyToFind)) {
                    return foundPosition.value;
                }
                foundPosition = foundPosition.next;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        hashTable.insert("Pratima", 4831);
        hashTable.insert("Pratima", 1234);
        System.out.println(hashTable.lookup("Pratima"));
    }
}