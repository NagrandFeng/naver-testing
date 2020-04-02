package ysf.program.problemone;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class Graph {

    public Set<Task> vertexSet = new HashSet<>();
    public Map<Task, Set<Task>> adjaNode = new HashMap<>();

    public boolean addNode(Task start, Task end) {
        if (!vertexSet.contains(start)) {
            vertexSet.add(start);
        }
        if (!vertexSet.contains(end)) {
            vertexSet.add(end);
        }
        if (adjaNode.containsKey(start)
                && adjaNode.get(start).contains(end)) {
            return false;
        }
        if (adjaNode.containsKey(start)) {
            adjaNode.get(start).add(end);
        } else {
            Set<Task> temp = new HashSet<>();
            temp.add(end);
            adjaNode.put(start, temp);
        }
        end.pathIn++;
        return true;
    }

}
