/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


public class Mahasiswa 
{
    private String nama;
    private String nrp;
    private Nilai nilai;

    public Mahasiswa(Nilai nilai) {
        this.nilai = nilai;
    }

    public String getNama() {
        return nama;
    }

    public String getNrp() {
        return nrp;
    }

    public Nilai getNilai() {
        return nilai;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setNrp(String nrp) {
        this.nrp = nrp;
    }

    public void setNilai(Nilai nilai) {
        this.nilai = nilai;
    }
}
