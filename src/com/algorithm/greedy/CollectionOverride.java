package com.algorithm.greedy;

import java.util.*;

/**
 * 集合覆盖问题
 * 变量
 * 1、未覆盖元素列表
 * 2、选择的选项列表
 * @author wyg
 * @version 1.0
 * @date 2021/6/21 20:23
 */
public class CollectionOverride {
    public static void main(String[] args) {
        Set<String> locations = new HashSet<>(Arrays.asList(new String[]{"北京", "上海", "天津", "广州", "深圳", "成都", "杭州", "大连"}));
        Map<String, Set<String>> itemLocation = new HashMap<>();
        itemLocation.put("1", new HashSet<>(Arrays.asList(new String[]{"北京", "上海", "天津"})));
        itemLocation.put("2", new HashSet<>(Arrays.asList(new String[]{"广州", "北京", "深圳"})));
        itemLocation.put("3", new HashSet<>(Arrays.asList(new String[]{"成都", "上海", "杭州"})));
        itemLocation.put("4", new HashSet<>(Arrays.asList(new String[]{"上海", "天津"})));
        itemLocation.put("5", new HashSet<>(Arrays.asList(new String[]{"杭州", "大连"})));
        List<String> finalLocations = new ArrayList<>();
        greedy(locations, itemLocation, finalLocations);
        System.out.println(finalLocations);
    }

    public static void greedy(Set<String> locations, Map<String, Set<String>> itemLocation, List<String> finalLocations) {
        while(!locations.isEmpty()) {
            System.out.println("------");
            String bestLocation = null;
            Set<String> covered = new HashSet<>();
            int bestLocationCoveredSize = 0;
            for (Map.Entry<String, Set<String>> entry : itemLocation.entrySet()) {
                covered.clear();
                covered.addAll(entry.getValue());
                covered.retainAll(locations);
                if (bestLocation == null || bestLocationCoveredSize < covered.size()) {
                    bestLocation = entry.getKey();
                    bestLocationCoveredSize = covered.size();
                }
            }
            finalLocations.add(bestLocation);
            locations.removeAll(itemLocation.get(bestLocation));
        }
    }
}
