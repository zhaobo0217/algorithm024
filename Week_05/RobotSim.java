public class RobotSim{

    public int robotSim(int[] commands, int[][] obstacles) {
        //这道题的难点是如何快速查找障碍物的位置，可以将障碍物坐标拼接起来放入hash表
        //时间复杂度遍历一个障碍物，为障碍物数组长度+ O(k * n) k为平均移动步数，空间复杂度多了一个HashSet，为O(1)
        int res = 0;
        Set<String> obstacleSet = new HashSet<>();
        for(int i = 0; i < obstacles.length; i++){
            if(obstacles[i] == null || obstacles[i].length != 2) continue;
            obstacleSet.add(obstacles[i][0] + "," + obstacles[i][1]);
        }
        //最终机器人可以向四个方向移动，为了之后计算方便，我们拆分成四个方向对应的移动距离
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        //方向索引
        int d = 0;
        int x = 0, y = 0;
        for(int command : commands){
            if(command == -1){
                //最终为4个方向可以想象成坐标系，奇数可以切换90度，配合d我们向右的时候加1
                d = (d + 1) % 4;
            }else if(command == -2){
                d = (d + 3) % 4;
            }else{
                //逐步移动知道结束或者碰到障碍停下
                while(command-- > 0 && !obstacleSet.contains((x + dx[d]) + "," +(y + dy[d]))){      
                    x += dx[d];
                    y += dy[d];
                }
                res = Math.max(res, x * x + y * y);
            }
        }
        return res;
    }
}
