import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayListUtils {

  // ArrayList, Arrays.asList
  public static ArrayList<String> createArrayList() {
    ArrayList<String> list = new ArrayList<>(Arrays.asList("A", "B", "C"));
    return list;
  }

  // ArrayList, array to list
  public static ArrayList<String> arrayToArrayList() {
    String[] sampleArray = { "abc", "aaa" };
    return new ArrayList<>(Arrays.asList(sampleArray));
  }

  // ArrayList, list to array
  public static String[] listToArray() {
    ArrayList<String> list = new ArrayList<>();
    list.add("A");
    list.add("B");
    String[] resultArray = list.toArray(new String[list.size()]);
    return resultArray;
  }

  // ArrayList, list to integer array
  public static int[] listToIntArray() {
    ArrayList<Integer> list = new ArrayList<>();
    list.add(100);
    list.add(1000);
    int[] resultArray = list
        .stream()
        .mapToInt(i -> i)
        .toArray();
    return resultArray;
  }

  // ascending ordering
  public static ArrayList<String> doAscendingOrder(ArrayList<String> list) {
    Collections.sort(list);
    return list;
  }

  // descending ordering
  public static ArrayList<String> doDescendingOrder(ArrayList<String> list) {
    Collections.sort(list, Collections.reverseOrder());
    return list;
  }

  // ascending ordering with case insensitive order
  public static ArrayList<String> doAscendingOrderWithInsensitiveCase(ArrayList<String> list) {
    Collections.sort(list, String.CASE_INSENSITIVE_ORDER);
    return list;
  }

  // descending ordering with case insensitive order
  public static ArrayList<String> doDescendingOrderWithInsensitiveCase(ArrayList<String> list) {
    Collections.sort(list, Collections.reverseOrder(String.CASE_INSENSITIVE_ORDER));
    return list;
  }

  // frequency count
  public static int getFreguencyCount(ArrayList<String> list) {
    return Collections.frequency(list, "10");
  }

  // binary search
  public static int doBinarySearch(ArrayList<String> list) {
    return Collections.binarySearch(list, "10");
  }

  // delete duplicated values
  public static List<String> deleteDuplicatedValues(ArrayList<String> list) {
    List<String> result = list.stream().distinct().collect(Collectors.toList());
    return result;
  }

  // ArrayList deepcopy
  public static ArrayList<String> deepCopy() {
    ArrayList<String> listA = new ArrayList<>();
    ArrayList<String> listB = new ArrayList<>();
    listB.add("A");
    listA.addAll(listB);
    return listA;
  }

  // ArrayList.subList
  public static List<Integer> getSubList(ArrayList<Integer> list) {
    List<Integer> resultList = list.subList(1, list.size() - 1);
    return resultList;
  }

  // Arrays.asList
  public static ArrayList<String> getArrayList() {
    return new ArrayList<String>(Arrays.asList("A", "B"));
  }

  // ArrayList max, min
  public static ArrayList<Integer> getMaxAndMinList(ArrayList<Integer> list) {
    int max = Collections.max(list);
    int min = Collections.min(list);
    return new ArrayList<Integer>(Arrays.asList(max, min));
  }
}
