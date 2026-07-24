class Solution {
    public boolean detectCapitalUse(String word) {
        if (word.equals(word.toUpperCase())) return true;
        if (word.equals(word.toLowerCase())) return true;
        if (word.charAt(0) == Character.toUpperCase(word.charAt(0)) && 
            word.substring(1).equals(word.substring(1).toLowerCase())) {
            return true;
        }
        return false;
    }
}
