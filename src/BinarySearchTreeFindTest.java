
public class BinarySearchTreeFindTest {

    public static void main(String[] args) throws Exception {
        SortedADT sorted = new BinarySearchTree();
        sorted.insert(10);
        sorted.insert(15);
        sorted.insert(5);
        sorted.insert(20);
        sorted.insert(8);
        System.out.println(sorted);
        Integer value;
        do{
            value = Input.getInteger("value: ");
            try {
                sorted.find(value);
                System.out.println("found");
            } catch (SortedADT.NotFoundException e) {
                System.out.println("value not found");
            }
        }while(Repeat.repeat());
    }
}
