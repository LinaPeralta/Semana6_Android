package model;

public class Dato {

    private String movimiento;
    private int r,g,b;
    private int mov;

    public Dato() {
    }

    public Dato(String movimiento, int r, int g, int b, int mov) {
        this.movimiento = movimiento;
        this.r = r;
        this.g = g;
        this.b = b;
        this.mov = mov;
    }

    public String getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(String movimiento) {
        this.movimiento = movimiento;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getMov() {
        return mov;
    }

    public void setMov(int mov) {
        this.mov = mov;
    }
}
