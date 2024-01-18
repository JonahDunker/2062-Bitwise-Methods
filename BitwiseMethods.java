import java.util.Scanner;
import java.util.ArrayList;

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
    int sum = num1 ^ num2;
    num1 -= sum & num1;
    num2 -= sum & num2;
    int shared = num1 & num2;
    num1 -= shared;
    num2 -= shared;
    shared <<= 1;
    while((sum & shared) != 0) {
      sum = sum ^ shared;
      shared -= sum & shared;
      shared <<= 1;
    }
    sum = sum | shared;

    return sum;
  }

  public static boolean isOddBinary(int num) {
    int odd = num & 1;
    boolean isOdd = odd == 1;
    return isOdd;
  }
}