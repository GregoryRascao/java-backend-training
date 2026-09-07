# IntelliJ IDE Installation Guide

This guide explains how to install **IntelliJ IDE** (Community) on **Windows**, **macOS**, and **Linux**.

---

## 📦 Download IntelliJ IDEA

- Official website: [https://www.jetbrains.com/idea/download](https://www.jetbrains.com/idea/download)
- Choose **Community Edition** (free, open-source)

---

## 🖥️ Windows

### Installer (Recommended)

1. Download the `.exe` installer from the [JetBrains website](https://www.jetbrains.com/idea/download).
2. Run the installer and follow the wizard.
3. Select installation options:
   - Add **bin folder to PATH** (recommended).
   - Associate `.java` files with IntelliJ IDEA.
   - Create a desktop shortcut (optional).
4. Finish installation and launch IntelliJ IDEA.

### Toolbox App

Alternatively, install via [JetBrains Toolbox](https://www.jetbrains.com/toolbox-app/).

---

## 🍏 macOS

### DMG Installer

1. Download the `.dmg` file from [JetBrains website](https://www.jetbrains.com/idea/download).
2. Open the `.dmg` and drag **IntelliJ IDEA** into the **Applications** folder.
3. Launch IntelliJ IDEA from **Applications** or **Spotlight**.

### Toolbox App

You can also install and manage updates with [JetBrains Toolbox](https://www.jetbrains.com/toolbox-app/).

---

## 🐧 Linux

### Snap (Recommended for Ubuntu/Debian)

```bash
sudo snap install intellij-idea-community --classic
# OR for Ultimate edition:
sudo snap install intellij-idea-ultimate --classic
```

### Tarball (Manual Install)

1. Download the `.tar.gz` file from [JetBrains website](https://www.jetbrains.com/idea/download).
2. Extract the archive:

   ```bash
   tar -xzf ideaIC-*.tar.gz
   ```

3. Move to `/opt`:

   ```bash
   sudo mv idea-IC-* /opt/intellij-idea
   ```

4. Run IntelliJ IDEA:

   ```bash
   /opt/intellij-idea/bin/idea.sh
   ```

### Toolbox App

For easy updates, install [JetBrains Toolbox](https://www.jetbrains.com/toolbox-app/).

---

## ✅ Verify Installation

After installation, open IntelliJ IDEA and:

1. Configure **JDK** under `File > Project Structure > SDKs`.
2. Install useful plugins (e.g., Lombok, CheckStyle).
3. Set up version control (Git, GitHub, etc.).

---
