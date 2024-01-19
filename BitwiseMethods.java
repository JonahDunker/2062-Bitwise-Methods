import java.util.Scanner;
import java.util.ArrayList;

public class BitwiseMethods {
  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(System.in);
    int[] arr = rgbaValues(Integer.parseInt(in.nextLine()));
    for(int i = 0; i < 4; i++) {
      System.out.println(arr[i]);
    }
  }

  public static int binaryRepresentations1(int num) {
    int count = 0;
    while(num > 0) {
      count += num & 1;
      num >>= 1;
    }
    return count;
  }

  public static int[] rgbaValues(int num) {
    // Take in int
    // compare num to an int which = num >>= 1
    // if both 0, give num back the starting # of bits and make arr[i] = starting num - new num
    // if not both 0, num >>= 1
    int[] arr = new int[4];
    int original = num;
    for(int i = 0; i < 4; i++) {
      int bitsDeleted  = 0;
      while((num & 1) == 0) {
        num >>= 1;
        bitsDeleted++;
      }
      boolean bool = true;
      while(bool) {
        int temp = num;
        temp >>= 1;
        if((num & 1) == 0 && (temp & 1) == 0) {
          num <<= bitsDeleted;
          arr[i] = original - num;
          bool = false;
          original >>= bitsDeleted+1;
          num >>= bitsDeleted+1;
        } else {
          num >>= 1;
          bitsDeleted++;
        }
      }
    }
    return arr;
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
    return (num & 1) == 1;
  }
}