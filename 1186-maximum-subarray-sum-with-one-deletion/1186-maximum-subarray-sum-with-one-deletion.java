class Solution {
    public int maximumSum(int[] arr) {

        int nodelete = arr[0];
        int onedelete = arr[0];
        int result = arr[0];

        for (int i = 1; i < arr.length; i++) {

            int previousnodelete = nodelete;

            nodelete = Math.max(arr[i], nodelete + arr[i]);

            onedelete = Math.max(
                previousnodelete,
                arr[i] + onedelete
            );

            result = Math.max(result, Math.max(nodelete, onedelete));
        }

        return result;
    }
}