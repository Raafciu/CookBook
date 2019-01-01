package pl.com.redpike.cookbook.util;

public class RestUtil {

    // Angular Host URL
    public static final String ANGULAR_HOST = "http://localhost:4200";
    public static final String TOMCAT_HOST = "http://localhost:8080";

    // General REST API
    private static final String API = "/api";
    private static final String DEV_API = "/cookbook/api";

    // Books
    public static final String BOOK_API = API + "/books";
    public static final String BOOK_DEV_API = DEV_API + "/books";
}
