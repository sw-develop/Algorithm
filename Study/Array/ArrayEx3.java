//알게된 개념)
//1. enum
//2. for-each

public class ArrayEx3{
  enum Week{Mon, Tue, Wed, Thu, Fri, Sat, Sun}

  public static void main(String[] args){
    int[] arr = {1,2,3,4};
    String[] names = {"apple", "orange", "banana", "watermelon"};

    System.out.print("arr : ");
    for(int k : arr){
      System.out.printf("%d ", k);
    }

    System.out.print("\nnames : ");
    for(String s : names){
      System.out.printf("%s ", s);
    }

    System.out.print("\nWeek : ");
    for(Week day : Week.values()){
      System.out.print(day + " ");
    }
  }
}