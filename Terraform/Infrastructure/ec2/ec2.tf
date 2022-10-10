module "security_groups" {
  source = "./../security_groups"
}

resource "aws_instance" "instance0" {
  ami             = "ami-01216e7612243e0ef"
  instance_type   = "t2.micro"
  security_groups = [module.security_groups.security_group]
  tags            = {
    name = "instance0"
  }

}

output "instance_id" {
  value = aws_instance.instance0.id
}