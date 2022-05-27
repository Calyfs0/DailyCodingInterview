/*
Given an array of integers, return a new array such that each element at index i of
the new array is the product of all the numbers in the original array except the one
at i.
For example, if our input was [ 1, 2, 3, 4, 5], the expected output would be [ 120,
60, 40, 30, 24]. Ifourinputwas [3, 2, 1],theexpectedoutputwouldbe [2,
3, 6].
Follow-up: What if you can't use division?
*/ 


public class MultiplicationOfAllElementExceptItself{
    
    public static void main(String[] args) {
        int[] A = {1,2,3,4,5};
        MultiplicationOfAllElementExceptItself m = new MultiplicationOfAllElementExceptItself();
        int[] output = m.Solve(A);
        for (int i : output) {
            System.out.println(i);
        }
    }

    public int[] Solve(int[] A){
        int length = A.length;
        int[] LeftMultiplicationArray = new int[length];
        int[] RightMultiplicationArray = new int[length];
        LeftMultiplicationArray[0] = A[0];
        RightMultiplicationArray[length -1] = A[length -1];

        for(int i=1;i<length;i++){
            LeftMultiplicationArray[i] = LeftMultiplicationArray[i-1] * A[i];
            RightMultiplicationArray[length -1 -i] = RightMultiplicationArray[length-i] * A[length -1 -i];
        }
        
        for(int i=0;i<A.length;i++){
            if(i==0){
                A[i] = RightMultiplicationArray[i+1];
            }
            else if(i == length -1){
                A[i] = LeftMultiplicationArray[i-1];
            }
            else{
                A[i] = LeftMultiplicationArray[i-1] * RightMultiplicationArray[i+1];
            }
        }

        return A;
    }
    
}