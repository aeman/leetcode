/*
 * @lc app=leetcode.cn id=468 lang=java
 *
 * [468] 验证IP地址
 */

// @lc code=start
class Solution {
    public String validIPAddress(String queryIP) {
        if (queryIP.isEmpty()) return "Neither";
        if (queryIP.charAt(queryIP.length() -1) == ':' || queryIP.charAt(queryIP.length() -1) == '.') return "Neither";

        if (queryIP.contains(".")) {
            return validIPv4(queryIP.split("\\."));
        } else if (queryIP.contains(":")) {
            return validIPv6(queryIP.split(":"));
        }

        return "Neither";
    }

    private String validIPv4(String[] segments) {
        if (segments.length != 4) return "Neither";
        boolean flag = true;
        for (String seg : segments) {
            if (seg.length() < 1 || seg.length() > 3) {
                flag = false;
                break;
            }
            for (char c : seg.toCharArray()) {
                if (!Character.isDigit(c)) {
                    flag = false;
                    break;
                }         
            }
            if (flag) {
                if (seg.charAt(0) == '0' && seg.length() > 1) {
                    flag = false;
                    break;
                }
                int val = Integer.parseInt(seg);
                if (val < 0 || val > 255) {
                    flag = false;
                    break;
                }
            }
        }
        return flag ? "IPv4" : "Neither";
    }

    private String validIPv6(String[] segments) {
        if (segments.length != 8) return "Neither";
        boolean flag = true;
        for (String seg : segments) {
            if (seg.length() < 1 || seg.length() > 4) {
                flag = false;
                break;
            }
            for (char c : seg.toCharArray()) {
                if (!Character.isLetterOrDigit(c)) {
                    flag = false;
                    break;
                }
                if (Character.isLetter(c)) {
                    char c1 = Character.toLowerCase(c);
                    if (c1 < 'a' || c1 > 'f') {
                        flag = false;
                        break;
                    }
                }
            }
        }
        return flag ? "IPv6" : "Neither";
    }
}
// @lc code=end
