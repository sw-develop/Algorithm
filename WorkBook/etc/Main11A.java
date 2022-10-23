public class Main11A {

  public static void main(String[] args) {
    char[] alphabet = { 'a', 'b', 'c' };

    int[] cnt = new int[26];
    for (char c : alphabet) {
      cnt[c - 'a'] += 1;
    }

    for (int i = 0; i < cnt.length; i++) {
      if (cnt[i] != 0) {
        System.out.println((char) (i + 'a') + " : " + cnt[i]);
      }
    }
  }
}