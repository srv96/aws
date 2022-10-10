provider "aws" {
  region = "ap-south-1"
}

module "ec2module" {
  source = "./ec2"
}

resource "aws_eip" "public_ip" {
  instance = module.ec2module.instance_id
}