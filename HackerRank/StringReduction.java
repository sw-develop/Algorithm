class Result {
    /*
     * Complete the 'getMinDeletions' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */
    public static int getMinDeletions(String s) {
    // Write your code here
        int alphabet[] = new int[26];
        int countDelete = 0;
        for(int i = 0; i < s.length(); i++){
            char val = s.charAt(i);
            int index = val - 'a';
            if(alphabet[index] == 0)
                alphabet[index]++;
            else
                countDelete++;
        }
        return countDelete;
  } 
}