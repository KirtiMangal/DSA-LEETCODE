class Solution {
    public int countTrapezoids(int[][] points) {
        long MOD = 1_000_000_007L;

        Map<Integer, Integer> map = new HashMap<>();
        for (int[] p : points) {
            int y = p[1];
            map.put(y, map.getOrDefault(y, 0) + 1);
        }

   
        List<Long> level = new ArrayList<>();
        for (int count : map.values()) {
            if (count >= 2) {
                long seg = (long) count * (count - 1) / 2L;
                level.add(seg % MOD);
            } 
            else {
                level.add(0L);
            }
        }

        long prefix = 0L;
        long answer = 0L;
        for (long seg : level) 
        {
            answer = (answer + prefix * seg) % MOD;
            prefix = (prefix + seg) % MOD;
        }

        return (int) answer;
    }
}
