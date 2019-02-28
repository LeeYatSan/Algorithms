//Solution1
class Solution {
    public void reverseString(char[] s) {
        for(int head = 0, tail = s.length-1; head < tail; ++head, --tail)
            swap(s, head, tail);
    }
    private void swap(char[] arr, int A, int B){
        arr[A] = new char[]{arr[B], arr[B] = arr[A]}[0];
    }
}
