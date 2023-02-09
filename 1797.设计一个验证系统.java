import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1797 lang=java
 *
 * [1797] 设计一个验证系统
 */

// @lc code=start
class AuthenticationManager {

    private int timeToLive;
    private Map<String, Integer> map;

    public AuthenticationManager(int timeToLive) {
        this.map = new HashMap<>();
        this.timeToLive = timeToLive;
    }
    
    public void generate(String tokenId, int currentTime) {
        map.put(tokenId, currentTime + timeToLive);
    }
    
    public void renew(String tokenId, int currentTime) {
        if (!map.containsKey(tokenId)) return;

        if (map.get(tokenId) > currentTime) {
            map.put(tokenId, currentTime + timeToLive);
        }
    }
    
    public int countUnexpiredTokens(int currentTime) {
        int ans = 0;
        for (int time : map.values()) {
            if (time > currentTime) ans++;
        }
        return ans;
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */
// @lc code=end

