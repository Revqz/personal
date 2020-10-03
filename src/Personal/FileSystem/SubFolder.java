package Personal.FileSystem;

class SubFolder extends Folder {

    SubFolder(String name) {
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
