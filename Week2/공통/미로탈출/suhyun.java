package Week2.공통.미로탈출;

import java.util.LinkedList;
import java.util.Queue;

public class suhyun {

    int sx = 0, sy = 0, lx = 0, ly = 0, ex = 0, ey = 0;
    int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    class Node{
        int x, y, cnt;
        public Node(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    public int bfs(int startX, int startY, int endX, int endY, String[] maps){
        boolean[][] visited = new boolean[maps.length][maps[0].length()];

        Queue<Node> q = new LinkedList<Node>();
        q.offer(new Node(startX, startY, 0));
        visited[startX][startY] = true;

        while(!q.isEmpty()){
            Node n = q.poll();
            if(n.x == endX && n.y == endY){
                return n.cnt;
            }
            for(int i=0; i<4; i++){
                int nx = n.x + dir[i][0];
                int ny = n.y + dir[i][1];
                if(nx < 0 || ny < 0 || nx >= maps.length || ny >= maps[0].length()){
                    continue;
                }
                if(maps[nx].charAt(ny) == 'X' || visited[nx][ny]){
                    continue;
                }
                visited[nx][ny] = true;
                q.offer(new Node(nx, ny, n.cnt + 1));
            }
        }
        return -1;
    }
    public int solution(String[] maps) {
        int answer = 0;
        for(int i=0; i<maps.length; i++){
            for(int j=0; j<maps[0].length(); j++){
                if(maps[i].charAt(j) == 'S'){
                    sx = i;
                    sy = j;
                } else if(maps[i].charAt(j) == 'L'){
                    lx = i;
                    ly = j;
                } else if(maps[i].charAt(j) == 'E'){
                    ex = i;
                    ey = j;
                }
            }
        }
        int before = bfs(sx, sy, lx, ly, maps);
        int after = bfs(lx, ly, ex, ey, maps);
        if(before == -1 || after == -1){
            answer = -1;
        } else{
            answer = before + after;
        }
        return answer;
    }
}
