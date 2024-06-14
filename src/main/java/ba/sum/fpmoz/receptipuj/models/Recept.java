package ba.sum.fpmoz.receptipuj.models;

import jakarta.persistence.*;

@Entity
@Table(name = "recept")
public class Recept {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int receptId;

    @Column(nullable = false)
    private String naslov;

    @Column(nullable = false)
    private String opis;

    @Column(nullable = false)
    private String sastojci;

    @Column(nullable = false)
    private String postupak;

    @Column(nullable = false)
    private int vrijeme_pripreme;

    @ManyToOne
    @JoinColumn(name = "korisnik_id", nullable = false)
    private Korisnik korisnik;

    // Getters and setters
    public int getReceptId() {
        return receptId;
    }

    public void setReceptId(int receptId) {
        this.receptId = receptId;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getSastojci() {
        return sastojci;
    }

    public void setSastojci(String sastojci) {
        this.sastojci = sastojci;
    }

    public String getPostupak() {
        return postupak;
    }

    public void setPostupak(String postupak) {
        this.postupak = postupak;
    }

    public int getVrijemePripreme() {
        return vrijeme_pripreme;
    }

    public void setVrijemePripreme(int vrijeme_pripreme) {
        this.vrijeme_pripreme = vrijeme_pripreme;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }
}