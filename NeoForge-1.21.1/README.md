# Xibao++ — NeoForge 1.21.1

[![Build NeoForge 1.21.1](https://github.com/Youzix-Star/Xibao-Plus-Plus/actions/workflows/neoforge-build.yml/badge.svg?branch=neoforge-1.21.1)](https://github.com/Youzix-Star/Xibao-Plus-Plus/actions/workflows/neoforge-build.yml)

This directory contains the **Minecraft 1.21.1 / NeoForge** port of
[Xibao++](https://github.com/GregTaoo/Xibao-Plus-Plus).

## What it does

When the client loses its connection, the vanilla "Disconnected" screen is
replaced with a Xibao illustration, looping music and optional falling-flower
animation. Three buttons let you stop the music, toggle the flowers and switch
albums.

Everything is client-side, so the mod can be used on any server.

## Requirements

- Minecraft **1.21.1**
- NeoForge **21.1.x** (built against 21.1.265)
- Java **21**

## Build

```bash
cd NeoForge-1.21.1
./gradlew build
```

The jar is written to `NeoForge-1.21.1/build/libs/`.

GitHub Actions builds every push automatically; the jar is attached to the
workflow run as the `XibaoPlusPlus-NeoForge-1.21.1` artifact.

## Configuration

On first launch a `config/xibao_plus_plus.properties` file is created:

```properties
playMusic=true
showPicture=true
displaySnow=false
type=xibao
```

`type` can be `xibao` or `beibao`.

## Differences from the Fabric version

- Official Mojang mappings and NeoForge APIs.
- Config moved from the working directory to the standard `config/` directory.
- Custom pictures/music still live in `assets/xibaopp/textures` and
  `assets/xibaopp/sounds`, so resource packs work the same way.
