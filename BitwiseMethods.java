import java.util.Scanner;

public class BitwiseMethods {
  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(System.in);
    System.out.println(binarySum(Integer.parseInt(in.nextLine()), Integer.parseInt(in.nextLine())));
  }

  public static int binaryRepresentations1(int num) {
    int count = 0;
    while(num > 0) {
      count += num & 1;
      num >>= 1;
    }
    return count;
  }

  public static int binarySum(int num1, int num2) {
    int sum = 0;
    while(num1 > 0) {
      sum = num1 | num2;
      num1 <<= 1;
      num2 <<= 1;
      //System.out.println(num1);
    }
    return sum;
  }

  public static boolean isOddBinary(int num) {
    int odd = num & 1;
    boolean isOdd = odd == 1;
    return isOdd;
  }
}