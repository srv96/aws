resource "aws_glue_catalog_table" "aws_glue_catalog_table" {
  name          = "worldcities"
  database_name = "s3_data_analysis"
  table_type    = "EXTERNAL_TABLE"

  parameters = {
    EXTERNAL = "TRUE"
  }

  storage_descriptor {
    location      = "s3://s3-srv96-tf-private/data/"
    input_format  = "org.apache.hadoop.mapred.TextInputFormat"
    output_format = "org.apache.hadoop.mapred.TextInputFormat"

    ser_de_info {
      name                  = "my-serde"
      serialization_library = "org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe"

      parameters = {
        "field.delim"            = ","
        "skip.header.line.count" = "1"
      }
    }

    columns {
      name = "city"
      type = "string"
    }

    columns {
      name = "city_ascii"
      type = "string"
    }

    columns {
      name = "lat"
      type = "float"
    }

    columns {
      name = "lng"
      type = "float"
    }

    columns {
      name = "country"
      type = "string"
    }

    columns {
      name = "iso2"
      type = "string"
    }

    columns {
      name = "iso3"
      type = "string"
    }

    columns {
      name = "admin_name"
      type = "string"
    }

    columns {
      name = "capital"
      type = "string"
    }

    columns {
      name = "population"
      type = "int"
    }

    columns {
      name = "id"
      type = "int"
    }

  }
}