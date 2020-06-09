package algo;

public class DivideTwoIntegersSolution {

    public int divide(int dividend, int divisor) {
        int quotient = 0;
        boolean negativeFlagDividend = true;
        boolean negativeFlagDivisor = true;
        if (dividend < Integer.MIN_VALUE || dividend > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (divisor < Integer.MIN_VALUE || divisor > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (dividend > 0) {
            dividend = -dividend;
            negativeFlagDividend = false;
        }
        if (divisor > 0) {
            divisor = -divisor;
            negativeFlagDivisor = false;
        }
        while (dividend <= divisor) {
            dividend = dividend - divisor;

            if (quotient == Integer.MAX_VALUE) {
                if (negativeFlagDividend != negativeFlagDivisor) {
                    return Integer.MIN_VALUE;
                } else {
                    return Integer.MAX_VALUE;
                }
            }
            quotient++;
        }
        if (negativeFlagDividend != negativeFlagDivisor) {
            quotient = -quotient;
        }
        return quotient;
    }
}
