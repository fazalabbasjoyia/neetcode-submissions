class Solution {

    public String encode(List<String> strs) {
        if (strs==null || strs.isEmpty()){
            return "";
        }
       StringBuilder sb= new StringBuilder();
       for (String str:strs){
        sb.append(str.length()).append("#").append(str);
       }
       return sb.toString();
    }

    public List<String> decode(String str) {
     List<String> result = new ArrayList<>();
        if (str == null || str.isEmpty()) {
            return result;
        }
        
        int i = 0;
        while (i < str.length()) {
            // Find the position of the next delimiter '#'
            int delimiterPos = str.indexOf('#', i);
            
            // Read the length of the upcoming string
            int length = Integer.parseInt(str.substring(i, delimiterPos));
            
            // Move our pointer right past the '#'
            i = delimiterPos + 1;
            
            // Extract the string based on the parsed length
            String str1 = str.substring(i, i + length);
            result.add(str1);
            
            // Move pointer to the start of the next encoded segment
            i += length;
        }
        
        return result;


    }
}
