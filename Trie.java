package interview;
import java.util.*;
public class Trie {
    ArrayList<TrieNode> ROOT;
    public Trie(){
        ROOT=new ArrayList<>();
    }
    public void display(){
        for(TrieNode tr:ROOT){
            TrieNode tmp=tr;
            while(tmp!=null){
                System.out.println("NODe: "+tmp.x+" LIST: "+tmp.list);
                tmp=tmp.next;
            }
        }
    }
    public void insert(String x){
        if(ROOT.isEmpty()){
            TrieNode newTrie=new TrieNode();
            ROOT.add(newTrie);
            for(char t:x.toCharArray())
                addtoList(newTrie,t);
        }else{
            boolean FLAG=false;
            TrieNode finalNode=null;
            for(TrieNode tr:ROOT){
                tr=tr.next;
                if(tr.x==x.charAt(0)){
                    FLAG=true;
                    finalNode=tr;
                    break;
                }
            }
            if(FLAG){
                TrieNode trav=finalNode;
                trav=trav.next;
                int index=1;
                while(trav!=null && index < x.length()){
                    if(trav.x!=x.charAt(index)){
                        trav.list.add(x.charAt(index));
                    }
                    index++;
                    trav=trav.next;
                }
                if(index < x.length()){
                    //copy as it is
                    for(;index < x.length();index++)
                        trav.list.add(x.charAt(index));
                }
            }else{
                TrieNode newTrie=new TrieNode();
                ROOT.add(newTrie);
                for(char t:x.toCharArray())
                    addtoList(newTrie,t);
            }
        }
    }
    public void addtoList(TrieNode root,char y){
        TrieNode node=new TrieNode(y);
        if(root==null){
            root=node;
        }else{
            TrieNode trav=root;
            while(trav.next!=null)
                trav=trav.next;
            trav.next=node;
        }
    }
    private class TrieNode{
        char x;
        TrieNode next;
        java.util.LinkedList<Character> list;
        public TrieNode(){
        }
        public TrieNode(char y){
            x=y;
            next=null;
            list=new java.util.LinkedList<>();
        }
    }
    public static void main(String[] args) {
        Trie trie=new Trie();
        trie.insert("microsdft");
        trie.insert("minisota");
        trie.insert("minecraft");
        trie.insert("standard");
        trie.insert("standsadkds");       
        trie.insert("stand");
        trie.insert("standary");
        trie.insert("yaaro da yaar");
        trie.display();
    }
}
