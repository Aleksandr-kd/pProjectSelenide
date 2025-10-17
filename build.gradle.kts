plugins {
    id("java")
}

group = "maja"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.8.1"))
    testImplementation("com.codeborne:selenide:6.19.1")
    testImplementation("org.junit.jupiter:junit-jupiter")

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()

//    systemProperty("selenide.holdBrowserOpen", "true")
    systemProperty("selenide.headless", "false")
    systemProperty("selenide.browser", "chrome")
    systemProperty("selenide.timeout", "10000")
}