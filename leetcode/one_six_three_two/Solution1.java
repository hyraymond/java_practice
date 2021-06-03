package one_six_three_two;
// Rank Transform of a Matrix, reference: https://leetcode-cn.com/problems/rank-transform-of-a-matrix/
import java.util.*;
class Solution1 {
    public int[][] matrixRankTransform(int[][] matrix) {
        final int row = matrix.length;
        final int col = matrix[0].length;

        //对每个坐标状态压缩(state = i * col + j)
        Integer[] indexs = new Integer[row * col];
        for (int i = 0; i < indexs.length; i++) {
            indexs[i] = i;
        }

        //对坐标点根据matrix的值进行排序。
        Arrays.sort(indexs, new Comparator<Integer>() {
            @Override
            public int compare(Integer t1, Integer t2) {
                return matrix[t1 / col][t1 % col] - matrix[t2 / col][t2 % col];
            }
        });

        int[] minRows = new int[row]; //第i行的秩号序列，第i行下一个秩号需要大于等于此cell([i, minRows[i]])的值
        int[] minCols = new int[col]; //第j列的秩号序列，第j列下一个秩号需要大于等于此cell([minCols[j], j])的值
        Arrays.fill(minRows, -1);
        Arrays.fill(minCols, -1);
        int[] leaders = new int[row * col]; //并查集，表示同行或同列的同样值串起来的一个集合。
        int[] leaderVals = new int[row * col]; //并查集leader的对应的秩号值。
        for (int i = 0; i < leaders.length; i++) {
            leaders[i] = i;
        }

        int pos = 0;
        while (pos < indexs.length) {

            int val = 1;
            int index = indexs[pos];

            //排序后的第pos个单元格
            int i = index / col;
            int j = index % col;
            int tmpIndex;
            int tmpVal;

            //第i行应该分配的下一个秩号
            if (minRows[i] != -1) {
                tmpIndex = i * col + minRows[i];
                int leaderIndex = getLeader(leaders, tmpIndex);
                tmpVal = leaderVals[leaderIndex];
                if (matrix[i][j] == matrix[i][minRows[i]]) {
                    //如果i行有相同的值，合并并查集
                    mergeLeader(leaders, index, tmpIndex);
                    val = Math.max(val, tmpVal);
                } else {
                    val = Math.max(val, tmpVal + 1);
                }
            }

            //第j列应该分配的下一个秩号
            if (minCols[j] != -1) {
                tmpIndex = minCols[j] * col + j;
                int leaderIndex = getLeader(leaders, tmpIndex);
                tmpVal = leaderVals[leaderIndex];
                if (matrix[i][j] == matrix[minCols[j]][j]) {
                    //如果j列有相同的值，合并并查集
                    mergeLeader(leaders, index, tmpIndex);
                    val = Math.max(val, tmpVal);
                } else {
                    val = Math.max(val, tmpVal + 1);
                }
            }
            //val = Math.max(val, ...)是取i行下一个秩号 和 j列下一个秩号 的较大值

            //更新i行和j列秩号序列。此时[i, j]为i行和j列的最大秩号
            minRows[i] = j;
            minCols[j] = i;

            //更新并查集的秩号
            int leader = getLeader(leaders, index);
            leaderVals[leader] = val;
            pos++;

        }

        //将秩号结果由并查集导出到数组ans
        int[][] ans = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int index = i * col + j;
                ans[i][j] = leaderVals[getLeader(leaders, index)];
            }
        }
        return ans;
    }

    private void mergeLeader(int[] leaders, int index, int tmpIndex) {
        int leader1 = getLeader(leaders, index);
        int leader2 = getLeader(leaders, tmpIndex);
        if (leader1 != leader2) {
            leaders[leader1] = leader2;
        }
    }

    private int getLeader(int[] leaders, int tmpIndex) {
        int leader = leaders[tmpIndex];
        if (leader == leaders[leader]) {
            return leader;
        } else {
            return leaders[tmpIndex] = getLeader(leaders, leader);
        }
    }
}
