plugins {
    id("soffa.lombok")
    id("soffa.test.junit5")
    id("soffa.qa.coverage.l5")
}

dependencies {
    api("jakarta.validation:jakarta.validation-api:3.0.2")
    api("org.checkerframework:checker-qual:3.42.0")
    api("org.checkerframework:checker:3.42.0")
    api("jakarta.annotation:jakarta.annotation-api:3.0.0")
    api("io.swagger.core.v3:swagger-annotations:2.2.41")
    api("io.swagger.core.v3:swagger-models:2.2.41")
    api("jakarta.ws.rs:jakarta.ws.rs-api:4.0.0")
    api("com.fasterxml.jackson.core:jackson-annotations:2.20")
    api("com.fasterxml.jackson.core:jackson-databind:2.20.1")
    api("commons-validator:commons-validator:1.10.1")
}

