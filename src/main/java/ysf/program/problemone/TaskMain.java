package ysf.program.problemone;

public class TaskMain {

        //测试
        public static void main(String[] args) {
            Task A = new Task("A");
            Task B = new Task("B");
            Task C = new Task("C");
            Task D = new Task("D");
            Task E = new Task("E");
            Task F = new Task("F");
            Task G = new Task("G");
            Task H = new Task("H");

            Graph graph = new Graph();
            graph.addNode(H,C);
            graph.addNode(C,A);
            graph.addNode(A,D);
            graph.addNode(D,F);
            graph.addNode(B,G);
            graph.addNode(G,A);
            graph.addNode(G,E);
            graph.addNode(B,E);
            graph.addNode(E,F);

            TopoSort topo = new TopoSort(graph);
            topo.dealTopo();
            for (Task temp : topo.getResult()) {
            System.out.print("Task "+ temp.taskName.toString() + " ");
        }
    }

}
