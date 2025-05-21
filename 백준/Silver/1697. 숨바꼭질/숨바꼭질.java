import java.io.*;
import java.util.*;

public class Main {
    static int[] time = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        time[start] = 1; // 방문 여부 체크 + 시간 저장 (시작점은 0초 → 1로 저장)

        while (!q.isEmpty()) {
            int now = q.poll();

            if (now == target) {
                System.out.println(time[now] - 1); // 시작점을 1로 저장했으므로 -1 해서 출력
                return;
            }

            for (int next : new int[]{now - 1, now + 1, now * 2}) {
                if (next < 0 || next > 100000) continue;
                if (time[next] == 0) { // 방문 안 한 경우만
                    time[next] = time[now] + 1;
                    q.offer(next);
                }
            }
        }
    }
}
