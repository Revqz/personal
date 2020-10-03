package Personal.FileSystem;

import java.util.ArrayList;
import java.util.List;

class Folder extends VirtualDiskObject{

    private final List<Folder> subFolders;

    Folder(String name) {
        this.name = name;
        this.size = MIN_SIZE;
        this.uniqueNumber = setUniqueNumber();
        this.subFolders = new ArrayList<>();
    }

    void addSubFolderToFolderList(SubFolder subFolderName) {
        subFolders.add(subFolderName);
    }

    @Override
    public String toString() {
        return "Folder{" +
                "subFolders=" + subFolders +
                ", name='" + name + '\'' +
                ", size=" + size +
                ", uniqueNumber=" + uniqueNumber +
                '}';
    }
}

