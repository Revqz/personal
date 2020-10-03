package Personal.FileSystem;

abstract class VirtualDiskObject {

    static final int MIN_SIZE = 5;
    static final int MAX_CHAR = 20;
    static int objectUniqueNumber = 1;

    String name;
    int size;
    int uniqueNumber;


    String getName() {
        return name;
    }

    int getSize() {
        return size;
    }

    int setUniqueNumber() {
        return objectUniqueNumber++;
    }

    int getUniqueNumber() {
        return uniqueNumber;
    }

    abstract void addSubFolderToFolderList(SubFolder subFolder);
}
