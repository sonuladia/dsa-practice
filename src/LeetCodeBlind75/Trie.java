package LeetCodeBlind75;

public class Trie {
    private static class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
    }

    private TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for(char c : word.toCharArray()){
            int idx = c - 'a';
            if(node.children[idx] == null)
                node.children[idx] = new TrieNode();
            node = node.children[idx];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for(char c : word.toCharArray()){
            int idx = c - 'a';
            if(node.children[idx] == null)
                return false;
            node = node.children[idx];
        }
        return node.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(char c: prefix.toCharArray()){
            int idx = c-'a';
            if(node.children[idx] == null)
                return false;
            node = node.children[idx];
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));   // true
        System.out.println(trie.search("app"));     // false
        System.out.println(trie.startsWith("app")); // true

        trie.insert("app");
        System.out.println(trie.search("app"));     // true
    }
}
