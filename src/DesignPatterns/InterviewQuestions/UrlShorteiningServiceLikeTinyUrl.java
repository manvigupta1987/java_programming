package DesignPatterns.InterviewQuestions;

// Design a service like TinyURL, a URL shortening service, a web service that provides short aliases for redirection of long URLs.

// Solution:
//Basically we need a one to one mapping to get shorten URL which can retrieve original URL later. This will involve saving such data into database.
//We should check the following things:
//1. What's the traffic volume / length of the shortened URL?
//2. What's the mapping function?
//3. Single machine or multiple machines?

// Traffic: Let's assume we want to serve more than 1000 billion URLs. If we can use 62 characters [A-Z, a-z, 0-9] for the short URLs having length n,
// then we can have total 62^n URLs. So, we should keep our URLs as short as possible given that it should fulfill the requirement. For our requirement,
// we should use n=7 i.e the length of short URLs will be 7 and we can serve 62^7 ~= 3500 billion URLs.


// Basic Solution:
// To make things easier, we can assume the alias is something like http://tinyurl.com/<alias_hash> and alias_hash is a fixed length string.
//To begin with, let’s store all the mappings in a single database. A straightforward approach is using alias_hash as the ID of each mapping, which can be
// generated as a random string of length 7.
//Therefore, we can first just store <ID, URL>. When a user inputs a long URL “http://www.google.com”, the system creates a random 7-character string like “abcd123” as ID and inserts entry <“abcd123”, “http://www.google.com”> into the database.
//
//In the run time, when someone visits http://tinyurl.com/abcd123, we look up by ID “abcd123” and redirect to the corresponding URL “http://www.google.com”.

// we can't use unique hash values for the given long urls. In hashing, there may be collisions and two long urls might have the same ID>

// Better Solution:use the integer id stored in the database and convert the integer to a character string that is at most 7 characters long.
//Below is one important observation about possible characters in URL.
//
//A URL character can be one of the following
//1) A lower case alphabet [‘a’ to ‘z’], total 26 characters
//2) An upper case alphabet [‘A’ to ‘Z’], total 26 characters
//3) A digit [‘0’ to ‘9’], total 10 characters
//
//There are total 26 + 26 + 10 = 62 possible characters.
//
//So the task is to convert a decimal number to base 62 number.
//To get the original long URL, we need to get URL id in the database. The id can be obtained using base 62 to decimal conversion.

// https://leetcode.com/discuss/interview-question/124658/Design-a-URL-Shortener-(-TinyURL-)-System/


public class UrlShorteiningServiceLikeTinyUrl {
    static String idToShortUrl(int n) {
        // Map to store 62 possible characters
        char map[] = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        StringBuffer sb = new StringBuffer();

        // Convert given integer id to a base 62 number
        while (n > 0) {
            sb.append(map[n%62]);
            n = n/62;
        }
        // Reverse shortURL to complete base

        // We can avoid this reverse step but to get the same ID from this shortUrl, we would need to process the characters from end in the shorturlToId.
        return sb.reverse().toString();
    }

    static int shorturlToId(String shorturl) {
        int id =0;
        for (int i =0; i< shorturl.length(); i++) {
            if (shorturl.charAt(i) >= 'a' && shorturl.charAt(i) <= 'z') {
                id = id*62 + shorturl.charAt(i) - 'a';
            } else if (shorturl.charAt(i) >= 'A' && shorturl.charAt(i) <= 'Z') {
                id = id * 62 + shorturl.charAt(i) - 'A' + 26;
            } else if (shorturl.charAt(i) >= '0' && shorturl.charAt(i) <= '9'){
                id = id * 62 + shorturl.charAt(i) - '0' + 52;
            }
        }
        return id;
    }


    public static void main(String[] args) {
        int n = 123456;

        String shorturl = idToShortUrl(n);
        System.out.println("Generated short url is " + shorturl);

        int id = shorturlToId(shorturl);
        System.out.println("Id from url is " + id);
    }
}
