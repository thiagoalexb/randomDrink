pluginManagement {
  repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
  }
}

dependencyResolutionManagement {
  repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
  repositories {
    google()
    mavenCentral()
  }
}

rootProject.name = "RandomDrink"
include(":app")
include(":core:domain")
include(":core:repository")
include(":feature:home")
include(":feature:search")
include(":design:strings")
include(":common:baseapp")
include(":common:di")
include(":common:extensions")
include(":core:data")
include(":design:components")
include(":feature:favorites")
