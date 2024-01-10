#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <queue>
using namespace std;
int arr[101][101];
int visited[101][101];
int dx[4] = { 0,0,1,-1 };
int dy[4] = { 1,-1,0,0 };
queue <pair<int,int>> q;


int main()
{	
	int N, M;
	cin >> N >> M;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			scanf("%1d", &arr[i][j]);
		}
	}
	

	q.push({ 0,0 });
	visited[0][0]=1;
	while (!q.empty()) {
		int x = q.front().first;
		int y = q.front().second;
		q.pop();
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || ny < 0 || nx >= N || ny >= M || arr[nx][ny] == 0 || visited[nx][ny] != 0) continue;
			q.push({ nx,ny });
			visited[nx][ny] = visited[x][y] + 1;
		}
	}
	cout << visited[N - 1][M - 1];
}
