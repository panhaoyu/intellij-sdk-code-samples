// Copyright 2000-2023 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.

plugins {
    id("java")
    id("org.jetbrains.intellij") version "1.17.4"
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
    version.set("2024.1.7")
    plugins.set(listOf("com.intellij.java"))
}

// 为IDE创建一个可以直接安装的JAR文件
tasks.register<Copy>("copyPluginJar") {
    from(tasks.jar)
    into(layout.buildDirectory.dir("distributions"))
    rename { "fish_language-2.0.0-installer.jar" }
}

tasks {
    buildSearchableOptions {
        enabled = false
    }

    patchPluginXml {
        version.set("${project.version}")
        sinceBuild.set("241")
        untilBuild.set("246.*")
    }

    withType<JavaCompile> {
        options.encoding = "UTF-8"
    }
}

// 定义复制任务 - 复制ZIP插件文件
val copyToNetworkShare by tasks.registering(Copy::class) {
    from(layout.buildDirectory.dir("distributions"))
    into("C:/Users/panhaoyu/OneDrive/1002-data/25032501-zhaogroup-share/pfc")
    include("*.zip")
    dependsOn("copyPluginJar")  // 确保在copyPluginJar之后运行
}

// 定义复制JAR文件的任务
val copyJarToNetworkShare by tasks.registering(Copy::class) {
    from(layout.buildDirectory.dir("libs"))
    into("C:/Users/panhaoyu/OneDrive/1002-data/25032501-zhaogroup-share/pfc")
    include("*.jar")
}

// 定义复制插件JAR到网络共享的任务
val copyPluginJarToNetworkShare by tasks.registering(Copy::class) {
    from(tasks.named("copyPluginJar"))
    into("C:/Users/panhaoyu/OneDrive/1002-data/25032501-zhaogroup-share/pfc")
}

// 同时复制ZIP和JAR文件
tasks.named("buildPlugin") {
    finalizedBy(copyToNetworkShare, copyJarToNetworkShare)
}

// 让buildPlugin任务也生成可安装的JAR文件
tasks.buildPlugin {
    finalizedBy("copyPluginJar")
}

// 确保插件JAR也复制到网络共享
tasks.buildPlugin {
    finalizedBy("copyPluginJarToNetworkShare")
}
