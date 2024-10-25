package com.example.convention

import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType

// 컨벤션 플러그인의 Project 블록 안에서 버전 카탈로그를 편하게 사용하기 위한 확장함수

fun Project.library(name: String) =
    extensions.getByType<VersionCatalogsExtension>().named("libs").findLibrary(name).get()

fun Project.version(name: String) =
    extensions.getByType<VersionCatalogsExtension>().named("libs").findVersion(name).get()