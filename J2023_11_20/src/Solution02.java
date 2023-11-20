import java.util.*;
public class Solution02 {
    public void merge(int A[], int m, int B[], int n) {
        int j = 0;
        for (int i = m-1; i < m+n; i++) {
            A[i] = B[j++];
        }
        Arrays.sort(A);
    }
}