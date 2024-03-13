#include <iostream>
#include <string.h>
using namespace std;

int arr[51][51];
bool visited[51][51];
int dx[4] = { 0,0,1,-1 };
int dy[4] = { 1,-1,0,0 };
int N, M;
void dfs(int x,int y)
{
	visited[x][y] = 1;
	for (int i = 0; i < 4; i++)
	{
		int nx = x + dx[i];
		int ny = y + dy[i];
		if (nx < 0 || ny < 0 || nx >= M || ny >= N)
		{
			continue;
		}
		if (arr[nx][ny] == 1 && visited[nx][ny] == 0)
		{	
			dfs(nx, ny);
		}
	}
}
int main()
{
	int TC;
	cin >> TC;

	int K;

	for (int i = 0; i < TC; i++)
	{
		int cnt = 0;


		cin >> M >> N >> K;

		memset(arr, 0, sizeof(arr));
		memset(visited, false, sizeof(visited));
		for (int i = 0; i < K; i++)
		{
			int m, n;
			cin >> m >> n;
			arr[m][n] = 1;
		}

		for (int i = 0; i < M; i++)
		{
			for (int j = 0; j < N; j++)
			{
				if (arr[i][j] == 1 && visited[i][j] == 0)
				{
					cnt++;
					dfs(i, j);
				}
			}
		}
		cout << cnt << endl;
	}
}
