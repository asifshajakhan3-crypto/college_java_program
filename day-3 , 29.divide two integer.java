class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        
        long lpDividend = Math.abs((long)dividend);
        long lpDivisor = Math.abs((long)divisor);
        
        int result = 0;
        while (lpDividend >= lpDivisor) {
            long temp = lpDivisor, multiple = 1;
            while (lpDividend >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }
            lpDividend -= temp;
            result += multiple;
        }
        
        return ((dividend ^ divisor) >> 31) == 0 ? result : -result;
    }
}
