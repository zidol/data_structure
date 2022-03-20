package HashTable;

public class HashTable {

    public Slot[] hasTable;

    public HashTable(Integer size) {
        this.hasTable = new Slot[size];
    }

    public class Slot {
        String value;

        Slot(String value) {
            this.value = value;
        }
    }

    public int hashFunc(String key) {
        return (int)(key.charAt(0)) % this.hasTable.length;
    }

    public boolean saveData(String key, String value) {
        Integer address = this.hashFunc(key);
        if (this.hasTable[address] != null) {
            this.hasTable[address].value = value;
        } else {
            this.hasTable[address] = new Slot(value);
        }
        return true;
    }

    public String getData(String key) {
        Integer address = this.hashFunc(key);
        if (this.hasTable[address] != null) {
            return this.hasTable[address].value;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        HashTable mainObject = new HashTable(20);
        mainObject.saveData("zidolLee", "01012343333");
        mainObject.saveData("DonLee", "010111122222");
        mainObject.saveData("David", "01033334444");
        mainObject.saveData("Dave", "01055556666");

        System.out.println(mainObject.getData("DonLee"));
    }

}
