class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> seen=new HashMap<>();

        for(int i=0;i<nums.length;i++){
            Integer complement=target-nums[i];
            if (seen.containsKey(nums[i])){
                System.out.println("fazal");
                return new int[]{seen.get(nums[i]),i};
            }
            else{
                seen.put(complement,i);
            }

        }
        System.out.println(seen);
        return new int[]{-1,-1};
        
    }
}
