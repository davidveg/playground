package com.hackerrank.binarytree;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ItsABinaryTree {  
  
    public static class Edge {  
        char from, to;  
        public Edge(String exp) {  
            String[] nodes = exp.replaceAll("[\\(\\)\\s]", "").split(",");  
            from = nodes[0].charAt(0);  
            to = nodes[1].charAt(0);  
        }  
    }  
      
    private Map<Character, Character> map = new HashMap<>();  
    private Map<Character, Set<Character>> childMap = new HashMap<>();  
    private List<Edge> edges = new ArrayList<>();  
      
    public ItsABinaryTree(String exp) {  
        String[] arr = exp.split("\\s");  
        for(String str:arr) {  
            Edge edge = new Edge(str);  
            edges.add(edge);  
            map.put(edge.from, edge.from);  
            map.put(edge.to, edge.to);  
              
            Set<Character> children = childMap.get(edge.from);  
            if(children == null) {  
                children = new HashSet<Character>();  
            }  
            children.add(edge.to);  
            childMap.put(edge.from, children);  
        }  
    }  
      
    public Character find(char x) {  
        Character parent = map.get(x);  
        if(parent == null || parent == x) {  
            return parent;  
        }  
        return find(parent);  
    }  
      
    public void union(char x, char y) {  
        Character xp = find(x);  
        Character yp = find(y);  
        map.put(xp, yp);  
    }  
      
    public boolean isEdgeExisted(Edge edge) {  
        Character p = map.get(edge.to);  
        return p != null && p == edge.from;  
    }  
      
    public String buildTree() {  
        for(Character key:childMap.keySet()) {  
            Set<Character> set = childMap.get(key);  
            if(set != null && set.size()>2) {  
                return "E1";  
            }  
        }  
        for(Edge edge:edges) {  
            if(isEdgeExisted(edge)) {  
                return "E2";  
            }  
            char xp = find(edge.from);  
            char yp = find(edge.to);  
            if(xp == yp) {  
                return "E3";  
            }  
            union(edge.to, edge.from);  
        }  
        if(rootNum() > 1) {  
            return "E4";  
        }  
        return null;  
    }  
      
    private int rootNum() {  
        int cnt = 0;  
        for(char key:map.keySet()) {  
            if(find(key) == key) {  
                cnt++;  
            }  
        }  
        return cnt;  
    }  
      
    public String treeString(char root) {  
        Set<Character> children = childMap.get(root);  
        if(children == null || children.size() == 0) {  
            return "("+root+")";  
        }  
        StringBuilder result = new StringBuilder("("+root);  
        for(char child:children) {  
            result.append(",").append(treeString(child));  
        }  
        result.append(")");  
        return result.toString();  
    }  
      
    public char getRoot() {  
        return find(edges.get(0).from);  
    }
    
    static String SExpression(String nodes) {
        ItsABinaryTree gt = new ItsABinaryTree(nodes);  
        String error = gt.buildTree();  
        if(error != null) {  
            return error;  
        } else {  
            String result = gt.treeString(gt.getRoot());  
            return result;  
        } 
        
    }
      
    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        String res;
        String _nodes;
        try {
            _nodes = in.nextLine();
        } catch (Exception e) {
            _nodes = null;
        }
        
        res = SExpression(_nodes);
        bw.write(res);
        bw.newLine();
        
        bw.close();
    } 
}