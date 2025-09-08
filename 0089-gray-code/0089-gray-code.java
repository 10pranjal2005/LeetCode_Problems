import java.util.ArrayList;
import java.util.List;
class Solution {
    public List<Integer> grayCode(int n) {
        int sequenceLength = 1 << n;
        List<Integer> result = new ArrayList<>(sequenceLength);
        for (int i = 0; i < sequenceLength; i++) {
            result.add(i ^ (i >> 1));
        }
        return result;
    }
}