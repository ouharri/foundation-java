plugins {
    id("soffa.lombok")
    id("soffa.springboot.library")
}

dependencies {
    api(project(":foundation-api"))
    api(project(":foundation-application"))
    api("org.springframework.boot:spring-boot-starter-data-jpa") {
        exclude(group = "com.zaxxer")
        exclude(group = "com.github.ben-manes.caffeine")
    }
    implementation("com.github.ben-manes.caffeine:caffeine:3.2.3")
    implementation("org.postgresql:postgresql:42.7.8")
    implementation("com.zaxxer:HikariCP:5.1.0")
    implementation("net.javacrumbs.shedlock:shedlock-provider-jdbc-template:5.16.0")
    implementation("net.javacrumbs.shedlock:shedlock-spring:5.16.0")
    //api("org.hibernate.javax.persistence:hibernate-jpa-2.1-api:1.0.2.Final")
    api("jakarta.persistence:jakarta.persistence-api:3.1.0")

    implementation("org.jdbi:jdbi3-core:3.51.0")
    implementation("org.jdbi:jdbi3-postgres:3.51.0")
    implementation("org.jdbi:jdbi3-sqlobject:3.51.0")
    implementation("org.liquibase:liquibase-core:4.33.0")
}

/*
api("org.jobrunr:jobrunr:4.0.7") {
    exclude(group = "com.zaxxer")
    exclude(group = "com.h2database")
}

 */

