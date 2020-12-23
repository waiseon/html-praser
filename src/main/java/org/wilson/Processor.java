package org.wilson;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Processor {
    public static void main(String[] args){

//        try {
//            FileWriter fw = new FileWriter("C:\\Wilson\\html\\file01.txt", true);
//            fw.write("Hello world");
//            fw.close();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        Document doc = Jsoup.parse();
        Document doc = null;
        FileWriter fileWritter = null;
        try {
            File fileIn = new File("C:\\swing\\html\\11_sexTrauma.html");
            doc = Jsoup.parse(fileIn, "UTF-8", "");
            File fileOut =new File("C:\\swing\\html\\output\\" + doc.title().substring(doc.title().indexOf("】")+1) + ".txt");
//            doc = Jsoup.connect("https://www.baidu.com/").get();
            if(fileOut.exists()){
                fileOut.delete();
            }
            fileWritter = new FileWriter("C:\\swing\\html\\output\\" + doc.title().substring(doc.title().indexOf("】")+1) + ".txt",true);

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(doc.title().substring(9));
        Elements newsHeadlines = doc.select("p span");
//        System.out.println(newsHeadlines);
        try{
            for (Element headline : newsHeadlines) {
                if(!headline.text().equals("")){
//                    System.out.print(headline.text());
                    fileWritter.write(headline.text());
                }else {
//                    System.out.println("\n");
                    fileWritter.write("\n\n");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                fileWritter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}