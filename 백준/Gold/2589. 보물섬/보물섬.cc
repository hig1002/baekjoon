#include <iostream>
#include <queue>
#include <algorithm>
#include <string.h>
using namespace std;

int N, M;
char arr[51][51];
int dx[4] = { 0,0,1,-1 };
int dy[4] = { 1,-1,0,0 };
int x, y;
vector<int> max_value;

void bfs(int X, int Y)
{
	queue<pair<int, int>> q;
	int visited[51][51] = {0};
	q.push(make_pair(X, Y));
	visited[X][Y] = 1;
	
	while (!q.empty())
	{
		x = q.front().first;
		y = q.front().second;
		q.pop();
		
		for (int i = 0; i < 4; i++)
		{
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && ny >= 0 && nx < N && ny < M && arr[nx][ny] == 'L' && visited[nx][ny] == 0) 
			{
				visited[nx][ny] = visited[x][y] + 1;
				q.push(make_pair(nx, ny));
				max_value.push_back(visited[nx][ny] - 1); 
			}
		}
	}
}

int main()
{
	cin >> N >> M;

	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < M; j++)
		{
			cin >> arr[i][j];
		}
	}
	

	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < M; j++)
		{
			int cnt = 0;
			if (arr[i][j] == 'L') 
			{
				bfs(i, j);
			}
			
			
		}
	}
	int a = 0;
	for (auto it : max_value)
	{
		a = max(a, it);
	}
	cout << a;
}
