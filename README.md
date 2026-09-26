# TimezoneManager
<div align="center">

[![Build][build-badge]][build-link]
[![Code Quality][codefactor-badge]][codefactor-link]
[![Release][release-badge]][release-link]
[![Modrinth Downloads][downloads-badge]][downloads-link]
[![GitHub Stars][stars-badge]][stars-link]
[![Java][java-badge]][java-link]
[![Gradle][gradle-badge]][gradle-link]
[![Bukkit API][bukkit-api-badge]][bukkit-api-link]
[![Online Servers][bstats-servers-badge]][bstats-link]
[![Online Players][bstats-players-badge]][bstats-link]

</div>

Simple global timezone manager for Bukkit, Spigot, Paper and Purpur.

## Commands

```text
/timezone
/timezone <timezone>
/timezone info
/timezone reload
/timezone reset
```

`/tz` is also available.

Examples:

```text
/timezone Asia/Kolkata
/timezone Europe/London
/timezone America/New_York
/timezone Kolkata
```

Permission: `timezone.admin`

## Config

```yaml
timezone: system
```

Use any valid IANA timezone ID. `system` restores the original JVM timezone.

## Build

```bash
./gradlew clean build
```

The JAR is created in `build/libs/`.

[build-badge]: https://img.shields.io/github/actions/workflow/status/DarkSpirit006/TimezoneManager/build.yml?branch=main&style=for-the-badge&logo=githubactions&logoColor=white&label=Build
[build-link]: https://github.com/DarkSpirit006/TimezoneManager/actions/workflows/build.yml

[codefactor-badge]: https://img.shields.io/codefactor/grade/github/DarkSpirit006/TimezoneManager?style=for-the-badge&logo=codefactor&logoColor=white&label=Code%20Quality
[codefactor-link]: https://www.codefactor.io/repository/github/darkspirit006/timezonemanager

[release-badge]: https://img.shields.io/modrinth/v/timezonemanager?style=for-the-badge&logo=modrinth&logoColor=white&label=Release
[release-link]: https://modrinth.com/plugin/timezonemanager/versions

[downloads-badge]: https://img.shields.io/modrinth/dt/timezonemanager?style=for-the-badge&logo=modrinth&logoColor=white&label=Downloads
[downloads-link]: https://modrinth.com/plugin/timezonemanager

[stars-badge]: https://img.shields.io/github/stars/DarkSpirit006/TimezoneManager?style=for-the-badge&logo=github&logoColor=white&label=Stars
[stars-link]: https://github.com/DarkSpirit006/TimezoneManager/stargazers

[java-badge]: https://img.shields.io/badge/dynamic/regex?url=https%3A%2F%2Fraw.githubusercontent.com%2FDarkSpirit006%2FTimezoneManager%2Frefs%2Fheads%2Fmain%2Fbuild.gradle&search=options%5C.release%5Cs*%3D%5Cs*%28%5Cd%2B%29&replace=%241%2B&style=for-the-badge&logo=openjdk&logoColor=white&label=Java&color=f89820&cacheSeconds=300
[java-link]: https://adoptium.net/temurin/

[gradle-badge]: https://img.shields.io/badge/dynamic/regex?url=https%3A%2F%2Fraw.githubusercontent.com%2FDarkSpirit006%2FTimezoneManager%2Frefs%2Fheads%2Fmain%2Fgradle%2Fwrapper%2Fgradle-wrapper.properties&search=gradle-%28%5B0-9.%5D%2B%29-bin&replace=%241&style=for-the-badge&logo=gradle&logoColor=white&label=Gradle&color=0f6b78&cacheSeconds=300
[gradle-link]: https://gradle.org/

[bukkit-api-badge]: https://img.shields.io/badge/dynamic/regex?url=https%3A%2F%2Fraw.githubusercontent.com%2FDarkSpirit006%2FTimezoneManager%2Frefs%2Fheads%2Fmain%2Fbuild.gradle&search=spigot-api%3A%28%5B0-9.%5D%2B%29-R&replace=%241%2B&style=for-the-badge&label=Bukkit%20API&color=33b5e5&cacheSeconds=300
[bukkit-api-link]: https://hub.spigotmc.org/javadocs/spigot/

[bstats-servers-badge]: https://img.shields.io/bstats/servers/34335?style=for-the-badge&logo=minecraft&logoColor=white&label=Online%20Servers
[bstats-players-badge]: https://img.shields.io/bstats/players/34335?style=for-the-badge&logo=minecraft&logoColor=white&label=Online%20Players
[bstats-link]: https://bstats.org/plugin/bukkit/TimezoneManager/34335
