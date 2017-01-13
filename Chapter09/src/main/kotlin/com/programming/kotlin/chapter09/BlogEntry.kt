package com.programming.kotlin.chapter09

import org.joda.time.DateTime
import java.net.URI

/**
 * Created by stepi on 15/10/16.
 */

data class BlogEntry(var title: String,
                     var description: String,
                     val publishTime: DateTime,
                     var approved: Boolean?,
                     val lastUpdated: DateTime,
                     val url: URI,
                     var comments: Int?,
                     var tags: List<String>,
                     var email: String?)