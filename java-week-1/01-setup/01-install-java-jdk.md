# Installing Java 21 (OpenJDK)

This guide explains how to install **Java 21 (OpenJDK 21)** on **macOS**, **Windows**, and **Ubuntu**.  
Java 21 is a Long-Term Support (LTS) release, making it a great choice for development and production environments.

---

## 📦 macOS

### Using Homebrew (recommended)

```bash
brew update
brew install openjdk@21
```

After installation, link Java 21 so it’s available system-wide:

```bash
brew link --force --overwrite openjdk@21
```

Add the following to your shell config (`~/.zshrc` or `~/.bashrc`):

```bash
export PATH="/usr/local/opt/openjdk@21/bin:$PATH"
```

Verify installation:

```bash
java -version
```

---

## 🖥️ Windows

### Option 1: Using Winget (recommended on Windows 10/11)

```powershell
winget install EclipseAdoptium.Temurin.21.JDK
```

### Option 2: Manual Installation

1. Download the [Temurin JDK 21 installer](https://adoptium.net/temurin/releases/?version=21).
2. Run the installer and follow the steps.
3. Ensure the **"Set JAVA_HOME variable"** option is selected.

Verify installation in PowerShell:

```powershell
java -version
```

---

## 🐧 Ubuntu (Debian-based Linux)

### Option 1: Using APT (default packages)

```bash
sudo apt update
sudo apt install openjdk-21-jdk -y
```

### Option 2: Using PPA (if not available in default repo)

```bash
sudo add-apt-repository ppa:openjdk-r/ppa
sudo apt update
sudo apt install openjdk-21-jdk -y
```

Verify installation:

```bash
java -version
```

---

## ✅ Verifying Installation

Run:

```bash
java -version
```

Expected output (may vary slightly):

```bash
openjdk version "21" 2023-09-19
OpenJDK Runtime Environment (build 21+35)
OpenJDK 64-Bit Server VM (build 21+35, mixed mode, sharing)
```

---
