// class Solution {
//     public boolean canConstruct(String ransomNote, String magazine) {
//         HashMap<Character,Integer> map= new HashMap<>();
//         int n= magazine.length();
//         int m= ransomNote.length();

//         for(int i=0;i<n;i++){
//             char ch= magazine.charAt(i);
//             map.put(ch, map.getOrDefault(ch,0)+1);
//         }

//         for(int i=0;i<m;i++){
//             char ch= ransomNote.charAt(i);

//             if(!map.containsKey(ch) || map.get(ch)==0){
//                 return false;
//             }

//             map.put(ch,map.get(ch)-1);
//         }

//         return true;
//         }
// }

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int n= ransomNote.length();
        int m= magazine.length();

        HashMap<Character,Integer> map= new HashMap<>();

        for(char ch: magazine.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        for(char ch: ransomNote.toCharArray()){
            if(!map.containsKey(ch) || map.get(ch)==0){
                return false;
            }

            map.put(ch, map.get(ch)-1);
        }

        return true;
    }}
