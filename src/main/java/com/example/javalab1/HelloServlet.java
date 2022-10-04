package com.example.javalab1;

import java.io.*;
import java.util.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "message";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        String letters = request.getParameter("splitText");
        String size = request.getParameter("size");
        PrintWriter out = response.getWriter();

        List<String> words = new ArrayList<>();
        File file = new File("C:\\master\\JavaLaborator1\\src\\test\\fisierJava.txt");

        Scanner myReader = new Scanner(file);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            words.add(data);
        }
        List<String> permutedWords = new ArrayList<>();

        if (Integer.parseInt(size) == 0) {
            printPermutn(letters, "", permutedWords);
        } else {
            permutation(letters,"", Integer.parseInt(size), permutedWords);
        }

        Set<String> printedWords = printValidWords(words, permutedWords);
        System.out.println(printedWords.size());
        out.println("<html><body><ol>");
        for (int i = 0; i < letters.length(); i++){
            out.println("<li>" + letters.charAt(i) + "</li>");
        }
        out.println("</ol><h1>" + message + "</h1><ol>");

        for (String wordToPrint : printedWords) {
            out.println("<li>" + wordToPrint + "</li>");
        }
        out.println("</ol></body></html>");
    }

    public void destroy() {}

    static void permutation(String str, String ans, int size, List<String> perms)
    {
        if(ans.length() == size){
            perms.add(ans);
        }

        if (str.length() == 0) {
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String ros = str.substring(0, i) +
                    str.substring(i + 1);
            permutation(ros, ans + ch,size,perms);
        }
    }

    static void printPermutn(String str, String ans, List<String> perms)
    {
        perms.add(ans);

        if (str.length() == 0) {
            System.out.print(ans + " ");
            return;
        }

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            String ros = str.substring(0, i) +
                    str.substring(i + 1);

            printPermutn(ros, ans + ch, perms);
        }
    }

    private Set<String> printValidWords(List<String> dictionaryWords, List<String> wordsPerms) {
        Set<String> wordsToPrint = new HashSet<>();

        for(String word: wordsPerms){
            if(dictionaryWords.contains(word)){
                wordsToPrint.add(word);
            }
        }
        return wordsToPrint;
    }
}