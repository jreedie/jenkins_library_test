



def call(args){
	String key = """-----BEGIN RSA PRIVATE KEY-----MIIEogIBAAKCAQEAuBay0u0qY/RSEQYLOw7FrBCtgp2nQTZrXA7XvMeZCdCyQxWURSk3axJNYjLNomIWob0IcbmASXq2Hexdx5Yv/AI8jdzmrwRX+7aYWx+EGdIHBEWKAXyeqTJ+yxwmag24TaQJp1LFlQFUYdlGVjb2u512JzH5VEpSTukFWS4uMaKE+YJPLxRym0BkNJsyiDmHNZePdp/I2tiRiMarKwpP1ldqDt7ocvvkAeEAvOXATNJ1RR9fkbDKq8IJ2bOMKcZOqYDal3kPIuy4QF66EtQq9EFmGNpAA2OomvOyC96I2EO8X+8E5CmemaR7Ixc5HY5yZg3I1O8y+RI2VwIKwwVxewIDAQABAoIBAEQqw5UvlV7l/e2n20jHM5N/qYCQeHrBeAfixyh0kMr9qMUGnJzvokHXySfvwA29XLwPj6ztEAAlnIKAIEnj52jeOyYdAp8UcLAY8Vns1bHqAAco6O2cA/SLakAz8FWdNv4pHBoFoHyIvYJuPol2WO8oY7Qn4TfBPbFSwFRBsYFXGC9t05fIu4YKXJs6eS/NjMJMNvYJ7FLEJwaLfLRXrnaMVIsJJ84v1v0XoKtBJ3Ybj08LW6jbXa97r/DLfCzjPvPLlRQAY6pk+uK39JwcwZl1vYU7FNpML+sbWZ3z/vnRrNWMa/3fH3O0K83Bm2CbzztOOnh95IuO4WNzkq253SECgYEA3Zvt3t1JzFErl8HPLI+xomBgOwESIAzgh4SHTvHfV8HWIKsY21Wf2aUgCRUHxZH1CDeph1QETpre+vC4OvvfvRcGRpBiaY5BAPvRNhBYqhlC7DWmg6bQMzX9a1/TqEbapgzg+kpGr35uYztEqrCeyCRSm6duPxDXHH5TW7iptQ8CgYEA1KgpBPUK4N6htCCGheIuOPjnOsfTQcxReYLD53hfY3GvdUecgDsccIH8G11qQDEFysiRtRb9pFUlDtzgrng2h+CZHllP3g0XAWiOyeJ73XN+2HVcY+fEl8qIxWnc6qIyiusy0dLxsD9VqSoN9KROJHbXAbra0XXYT7SYVwHJdNUCgYB6+5fswH2+B6XbmFDy9+OqqzV8SUHXy42nZ2L36r75orbEdm9a+Y+2Zy76G1OuzytenhVU5sllHgl01bZH9ZPbCjYPXv1eevWUKCuYh0XNUCuVjsiT8zVD1kiHGC0MDBY3ZJpODH5h0hZMt42J9G6Jv66gdzB1i1D1nR2Bn19+/QKBgH8xwa8sXgBYSUHy/mNQALOk9LEs2kgNzGGwfDqTvgI9+mNcnNf6Ay2sIb3AZw/UApHi23wEL1u+bbbxGBZi4sLs7MjBRMsc6zi1cEqCg/HV5fXUZJmBBA6CXsItaqyQrUh4G2JzGIqBp1vSQpykNfULe9iWCdGk+efarg/EitmtAoGACiTLUBGT2/hI3JNlPKG7dQ9xJPMbH9CvRIbvB4yNPi7NwhTZhCxgxIl0c+xlsTW5wtOQ4yVKIDYlFFa2ngNikE9psT1y1ax3ZOibvlI80MicrnWTIqdmxF6+bE3PgvaKq9kTx3sD00D+SNN438RJhFckhUALjQvncNDZJA/fZzY=-----END RSA PRIVATE KEY-----"""
	String keyPath = "/var/jenkins_home/workspace/petclinic_pipeline_master-SB4IZJUDDU473F33XRGM7HJYLNLXKCH3DORA7ALO7SGM6FBSUCKQ/tmpkey.txt"
	sh "touch tmpkey.txt"
	sh "chmod 400 $keyPath"
	sh "chown root $keyPath"
	sh "echo $key > $keyPath" 
	sh "ssh -i $keyPath $args"
	sh "rm $keyPath"
}

