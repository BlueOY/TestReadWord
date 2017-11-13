package test;

import utils.ReadUtil;

import java.io.IOException;

/**
 * Created by Windows10 on 2017/11/13.
 */
public class Main {

    public static void main(String[] args) {
        try {
//            String path = "C:\\Users\\Windows10\\Documents\\测试.txt";
//            String res = ReadUtil.readTxt(path);
//            System.out.println("res="+res);

            String path = "C:\\Users\\Windows10\\Documents\\测试.doc";
            String res = ReadUtil.readWord2003(path);
            System.out.println("res="+res);

//            String path = "C:\\Users\\Windows10\\Documents\\测试.docx";
//            String res = ReadUtil.readWord2007(path);
//            System.out.println("res="+res);



//            String path = "C:\\Users\\Windows10\\Documents\\测试.doc";
//            new ReadByDoc().testReadByDoc(path);
//            new ReadByExtractor().testReadByExtractor(path);


        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
