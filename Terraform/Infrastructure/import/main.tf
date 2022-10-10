resource "aws_athena_database" "example" {
  name   = "s3_data_analysis"
  bucket = "s3://s3-srv96-tf-private"
}