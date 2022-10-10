variable "instance_ingress_rule_dev" {
  type = map(object({
    port        = number
    protocol    = string
    cidr_blocks = list(string)
  }))
  default = {
    "443" = {
      port       = 443
      protocol   = "tcp"
      cidr_blocks = ["0.0.0.0/0"]
    }
    "80" = {
      port        = 80
      protocol    = "tcp"
      cidr_blocks = ["0.0.0.0/0"]
    }
  }
}

module "variables" {
  source = "./../variables"
}

resource "aws_security_group" "web_traffic" {
  name = "Allow Https"

  dynamic "ingress" {
    for_each = var.instance_ingress_rule_dev
    content {
      description = "TLS from VPC"
      from_port   = ingress.value.port
      to_port     = ingress.value.port
      protocol    = ingress.value.protocol
      cidr_blocks = ingress.value.cidr_blocks
    }
  }

  egress {
    from_port   = 0
    protocol    = "TCP"
    to_port     = 0
    cidr_blocks = ["0.0.0.0/0"]
  }

}

output "security_group" {
  value = aws_security_group.web_traffic.name
}