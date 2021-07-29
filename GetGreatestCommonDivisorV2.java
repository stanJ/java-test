public class GetGreatestCommonDivisorV2 {
  // 九章算术 更相减损法
  public static int getGreatestCommonDivisorV2(int a, int b) {
    if (a == b) {
      return a;
    }
    int big = a > b ? a : b;
    int small = a < b ? a : b;
    return getGreatestCommonDivisorV2(big - small, small);
  }
  public static void main (String[] args) {
    System.out.println(getGreatestCommonDivisorV2(25, 5));
    System.out.println(getGreatestCommonDivisorV2(100, 80));
    System.out.println(getGreatestCommonDivisorV2(27, 14));
  }
}
