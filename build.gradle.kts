/*
 * This file was generated by the Gradle 'init' task.
 *
 * This project uses @Incubating APIs which are subject to change.
 */

plugins {
    `java-library`
    `maven-publish`
}

repositories {
    mavenLocal()
    maven {
        url = uri("https://repo.maven.apache.org/maven2/")
    }
}

dependencies {
    api(libs.org.springframework.boot.spring.boot.starter.cache)
    api(libs.org.springframework.boot.spring.boot.starter.data.jpa)
    api(libs.org.springframework.boot.spring.boot.starter.data.rest)
    api(libs.org.springframework.boot.spring.boot.starter.validation)
    api(libs.org.springframework.boot.spring.boot.starter.web)
    api(libs.org.springframework.boot.spring.boot.starter.web.services)
    api(libs.org.springframework.cloud.spring.cloud.starter.openfeign)
    api(libs.com.mysql.mysql.connector.j)
    api(libs.org.springframework.boot.spring.boot.configuration.processor)
    api(libs.org.projectlombok.lombok)
    api(libs.org.hibernate.hibernate.core)
    api(libs.org.springframework.boot.spring.boot.starter.aop)
    api(libs.com.itextpdf.itextpdf)
    api(libs.org.springframework.boot.spring.boot.starter.actuator)
    api(libs.com.zaxxer.hikaricp)
    api(libs.org.springframework.boot.spring.boot.starter.integration)
    api(libs.org.springframework.boot.spring.boot.starter.security)
    api(libs.org.springframework.boot.spring.boot.starter.logging)
    api(libs.org.json.json)
    api(libs.org.springdoc.springdoc.openapi.ui)
    api(libs.org.apache.tomcat.tomcat.jdbc)
    runtimeOnly(libs.org.springframework.boot.spring.boot.devtools)
    testImplementation(libs.org.springframework.boot.spring.boot.starter.test)
    compileOnly(libs.org.springframework.boot.spring.boot.starter.tomcat)
}

group = "com.oderzy"
version = "0.0.1-SNAPSHOT"
description = "oderzy_home"
java.sourceCompatibility = JavaVersion.VERSION_1_8

publishing {
    publications.create<MavenPublication>("maven") {
        from(components["java"])
    }
}

tasks.withType<JavaCompile>() {
    options.encoding = "UTF-8"
}

tasks.withType<Javadoc>() {
    options.encoding = "UTF-8"
}
