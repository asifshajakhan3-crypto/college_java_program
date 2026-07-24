class Solution {
    public String[] findWords(String[] words) {
        String[] rows = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        List<String> result = new ArrayList<>();
        
        for (String word : words) {
            String lower = word.toLowerCase();
            for (String row : rows) {
                if (row.contains(String.valueOf(lower.charAt(0)))) {
                    boolean found = true;
                    for (char c : lower.toCharArray()) {
                        if (!row.contains(String.valueOf(c))) {
                            found = false;
                            break;
                        }
                    }
                    if (found) {
                        result.add(word);
                    }
                    break;
                }
            }
        }
        return result.toArray(new String[0]);
    }
}
