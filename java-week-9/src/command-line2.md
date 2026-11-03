# 📟 Command Line — Part 2

This is the continuation of our command-line series.
In [Part 1](https://github.com/HackYourFutureBelgium/java-week-2/blob/main/info/command-line.md) we covered the essentials:
`pwd`, `ls`, `cd`, `cat`, `grep`, `find`, absolute vs relative paths, the pipe `|`, and output redirection (`>`, `>>`).

Here we go deeper: file inspection tools, permissions, downloading files from the web, standard error, and an introduction to network tools.

> Examples below use **bash** (Linux / macOS / Git Bash on Windows).

---

## `file` — Identify What a File Actually Is

The `file` command inspects the **content** of a file and tells us what type it is — regardless of its extension.
This is useful when we are not sure whether a `.dat` file is a text file, a binary, a ZIP archive, or something else entirely.

```bash
file README.md
# README.md: ASCII text

file photo.jpg
# photo.jpg: JPEG image data, JFIF standard 1.01

file archive.tar.gz
# archive.tar.gz: gzip compressed data

file Main.class
# Main.class: compiled Java class data, version 61.0 (Java 17)

file /usr/bin/ls
# /usr/bin/ls: ELF 64-bit LSB pie executable, x86-64 ...
```

We can pass multiple files at once:

```bash
file src/*.java
```

### When do we use it?

- Before opening a suspicious download — we check what it really is.
- When a script fails because a "text file" is actually binary.
- When we receive files without extensions and need to know how to handle them.

---

## `strings` — Extract Human-Readable Text from Any File

Compiled binaries, images, and other non-text files still contain scattered human-readable strings (error messages, version numbers, URLs, hard-coded credentials, etc.).
`strings` extracts every sequence of printable characters that is at least 4 characters long.

```bash
strings Main.class           # read strings from a compiled Java class
strings /usr/bin/curl        # read strings from the curl binary
strings firmware.bin         # inspect an unknown binary file
```

### Useful flags

```bash
strings -n 8 Main.class      # only show strings of length >= 8 (fewer false positives)
strings -o Main.class        # show the file offset next to each string
```

### Combine with `grep`

```bash
strings Main.class | grep -i "version"
strings firmware.bin | grep "http"
strings app.jar | grep "password"   # check for accidental hard-coded secrets!
```

`strings` is one of the first tools we reach for when we want a quick look inside a binary without a full disassembler.

---

## `chmod` — Change File Permissions

Every file on a Unix system has **permission bits** that control who can read, write, or execute it.
`chmod` (change mode) lets us modify those bits.

### Reading permission strings

When we run `ls -l` we see something like:

```
-rwxr-xr--  1 alize staff  4096 May 18 10:00 deploy.sh
```

The first 10 characters are the permission string:

```
- rwx r-x r--
│ │   │   └── other  (everyone else): read only
│ │   └─────── group: read + execute
│ └─────────── owner: read + write + execute
└───────────── file type (- = regular file, d = directory)
```

### Symbolic mode (human-readable)

```bash
chmod +x deploy.sh          # add execute permission for everyone
chmod -x deploy.sh          # remove execute permission for everyone
chmod u+x deploy.sh         # add execute only for the owner (u = user)
chmod g-w config.txt        # remove write from the group (g)
chmod o-r secret.key        # remove read from others (o)
chmod u+rw,g+r,o-rwx data/  # set multiple permissions at once
```

| Letter | Meaning |
|--------|---------|
| `u`    | user (owner) |
| `g`    | group |
| `o`    | others |
| `a`    | all (u + g + o) |

### Numeric (octal) mode

Each permission is a bit: read = 4, write = 2, execute = 1.
We add the bits together for each category:

| Octal | Permissions |
|-------|------------|
| `7`   | rwx (4+2+1) |
| `6`   | rw- (4+2)   |
| `5`   | r-x (4+1)   |
| `4`   | r-- (4)     |
| `0`   | --- (nothing)|

```bash
chmod 755 deploy.sh    # rwxr-xr-x  — owner full, group + others read/execute
chmod 644 config.txt   # rw-r--r--  — owner read/write, everyone else read only
chmod 600 private.key  # rw-------  — owner only, nobody else
chmod 000 locked.txt   # ---------- — nobody can do anything
```

`755` for scripts and `644` for regular files are the two most common patterns we use.

---

## `curl` — Transfer Data Over the Network

`curl` (Client URL) sends and receives data over many protocols: HTTP, HTTPS, FTP, and more.
We use it to test APIs, download files, and inspect HTTP responses — all from the terminal.

### Download a file

```bash
curl https://example.com/data.json          # print response to stdout
curl -o data.json https://example.com/data.json   # save to a file
curl -O https://example.com/archive.tar.gz  # save using the remote filename
curl -L https://short.url/xyz -o page.html  # -L follows redirects
```

### Inspect HTTP responses

```bash
curl -I https://example.com          # -I  HEAD request — headers only, no body
curl -v https://example.com          # -v  verbose: show request + response headers
curl -s https://example.com          # -s  silent: no progress bar (good in scripts)
curl -w "%{http_code}\n" -o /dev/null -s https://example.com   # just the status code
```

### Send data (REST APIs)

```bash
# GET request (default)
curl https://api.example.com/users

# POST with JSON body
curl -X POST https://api.example.com/users \
     -H "Content-Type: application/json" \
     -d '{"name": "Alize", "email": "alize@example.com"}'

# POST with Authorization header
curl -X GET https://api.example.com/profile \
     -H "Authorization: Bearer YOUR_TOKEN_HERE"

# PUT request
curl -X PUT https://api.example.com/users/1 \
     -H "Content-Type: application/json" \
     -d '{"name": "Alize Updated"}'

# DELETE request
curl -X DELETE https://api.example.com/users/1
```

### Useful flags summary

| Flag | Meaning |
|------|---------|
| `-o <file>` | Save output to file |
| `-O`        | Save using remote filename |
| `-L`        | Follow redirects |
| `-I`        | HEAD request (headers only) |
| `-v`        | Verbose output |
| `-s`        | Silent (no progress bar) |
| `-X <METHOD>` | HTTP method (GET, POST, PUT, DELETE…) |
| `-H <header>` | Add a request header |
| `-d <data>` | Request body |

---

## `wget` — Download Files from the Web

`wget` is purpose-built for **downloading files**.
It is simpler than `curl` for that specific job, and it supports resuming interrupted downloads out of the box.

```bash
wget https://example.com/archive.tar.gz           # download to current directory
wget -O output.tar.gz https://example.com/archive  # save with a custom name
wget -P downloads/ https://example.com/file.txt   # save into a specific directory
wget -c https://example.com/big-file.iso          # -c  continue/resume an interrupted download
wget -q https://example.com/file.txt              # -q  quiet mode (no output)
```

### Download multiple files

```bash
# list URLs in a text file, one per line
wget -i urls.txt

# mirror an entire website (careful — can be very large)
wget --mirror --convert-links https://example.com
```

### `wget` vs `curl`

| Task | Recommended tool |
|------|-----------------|
| Quickly download a file | `wget` |
| Test or call a REST API | `curl` |
| Resume large downloads | `wget -c` |
| Custom headers / methods | `curl` |
| Scripts that process response data | `curl` |

In practice we use both — `wget` when we just want a file, `curl` when we want to inspect or interact with an HTTP endpoint.

---

## Standard Error and `2>/dev/null`

Every process has three standard streams:

| Stream | Number | Default destination |
|--------|--------|---------------------|
| stdin  | 0      | keyboard input |
| stdout | 1      | terminal (normal output) |
| stderr | 2      | terminal (error output) |

By default both stdout and stderr appear together in the terminal, which can make output messy.
We can redirect them independently.

### Redirect stderr to a file

```bash
find / -name "*.java" 2>errors.txt        # send only errors to a file
find / -name "*.java" > results.txt 2>errors.txt   # stdout and stderr to separate files
```

### Suppress errors with `/dev/null`

`/dev/null` is a special "black hole" file — anything written to it disappears.

```bash
find / -name "*.java" 2>/dev/null         # discard all error messages
grep -r "TODO" /etc/ 2>/dev/null          # ignore "Permission denied" noise
```

This is our most common pattern: we only care about the successful results, so we silence the errors.

### Merge stderr into stdout

```bash
find / -name "*.java" > all-output.txt 2>&1   # redirect stderr (2) to wherever stdout (1) goes
command > output.txt 2>&1                      # both streams end up in the same file
```

### Redirect stdin

```bash
mysql -u root -p my_database < backup.sql   # feed a file into a command as stdin
```

### Full picture

```
command  >  file.txt    # stdout → file (overwrite)
command  >> file.txt    # stdout → file (append)
command  2> err.txt     # stderr → file
command  2>/dev/null    # stderr → nowhere (discard)
command  2>&1           # stderr → same place as stdout
command  > out.txt 2>&1 # both stdout and stderr → file
```

---

## `nmap` — Network Scanner

`nmap` (Network Mapper) is a tool for **discovering hosts and open ports** on a network.
Security professionals use it to audit their own infrastructure; developers use it to check which services are actually reachable.

> **Important:** Only scan networks and hosts you own or have explicit permission to scan.
> Unauthorized scanning is illegal in many jurisdictions.

### Basic usage

```bash
nmap 192.168.1.1                  # scan a single host
nmap 192.168.1.1-50               # scan a range of IPs
nmap 192.168.1.0/24               # scan an entire subnet (all 256 addresses)
nmap scanme.nmap.org              # nmap's own public test server (authorized)
```

### Common flags

```bash
nmap -p 80,443 192.168.1.1        # scan specific ports only
nmap -p 1-1000 192.168.1.1        # scan port range
nmap -p- 192.168.1.1              # scan ALL 65535 ports
nmap -sV 192.168.1.1              # -sV  detect service versions
nmap -O  192.168.1.1              # -O   detect operating system (requires root)
nmap -A  192.168.1.1              # -A   aggressive: OS, version, scripts, traceroute
nmap -Pn 192.168.1.1              # -Pn  skip host discovery (treat host as up)
nmap -sn 192.168.1.0/24           # -sn  ping scan — find live hosts without port scan
```

### Example output

```
PORT     STATE  SERVICE  VERSION
22/tcp   open   ssh      OpenSSH 8.9
80/tcp   open   http     nginx 1.24.0
443/tcp  open   https    nginx 1.24.0
3306/tcp closed mysql
```

`open` = we can connect; `closed` = host responded but port not listening; `filtered` = firewall is blocking.

---

## `nc` — Netcat, the Swiss Army Knife

`nc` (or `netcat`) is a low-level networking utility that can:
- open raw TCP/UDP connections
- listen for incoming connections
- transfer files
- create simple port scanners

It is often called the **Swiss Army knife** of networking because it does so many simple networking tasks with a single tool.

### Connect to a host and port (manual HTTP)

```bash
nc example.com 80           # open a raw TCP connection to port 80
```

Then type manually:
```
GET / HTTP/1.0
Host: example.com
[press Enter twice]
```

We will see the raw HTTP response — useful for understanding exactly what happens under the hood.

### Check if a port is open

```bash
nc -zv 192.168.1.1 22           # -z  don't send data, just check; -v  verbose
nc -zv 192.168.1.1 80 443 8080  # check multiple ports at once
nc -zv 192.168.1.1 20-25        # check a port range
```

```
# Output examples:
# Connection to 192.168.1.1 22 port [tcp/ssh] succeeded!
# nc: connect to 192.168.1.1 port 81: Connection refused
```

### Listen for incoming connections (simple server)

Terminal 1 — start a listener:
```bash
nc -l 9000           # listen on port 9000
```

Terminal 2 — connect to it:
```bash
nc localhost 9000    # connect to the listener
```

Now whatever we type in either terminal appears in the other. This is useful for quick local testing.

### Transfer a file over the network

Receiver (run first):
```bash
nc -l 9000 > received-file.tar.gz
```

Sender:
```bash
nc 192.168.1.5 9000 < file-to-send.tar.gz
```

### `nc` vs `curl`

| Task | Tool |
|------|------|
| Make HTTP/API requests | `curl` |
| Check if a port is open | `nc -zv` |
| Raw TCP connection / debugging | `nc` |
| Simple file transfer on a LAN | `nc` |
| Listen for incoming data | `nc -l` |

---

## Quick Reference

| Command | Purpose |
|---------|---------|
| `file <path>`              | Identify file type by content |
| `strings <file>`           | Extract printable strings from any file |
| `strings <file> \| grep <pat>` | Search for specific text inside a binary |
| `chmod +x <file>`          | Make a file executable |
| `chmod 755 <file>`         | rwxr-xr-x (scripts) |
| `chmod 644 <file>`         | rw-r--r-- (regular files) |
| `chmod 600 <file>`         | rw------- (private files) |
| `curl -o out.json <url>`   | Download URL, save to file |
| `curl -I <url>`            | Show HTTP headers only |
| `curl -X POST -d '{...}' <url>` | POST JSON to an API |
| `wget <url>`               | Download a file |
| `wget -c <url>`            | Resume an interrupted download |
| `2>/dev/null`              | Discard all error output |
| `> out.txt 2>&1`           | Save both stdout and stderr to a file |
| `nmap -sV <host>`          | Scan ports and detect service versions |
| `nmap -sn <network>`       | Discover live hosts on a network |
| `nc -zv <host> <port>`     | Check if a port is open |
| `nc -l <port>`             | Listen on a port |
