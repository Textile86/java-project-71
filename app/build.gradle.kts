plugins {
    id("java")
    id("com.github.ben-manes.versions") version "0.52.0"
    application
    checkstyle
    id("org.sonarqube") version "6.2.0.5505"
    jacoco
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
