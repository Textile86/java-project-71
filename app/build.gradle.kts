plugins {
    id("java")
    id("com.github.ben-manes.versions") version "0.52.0"
    application
    checkstyle
}

application {
    mainClass = "hexlet.code.App"
}

checkstyle {
    config = resources.text.fromFile("/home/textile86/java-project-71/app/config/checkstyle/checkstyle.xml")
    toolVersion = "11.0.0"
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
}
