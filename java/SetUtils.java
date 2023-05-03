import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;

public class SetUtils {

  // set to list
  public static List<String> setToList() {
    Set<String> set = new HashSet<String>();
    List<String> list = new ArrayList<>(set);
    return list;
  }
}
