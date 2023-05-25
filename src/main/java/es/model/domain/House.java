package es.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity(name = "t_house")
@Table(name = "t_house")
@PrimaryKeyJoinColumn(name = "id")
@OnDelete(action = OnDeleteAction.CASCADE)
public class House extends Product {

  @Column(name = "m2")
  private int m2;

  public int getM2() {
    return m2;
  }

  public void setM2(int m2) {
    this.m2 = m2;
  }
}
