package HashTable;

public class ChainingHash {

    public Slot[] hasTable;

    public ChainingHash(Integer size) {
        this.hasTable = new Slot[size];
    }

    public class Slot {
        String key;
        String value;
        Slot next;//링크드 리스트
        Slot(String key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public int hashFunc(String key) {
        return (int)(key.charAt(0)) % this.hasTable.length;
    }

    public boolean saveData(String key, String value) {
        Integer address = this.hashFunc(key);
        if (this.hasTable[address] != null) {
            //헤드 설정
            Slot findSlot = this.hasTable[address];
            Slot prevSlot = this.hasTable[address];
            while (findSlot != null) {
                if (findSlot.key == key) {
                    findSlot.value = value;//존재시 업데이트
                    return true;
                } else {
                    prevSlot = findSlot;
                    findSlot = findSlot.next;
                }
            }//while문 종료는 같으 키의 데이터가 없다는 뜻
            prevSlot.next = new Slot(key, value);
        } else {
            this.hasTable[address] = new Slot(key, value);
        }
        return true;
    }

    public String getData(String key) {
        Integer address = this.hashFunc(key);
        if (this.hasTable[address] != null) {
            Slot findSlot = this.hasTable[address];
            while (findSlot != null) {
                if (findSlot.key == key) {
                    return findSlot.value;
                } else {
                    findSlot = findSlot.next;
                }
            }
            //해당 데이터 없을시
            return null;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        ChainingHash mainObject = new ChainingHash(20);
        mainObject.saveData("DaveLee", "01012343333");
        mainObject.saveData("DonLee", "010111122222");
        mainObject.saveData("David", "01033334444");
        mainObject.saveData("Dave", "01055556666");
        mainObject.saveData("Dave", "01099999999");

        System.out.println(mainObject.getData("Dave"));
    }

}
