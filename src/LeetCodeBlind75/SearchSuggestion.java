package LeetCodeBlind75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchSuggestion {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        List<String> suggestions = new ArrayList<>();
    }
    private TrieNode root = new TrieNode();

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        for(String product : products){
            insert(product);
        }
        List<List<String>> result = new ArrayList<>();
        TrieNode curr = root;
        for(char c : searchWord.toCharArray()){
            if(curr != null)
                curr = curr.children[c-'a'];
            if(curr != null)
                result.add(curr.suggestions);
            else
                result.add(new ArrayList<>());
        }
        return result;
    }

    private void insert(String product) {
        TrieNode curr = root;
        for (char c : product.toCharArray()) {
            int idx = c - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new TrieNode();
            }
            curr = curr.children[idx];

            // Only keep 3 smallest suggestions
            if (curr.suggestions.size() < 3) {
                curr.suggestions.add(product);
            }
        }
    }

    public static void main(String[] args) {
        SearchSuggestion solution = new SearchSuggestion();

        String[] products = {"mobile", "mouse", "moneypot", "monitor", "mousepad"};
        String searchWord = "mouse";

        List<List<String>> results = solution.suggestedProducts(products, searchWord);

        System.out.println("Search word: " + searchWord);
        System.out.println("Products: " + Arrays.toString(products));
        System.out.println("Suggestions after each character:");

        int index = 1;
        for (List<String> suggestions : results) {
            System.out.println(searchWord.substring(0, index) + " → " + suggestions);
            index++;
        }
    }
}
