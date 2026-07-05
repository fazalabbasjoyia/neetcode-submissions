class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        // Handle empty input edge case
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        // Map to store: Key = sorted string, Value = list of matching anagrams
        Map<String, List<String>> anagramGroups = new HashMap<>();

        for (String currentStr : strs) {
            // Step 1: Sort the characters of the string to create a unique key
            char[] charArray = currentStr.toCharArray();
            Arrays.sort(charArray);
            String sortedKey = new String(charArray);

            // Step 2: Create a new list for the key if it does not exist yet
            if (!anagramGroups.containsKey(sortedKey)) {
                anagramGroups.put(sortedKey, new ArrayList<>());
            }

            // Step 3: Add the original string to the matching anagram group
            anagramGroups.get(sortedKey).add(currentStr);
        }

        // Return all the grouped lists
        return new ArrayList<>(anagramGroups.values());
    }
}
