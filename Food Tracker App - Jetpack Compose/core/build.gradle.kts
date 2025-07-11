import org.gradle.kotlin.dsl.resolver.buildSrcSourceRootsFilePath

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

// Correct usage of apply for external scripts in Kotlin DSL
//apply(from = "${buildSrcSourceRootsFilePath}/basemodule.gradle.kts")