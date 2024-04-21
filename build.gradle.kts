plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    implementation("com.h2database:h2:2.2.220")
    implementation("org.flywaydb:flyway-core:10.11.0")
    implementation("org.hibernate.orm:hibernate-core:6.5.0.CR1")

    implementation("org.hibernate.validator:hibernate-validator:8.0.1.Final")
    implementation("javax.validation:validation-api:2.0.1.Final")

    implementation("org.glassfish.expressly:expressly:5.0.0")
}

tasks.test {
    useJUnitPlatform()
}