package org.example.Therians;

public enum TipoSer {
    THERIAN(0.0),
    DOMESTICO(10.0),
    EXOTICO(50.0);

    private double punto;

    TipoSer (double punto){
        this.punto = punto;
    }

    public double getPunto() {
        return punto;
    }
}
