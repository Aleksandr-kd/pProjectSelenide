plugins {
    id("java")
}

group = "maja"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(
        "com.codeborne:selenide:6.3.5",
        "org.junit.jupiter:junit-jupiter:5.8.2"
    )
}

tasks.test {
    useJUnitPlatform()
}