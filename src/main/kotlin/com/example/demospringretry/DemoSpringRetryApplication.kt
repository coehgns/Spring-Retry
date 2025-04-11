package com.example.demospringretry

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.retry.annotation.EnableRetry
import org.springframework.retry.annotation.Retryable

@EnableRetry
@SpringBootApplication
class DemoSpringRetryApplication

fun main(args: Array<String>) {
    runApplication<DemoSpringRetryApplication>(*args)
}
