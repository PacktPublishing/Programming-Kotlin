package com.programming.kotlin.chapter09;

import org.joda.time.DateTime;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

/**
 * Created by stepi on 15/10/16.
 */
public class SomeProgram {
  public static void main(String[] args) {
    try {
      BlogEntry blogEntry = new BlogEntry("Data Classes are here",
              "Because Kotlin rulz!",
              DateTime.now(),
              true,
              DateTime.now(),
              new URI("http://packt.com/blog/programming_kotlin/data_classes"),
              0,
              new ArrayList<>(),
              null);

      blogEntry.copy(blogEntry.getTitle(),
              blogEntry.getDescription(),
              blogEntry.getPublishTime(),
              blogEntry.getApproved(),
              blogEntry.getLastUpdated(),
              blogEntry.getUrl(),
              blogEntry.getComments(),
              blogEntry.getTags(),
              blogEntry.getEmail());

    } catch (URISyntaxException e) {

    }

    Email email=new Email();
  }
}
