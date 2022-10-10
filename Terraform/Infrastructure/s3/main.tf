resource "aws_s3_bucket" "example" {
  bucket = "s3-srv96-tf-private"
}

resource "aws_s3_bucket_acl" "example" {
  bucket = aws_s3_bucket.example.id
  acl    = "private"
}

resource "aws_s3_bucket_versioning" "versioning_example" {
  bucket = aws_s3_bucket.example.id
  versioning_configuration {
    status = "Disabled"
  }
}

resource "aws_athena_database" "example" {
  name   = "s3_data_analysis"
  bucket = aws_s3_bucket.example.bucket
}