import java.util.*;
import java.io.*;

public class Main {

    static int [] dx = {1,-1,0,0};
    static int [] dy = {0,0,-1,1};
    static char [][] arr ;
    static int[][] fire;
    static int[][] jihoon;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        arr = new char[R][C];
        fire = new int[R][C];
        jihoon = new int[R][C];

        Queue<int[]> fireQ = new LinkedList<>();
        Queue<int[]> jihoonQ = new LinkedList<>();

        for(int i=0; i<R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = input.charAt(j);
                fire[i][j] = -1;
                jihoon[i][j] = -1;

                if (arr[i][j] == 'F') {
                    fire[i][j] = 0;
                    fireQ.offer(new int[]{i, j});
                }
                if (arr[i][j] == 'J') {
                    jihoon[i][j] = 0;
                    jihoonQ.offer(new int[]{i, j});
                }
            }
        }

        while (!fireQ.isEmpty()) {
            int[] now = fireQ.poll();
            int x = now[0];
            int y = now[1];

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if (arr[nx][ny] == '#' || fire[nx][ny] != -1) continue;

                fire[nx][ny] = fire[x][y] + 1;
                fireQ.offer(new int[]{nx, ny});
            }
        }

        while (!jihoonQ.isEmpty()) {
            int[] now = jihoonQ.poll();
            int x = now[0];
            int y = now[1];

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                // 밖으로 나가면 탈출 성공
                if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
                    System.out.println(jihoon[x][y] + 1);
                    return;
                }

                if (arr[nx][ny] == '#' || jihoon[nx][ny] != -1) continue;

                // 불보다 늦게 도착하면 안 됨
                if (fire[nx][ny] != -1 && fire[nx][ny] <= jihoon[x][y] + 1) continue;

                jihoon[nx][ny] = jihoon[x][y] + 1;
                jihoonQ.offer(new int[]{nx, ny});
            }
        }



        System.out.println("IMPOSSIBLE");

    }

}




