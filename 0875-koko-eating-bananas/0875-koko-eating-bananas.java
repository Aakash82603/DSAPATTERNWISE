class Solution {

    public long totalhour(int[] piles, int speed) {
        long totalH = 0;

        for (int i = 0; i < piles.length; i++) {
            totalH += (int) Math.ceil(piles[i] / (double) speed);
        }

        return totalH;
    }

    public int max(int[] piles, int h) {
        int maxvalue = Integer.MIN_VALUE;

        for (int maxy : piles) {
            maxvalue = Math.max(maxvalue, maxy);
        }

        return maxvalue;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = max(piles, h);

        while (left <= right) {
            int mid = left + (right - left) / 2;

            long totalHour = totalhour(piles, mid);

            if (totalHour <= h) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}