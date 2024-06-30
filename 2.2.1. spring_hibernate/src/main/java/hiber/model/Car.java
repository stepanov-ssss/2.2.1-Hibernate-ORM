package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "Car")
public class Car {

    @Column(name = "Model")
    private String model;

    @Column(name = "series")
    private int series;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    public Car() {
    }

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    @Override
    public String toString() {
        return "Cars{" +
                "id=" + id + '\'' +
                ", model='" + model + '\'' +
                ", series=" + series +
                '}';
    }
}
