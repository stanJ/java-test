public class IsPowerOf2 {
  public static boolean isPowerOf2 (int num) {
    return (num & num - 1) == 0;
  }
  public static void main (String[] args) {
    System.out.println(isPowerOf2(1004));
    System.out.println(isPowerOf2(1000));
    System.out.println(isPowerOf2(1024));
  }
}
