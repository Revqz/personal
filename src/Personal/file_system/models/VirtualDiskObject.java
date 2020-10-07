package Personal.file_system.models;

public abstract class VirtualDiskObject {

    public static final int MAX_CHAR = 20;
    public static final int MIN_SIZE = 5;

    protected String name;
    protected int size;
    protected int uniqueNumber;

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public int getUniqueNumber() {
        return uniqueNumber;
    }

    public void setUniqueNumber(int uniqueNumber) {
        this.uniqueNumber = uniqueNumber;
    }

    public abstract void addSubFolderToFolderList(SubFolder subFolder);
}
