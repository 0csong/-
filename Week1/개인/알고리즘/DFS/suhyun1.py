def dfs(x, graph, visited):
    visited[x] = True
    print(x, end=' ')
    for y in graph[x]:
        if not visited[y]:
            dfs(y, graph, visited) 

graph = [
    [],
    [2,3,8],
    [1,7],
    [1,4,5],
    [3,5],
    [3,4],
    [7],
    [2,6,8],
    [1,7]
]

visited = [False] * 9

dfs(1, graph, visited)