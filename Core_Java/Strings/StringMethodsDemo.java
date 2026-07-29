package Strings;

public class StringMethodsDemo {
    public static void main(String[] args) {

        String str1 = "Hello World";
        String str2 = "hello world";
        String str3 = "  Java Programming  ";

        // 1. length()
        System.out.println("1. length()");
        System.out.println("Length: " + str1.length());

        // 2. charAt()
        System.out.println("\n2. charAt()");
        System.out.println("Character at index 4: " + str1.charAt(4));

        // 3. equals()
        System.out.println("\n3. equals()");
        System.out.println(str1.equals(str2));

        // 4. equalsIgnoreCase()
        System.out.println("\n4. equalsIgnoreCase()");
        System.out.println(str1.equalsIgnoreCase(str2));

        // 5. contains()
        System.out.println("\n5. contains()");
        System.out.println(str1.contains("World"));

        // 6. substring()
        System.out.println("\n6. substring()");
        System.out.println(str1.substring(6));
        System.out.println(str1.substring(0, 5));

        // 7. replace()
        System.out.println("\n7. replace()");
        System.out.println(str1.replace("World", "Java"));

        // 8. trim()
        System.out.println("\n8. trim()");
        System.out.println("Before Trim: '" + str3 + "'");
        System.out.println("After Trim : '" + str3.trim() + "'");

        // 9. split()
        System.out.println("\n9. split()");
        String sentence = "Java,Python,C,C++";
        String[] languages = sentence.split(",");

        for (String lang : languages) {
            System.out.println(lang);
        }

        // 10. toUpperCase()
        System.out.println("\n10. toUpperCase()");
        System.out.println(str1.toUpperCase());

        // 11. toLowerCase()
        System.out.println("\n11. toLowerCase()");
        System.out.println(str1.toLowerCase());

        // 12. startsWith()
        System.out.println("\n12. startsWith()");
        System.out.println(str1.startsWith("Hello"));

        // 13. endsWith()
        System.out.println("\n13. endsWith()");
        System.out.println(str1.endsWith("World"));
    }
}