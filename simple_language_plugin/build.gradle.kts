// Copyright 2000-2023 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.

plugins {
    id("java")
    id("org.jetbrains.intellij") version "1.17.3"
}

group = "org.intellij.sdk"
version = "2.0.0"

repositories {
    mavenCentral()
}

// Include the generated files in the source set
sourceSets {
    main {
        java {
            srcDirs("src/main/gen")
        }
    }
}

dependencies {
    testImplementation("junit:junit:4.13.2")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

// See https://plugins.jetbrains.com/docs/intellij/tools-gradle-intellij-plugin.html
intellij {
    version.set("2023.2.6")
//  plugins.set(listOf("com.intellij.java"))
}

tasks {
    buildSearchableOptions {
        enabled = false
    }

    patchPluginXml {
        version.set("${project.version}")
        sinceBuild.set("232")
        untilBuild.set("300.*")
    }

    withType<JavaCompile> {
        options.encoding = "UTF-8"
    }
}

// 定义复制任务
val copyToNetworkShare by tasks.registering(Copy::class) {
    from(layout.buildDirectory.dir("distributions"))
    into("D:/局域网共享")
    include("*.zip")
}

tasks.named("buildPlugin") {
    finalizedBy(copyToNetworkShare)
}
