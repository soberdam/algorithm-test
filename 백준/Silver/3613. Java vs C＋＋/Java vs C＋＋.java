import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

interface Main{
    static void main(String[]a) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        String regex1 = "(?:_([a-z]))", regex2 = "([A-Z])";      
        if(str.matches(".*[A-Z].*") && str.matches(".*_.*")|| str.matches(".*(_){2,}.*|^([A-Z]|_).*|.*(_)$")||str.equals("")) {
          bw.write("Error!");
          bw.flush();
        } else {
          Matcher matcher;
          if(str.contains("_")) {
            matcher = Pattern.compile(regex1).matcher(str);
            while(matcher.find()) {
              str = str.replace(matcher.group(), matcher.group(1).toUpperCase());
            }
          } else if(str.matches(".*([A-Z]).*")) {
            matcher = Pattern.compile(regex2).matcher(str);
            while(matcher.find()) {
              str = str.replace(matcher.group(), "_"+matcher.group().toLowerCase());
            }
          }
          bw.write(str);
          bw.flush(); 
      }
    }
}