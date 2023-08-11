import java.util.List;
import java.util.ArrayList;

public class StringListManipulator {

    public static void removeStrings(List<String> stringsToRemove, List<String> targetList) {
        targetList.removeAll(stringsToRemove);
    }

    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("apple");
        list1.add("banana");
        list1.add("cherry");

        List<String> list2 = new ArrayList<>();
        list2.add("banana");
        list2.add("grape");
        list2.add("cherry");

        System.out.println("List 1 before removal: " + list1);
        System.out.println("List 2 before removal: " + list2);

        removeStrings(list1, list2);

        System.out.println("List 1 after removal: " + list1);
        System.out.println("List 2 after removal: " + list2);
    }
}
