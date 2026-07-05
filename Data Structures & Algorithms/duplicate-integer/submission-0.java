class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int counter=map.getOrDefault(num,0);
            if (counter>=1){
                return true;
            }
            map.put(num,counter+1);
        }
        return false;
    }
}