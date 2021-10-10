package two_zero_eight;
import java.util.*;
class TrieNode{
    int count;
    int prefix;
    TrieNode[] next;
    TrieNode(){
        count = 0;
        prefix = 0;
        next = new TrieNode[26];
        for (int i = 0; i < 26; ++i){
            next[i] = null;
        }
    }
}
class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
        root.count = -1;
    }
    
    public void insert(String word) {
        int n = word.length();
        char[] str = word.toCharArray();
        TrieNode cur = root;
        for (int i = 0; i < n; ++i){
            if (cur.next[(int)(str[i] - 'a')] == null){
                cur.next[(int)(str[i] - 'a')] = new TrieNode();
            }
            cur = cur.next[(int)(str[i] - 'a')];
            cur.prefix++;
        }
        cur.count++;
    }
    
    public boolean search(String word) {
        if (word == null || root == null){
            return false;
        }
        char[] str = word.toCharArray();
        int n = word.length();
        TrieNode cur = root;
        for (int i = 0; i < n; ++i){
            if (cur.next[(int)(str[i] - 'a')] == null){
                return false;
            }
            cur = cur.next[(int)(str[i] - 'a')];
            cur.prefix++;
        }
        return cur.count != 0;
    }
    
    public boolean startsWith(String prefix){
        if (prefix == null || root == null){
            return false;
        }
        char[] str = prefix.toCharArray();
        int n = prefix.length();
        TrieNode cur = root;
        for (int i = 0; i < n; ++i){
            if (cur.next[(int)(str[i] - 'a')] == null){
                return false;
            }
            cur = cur.next[(int)(str[i] - 'a')];
            cur.prefix++;
        }
        return cur.prefix != 0;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
