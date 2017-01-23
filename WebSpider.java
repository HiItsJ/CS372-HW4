import java.io.*;
import java.net.URL;
import java.util.*;
import java.util.regex.*;

public class WebSpider{

  static HashMap<URL, Boolean> links;

  public static void main(String[] args){
    links = new HashMap<URL, Boolean>();
    try{
      links.put(new URL("http://stackoverflow.com/"), false);
    }
    catch(Exception ex){
      System.out.printf("Oops: %s", ex.getMessage());
    }
    search();
  }
  public static void search(){
    for (URL url: links.keySet()){
      if (!links.get(url)){
        links.put(url, true);
        try{
          BufferedReader rdr = new BufferedReader(new InputStreamReader(url.openStream()));
          String line;
          while ((line = rdr.readLine()) != null){
            Pattern p = Pattern.compile("href=\"(.*?)\"");
            Matcher matcher = p.matcher(line);
            if (matcher.find()){
              String s = matcher.group(1);
              if (s.contains("http") || s.contains("www")){
                if (s.contains(".com") || s.contains(".net") || s.contains(".edu") || s.contains(".org")){
                  URL u = new URL(s);
                  if (links.get(u) == null && links.size()<100){
                    if (links.size()<100){
                      links.put(u, false);
                      System.out.println("added: "+s);
                    }
                    else{
                      System.out.println("break");
                      break;
                    }
                  }
                }
              }
              else{
                System.out.println("found in map");
              }
            }
            else{
              System.out.println("no pattern match");
            }
          }
        }
        catch(Exception ex){
          System.out.printf("Error: %s\n", ex.getMessage());
        }
      }
    }
    if (links.size()<100){
      search();
    }
    else {
      System.out.printf("%d\n", links.size());
    }
  }
}
