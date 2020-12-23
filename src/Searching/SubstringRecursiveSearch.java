package Searching;

public class SubstringRecursiveSearch {
    private static boolean exactMatch(String orgString, String searchPat, int orgIndex, int searchIndx) {
        if(orgIndex == orgString.length() && searchIndx != searchPat.length()) {
            return false;
        }
        if (searchIndx == searchPat.length()) {
            return true;
        }
        if (orgString.charAt(orgIndex) == searchPat.charAt(searchIndx)) {
            return exactMatch(orgString, searchPat, orgIndex+1, searchIndx+1);
        }
        return false;
    }
    private static boolean contains(String orgString, String searchPat, int orgIndex, int searchIndx) {
        if(orgIndex == orgString.length()-1 && searchIndx != searchPat.length()-1) {
            return false;
        }
        if (orgString.charAt(orgIndex) == searchPat.charAt(searchIndx)) {
            if(exactMatch(orgString, searchPat, orgIndex, searchIndx)) {
                return true;
            } else {
                return contains(orgString, searchPat, orgIndex+1, searchIndx);
            }
        }
        return contains(orgString, searchPat, orgIndex + 1, searchIndx);
    }
    public static void main(String[] args) {
        boolean result = contains("geeksforgeeks", "fok", 0, 0);
        if (result) {
            System.out.println("string is found");
        } else {
            System.out.println("string is not found");
        }
    }
}
