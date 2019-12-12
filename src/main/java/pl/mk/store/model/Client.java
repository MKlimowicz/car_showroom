package pl.mk.store.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String adres;
    @Column
    private String nip;
    @Column
    private String pesel;


    public Client() {
    }


    public Client(String firstName, String lastName, String adres, String nip, String pesel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.adres = adres;
        this.nip = nip;
        this.pesel = pesel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id) &&
                Objects.equals(firstName, client.firstName) &&
                Objects.equals(lastName, client.lastName) &&
                Objects.equals(adres, client.adres) &&
                Objects.equals(nip, client.nip) &&
                Objects.equals(pesel, client.pesel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, adres, nip, pesel);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", adres='" + adres + '\'' +
                ", nip='" + nip + '\'' +
                ", pesel='" + pesel + '\'' +
                '}';
    }
}
