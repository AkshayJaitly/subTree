import java.io.*;
import java.util.*;

class ShortestWordEditPath {
      static int shortestWordEditPath(String source, String target, String[] words) {
        Set<String> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(source, 0));
        while (!queue.isEmpty()) {
            Node poppedNode = queue.poll();
            if (poppedNode.val.equals(target)) {
                return poppedNode.level;
            }

            for (String word : words) {
                if (!visited.contains(word)) {
                    if (stringDiffCounter(poppedNode.val, word)) {
                        Node node = new Node(word, poppedNode.level + 1);
                        queue.add(node);
                        visited.add(word);
                    }
                }
            }
        }

        return -1;
    }

    static boolean stringDiffCounter(String source, String target) {
        if (source.length() != target.length()) {
            return false;
        }
        int count = 0;

        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) != target.charAt(i)) {
                count++;
            }
        }
        return count == 1;
    }

    public static void main(String[] args) {
        int level = shortestWordEditPath("bit", "fog", new String[]{"but", "put", "big", "pot", "pog", "dog", "lot", "lit", "fog"});
        System.out.println(level);
    }
  
     static class Node {
       String val;
       int level;
       
       Node(String val, int level) {
         this.val = val;
         this.level = level;
       }
     }
}