plugins {
    id("com.github.ben-manes.versions") version "0.52.0"
    application
    checkstyle
    id("org.sonarqube") version "6.2.0.5505"
    jacoco
    id("io.freefair.lombok") version "8.14.2"
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21) // Укажите вашу версию Java
    }
}

application {
    mainClass.set("hexlet.code.App")
}

checkstyle {
    configFile = file("config/checkstyle/checkstyle.xml")
    toolVersion = "11.0.0"
    // isIgnoreFailures = false
}

sonar {
    properties {
        property("sonar.projectKey", "Textile86_java-project-71")
        property("sonar.organization", "textile86")
        property("sonar.host.url", "https://sonarcloud.io")

    }
}

jacoco {
    toolVersion = "0.8.13"
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("info.picocli:picocli:4.7.7")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.18.3")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.14.2")
    compileOnly("org.projectlombok:lombok:1.18.30")
    annotationProcessor("org.projectlombok:lombok:1.18.30")
}

tasks.test {
    useJUnitPlatform()
    finalizedBy(tasks.jacocoTestReport)
}

tasks.jacocoTestReport {
    dependsOn(tasks.test)
    reports {
        xml.required = true
        html.required = true
    }
}
