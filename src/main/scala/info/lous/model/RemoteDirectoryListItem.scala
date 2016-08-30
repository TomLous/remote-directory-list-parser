package info.lous.model

import info.lous.model.FileUtils.FileSize




/**
  * Created by Tom Lous on 26/08/16.
  * Copyright © 2016 Datlinq B.V..
  */
case class RemoteDirectoryListItem (name: String, lastModified: java.time.LocalDateTime, bytes: FileSize)
