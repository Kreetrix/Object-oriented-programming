package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "currencies")
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "abbreviation", unique = true, nullable = false)
    private String abbreviation;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "conversion_rate", nullable = false)
    private double conversionRate;

    public Currency() {
    }

    public Currency(String abbreviation, String name, double conversionRate) {
        this.abbreviation = abbreviation;
        this.name = name;
        this.conversionRate = conversionRate;
    }

    public String getAbbreviation() {
        return abbreviation;
    }
    //useless
    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(double conversionRate) {
        this.conversionRate = conversionRate;
    }

    @Override
    public String toString() {
        return abbreviation + " - " + name;
    }
}
