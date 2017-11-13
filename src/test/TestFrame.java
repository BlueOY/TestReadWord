package test;

import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.xmlbeans.XmlException;
import utils.ReadUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * Created by Windows10 on 2017/11/13.
 */
public class TestFrame extends JFrame implements ActionListener {

    JLabel label;

    public TestFrame(){

        JPanel jp=(JPanel)this.getContentPane();
        jp.setOpaque(false);//设置透明
        jp.setLayout(null);

        //初始化按钮
        JButton btn = new JButton("选择");
        btn.setBounds(140, 210, 60, 30);
        btn.setActionCommand("btn");//给按钮取一个动作的命令名称
        btn.addActionListener(this);
        jp.add(btn);

        //初始化文本框
        label = new JLabel();
        label.setText("请选择文件");
        label.setBounds(140, 10, 160, 130);
        label.setBackground(Color.RED);
        jp.add(label);

        //然后设置大小
        this.setSize(600,450);
        this.setTitle("读取word文档");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);//关闭窗体后同时结束后台线程
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("btn")) {
            JFileChooser fd = new JFileChooser();
            //fd.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            fd.showOpenDialog(null);
            File f = fd.getSelectedFile();
            if(f != null){
                String path = f.getAbsolutePath();
                String suffix = path.substring(path.lastIndexOf("."));
                System.out.println("path="+path+" suffix="+suffix);
                try {
                    if(".doc".endsWith(suffix)){
                        String res = ReadUtil.readWord2003(path);
                        label.setText(res);
                    }else if(".docx".endsWith(suffix)){
                        String res = ReadUtil.readWord2007(path);
                        label.setText(res);
                    }else if(".txt".endsWith(suffix)){
                        String res = ReadUtil.readTxt(path);
                        label.setText(res);
                    }else{
                        label.setText("");
                    }
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (XmlException e1) {
                    e1.printStackTrace();
                } catch (OpenXML4JException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        new TestFrame();
    }

}
