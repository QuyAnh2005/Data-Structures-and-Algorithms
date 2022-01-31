package StackAndQueue;

public class Position {
	int x;
    int y;
    public Position (int x, int y){
        this.x = x;
        this.y = y;
    }
    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }
    public String toString(){
        return String.format("(%d,%d)", this.x, this.y);
    }
    public boolean equalTo(Position other){
        if (this.getX() == other.getX() && this.getY() == other.getY()){
            return true;
        }
        return false;
    }
}
