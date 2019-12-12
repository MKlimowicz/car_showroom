package pl.mk.store.dto;


import java.util.Objects;

public class ClientDto {

    private Integer id;
    private String firstName;
    private String lastName;
    private String adres;
    private String nip;

    private String pesel;

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
        ClientDto clientDto = (ClientDto) o;
        return Objects.equals(id, clientDto.id) &&
                Objects.equals(firstName, clientDto.firstName) &&
                Objects.equals(lastName, clientDto.lastName) &&
                Objects.equals(adres, clientDto.adres) &&
                Objects.equals(nip, clientDto.nip) &&
                Objects.equals(pesel, clientDto.pesel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, adres, nip, pesel);
    }

    @Override
    public String toString() {
        return "ClientDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", adres='" + adres + '\'' +
                ", nip='" + nip + '\'' +
                ", pesel='" + pesel + '\'' +
                '}';
    }
}
