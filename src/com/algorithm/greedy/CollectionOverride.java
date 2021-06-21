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
        String bestLocation;
        Set<String> covered = new HashSet<>();
        while(!locations.isEmpty()) {
            bestLocation = null;
            int bestLocationCoveredSize = 0;
            // 每一次for循环，选出与当前未选择的locations交集最大的选项，即贪心算法
            for (Map.Entry<String, Set<String>> entry : itemLocation.entrySet()) {
                covered.clear();
                covered.addAll(entry.getValue());
                covered.retainAll(locations);
                // bestLocation == null为每轮初始化的问题，bestLocationCoveredSize记录截止到当前选项时，选出的bestLocation集合与locations的交集大小
                if (bestLocation == null || bestLocationCoveredSize < covered.size()) {
                    bestLocation = entry.getKey();
                    bestLocationCoveredSize = covered.size();
                }
            }
            finalLocations.add(bestLocation);
            // 去除本轮已经选择的，以便下次选择时，排除此项干扰
            locations.removeAll(itemLocation.get(bestLocation));
        }
    }
}
