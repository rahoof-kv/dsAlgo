package study.algo.medium;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class URLShortener {

    private Map<String, Long> urlToIndexMap = new HashMap<>();
    private Map<Long, String> indexToUrlMap = new HashMap<>();

    private AtomicLong id = new AtomicLong(1000000000L);
    private String base62 = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static void main(String[] args) {
        URLShortener urlShortener = new URLShortener();
        String url = urlShortener.shortenUrl("www.google.com");
        System.out.println(url);
        System.out.println(urlShortener.getOriginalUrl(url));

        String url2 = urlShortener.shortenUrl("www.google.com");
        System.out.println(url2);
         System.out.println(urlShortener.getOriginalUrl(url2));

        String url3 = urlShortener.shortenUrl("www.facebook.com");
        System.out.println(url3);
         System.out.println(urlShortener.getOriginalUrl(url3));

        String url4 = urlShortener.shortenUrl("www.amazon.com");
        System.out.println(url4);
         System.out.println(urlShortener.getOriginalUrl(url4));

    }

    public String shortenUrl(String originalUrl) {
        String shortenUrl = null;
        if (urlToIndexMap.containsKey(originalUrl)) {
            shortenUrl = encode(urlToIndexMap.get(originalUrl));
        } else {
            Long urlId = id.getAndAdd(1);
            urlToIndexMap.put(originalUrl, urlId);
            indexToUrlMap.put(urlId,originalUrl);
            shortenUrl = encode(urlId);
        }

        return "shortenUrl.com/" + shortenUrl;
    }

    public String getOriginalUrl(String shortUrl) {

        String base62Encoded = shortUrl.substring(shortUrl.lastIndexOf("/") + 1);
        long decode = 0;
        for(int i = 0; i < base62Encoded.length(); i++) {
            decode = decode * 62 + base62.indexOf(base62Encoded.charAt(i));
        }
        return indexToUrlMap.get(decode);
    }

    private String encode(Long id) {
        StringBuilder stringBuilder = new StringBuilder();
        while (id > 0) {
            int val = (int) id.longValue() % 62;
            stringBuilder.append(base62.charAt(val));
            id = id / 62;
        }
        return stringBuilder.reverse().toString();
    }
}
