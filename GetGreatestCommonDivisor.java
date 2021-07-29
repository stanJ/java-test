public class GetGreatestCommonDivisor {
  // 辗转相除法，也叫欧几里得算法
  public static int getGreatestCommonDivisor(int a, int b) {
    int big = a > b ? a : b;
    int small = a < b ? a : b;
    if (big % small == 0) {
      return small;
    }
    return getGreatestCommonDivisor(big % small, small);
  }
  public static void main (String[] args) {
    System.out.println(getGreatestCommonDivisor(25, 5));
    System.out.println(getGreatestCommonDivisor(100, 80));
    System.out.println(getGreatestCommonDivisor(27, 14));
  }
}
