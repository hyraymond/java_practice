package two_one_two;
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
class Solution {
    private void dfs(char[][] board, int[][] visited, TrieNode root, int x, int y, StringBuilder temp, Set<String> result){
        if (root == null || x < 0 || x >= board.length || y < 0 || y >= board[0].length){
            return;
        }
        if (root.prefix == 0 && root.count != -1){
            return;
        }
        if (root.count > 0){
            result.add(temp.toString());
        }
        if (x > 0 && visited[x-1][y] == 0 && root.next[(int)(board[x-1][y]-'a')] != null &&
        root.next[(int)(board[x-1][y]-'a')].prefix > 0){
            temp.append(board[x-1][y]);
            visited[x-1][y] = 1;
            dfs(board, visited, root.next[(int)(board[x-1][y]-'a')], x-1, y, temp, result);
            temp.deleteCharAt(temp.length() - 1);
            visited[x-1][y] = 0;
        }
        if (x < board.length-1 && visited[x+1][y] == 0 && root.next[(int)(board[x+1][y]-'a')] != null &&
        root.next[(int)(board[x+1][y]-'a')].prefix > 0){
            temp.append(board[x+1][y]);
            visited[x+1][y] = 1;
            dfs(board, visited, root.next[(int)(board[x+1][y]-'a')], x+1, y, temp, result);
            temp.deleteCharAt(temp.length() - 1);
            visited[x+1][y] = 0;
        }
        if (y > 0 && visited[x][y-1] == 0 && root.next[(int)(board[x][y-1]-'a')] != null &&
        root.next[(int)(board[x][y-1]-'a')].prefix > 0){
            temp.append(board[x][y-1]);
            visited[x][y-1] = 1;
            dfs(board, visited, root.next[(int)(board[x][y-1]-'a')], x, y-1, temp, result);
            temp.deleteCharAt(temp.length() - 1);
            visited[x][y-1] = 0;
        }
        if (y < board[0].length-1 && visited[x][y+1] == 0 && root.next[(int)(board[x][y+1]-'a')] != null &&
        root.next[(int)(board[x][y+1]-'a')].prefix > 0){
            temp.append(board[x][y+1]);
            visited[x][y+1] = 1;
            dfs(board, visited, root.next[(int)(board[x][y+1]-'a')], x, y+1, temp, result);
            temp.deleteCharAt(temp.length() - 1);
            visited[x][y+1] = 0;
        }
    }
    public List<String> findWords(char[][] board, String[] words) {
        Trie root = new Trie();
        Set<String> result = new HashSet<String>();
        List<String> list = new ArrayList<String>();
        if (board == null || words == null){
            return list;
        }
        for (int i = 0; i < words.length; ++i){
            root.insert(words[i]);
        }
        int m = board.length;
        int n = board[0].length;
        int[][] visited = new int[m][n];
        for (int i = 0; i < m; ++i){
            for (int j = 0; j < n; ++j){
                StringBuilder temp = new StringBuilder();
                char key = board[i][j];
                if (root.root.next[(int)(key - 'a')] != null && root.root.next[(int)(key - 'a')].prefix > 0)
                {
                    temp.append(key);
                    visited[i][j] = 1;
                    dfs(board, visited, root.root.next[(int)(key - 'a')], i, j, temp, result);
                    temp.deleteCharAt(temp.length()-1);
                    visited[i][j] = 0;
                }
            }
        }
        for (String temp: result){
            list.add(temp);
        }
        return list;
    }
    public static void main(String[] args){
        char[][] board = {{'a'}};
        String[] words = {"a"};
        List<String> result = new Solution().findWords(board, words);
        System.out.println("hello world");
    }
}