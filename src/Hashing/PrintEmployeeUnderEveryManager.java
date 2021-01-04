package Hashing;

// Given a dictionary that contains mapping of employee and his manager as a number of (employee, manager) pairs like below.
//{ "A", "C" },
//{ "B", "C" },
//{ "C", "F" },
//{ "D", "E" },
//{ "E", "F" },
//{ "F", "F" }

// Write a function to get no of employees under each manager in the hierarchy not just their direct reports. It may be assumed that an employee directly reports to only one manager. In the above dictionary the root node/ceo is listed as reporting to himself.
//
//Output should be a Dictionary that contains following.
//
//A - 0
//B - 0
//C - 2
//D - 0
//E - 1
//F - 5

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrintEmployeeUnderEveryManager {
    // A hashmap to store result. It stores count of employees
    // under every employee, the count may by 0 also
    static Map<String, Integer> result = new HashMap<String, Integer>();

    static void populateResult(Map<String, String> map) {
        HashMap<String, List<String>> reverseMap = new HashMap<>();

        // Create a reverse map with Manager Employee relationship
        for (Map.Entry<String, String> entry: map.entrySet()) {
            String employee = entry.getKey();
            String manager = entry.getValue();
            if (!employee.equals(manager)) { // excluding emp-emp entry
                if (reverseMap.containsKey(manager)) {
                    List<String> list = reverseMap.get(manager);
                    list.add(employee);
                } else {
                    List<String> list = new ArrayList<>();
                    list.add(employee);
                    reverseMap.put(manager, list);
                }
            }
        }

        // Now use manager-Emp map built above to populate result
        // with use of populateResultUtil()

        // note- we are iterating over original emp-manager map and
        // will use mngr-emp map in helper to get the count

        for (String manager : map.keySet()) {
            populateResultUtil(manager, reverseMap );
        }
    }

    static int populateResultUtil(String manager, Map<String, List<String>> reverseMap) {
        int count = 0;
        // if the manager doesn't found in the map, fill 0 for it.
        if (!reverseMap.containsKey(manager)) {
            result.put(manager, 0);
            return 0;
            // this employee count has already been done by this
            // method, so avoid re-computation
        } else if (result.containsKey(manager)) {
            count = result.get(manager);
        } else {
            List<String> list = reverseMap.get(manager);
            count = list.size();
            for (String employee: list) {
                count += populateResultUtil(employee, reverseMap);
            }
            result.put(manager, count);
        }
        return count;
    }
    // Driver function
    public static void main(String[] args) {
        Map<String, String> dataSet = new HashMap<String, String>();
        dataSet.put("A", "C");
        dataSet.put("B", "C");
        dataSet.put("C", "F");
        dataSet.put("D", "E");
        dataSet.put("E", "F");
        dataSet.put("F", "F");

        populateResult(dataSet);
        System.out.println("result = " + result);
    }
}
