public class Randp {
  
  private int[] nums;
  private int numsLeft;
  
  public Randp(int n) {
    nums = new int[n];
    numsLeft = n;
  }
  
  public int nextInt() {
    if (numsLeft <= 0) return 0;
    
    int index = (int) (Math.random() * numsLeft);
    int num = nums[index];
    numsLeft--;
    if (nums[numsLeft] == 0) nums[index] = numsLeft + 1;
    else nums[index] = nums[numsLeft];
    
    if (num == 0) return index + 1;
    else return num;
  }
}
