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
