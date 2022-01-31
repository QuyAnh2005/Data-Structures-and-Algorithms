package StackAndQueue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Maze extends JPanel implements ActionListener {
    
    private int screenWidth, screenHeight;
    private char[][] theMaze;
    private int row, col;
    private Position entry, exit;
    boolean running;
    Timer timer;
    
    static final int[][] DIRECTIONS = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
    
    private ArrayList<Position> visitedPoint = new ArrayList<>();
    private ArrayList<Position> deadPoint = new ArrayList<>();
    private ArrayList<Position> steps = new ArrayList<>();
    private Stack<Position> path;
    Position currentPoint;
    
    // Initialize size matrix cell (point) in maze
    static final int CELL_SIZE = 30;
    // Use to change speed run program 
    static final int DELAY = 75;

    public Maze(String filename){
        try {
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);
            StringBuilder data = new StringBuilder();
            int row = 0;
            while (myReader.hasNextLine()) {
                data.append(myReader.nextLine());
                row ++;
            }
            // Define the number of rows and columns of 2D-array
            this.row = row;
            this.col = data.length() / this.row;
            // Initialize matrix matrix to save maze
            this.theMaze = new char[this.row][this.col];
            int m = 0;
            System.out.println();
            for (int i = 0; i < this.row; i++) {
                for (int j = 0; j < this.col; j++) {
                	// Load data in 2D - array (look like matrix matrix)
                    this.theMaze[i][j] = data.charAt(m++);
                    // Define the starting of point
                    if (this.theMaze[i][j] == 'S') this.entry = new Position(i,j);
                    // Define the ending of point
                    if (this.theMaze[i][j] == 'E')  this.exit = new Position(i,j);
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }
        
        this.path = new Stack<>();
        this.path.push(entry);
        this.setVisited(entry.getX(),entry.getY());
        this.currentPoint = entry;
        this.screenWidth = CELL_SIZE * col + 400;
        this.screenHeight = CELL_SIZE * row + 40;
        running = true;
        timer = new Timer(DELAY,this);
        timer.start();
    }
    
    public Position getEntry(){return this.entry;}
    public Position getExit(){return this.exit;}
    public int getScreenWidth(){return screenWidth;}
    public int getScreenHeight(){return screenHeight;}
    
    // Check position if it is out of maze
    public boolean isValidLocation(int row, int col){
        if (row >= this.row||row < 0|| col >= this.col|| col <0){
            return false;
        }
        else return true;
    }
    
    // Check whether this position is wall or can go 
    public boolean isWall(int row, int col){
        if (theMaze[row][col] == 'X'){
            return true;
        }
        else return false;
    }
    
    // Check that position is end point 
    public boolean isExit(int row, int col){
        if (row == getExit().getX() && col == getExit().getY()){
            return true;
        }
        else return false;
    }
    
    // Check whether the point is matrix part of path 
    public boolean isEntry(int row, int col){
        if (row == getEntry().getX() && col == getEntry().getY()){
            return true;
        }
        else return false;
    }
    
    // Add visited point into array list
    public void setVisited(int row, int col){
        this.visitedPoint.add(new Position(row, col));
    }
    
    // Check whether the point is visited or not
    public boolean isVisited(int row, int col){
        for(Position point : visitedPoint){
            if (point.getX() == row && point.getY() == col) return true;
        }
        return false;
    }
    
    public void setDeadPoint(Position point){
        this.deadPoint.add(point);
    }
    
    public boolean isDeadPoint(int row, int col){
        for(Position point : deadPoint){
            if (point.getX() == row && point.getY() == col) return true;
        }
        return false;
    }
    
    public void draw(Graphics g){
        for (int i = 0; i<this.row; i++){
            for (int j = 0; j<this.col; j++){
                if (isWall(i,j)) {
                    g.setColor(Color.BLACK);
                }else if (isEntry(i,j)){
                    g.setColor(Color.BLUE);
                }else if (isExit(i,j)){
                    if (running){g.setColor(Color.ORANGE);}
                    else g.setColor(Color.GREEN);
                } else if(isVisited(i,j)){
                    if (isDeadPoint(i,j)) {
                        g.setColor(Color.RED);
                    }else {
                        g.setColor(Color.PINK);
                    }
                }else{
                    g.setColor(Color.WHITE);
                }
                g.fillRect(j * CELL_SIZE, i * CELL_SIZE, CELL_SIZE, CELL_SIZE);
            }
        }
    }
    
    // Define next point
    private static Position getNextPoint(int row, int col, int i, int j) {
        return new Position(row + i, col + j);
    }
    
    // Check direction to go through
    private Position checkDir(int row, int col){
        for (int[] direction : DIRECTIONS) {
            Position point = getNextPoint(row, col, direction[0], direction[1]);
            if (isValidLocation(point.getX(), point.getY())
                    && !isWall(point.getX(), point.getY())
                    && !isVisited(point.getX(), point.getY())) {
               return point;
            }
        }
        return null;
    }
    
    private void findPath( int row, int col) {
        Position check = checkDir(row, col);
        if (check != null){
            if (this.exit.equalTo(check)){
                this.running = false;
                return;
            }
            path.push(check);
            setVisited(check.getX(), check.getY());
            this.currentPoint = check;
        }
        else{
            Position dead = path.pop();
            setDeadPoint(dead);
            this.currentPoint = path.peek();
        }
        steps.add(currentPoint);
    }
    
    public Stack<Position> solveMaze(){
        while (running){
            findPath(this.currentPoint.getX(), this.currentPoint.getY());
        }
        return this.path;
    }
    
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
        g.setColor(Color.BLUE);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        for(int i = 0; i < path.size(); i++){
            g.drawString(path.get(i).toString(), CELL_SIZE*(col + i/row) + 40*((int) i/row),25*(i%row + 1));
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if(running){
            findPath(this.currentPoint.getX(), this.currentPoint.getY());
        }
        repaint();
    }

}
