package catering.businesslogic.recipe;

import java.time.Duration;
import java.util.ArrayList;

public abstract class KitchenDuty {

  private String name;
  private String author;
  private String instructions;
  private Double quantity;
  private Duration activityTime; // TODO: aggiungere activityTime nel DCD
  private ArrayList<String> tags;

  public KitchenDuty(String name) {
    this.name = name;
  }

  public KitchenDuty() {
  }

  public KitchenDuty(String name, String author, String instructions, Double quantity, Duration activityTime,
      ArrayList<String> tags) {
    this.name = name;
    this.author = author;
    this.instructions = instructions;
    this.quantity = quantity;
    this.activityTime = activityTime;
    this.tags = tags;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getInstructions() {
    return instructions;
  }

  public void setInstructions(String instructions) {
    this.instructions = instructions;
  }

  public Double getQuantity() {
    return quantity;
  }

  public void setQuantity(Double quantity) {
    this.quantity = quantity;
  }

  public Duration getActivityTime() {
    return activityTime;
  }

  public void setActivityTime(Duration activityTime) {
    this.activityTime = activityTime;
  }

  public ArrayList<String> getTags() {
    return tags;
  }

  public void setTags(ArrayList<String> tags) {
    this.tags = tags;
  }

}
