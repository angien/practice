import java.util.*;

public class Answer2 {
    public static HashMap<Integer, Integer> parent;
       
    public static void main(String args[]) { 
        int h = 5;
        int[] q = {6,7, 8, 9, 10, 11, 12, 13};
        int[] ans = answer(h, q);
        for (int i : ans) {
            System.out.println(i);
        }
    }

    public static int[] answer(int h, int[] q) {
        parent = new HashMap<Integer, Integer>();
        for (int j : q) {
            parent.put(j, -1);
        }

        int maxNum = (int)Math.pow(2, h) - 1;
    
        // build tree
        buildTree(h, maxNum);
    
        int[] ans = new int[q.length]; 

        for (int i = 0; i < q.length; i++) {
            if (q[i] < maxNum)
                ans[i] = parent.get(q[i]);
        }
            
        return ans;
    }

    public static void buildTree(int h, int maxNum) {
        class Node {
            int height;
            int data;
            Node left;
            Node right;

            public Node(int height, int data) {
                this.height = height;
                this.data = data;
            }

            public void addLeftChild(Node o) {
                this.left = o;
            }

            public void addRightChild(Node o) {
                this.right = o;
            }

            public int getData() {
                return this.data;
            }

            public int getHeight() {
                return this.height;
            }
        }

        Node head = new Node(h, maxNum);
        Queue<Node> q = new LinkedList<Node>();
        q.add(head);

        while (!q.isEmpty()) {
            Node temp = q.remove();
            int tempH = temp.getHeight();
            int tempV = temp.getData();
            if (tempH > 1) {
                tempH--;
                int l = tempV - (int)Math.pow(2,tempH);
                int r = tempV - 1;

                //add to parent dictionary
                if (parent.containsKey(l))
                    parent.put(l, tempV);
                if (parent.containsKey(r))
                    parent.put(r, tempV);

                Node lNode = new Node(tempH, l);
                Node rNode = new Node(tempH, r);

                // add to tree
                temp.addLeftChild(lNode);
                temp.addRightChild(rNode);

                // add to queue
                q.add(rNode);
                q.add(lNode);
            }
        }

    } 
}


