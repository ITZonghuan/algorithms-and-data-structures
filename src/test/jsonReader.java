package test;


import java.io.*;
import java.util.ArrayList;


public class jsonReader {
    //主方法
    public static void main(String[] args) throws Exception{
        String road = "C:" + File.separator + "Users\\13031\\Desktop\\CDA2.0_V2_开发版本\\数控机床论文数据-20181121.txt";
        //String road = "C:" + File.separator + "Users\\13031\\Desktop\\CDA2.0_V2_开发版本\\520.txt";
        String write = "C:" + File.separator + "Users\\13031\\Desktop\\CDA2.0_V2_开发版本\\paper999.json";
        ArrayList<String> wj = writejson(road);
        System.out.println(wj);
        String str = "{\"texts\":" + wj.toString() + "}";
        //wj.add(0,"\"texts\":[");
        //System.out.println(str);
        //wj.add("]");
        //String strl = wj.toString().replace(":[, ", ":[").replace("}, ]","}]");



        //写入
        FileWriter fwriter = null;
        try {
            // true表示不覆盖原来的内容，而是加到文件的后面。若要覆盖原来的内容，直接省略这个参数就好
            fwriter = new FileWriter(write, true);
            fwriter.write(str);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                fwriter.flush();
                fwriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    //文件处理方法
    public static ArrayList<String> writejson(String road) throws Exception{
        ArrayList<String> ar = new ArrayList<String>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(road), "UTF-8"));
        int index = 0;
        int ABgg = 0;
        int KWgg = 0;
        int AUgg = 0;
        String ti = null;
        String kw = null;
        ArrayList<String> sa = new ArrayList<>();   //标题
        ArrayList<String> TI = new ArrayList<>();   //标题
        ArrayList<Integer> ID = new ArrayList<>();   //id
        ArrayList<Integer> YEAR = new ArrayList<>(); //年份
        ArrayList<String> AU = new ArrayList<>();   //作者
        ArrayList<String> AB = new ArrayList<>();   //摘要
        ArrayList<String> KW = new ArrayList<>();   //关键词
        ArrayList<String> paper = new ArrayList<>();   //关键词
        while(true) {
            String str = reader.readLine();
            if (str == null) {
                break;
            }
            sa.add(str);
        }
        for(int i=0;i<sa.size();i++){
            System.out.println(i);
            String s = sa.get(i);
            String[] s1 = s.split(" ");
            if (s1[0].equals("AF")) {
                ArrayList<String> AFF = new ArrayList<String>();
                AUgg = 1;
                AFF.add("\"" +s.substring(3).replace(",  "," ")+ "\"");
                while(sa.get(++i).charAt(0) == ' '){
                    AFF.add("\"" +sa.get(i).substring(3).replace(",  "," ") + "\"");   //其他作者
                }
                AU.add(AFF.toString());

                i--;
                continue;
            }else if (s1[0].equals("TI")) {
                ArrayList<String> TIF = new ArrayList<String>();
                //int x = i;
                //System.out.println(s.substring(3));
                TIF.add(s.substring(3).replace("\""," "));
                while(sa.get(++i).charAt(0) == ' '){
                    TIF.add(sa.get(i).substring(3).replace("\""," "));   //其他作者
                }
                //TI.add(TIF.toString().replace(", "," "));
                //ti = TIF.toString().replace('[',' ').replace(']',' ').replace('"',' ');
                ti = TIF.toString();
                //String ti = String.valueOf(TI);
                //System.out.println(ti);
                i--;
                continue;
            }else if (s1[0].equals("DE")) {
                ArrayList<String> DEF = new ArrayList<String>();
                //int y = i;
                KWgg = 1;
                DEF.add("\"" +s.substring(3).trim() + "\"");
                // && (!(sa.get(++y).split(" "))[0].equals("ID"))
                while(sa.get(++i).charAt(0) == ' '){
                //while((sa.get(++y).split(" "))[0].indexOf(" ") == 0){
                    DEF.add("\"" +sa.get(i).substring(3).trim()+ "\"");
                }
                KW.add(DEF.toString().trim());
                i--;
                continue;
            }else if (s1[0].equals("ID") && KWgg == 0) {
                ArrayList<String> IDF = new ArrayList<String>();
                //int y = i;
                KWgg = 1;
                IDF.add("\"" +s.substring(3).trim()+ "\"");
                //System.out.println(s.substring(3).trim());
                // && (!(sa.get(++y).split(" "))[0].equals("ID"))
                while(sa.get(++i).charAt(0) == ' '){
                    //while((sa.get(++y).split(" "))[0].indexOf(" ") == 0){
                    IDF.add( "\""+sa.get(i).substring(3).trim()+ "\"");   //其他作者
                }
                KW.add(IDF.toString().trim());
                i--;
                continue;
            }else if (s1[0].equals("AB")) {
                ABgg = 1;
                AB.add(s.substring(3));
            }else if (s1[0].equals("PY")) {
                int n = Integer.parseInt(s.substring(3));
                YEAR.add(n);
            }else if(s1[0].equals("ER")){
                ID.add(index);
                if(ABgg == 0){
                    AB.add("null");
                }
                if(AUgg == 0){
                    AU.add("null");
                }
                if(KWgg == 0){
                    KW.add("null");
                }
                paper.add("\r\n" + "{" + "\"ID\":" +ID.get(index)
                        //+ ",\"TI\":" +"\""+TI.get(index)+"\""
                        + ",\"TI\":" +"\"" + ti +"\""
                        + ",\"YEAR\":" +YEAR.get(index)
                        + ",\"AU\":"+AU.get(index)
                        //+ ",\"AB\":"+"\""+AB.get(index)+"\""
                        //+ ",\"KW\":" +KW.get(index).replace("; ","\",\"").replace(";\"","\"").replace(" ","\",\"") +"}");
                        + ",\"KW\":" +KW.get(index).replace(";\", \"","\",\"").replace("; ","\",\"").replace(", ",",").replace(" ","\",\"") +"}");
                index++;
                ABgg = 0;
                KWgg = 0;
                AUgg = 0;
                ti = null;
            }
        }
        return paper;
    }
}

