package net.riking.design.decorator.pattern.morrigan;

import javax.swing.*;
import java.awt.*;

//具体构件角色：原身少女
public class OriginalGirl extends JFrame implements Morrigan
{
    private static final long serialVersionUID = 1L;

    private JLabel jl= new JLabel(new ImageIcon(this.getClass().getClassLoader().getResource("static").getPath()+"/Morrigan0.jpg"));

    public OriginalGirl()
    {
        super("《恶魔战士》中的莫莉卡·安斯兰");
    }


    public String getDescription() {
        return "原身莫莉卡·安斯兰";
    }

    public void display()
    {   
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