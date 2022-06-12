// this is a cut down version of the interface specifically for the Find test
// the complete version is in the Library folder on Moodle

public abstract interface SortedADT {
    
    public class NotFoundException extends Exception{}

    public class NotUniqueException extends Exception{}

    public abstract void insert (Comparable object) throws NotUniqueException;

    public abstract Comparable find(Comparable object) throws NotFoundException;
}
