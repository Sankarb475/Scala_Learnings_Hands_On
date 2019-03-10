{"eventPayloadInJson":{
  "NAME":"SANKAR",
  "PROCESS_NAME":"CODING",
  "DETAILS":[{"ID": 100,"CD": 02}, {"ID": 1001,"CD": 2}]
  }
}

// so if you have a dataset like above you would want to have a case class like this ::

case class detailsCaseClass("ID": Int, "CD": Int)

case class Metadata("NAME": String, "PROCESS_NAME": String, "DETAILS" : detailsCaseClass)

and then you can use "extract[Metadata]" to extract the data and give the schema on it
