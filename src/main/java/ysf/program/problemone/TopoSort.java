package ysf.program.problemone;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class TopoSort {

    private List<Task> result; //结果
    private LinkedList<Task> zeroDegree;//入度：0
    private Graph graph;

    public TopoSort(Graph di) {
        this.graph = di;
        this.result = new ArrayList<Task>();
        this.zeroDegree = new LinkedList<Task>();
        for (Task iterator : this.graph.vertexSet) {
            if (iterator.pathIn == 0) {
                this.zeroDegree.add(iterator);
            }
        }
    }

    //排序
    public void dealTopo() {
        while (!zeroDegree.isEmpty()) {
            Task v = zeroDegree.poll();
            result.add(v);

            if (this.graph.adjaNode.keySet().isEmpty()) {
                return;
            }

            // 遍历
            for (Task w : this.graph.adjaNode.get(v)) {
                w.pathIn--;
                if (0 == w.pathIn){ //入度为0特殊处理
                    zeroDegree.add(w);
                }
            }
            this.graph.vertexSet.remove(v);
            this.graph.adjaNode.remove(v);
        }


        if (!this.graph.vertexSet.isEmpty()) {
            System.out.println("error,出现闭环");
            throw new RuntimeException("闭环，程序退出");
        }
    }

    //
    public Iterable<Task> getResult() {
        return result;
    }
}
