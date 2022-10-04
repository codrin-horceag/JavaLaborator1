package com.example.javalab1;

import java.io.*;
import java.util.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    public void init() {
        String message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        List<String> words = new ArrayList<>();

        File myObj = new File("C:\\master\\JavaLab1\\src\\test\\fisierJava.txt");
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            words.add(data);
        }

        //print html
        PrintWriter out = response.getWriter();
        out.println("<html><body><ol>");
        String mesaj = request.getParameter("textSpart");
        String sizeForPerm = request.getParameter("sizeul");
        for(int i = 0 ; i <= mesaj.length(); i++ ) {
            out.println("<li>" + mesaj.charAt(i) + "</li>");

        }
        out.println("</ol></br><ol>");
        //permutation
        char[] perm = new char[Integer.parseInt(sizeForPerm)];
        List<String> wordsPermuted = new ArrayList<>();
        permutation(perm,0,mesaj,wordsPermuted);
        List<String> wordsPrint = printValidWords(words,wordsPermuted);

        for(int i =0 ; i <= wordsPrint.size(); i++){
            out.println("<li>" + wordsPrint.get(i) + "</li>");
        }
        out.println("</ol></body></html>");
    }

    public void destroy() {
    }

    private void permutation(char[] perm, int pos, String str, List<String> perms) {
        if (pos == perm.length) {
            perms.add(new String(perm));
        } else {
            for (int i = 0 ; i < str.length() ; i++) {
                perm[pos] = str.charAt(i);
                permutation(perm, pos+1, str,perms);
            }
        }
    }

    private List<String> printValidWords(List<String> dictionaryWords, List<String> wordsPerms){
        List<String> wordsToPrint = new ArrayList<>();

        for(int i = 0 ; i <=wordsPerms.size();i++) {
            for(int j=0; j<= dictionaryWords.size();j++) {
                if(wordsPerms.get(i).equals(dictionaryWords.get(j))){
                    wordsToPrint.add(wordsPerms.get(i));
                }
            }
        }
        return wordsToPrint;
    }
}