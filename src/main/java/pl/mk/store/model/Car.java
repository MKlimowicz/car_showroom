package pl.mk.store.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //id
    @Column
    private String nrVin;
    @Column
    private Integer vintage;
    @Column
    private String brand;
    @Column
    private String model;
    @Column
    private String nrOc;
    @Column
    private String nrCertificateReg;
    @Column
    private String typeOfFuel;
    @Column
    private Integer mileage;
    @Column
    private Integer engineCapacity;
    @Column
    private Integer powerEngine;
    @Column
    private String gearbox;
    @Column
    private String description;
    @Column
    private Integer numberTestDrivers;
    @Column
    private Integer price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNrVin() {
        return nrVin;
    }

    public void setNrVin(String nrVin) {
        this.nrVin = nrVin;
    }

    public Integer getVintage() {
        return vintage;
    }

    public void setVintage(Integer vintage) {
        this.vintage = vintage;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNrOc() {
        return nrOc;
    }

    public void setNrOc(String nrOc) {
        this.nrOc = nrOc;
    }

    public String getNrCertificateReg() {
        return nrCertificateReg;
    }

    public void setNrCertificateReg(String nrCertificateReg) {
        this.nrCertificateReg = nrCertificateReg;
    }

    public String getTypeOfFuel() {
        return typeOfFuel;
    }

    public void setTypeOfFuel(String typeOfFuel) {
        this.typeOfFuel = typeOfFuel;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public Integer getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(Integer engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public Integer getPowerEngine() {
        return powerEngine;
    }

    public void setPowerEngine(Integer powerEngine) {
        this.powerEngine = powerEngine;
    }

    public String getGearbox() {
        return gearbox;
    }

    public void setGearbox(String gearbox) {
        this.gearbox = gearbox;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getNumberTestDrivers() {
        return numberTestDrivers;
    }

    public void setNumberTestDrivers(Integer numberTestDrivers) {
        this.numberTestDrivers = numberTestDrivers;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(id, car.id) &&
                Objects.equals(nrVin, car.nrVin) &&
                Objects.equals(vintage, car.vintage) &&
                Objects.equals(brand, car.brand) &&
                Objects.equals(model, car.model) &&
                Objects.equals(nrOc, car.nrOc) &&
                Objects.equals(nrCertificateReg, car.nrCertificateReg) &&
                Objects.equals(typeOfFuel, car.typeOfFuel) &&
                Objects.equals(mileage, car.mileage) &&
                Objects.equals(engineCapacity, car.engineCapacity) &&
                Objects.equals(powerEngine, car.powerEngine) &&
                Objects.equals(gearbox, car.gearbox) &&
                Objects.equals(description, car.description) &&
                Objects.equals(numberTestDrivers, car.numberTestDrivers) &&
                Objects.equals(price, car.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nrVin, vintage, brand, model, nrOc, nrCertificateReg, typeOfFuel, mileage, engineCapacity, powerEngine, gearbox, description, numberTestDrivers, price);
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", nrVin='" + nrVin + '\'' +
                ", vintage=" + vintage +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", nrOc='" + nrOc + '\'' +
                ", nrCertificateReg='" + nrCertificateReg + '\'' +
                ", typeOfFuel='" + typeOfFuel + '\'' +
                ", mileage=" + mileage +
                ", engineCapacite=" + engineCapacity +
                ", powerEngine=" + powerEngine +
                ", gearbox='" + gearbox + '\'' +
                ", description='" + description + '\'' +
                ", numberTestDrivers=" + numberTestDrivers +
                ", price=" + price +
                '}';
    }
}
