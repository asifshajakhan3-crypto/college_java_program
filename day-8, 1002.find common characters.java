class Solution {
    public List<String> commonChars(String[] words) {
        List<String> result = new ArrayList<>();
        int[] freq = new int[26];
        for (int i = 0; i < 26; i++) {
            freq[i] = Integer.MAX_VALUE;
        }
        
        for (String word : words) {
            int[] currFreq = new int[26];
            for (char c : word.toCharArray()) {
                currFreq[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                freq[i] = Math.min(freq[i], currFreq[i]);
            }
        }
        
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < freq[i]; j++) {
                result.add(String.valueOf((char)('a' + i)));
            }
        }
        return result;
    }
}
