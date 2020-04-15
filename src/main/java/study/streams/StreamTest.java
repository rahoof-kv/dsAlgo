package study.streams;


import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamTest {

    public static void main(String[] args) {

     /*   List<User> users = Arrays.asList(new User("John", 30), new User("Julie", 35));

        int result = users.stream().reduce( 0, (partialAge, user) -> partialAge + user.getAge(), Integer::sum);
        System.out.println(result);
*/

        JSONArray jsonArray = new JSONArray();

        JSONObject j1 = new JSONObject();
        j1.put("id", 1);
        j1.put("name", "amy");

        JSONObject j2 = new JSONObject();
        j2.put("id", 2);
        j2.put("name", "adam");

        JSONObject j3 = new JSONObject();
        j3.put("id", 1);
        j3.put("name", "smith");

        jsonArray.put(j1);
        jsonArray.put(j2);
        jsonArray.put(j3);

        System.out.println("--------- " + jsonArray);

        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);

        Map<Object, Long> jsonObjectMap = IntStream.range(0, jsonArray.length())
                .mapToObj(index -> ((JSONObject) jsonArray.get(index)))
                .collect(Collectors.groupingBy(object -> object.getInt("id"), Collectors.counting()));

        jsonObjectMap.entrySet().forEach(obj -> {
            System.out.println("========= " + obj.toString());
        });

        int[] listOutputSorted = IntStream.of(-3, 10, -4, 1, 3)
                .sorted()
                .toArray();
    }


}
