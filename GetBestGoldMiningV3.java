public class GetBestGoldMiningV3 {
  /**
   * 获得金矿最优收益
   * @param w 工人数量
   * @param p 金矿开采所需的工人数量
   * @param g 金矿储量
   */
  public static int getBestGoldMiningV3(int w, int[] p, int[] g) {
    // 创建当前结果
    int[] results = new int[w + 1];
    // 填充一维数组
    for (int i = 1; i <= g.length; i++) {
      for (int j = w; j >= 1; j--) {
        if (j >= p[i - 1]) {
          results[j] = Math.max(results[j], results[j - p[i - 1]] + g[i - 1]);
        }
      }
    }
    return results[w];
  }

  public static void main(String[] args) {
    int w = 10;
    int[] p = { 5, 5, 3, 4, 3 };
    int[] g = { 400, 500, 200, 300, 350 };
    System.out.println("最优收益：" + getBestGoldMiningV3(w, p, g));
  }
}
