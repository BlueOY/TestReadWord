package utils;

import org.apache.poi.POIXMLDocument;
import org.apache.poi.POIXMLTextExtractor;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.xmlbeans.XmlException;

import java.io.*;

/**
 * Created by Windows10 on 2017/11/13.
 */
public class ReadUtil {

    public static String readTxt(String path) throws IOException {
        String s="";
        File file = new File(path);
        InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "GBK"); //或GB2312,GB18030
        BufferedReader br = new BufferedReader(isr);
        //以下方法会有乱码
//        FileReader fr=new FileReader(path);
//        BufferedReader br=new BufferedReader(fr);
        String str="";
        while((str=br.readLine())!=null){
            s+=str;            }
        br.close();
        return s;
    }

    public static String readWord2003(String path) throws IOException {
        InputStream is = new FileInputStream(new File(path));
        WordExtractor ex = new WordExtractor(is);
        String text2003 = ex.getText();
        return text2003;
    }

    public static String readWord2007(String path) throws IOException, OpenXML4JException, XmlException {
        OPCPackage opcPackage = POIXMLDocument.openPackage(path);
        POIXMLTextExtractor extractor = new XWPFWordExtractor(opcPackage);
        String text2007 = extractor.getText();
        return text2007;
    }

    //参考资料：https://www.cnblogs.com/xudong-bupt/p/3746796.html

}
