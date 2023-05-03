import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class HashMapUtils {

  // HashMap
  public static Map<String, String> getHashMap() {
    Map<String, String> hashMap = new HashMap<>();
    hashMap.put("A", "100");
    hashMap.put("B", "200");
    hashMap.put("C", hashMap.get("A"));
    // A=100, B=200, C=100
    return hashMap;
  }

  // common function for getting key from hash map.
  public static <K, V> K getKey(Map<K, V> map, V value) {
    return map.entrySet()
        .stream()
        .filter(entry -> value.equals(entry.getValue()))
        .findFirst().map(Map.Entry::getKey)
        .orElse(null);
  }

  // get key
  public static Map<String, Integer> getKey(int value) {
    Map<String, Integer> sampleMap = new HashMap<>();

    sampleMap.put("A", 1);
    sampleMap.put("B", 2);
    sampleMap.put("C", 3);

    sampleMap
        .entrySet()
        .stream()
        .filter(entry -> value == entry.getValue())
        .findFirst()
        .map(Map.Entry::getKey)
        .orElse(null);

    return sampleMap;
  }

  // get key, values
  public static void showKeyAndValues() {
    HashMap<String, String> hashMap = new HashMap<String, String>();
    hashMap.put("A", "test");
    hashMap.put("B", "test2");

    // method 1
    Iterator<Map.Entry<String, String>> entries = hashMap.entrySet().iterator();
    while (entries.hasNext()) {
      Entry<String, String> entry = (Entry<String, String>) entries.next();
      System.out.println("key: " + entry.getKey() + ", value: " + entry.getValue());
    }
    // method 2
    for (Map.Entry<String, String> entry : hashMap.entrySet()) {
      System.out.println("key: " + entry.getKey() + ", value: " + entry.getValue());
    }
    // method 3
    hashMap.forEach((k, v) -> System.out.println("key: " + k + ", value: " + v));
  }

  // containsKey
  public static boolean containsKey(String key) {
    Map<String, String> map = new HashMap<>();
    return map.containsKey(key);
  }

  // keySet, iterator
  public static String getKeyAndValues() {
    Map<String, Integer> map = new HashMap<>();
    map.put("A", 100);
    map.put("B", 200);
    int mapLength = map.size();
    System.out.println("mapLength: " + mapLength);

    Iterator<String> it = map.keySet().iterator();

    StringBuilder builder = new StringBuilder("result: ");
    while (it.hasNext()) {
      String key = it.next();
      int value = map.get(key);
      builder.append(key + ":" + value);
    }
    return builder.toString();
  }

  // put collection to map
  public static String putCollectionToMap() {
    Map<String, List<Integer>> map = new HashMap<>();
    if (map.containsKey("A") == false) {
      List<Integer> list = new ArrayList<>();
      list.add(Integer.parseInt("100"));
      map.put("A", list);

    } else {
      map.get("A").add(Integer.parseInt("100"));
    }

    StringBuffer buffer = new StringBuffer("result: ");
    Iterator<Entry<String, List<Integer>>> iterator = map.entrySet().iterator();
    while (iterator.hasNext()) {
      Entry<String, List<Integer>> entrySet = iterator.next();
      buffer.append(entrySet.getKey() + ":" + entrySet.getValue());
    }
    return buffer.toString();
  }
}
