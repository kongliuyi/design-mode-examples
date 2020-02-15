package net.riking.design.decorator.pattern.morrigan;

import javax.swing.*;
import java.awt.*;
/**
 * @Description 具体构件角色：原身少女
 * @Author: kongLiuYi
 * @Date: 2020/2/15 23:31
 */
public class OriginalGirl extends JFrame implements Morrigan {

    private JLabel jl= new JLabel(new ImageIcon(this.getClass().getClassLoader().getResource("static").getPath()+"/Morrigan0.jpg"));

    public OriginalGirl() {
        super("《恶魔战士》中的莫莉卡·安斯兰");
    }

    @Override
    public String getDescription() {
        return "原身莫莉卡·安斯兰";
    }

    @Override
    public void display() {
        this.setLayout(new FlowLayout());
        this.add(jl);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        this.setVisible(true);
    }

    public void setJl(JLabel jl) {
        this.jl = jl;
    }
}