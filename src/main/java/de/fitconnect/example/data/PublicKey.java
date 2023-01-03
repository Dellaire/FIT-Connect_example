package de.fitconnect.example.data;

import java.util.List;

public class PublicKey {

    private String kty;
    private List<String> keyops;
    private List<String> x5c;
    private String kid;
    private String alg;
    private String n;
    private String e;

    public String getKty() {
        return kty;
    }

    public void setKty(String kty) {
        this.kty = kty;
    }

    public List<String> getKeyops() {
        return keyops;
    }

    public void setKeyops(List<String> keyops) {
        this.keyops = keyops;
    }

    public List<String> getX5c() {
        return x5c;
    }

    public void setX5c(List<String> x5c) {
        this.x5c = x5c;
    }

    public String getKid() {
        return kid;
    }

    public void setKid(String kid) {
        this.kid = kid;
    }

    public String getAlg() {
        return alg;
    }

    public void setAlg(String alg) {
        this.alg = alg;
    }

    public String getN() {
        return n;
    }

    public void setN(String n) {
        this.n = n;
    }

    public String getE() {
        return e;
    }

    public void setE(String e) {
        this.e = e;
    }
}
