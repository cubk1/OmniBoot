plugins {
    id("java")
}

group = "org.union4dev"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":"))
    compileOnly("org.projectlombok:lombok:1.18.30")
    annotationProcessor("org.projectlombok:lombok:1.18.30")
    testCompileOnly("org.projectlombok:lombok:1.18.30")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.30")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}