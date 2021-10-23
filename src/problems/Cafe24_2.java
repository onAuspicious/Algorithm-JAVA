package problems;

public class Cafe24_2 {
    public int solution(int[] sortedArray, int findValue) {
        int lt = 0;
        int rt = sortedArray.length;
        while(lt <= rt) {
            int mid = (lt + rt) / 2;
            if (sortedArray[mid] < findValue) {
                lt = mid + 1;
            } else if (sortedArray[mid] > findValue) {
                rt = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
