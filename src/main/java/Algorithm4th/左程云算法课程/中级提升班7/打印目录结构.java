package Algorithm4th.左程云算法课程.中级提升班7;

import java.util.TreeMap;

public class 打印目录结构 {
    /**
     * 给定一个字符串数组arr，把路径中的目录结构画出来
     * 思路：先构建前缀树，再深度优先遍历
     */
    class Node {
        String name;
        TreeMap<String, Node> nextMap; //用有序表存放，如果只是单纯的前缀树，用int[] arr = new int[24];
        public Node(String name) {
            this.name = name;
            nextMap = new TreeMap<>();
        }
    }
    Node generateFolderTree(String[] folderPaths){
        Node head = new Node("");
        for (String foldPath: folderPaths) {
            String[] paths = foldPath.split("\\\\");
            Node cur = head;
            for (int i =0;i<paths.length;i++) {
                if (!cur.nextMap.containsKey(paths[i])) {
                    cur.nextMap.put(paths[i], new Node(paths[i]));
                }
                cur = cur.nextMap.get(paths[i]);
            }
        }
        return head;
    }
    //深度优先打印生成的前缀树
    void printProcess(Node node, int level) {
        if (level != 0) {
            System.out.println(get2nSpace(level) + node.name);
        }
        for (Node next: node.nextMap.values()) {
            printProcess(next, level + 1);
        }
    }
    String get2nSpace(int n) {
        String res = "";
        for (int i = 1;i<n;i++) {
            res += "  ";
        }
        return res;
    }
    void print(String[] folderPaths) {
        if (folderPaths == null || folderPaths.length == 0) {
            return ;
        }
        Node head = generateFolderTree(folderPaths);
        printProcess(head, 0);
    }

}
