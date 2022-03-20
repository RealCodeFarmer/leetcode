package cn.meow.array.maxchunksmakesorted;

public class MaxChunksMakeSorted2 {

    /**
     * 在k的位置新加一个元素进来后，看能不能组成arr[:k-1]的升序
     * 如果能，result+1
     * right == i，数据在它应在的位置（index）即可以达成升序的条件，所以result+1
     */
    public int maxChunksToSorted(int[] arr) {
        if (arr == null) {
            return 0;
        }
        int result = 0;
        int right = arr[0];
        for (int i = 0; i < arr.length; i++) {
            right = Math.max(right, arr[i]);
            if (right == i) {
                result++;
            }
        }
        return result;
    }
}