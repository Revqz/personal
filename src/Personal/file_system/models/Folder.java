package Personal.file_system.models;

import java.util.ArrayList;
import java.util.List;

public class Folder extends VirtualDiskObject {

    private final List<Folder> subFolders;

    public Folder(String name) {
        this.name = name;
        this.size = MIN_SIZE;
        this.uniqueNumber = 0;
        this.subFolders = new ArrayList<>();
    }

    public void addSubFolderToFolderList(SubFolder subFolderName) {
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

