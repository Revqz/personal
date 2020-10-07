package Personal.file_system.models;

public class SubFolder extends Folder {

    public SubFolder(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "SubFolder{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", uniqueNumber=" + uniqueNumber +
                '}';
    }
}
