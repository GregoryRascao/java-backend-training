# 📟 Command Line Basics

The command line (also called the **terminal** or **shell**) lets us interact with the operating system by typing text commands instead of clicking through a graphical interface.
It is fast, scriptable, and present on every server we will ever work on — so we need to be comfortable here.

> Examples below use **bash** (Linux / macOS / Git Bash on Windows).
> PowerShell equivalents are noted where they differ.

---

## Paths — Absolute vs Relative

Before we look at any command, we need to understand **paths**, because almost every command takes one.

### Absolute Path

An absolute path starts from the **root** of the filesystem and describes the full location of a file or directory.

```
/home/alice/projects/java-week-2/src/Main.java   ← Linux / macOS
C:\Users\Alice\projects\java-week-2\src\Main.java ← Windows
```

An absolute path is **always the same** no matter which directory we are currently in.

### Relative Path

A relative path is interpreted **from our current location**.

```
src/Main.java          ← one folder deeper
../info/arrays.md      ← go up one level, then into info/
../../other-project    ← go up two levels
```

Special symbols:
| Symbol | Meaning |
|--------|---------|
| `.`    | Current directory |
| `..`   | Parent directory |
| `~`    | Home directory of the current user |

---

## `pwd` — Print Working Directory

`pwd` tells us exactly where we are in the filesystem right now.
We use it whenever we are lost or want to confirm our current location before running another command.

```bash
pwd
# /home/alice/projects/java-week-2
```

PowerShell equivalent: `Get-Location` (or `pwd` — it works there too as an alias).

---

## `ls` — List Directory Contents

`ls` shows the files and folders inside a directory.

```bash
ls                   # list current directory
ls src/              # list a specific directory
ls -l                # long format: permissions, size, date
ls -a                # include hidden files (names starting with .)
ls -la               # combine both flags
ls -lh               # human-readable file sizes (KB, MB…)
```

Example output of `ls -lh`:

```
drwxr-xr-x  4 alice staff  128B May 18 10:00 src
-rw-r--r--  1 alice staff  3.2K May 18 09:45 README.md
```

PowerShell equivalent: `Get-ChildItem` (or `ls` / `dir` as aliases).

---

## `cd` — Change Directory

`cd` moves us from our current directory to another one.

```bash
cd src/              # move into a subfolder
cd ..                # go up one level
cd ../info           # go up one level, then into info/
cd ~                 # go to home directory
cd /                 # go to root of the filesystem
cd -                 # go back to the previous directory (very handy!)
```

### Creating directories along the way

We often combine `cd` with `mkdir` (make directory):

```bash
mkdir my-project         # create a single directory
mkdir -p a/b/c           # create nested directories in one command
cd my-project
```

---

## `cat` — Display File Contents

`cat` (concatenate) reads one or more files and prints their contents to the terminal.

```bash
cat README.md                    # print a single file
cat file1.txt file2.txt          # print two files one after the other
cat -n README.md                 # print with line numbers
```

When a file is long, `cat` dumps everything at once.
For large files we prefer `less` (scrollable viewer) or `head` / `tail`:

```bash
less README.md           # open scrollable view (q to quit)
head -n 20 README.md     # show first 20 lines
tail -n 20 README.md     # show last 20 lines
tail -f app.log          # follow a log file in real time (Ctrl+C to stop)
```

### Creating a small file quickly

```bash
echo "Hello, World!" > hello.txt    # write (overwrite) a file
echo "Second line"   >> hello.txt   # append to a file
cat hello.txt
```

---

## `grep` — Search for Text

`grep` searches for a **pattern** inside files (or input from a pipe) and prints every matching line.

```bash
grep "main"  src/Main.java                  # find lines containing "main"
grep -i "main" src/Main.java                # -i  case-insensitive
grep -n "main" src/Main.java                # -n  show line numbers
grep -r "hashCode" src/                     # -r  search recursively in a directory
grep -r "hashCode" src/ --include="*.java"  # limit to .java files
grep -l "TODO" src/                         # -l  list only file names, not lines
grep -v "import" src/Main.java              # -v  invert: lines that do NOT match
```

### Useful flag combinations

```bash
grep -rn "Arrays.sort" src/    # recursive + line numbers — our most common combo
grep -c "System.out" src/Main.java   # -c count matching lines
```

---

## `find` — Find Files and Directories

`find` walks a directory tree and returns everything that matches the given criteria.

```bash
find .                             # list every file under current directory
find . -name "Main.java"           # find by exact filename
find . -name "*.java"              # find by pattern (wildcard)
find . -type f                     # only files (not directories)
find . -type d                     # only directories
find . -name "*.java" -type f      # combine criteria
find . -name "*.class" -delete     # find and delete compiled class files
```

### `find` vs `grep`

| Tool    | What it searches |
|---------|-----------------|
| `find`  | File and directory **names** / metadata |
| `grep`  | **Content** inside files |

We use `find` to locate *where* a file is, and `grep` to locate *what* is inside a file.

---

## `|` — The Pipe

The pipe `|` connects two commands by sending the **output of the left command** as the **input of the right command**.
This lets us build powerful one-liners by chaining small, focused tools together.

```
command1 | command2 | command3 ...
```

### Examples

```bash
# Count how many .java files exist under src/
find src/ -name "*.java" | wc -l

# Search for "TODO" in all Java files and count the results
grep -r "TODO" src/ --include="*.java" | wc -l

# List all files, then filter only .md files
ls -la | grep ".md"

# Show the first 5 lines that contain "import" in Main.java
grep "import" src/Main.java | head -n 5

# Sort lines alphabetically and remove duplicates
cat names.txt | sort | uniq

# Find all Java files, then search inside each one for "hashCode"
find src/ -name "*.java" | xargs grep -l "hashCode"
```

### `wc` — Word Count

`wc` is a small utility we use frequently with pipes:

```bash
wc -l file.txt        # count lines
wc -w file.txt        # count words
wc -c file.txt        # count bytes
```

### Redirection (`>` and `>>`)

Related to pipes, we can also redirect output to a file instead of the terminal:

```bash
find src/ -name "*.java" > java-files.txt    # save list to a file (overwrite)
grep -r "TODO" src/      >> notes.txt        # append results to a file
```

---

## Quick Reference

| Command | Purpose |
|---------|---------|
| `pwd`             | Show current directory |
| `ls`              | List directory contents |
| `ls -la`          | Detailed listing including hidden files |
| `cd <path>`       | Change directory |
| `cd ..`           | Go up one level |
| `cd -`            | Go back to previous directory |
| `mkdir <name>`    | Create a directory |
| `mkdir -p a/b/c`  | Create nested directories |
| `cat <file>`      | Print file contents |
| `head -n N <file>`| Print first N lines |
| `tail -n N <file>`| Print last N lines |
| `less <file>`     | Scroll through a file |
| `grep <pat> <file>` | Search for pattern in file |
| `grep -rn <pat> <dir>` | Recursive search with line numbers |
| `find <dir> -name <pat>` | Find files by name |
| `wc -l`           | Count lines (usually after a pipe) |
| `sort`            | Sort lines alphabetically |
| `uniq`            | Remove duplicate adjacent lines |
| `echo "text" > file` | Write text to a file |
| `cmd1 \| cmd2`    | Pipe: feed output of cmd1 into cmd2 |
