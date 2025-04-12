package Hot100;

import java.util.*;

/**
 * @Author : Vagrant
 * @Time: 2025-04-10 10:07
 * @File : Solution65.java
 * @Description :399. 除法求值(直接抄)
 */

public class Solution65 {
    private Map<String, HashMap<String, Double>> graph = null;

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        graph = new HashMap<>();
        int cur = 0;
        for (List<String> equation : equations) {
            String x = equation.get(0);
            String y = equation.get(1);
            graph.computeIfAbsent(x, k -> new HashMap<>()).put(y, values[cur]);
            graph.computeIfAbsent(y, k -> new HashMap<>()).put(x, 1.0 / values[cur]);
            cur++;
        }
        double[] res = new double[queries.size()];
        int i = 0;
        for (List<String> query : queries) {
            Set<String> visited = new HashSet<>();
            res[i++] = dfs(query.get(0), query.get(1), visited);
        }
        return res;
    }

    private double dfs(String x, String y, Set<String> visited) {
        if (!graph.containsKey(x)) return -1.0;
        if (x.equals(y)) return 1.0;
        for (String key:graph.get(x).keySet()){
            if (key.equals(y)){
                return graph.get(x).get(y);
            }else if (!visited.contains(key)){
                visited.add(key);
                double val = dfs(key, y, visited);
                if (val != -1.0){
                    return graph.get(x).get(key) * val;
                }
            }

        }
        return -1.0;
    }
}


