class Solution {
    public String[] squareIsWhite(String[] coordinates) {
        String[] result = new String[coordinates.length];
        for (int i = 0; i < coordinates.length; i++) {
            int col = coordinates[i].charAt(0) - 'a';
            int row = coordinates[i].charAt(1) - '0';
            result[i] = ((col + row) % 2 == 1) ? "true" : "false";
        }
        return result;
    }
}
