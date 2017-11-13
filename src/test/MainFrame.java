package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Windows10 on 2017/11/13.
 */
public class MainFrame extends JFrame implements ActionListener {

    JPanel jp1, jp2;

    public MainFrame(){
        //初始化按钮
        JButton btn1 = new JButton("文稿检查");
        btn1.setBounds(140, 0, 130, 30);
        btn1.setActionCommand("btn1");//给按钮取一个动作的命令名称
        btn1.addActionListener(this);
        JButton btn2 = new JButton("词库管理");
        btn2.setBounds(280, 0, 130, 30);
        btn2.setActionCommand("btn2");//给按钮取一个动作的命令名称
        btn2.addActionListener(this);

        //初始化子页面
        jp1 = new JPanel();
        jp1.add(new JLabel("信息录入"));
        jp1.setBackground(Color.YELLOW);

        jp2 = new JPanel();
        jp2.add(new JLabel("信息查询"));
        jp2.setBackground(Color.LIGHT_GRAY);

        JPanel jp3 = new JPanel();
        jp3.add(btn1);
        jp3.add(btn2);

        add(jp1);
        add(jp3, BorderLayout.NORTH);

        //初始化主页面
        this.setSize(600,450);
        this.setTitle("读取word文档");
        this.setLocationRelativeTo(null);//居中
//        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);//关闭窗体后同时结束后台线程
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("btn1")) {

        }else if(e.getActionCommand().equals("btn2")){

        }
    }

    public static void main(String[] args) {
        new MainFrame();
    }

}
