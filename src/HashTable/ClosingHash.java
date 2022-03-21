package HashTable;

/**
 * Linear Probing 기법
 */

public class ClosingHash {

    public Slot[] hashTable;

    public ClosingHash(Integer size) {
        this.hashTable = new Slot[size];
    }

    public class Slot {
        String key;
        String value;

        Slot(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public int hashFunc(String key) {
        return (int)(key.charAt(0)) % this.hashTable.length;
    }

    public boolean saveData(String key, String value) {
        Integer address = this.hashFunc(key);
        if (this.hashTable[address] != null) {
            if (this.hashTable[address].key == key) {
                this.hashTable[address].value = value;
                return true;
            } else {
                Integer currAddress = address + 1; //현재 주소에서 한칸 이동
                while (this.hashTable[currAddress] != null) {//해당 슬롯 체크
                    if (this.hashTable[currAddress].key == key) {
                        this.hashTable[currAddress].value = value;
                        return true;
                    } else {
                        currAddress++;//다음 슬롯 이동
                        if (currAddress >= this.hashTable.length) {
                            return false;
                        }
                    }
                }
                //최종 슬롯까지  순회 후
                this.hashTable[currAddress] = new Slot(key, value);
                return true;
            }
        } else {
            this.hashTable[address] = new Slot(key, value);
        }
        return true;
    }

    public String getData(String key) {
        Integer address = this.hashFunc(key);
        if (this.hashTable[address] != null) {
            if (this.hashTable[address].key == key) {
                return this.hashTable[address].value;
            } else {
                Integer currAddress = address + 1;
                while (this.hashTable[currAddress] != null) {
                    if (this.hashTable[currAddress].key == key) {
                        return this.hashTable[currAddress].value;
                    } else {
                        currAddress++;
                        if (currAddress >= this.hashTable.length) {
                            return null;
                        }
                    }
                }
                return null;
            }

        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        ClosingHash mainObject = new ClosingHash(20);
        mainObject.saveData("DaveLee", "01012343333");
        mainObject.saveData("DonLee", "010111122222");
        mainObject.saveData("David", "01033334444");
        mainObject.saveData("Dave", "01055556666");
        mainObject.saveData("Dave", "01099999999");

        System.out.println(mainObject.getData("DaveLee"));
    }

}

