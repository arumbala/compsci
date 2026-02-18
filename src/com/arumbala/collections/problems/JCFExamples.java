package com.arumbala.collections.problems;

import java.util.*;

/**
 * Java Collection Framework Examples
 */
public class JCFExamples {
    // Array: print, sort, filter
    // Uses Arrays.sort() for sorting primitives
    private static void processArrays(int[] nums){
        //Just Print
        System.out.println("Executing:: processArrays");
        for (int num : nums) {
            System.out.println(num);
        }

        //Sort and Print
        System.out.println("Sorted::");
        Arrays.sort(nums);
        for (int num : nums) {
            System.out.println(num);
        }

        System.out.println("Print Even Only::");
        for (int n : nums) {
            if (n % 2 == 0) {
                System.out.println(n);
            }
        }

    }


    // ArrayList: sort with Collections.sort(), filter with loop and stream
    // List.of() is immutable, wrap with new ArrayList<>() to modify
    private static void processArrayList(List<String> list) {
        System.out.println("Executing:: processArrayList");
        for(String item: list){
            System.out.println(item);
        }
        System.out.println("Sorted::");

        Collections.sort(list);
        for (String item : list) {
            System.out.println(item);
        }

        System.out.println("Filter:: Only with J* names");
        for(String name: list){
            if(name.startsWith("J")){
                System.out.println(name);
            }
        }

        System.out.println("Filter:: Only with B* names");
        list.stream()
            .filter(name -> name.startsWith("B"))
            .forEach(System.out::println);

    }

    // HashMap: word count using getOrDefault
    // HashMap has no ordering guarantee
    private static void processMap1(List<String> strings) {
        //Word Count
        Map<String, Integer> map = new HashMap<>();
        System.out.println("Executing:: processMap");
        for(String item: strings){
            map.put(item, map.getOrDefault(item, 0) + 1);
        }

        System.out.println("Word Count::");
        for(Map.Entry<String, Integer> entry: map.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    // Map: sort by key (TreeMap), sort by value (List + comparingByValue)
    // Collections.reverseOrder() for descending order
    private static void processMap2(Map<String, Integer> map) {
        System.out.println("Executing:: processMap2");

        System.out.println("Print::");
        for(String key: map.keySet()){
            System.out.println(key + " : " + map.get(key));
        }

        System.out.println("SortedMap:: Sort by Key Ascending");
        Map<String, Integer> sortedMapByKey = new TreeMap<>(map);
        for(String item: sortedMapByKey.keySet()){
            System.out.println(item + " : " + sortedMapByKey.get(item));
        }

        System.out.println("SortedMap:: Sort by Key Descending");
        Map<String, Integer> sortedMapByKeyDesc = new TreeMap<>(Collections.reverseOrder());
        sortedMapByKeyDesc.putAll(map);
        for(String item: sortedMapByKeyDesc.keySet()){
            System.out.println(item + " : " + sortedMapByKeyDesc.get(item));
        }

        System.out.println("SortedMap:: Sort by Value Ascending");
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());
        entries.sort(Map.Entry.comparingByValue());
        for(Map.Entry<String, Integer> entry: entries){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        System.out.println("SortedMap:: Sort by Value Descending");
        entries.sort(Map.Entry.comparingByValue(Collections.reverseOrder()));
        for(Map.Entry<String, Integer> entry: entries){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public static void main(String[] args){
        processArrays(new int[]{4,5,3,2,9});
        processArrayList(new ArrayList<>(List.of("Tom","Bobbie", "Sam", "Tom", "John")));
        processMap1(List.of("Tom","Bobbie", "Sam", "Tom", "John"));//Immutable List
        processMap2(Map.ofEntries(
                Map.entry("Bob", 2),
                Map.entry("Anna", 1),
                Map.entry("Cathy", 3),
                Map.entry("Danny", 4)
        ));
    }
}
