//배열 복제

class CloneArray{
  public static void main(String[] args){
    int[] a = {1,2,3,4,5};
    int[] b = a.clone(); //b는 a의 복제를 참조

    b[0] = 6;

    for(int i = 0; i<a.length; i++)
      System.out.printf("%d ", a[i]);

    for(int i = 0; i<b.length; i++)
      System.out.printf("%d ", b[i]);
  }
}