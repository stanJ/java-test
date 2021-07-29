import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class DivideRedPackageV2 {
  /**
   * 拆分红包
   * @param totalAmount 总金额（以分为单位）
   * @param totalPeopleNum 总人数
   */
  public static List<Integer> divideRedPackageV2(Integer totalAmount, Integer totalPeopleNum) {
    List<Integer> amountList = new ArrayList<Integer>();
    List<Integer> dividePointsList = new ArrayList<Integer>();
    int dividePointsNum = totalPeopleNum - 1;
    Random random = new Random();
    for (int i = 0; i < dividePointsNum; i++) {
      // 切割点的数值范围 [1, 总金额 - 1]分
      int dividePoint = random.nextInt(totalAmount - 1) + 1;
      if (dividePointsList.contains(dividePoint)) {
        // 如果切割点重复
        i--;
      } else {
        dividePointsList.add(dividePoint);
      }
    }
    // 对切割点列表进行排序
    dividePointsList = bucketSort(dividePointsList);
    int prev = 0;
    for (int point : dividePointsList) {
      int amount = point - prev;
      amountList.add(amount);
      prev = point;
    }
    amountList.add(totalAmount - dividePointsList.get(dividePointsList.size() - 1));
    return amountList;
  }

  private static List<Integer> bucketSort(List<Integer> array) {
    // 得到数组的最大值和最小值，并算出差值d
    int max = array.get(0);
    int min = array.get(0);
    for (int i = 1; i < array.size(); i++) {
      if (array.get(i) > max) {
        max = array.get(i);
      }
      if (array.get(i) < min) {
        min = array.get(i);
      }
    }
    int d = max - min;
    // 初始化桶
    int bucketNum = array.size();
    ArrayList<LinkedList<Integer>> bucketList = new ArrayList<LinkedList<Integer>>(bucketNum);
    for (int i = 0; i < bucketNum; i++) {
      bucketList.add(new LinkedList<Integer>());
    }
    // 遍历原始数组，将每个元素放入桶中
    for (int i = 0; i < array.size(); i++) {
      int num = (int)((array.get(i) - min) * (bucketNum - 1) / d);
      bucketList.get(num).add(array.get(i));
    }
    // 对每个桶内部进行排序
    for (int i = 0; i < bucketList.size(); i++) {
      // 采用自带的归并排序
      Collections.sort(bucketList.get(i));
    }

    // 输出全部元素
    ArrayList<Integer> sortedArray = new ArrayList<Integer>();
    for (LinkedList<Integer> list : bucketList) {
      for (int element : list) {
        sortedArray.add(element);
      }
    }
    return sortedArray;
  }

  public static void main(String[] args) {
    List<Integer> amountList = divideRedPackageV2(1000, 5);
    for (int amount : amountList) {
      System.out.println("抢到金额：" + new BigDecimal(amount).divide(new BigDecimal(100)));
    }
  }
}
