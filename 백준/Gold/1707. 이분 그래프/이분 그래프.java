import java.io.*;
import java.util.*;

public class Main {

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int K = Integer.parseInt(br.readLine());// 테스트 케이스 개수
      for (int T = 0; T < K; T++) {
         StringTokenizer st = new StringTokenizer(br.readLine());
         // 정점 개수, 간선 개수
         int V = Integer.parseInt(st.nextToken());
         int E = Integer.parseInt(st.nextToken());

         // 이분그래프 - 두 정점이 이어진 그래프, 단 1-2-1-2 이렇게 되야하지 1-2-2-1 이렇게 되면 안됨.
         ArrayList[] arr = new ArrayList[V + 1];
         for (int i = 1; i < V + 1; i++)
            arr[i] = new ArrayList<>();

         for (int i = 0; i < E; i++) {// 간선 정보
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x].add(y);
            arr[y].add(x);
         }

         
         // 각 정점에서 모두 본다.
         String result = "YES";
         boolean flag = false;
         int[] v = new int[V + 1];//모든 정점을 한번에 계산해야함. 이어져있지 않은 정점도!!
         for (int i = 1; i < V + 1; i++) {
            Queue<Integer> Q = new LinkedList<>();
            
            if(v[i] == 0) {//시초방지
                Q.add(i);
                v[i] = 1;
            }
            
            while (!Q.isEmpty()) {
               int p = Q.poll();

               for (int j = 0; j < arr[p].size(); j++) {
                  int num = (int) arr[p].get(j);

                     if (v[num] == 0) {
								  
                       if(v[p]==1) v[num] =2;
                        else v[num] = 1;
                        
                        Q.add(num);
                      } else if (v[num] == v[p]  && num!=p) {
                         result = "NO";
                         flag = true;
                         break;
                      }
               }
               if(flag) break;
            }
            if(flag) break;
         }
         System.out.println(result);
      }

   }

}