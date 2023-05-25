package es.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity(name = "t_car")
@Table(name = "t_car")
@PrimaryKeyJoinColumn(name = "id")
@OnDelete(action = OnDeleteAction.CASCADE)

public class Car extends Product {
  @Column(name = "km")
  private int km;

  public int getKm() {
    return km;
  }

  public void setKm(int km) {
    this.km = km;
  }
}
