package com.programming.kotlin.chapter09;

public class Sensor {
  private final String id;
  private final double value;

  public Sensor(String id, double value) {
    this.id = id;
    this.value = value;
  }

  public String getId() {
    return id;
  }

  public double getValue() {
    return value;
  }
}
