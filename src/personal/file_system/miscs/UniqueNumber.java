package personal.file_system.miscs;

public class UniqueNumber {

    private static int objectUniqueNumber = 1;

    private UniqueNumber() {
    }

    public static int uniqueNumberGeneration() {
        return objectUniqueNumber++;
    }

    public static void resetUniqueNumber() {
        objectUniqueNumber = 1;
    }
}
