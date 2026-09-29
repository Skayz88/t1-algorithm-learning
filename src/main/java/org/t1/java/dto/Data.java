package org.t1.java.dto;

public class Data<T> {
    int x,y;
    String op;
    int res;

    public Data(int x, int y,String op) {
        this.op = op;
        this.x = x;
        this.y = y;
    }

    public Data(Data<T> data) {
        this.op = data.op;
        this.x = data.x;
        this.y = data.y;
    }

    public String operation() {
        return op;
    }

    public int getRes() {
        return res;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public void setRes(int res) {
        this.res = res;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
