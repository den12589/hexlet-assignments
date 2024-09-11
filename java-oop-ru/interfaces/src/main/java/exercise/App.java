package exercise;

import java.util.ArrayList;
import java.util.List;

// BEGIN
public class App{
    public static List<String>  buildApartmentsList(List<Home> list, int count){
        if(list.isEmpty())
            return new ArrayList<String>();
        return list.stream()
                .sorted(Home::compareTo)
                .map(Home::toString)
                .toList()
                .subList(0, count);
    }
}
// END
