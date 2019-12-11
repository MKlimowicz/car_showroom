package pl.mk.store.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.Objects;


public class CarDto {

    private Integer id; //id
    private String nrVin;
    private Integer vintage;
    private String brand;
    private String model;
    private String nrOc;
    private String nrCertificateReg;
    private String typeOfFuel;
    private Integer mileage;
    private Integer engineCapacity;
    private Integer powerEngine;
    private String gearbox;
    private String description;
    private Integer numberTestDrivers;
    private Integer price;


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
        CarDto carDto = (CarDto) o;
        return Objects.equals(id, carDto.id) &&
                Objects.equals(nrVin, carDto.nrVin) &&
                Objects.equals(vintage, carDto.vintage) &&
                Objects.equals(brand, carDto.brand) &&
                Objects.equals(model, carDto.model) &&
                Objects.equals(nrOc, carDto.nrOc) &&
                Objects.equals(nrCertificateReg, carDto.nrCertificateReg) &&
                Objects.equals(typeOfFuel, carDto.typeOfFuel) &&
                Objects.equals(mileage, carDto.mileage) &&
                Objects.equals(engineCapacity, carDto.engineCapacity) &&
                Objects.equals(powerEngine, carDto.powerEngine) &&
                Objects.equals(gearbox, carDto.gearbox) &&
                Objects.equals(description, carDto.description) &&
                Objects.equals(numberTestDrivers, carDto.numberTestDrivers) &&
                Objects.equals(price, carDto.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nrVin, vintage, brand, model, nrOc, nrCertificateReg, typeOfFuel, mileage, engineCapacity, powerEngine, gearbox, description, numberTestDrivers, price);
    }
}
