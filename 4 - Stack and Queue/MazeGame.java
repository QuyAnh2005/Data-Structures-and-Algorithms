package StackAndQueue;

import javax.swing.JFrame;

public class MazeGame extends JFrame {
    public static void draw(Maze maze){
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setTitle("Find Path in Maze");
        f.add(maze);
        f.setSize(maze.getScreenWidth(), maze.getScreenHeight());
        f.setVisible(true);
    }
    public static void main(String[] args) {
        Maze maze = new Maze("src/StackAndQueue/data.txt");
        draw(maze);
    }

}
