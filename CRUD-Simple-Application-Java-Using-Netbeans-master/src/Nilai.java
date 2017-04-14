/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


public class Nilai
{
    private double uts;
    private double uas;
    private double tugas;
    private double ttt;
    private double lainlain;
    private double nilai;

    public Nilai() {
    }
    
    public Nilai(double uts, double uas, double tugas, double lainlain) {
        this.uts = uts;
        this.uas = uas;
        this.tugas = tugas;
        this.lainlain = lainlain;
    }

    public double getLainlain() {
        return lainlain;
    }

    public double getTugas() {
        return tugas;
    }

    public double getUas() {
        return uas;
    }

    public double getUts() {
        return uts;
    }

    public double getNilai() {
        return (uts * 35/100) + (uas * 25/100) + (lainlain * 5/100) + (tugas * 10/100) + (ttt * 25 / 100);
    }

    public double getTtt() {
        return ttt;
    }

    public void setTugas(double tugas) {
        this.tugas = tugas;
    }

    public void setUas(double uas) {
        this.uas = uas;
    }

    public void setUts(double uts) {
        this.uts = uts;
    }

    public void setLainlain(double lainlain) {
        this.lainlain = lainlain;
    }

    public void setTtt(double ttt) {
        this.ttt = ttt;
    }
}
