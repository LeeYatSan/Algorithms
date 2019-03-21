public class Solution {

    public int searchKthLargest(int[] listA, int[]listB, int K){
        return getTheKthLargestElem(listA, listB, 0, 0, K);
    }

    private int getTheKthLargestElem(int[]listA, int[]listB, int AStart,int BStart, int K){

        //排除非法情况
        if(K <= 0)
            return -1;
        //第一个的情况
        if(K == 1)
            return listA[AStart] <= listB[BStart] ? listA[AStart] : listB[BStart];

        int lenA = listA.length-AStart;
        int lenB = listB.length-BStart;

        //保证lenA < lenB
        if(lenA > lenB)
            return getTheKthLargestElem(listB, listA, BStart, AStart, K);
        if(lenA == 0)
            return listB[K-1];

        //lenA < lenB, 如果lenA > K/2, lenB一定大于K/2；但lenA可能小于lenB
        //确保indexA+indexB==K，即将最终K长的序列分为A、B两部分
        int indexA = lenA >= K/2 ? K/2 : lenA;
        int indexB = K-indexA;

        if(listA[indexA-1] < listB[indexB-1])
            return getTheKthLargestElem(listA, listB, indexA, BStart, K-indexA);
        else if(listA[indexA-1] > listB[indexB-1])
            return getTheKthLargestElem(listA, listB, AStart, indexB, K-indexB);
        else
            return listA[indexA-1];
    }
}
