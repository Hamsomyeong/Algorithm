class Solution {
    static int[] answer;
    public int[] solution(int[][] arr) {
        //압축하고자 하는 특정 영역 -> S
        //S 내부에 있는 모든 수가 같은 값이라면,  S를 해당 수 하나로 압축
        //그렇지 않다면, S를 4등분 한 뒤 각 영역에 대해 다시 압축 
        //배열에 최종적으로 남는 0의 개수와 1의 개수를 배열에 담아서 return  
        answer = new int[2];
        quad(arr,0,0,arr.length);
        return answer;
    }
    public void quad(int[][] arr, int x, int y, int size){
        if(zip(arr,x,y,size, arr[x][y])){
            if(arr[x][y] ==1)
                answer[1]++;
            else answer[0]++;
            return;
        }
        quad(arr, x, y, size/2);
        quad(arr, x, y+size/2, size/2);
        quad(arr, x+size/2, y, size/2);
        quad(arr, x+size/2, y+size/2, size/2);
    }
    public boolean zip(int[][] arr, int x, int y, int size, int val){
        for(int i=x; i<x+size; i++)
            for(int j=y; j<y+size; j++)
                if(arr[i][j] != val)
                    return false;
        return true;
    }
}