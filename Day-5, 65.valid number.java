class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        if (s.isEmpty()) return false;
        
        boolean hasNum = false, hasE = false, hasDot = false, hasSign = false;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c >= '0' && c <= '9') {
                hasNum = true;
            } else if (c == '+' || c == '-') {
                if (hasSign || hasNum || hasDot) return false;
                hasSign = true;
            } else if (c == '.') {
                if (hasDot || hasE) return false;
                hasDot = true;
            } else if (c == 'e' || c == 'E') {
                if (hasE || !hasNum) return false;
                hasE = true;
                hasNum = false;
                hasSign = false;
                hasDot = false;
            } else {
                return false;
            }
        }
        
        return hasNum;
    }
}
