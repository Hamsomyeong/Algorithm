import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
 
public class Main {
    
    static class info implements Comparable<info>{
        int x, y, index, time;
 
        public info(int x, int y, int index, int time) {
            this.x = x;
            this.y = y;
            this.index = index;
            this.time = time;
        }
 
        @Override
        public int compareTo(info o) {
            return index-o.index;
        }
    }
    
    static int N,K,S,X,Y;
    static int [][] arr;
    static int [] dx = {-1,0,1,0};
    static int [] dy = {0,1,0,-1};
    static ArrayList<info> list = new ArrayList<>();
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine()," ");
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        arr = new int[N][N];
        
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++) {
                arr[i][j]= Integer.parseInt(st.nextToken());
                if(arr[i][j]!=0) {
                    list.add(new info(i,j,arr[i][j],0));
                }
            }
        }
        
        Collections.sort(list);
        
        st = new StringTokenizer(br.readLine()," ");
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        
        bfs();
        
        System.out.println(arr[X-1][Y-1]);
 
    }
    
    public static void bfs() {
        while(!list.isEmpty()) {
            info temp = list.remove(0);
            int x = temp.x;
            int y = temp.y;
            int num = temp.index;
            int time = temp.time;
            if(time==S) break;
            for(int i=0;i<4;i++) {
                int nx = x +dx[i];
                int ny = y +dy[i];
                if(range(nx,ny) && arr[nx][ny]==0) {
                    arr[nx][ny]=num;
                    list.add(new info(nx,ny,num,time+1));
                }
            }
        }
        
    }
    
    public static boolean range(int x, int y) {
        return x>=0 && y>=0 && x<N && y<N;
    }
 
}