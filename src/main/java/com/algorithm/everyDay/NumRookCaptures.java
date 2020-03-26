package com.algorithm.everyDay;

/**
 * 在一个 8 x 8 的棋盘上，有一个白色车（rook）。也可能有空方块，白色的象（bishop）和黑色的卒（pawn）。它们分别以字符 “R”，“.”，“B” 和 “p” 给出。大写字符表示白棋，小写字符表示黑棋。
 *
 * 车按国际象棋中的规则移动：它选择四个基本方向中的一个（北，东，西和南），然后朝那个方向移动，直到它选择停止、到达棋盘的边缘或移动到同一方格来捕获该方格上颜色相反的卒。另外，车不能与其他友方（白色）象进入同一个方格。
 *
 * 返回车能够在一次移动中捕获到的卒的数量。
 */
public class NumRookCaptures {

    public static void main(String[] args) {
        char[][] board = {{'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'P', '.', '.', '.', '.'},
                {'.', '.', '.', 'R', '.', '.', '.', 'P'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'P', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'}};
        System.out.println(numRookCaptures(board));
    }

    public static int numRookCaptures(char[][] board) {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int cnt = 0;
        int st = 0, ed = 0;
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                if(board[i][j] == 'R') {
                    st = i;
                    ed = j;
                }
            }
        }

        for(int i = 0; i < 4; i++) {
            for(int step = 0;;step++) {
                int tx = st + step * dx[i];
                int ty = ed + step * dy[i];
                if(tx >= 8 || ty >= 8 || tx < 0 || ty < 0 || board[tx][ty] == 'B') break;
                if(board[tx][ty] == 'P') {
                    cnt++;
                    break;
                }
            }
        }

        return cnt;
    }
}
