package nhom17.iuh.ailatrieuphu;

/**
 * Created by KAI on 13/11/2017.
 */

public class CauHoi {
    private int sott;
    private String noidung;
    private String A,B,C,D;
    private int DapAn;

    public int getSott() {
        return sott;
    }

    public void setSott(int sott) {
        this.sott = sott;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public String getA() {
        return A;
    }

    public void setA(String a) {
        A = a;
    }

    public String getB() {
        return B;
    }

    public void setB(String b) {
        B = b;
    }

    public String getC() {
        return C;
    }

    public void setC(String c) {
        C = c;
    }

    public String getD() {
        return D;
    }

    public void setD(String d) {
        D = d;
    }

    public int getDapAn() {
        return DapAn;
    }

    public void setDapAn(int dapAn) {
        DapAn = dapAn;
    }

    public CauHoi() {
    }
    public CauHoi(int sott, String noidung, String a, String b, String c, String d, int dapAn) {
        this.sott = sott;
        this.noidung = noidung;
        A = a;
        B = b;
        C = c;
        D = d;
        DapAn = dapAn;
    }

    @Override
    public String toString() {
        return sott+"-"+noidung+"-"+A+"-"+B+"-"+C+"-"+D+"-"+DapAn;
    }
}
