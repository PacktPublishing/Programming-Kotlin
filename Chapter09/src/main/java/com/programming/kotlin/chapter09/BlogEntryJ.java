package com.programming.kotlin.chapter09;

import org.joda.time.DateTime;

import java.net.URI;
import java.util.List;

/**
 * Created by stepi on 15/10/16.
 */
public class BlogEntryJ {
  private final String title;
  private final String description;
  private final DateTime publishTime;
  private final Boolean approved;
  private final DateTime lastUpdated;
  private final URI url;
  private final Integer comments;
  private final List<String> tags;
  private final String email;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    BlogEntryJ that = (BlogEntryJ) o;

    if (!title.equals(that.title)) return false;
    if (!description.equals(that.description)) return false;
    if (!publishTime.equals(that.publishTime)) return false;
    if (approved != null ? !approved.equals(that.approved) : that.approved != null) return false;
    if (!lastUpdated.equals(that.lastUpdated)) return false;
    if (!url.equals(that.url)) return false;
    if (comments != null ? !comments.equals(that.comments) : that.comments != null) return false;
    if (tags != null ? !tags.equals(that.tags) : that.tags != null) return false;
    return email != null ? email.equals(that.email) : that.email == null;

  }

  @Override
  public int hashCode() {
    int result = title.hashCode();
    result = 31 * result + description.hashCode();
    result = 31 * result + publishTime.hashCode();
    result = 31 * result + (approved != null ? approved.hashCode() : 0);
    result = 31 * result + lastUpdated.hashCode();
    result = 31 * result + url.hashCode();
    result = 31 * result + (comments != null ? comments.hashCode() : 0);
    result = 31 * result + (tags != null ? tags.hashCode() : 0);
    result = 31 * result + (email != null ? email.hashCode() : 0);
    return result;
  }

  public BlogEntryJ(String title, String description, DateTime publishTime, Boolean approved, DateTime lastUpdated, URI url, Integer comments, List<String> tags, String email) {
    this.title = title;
    this.description = description;
    this.publishTime = publishTime;
    this.approved = approved;
    this.lastUpdated = lastUpdated;
    this.url = url;
    this.comments = comments;
    this.tags = tags;
    this.email = email;
  }

  public String getTitle() {
    return title;
  }

  public String getDescription() {
    return description;
  }

  public DateTime getPublishTime() {
    return publishTime;
  }

  public Boolean getApproved() {
    return approved;
  }

  public DateTime getLastUpdated() {
    return lastUpdated;
  }

  public URI getUrl() {
    return url;
  }

  public Integer getComments() {
    return comments;
  }

  public List<String> getTags() {
    return tags;
  }

  public String getEmail() {
    return email;
  }
}
