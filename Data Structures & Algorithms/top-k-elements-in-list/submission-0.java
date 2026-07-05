class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // Step 1: Count frequency of each number
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : nums) {
            frequencyMap.put(num,
                    frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create a Min Heap
        // Heap stores Map entries (number -> frequency)
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap =
                new PriorityQueue<>(
                        (a, b) -> a.getValue() - b.getValue()
                );

        // Step 3: Process every unique number
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {

            minHeap.offer(entry);

            // Keep only k elements
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // Step 4: Build answer array
        int[] result = new int[k];

        for (int i = k - 1; i >= 0; i--) {
            result[i] = minHeap.poll().getKey();
        }

        return result;


        // solution 2 using buckets with less time complexity as o(n)
        // Step 1: Count frequencies
        // Map<Integer, Integer> frequencyMap = new HashMap<>();

        // for (int num : nums) {
        //     frequencyMap.put(
        //             num,
        //             frequencyMap.getOrDefault(num, 0) + 1
        //     );
        // }

        // // Step 2: Create buckets
        // List<Integer>[] buckets = new ArrayList[nums.length + 1];

        // // Step 3: Place each number into bucket based on frequency
        // for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {

        //     int number = entry.getKey();
        //     int frequency = entry.getValue();

        //     if (buckets[frequency] == null) {
        //         buckets[frequency] = new ArrayList<>();
        //     }

        //     buckets[frequency].add(number);
        // }

        // // Step 4: Collect top k elements
        // int[] result = new int[k];
        // int index = 0;

        // for (int i = buckets.length - 1; i >= 0 && index < k; i--) {

        //     if (buckets[i] != null) {

        //         for (int number : buckets[i]) {

        //             result[index++] = number;

        //             if (index == k) {
        //                 break;
        //             }
        //         }
        //     }
        // }

        // return result;
 
        
    }
}
