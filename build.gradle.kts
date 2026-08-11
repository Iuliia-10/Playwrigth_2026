plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

val playwrightVersion = "1.50.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.testng:testng:7.12.0")
    implementation("com.microsoft.playwright:playwright:$playwrightVersion")
}

tasks.test {
    useTestNG()
}

// Корректная запись таска для Kotlin DSL (build.gradle.kts)
tasks.register<JavaExec>("playwrightInstall") {
    group = "verification"
    description = "Downloads Playwright browser binaries"
    classpath = sourceSets["test"].runtimeClasspath
    mainClass.set("com.microsoft.playwright.CLI")
    args = listOf("install")
}