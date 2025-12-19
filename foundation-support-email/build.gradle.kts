plugins {
    id("soffa.lombok")
    id("soffa.test.junit5")
}

dependencies {
    api(project(":foundation-commons"))
    implementation("org.apache.commons:commons-email:1.6.0")
    implementation("com.sendgrid:sendgrid-java:4.10.3")
    compileOnly("org.springframework.boot:spring-boot-autoconfigure:3.3.12")
    testImplementation("org.springframework.boot:spring-boot-starter-test:3.2.4")
}
