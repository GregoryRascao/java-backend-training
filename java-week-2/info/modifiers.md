# Java Modifiers Cheat Sheet

## ✅ Access Modifiers

| Modifier                | Class (Top-level) | Inner Class | Methods | Fields |
|-------------------------|-------------------|-------------|---------|--------|
| `public`                | ✅                 | ✅           | ✅       | ✅      |
| `protected`             | ❌                 | ✅           | ✅       | ✅      |
| `default` (no modifier) | ✅                 | ✅           | ✅       | ✅      |
| `private`               | ❌                 | ✅           | ✅       | ✅      |

⚠️ Note:

* `protected` and `private` are **not allowed for top-level classes**, but can be used for **inner/nested classes**.
* `default` applies when no access modifier is given.

---

## ✅ Non-Access Modifiers

| Modifier       | Class                            | Methods                  | Fields                                 |
|----------------|----------------------------------|--------------------------|----------------------------------------|
| `abstract`     | ✅ (class cannot be instantiated) | ✅ (no body)              | ❌                                      |
| `final`        | ✅ (class cannot be subclassed)   | ✅ (cannot be overridden) | ✅ (constant, must be initialized once) |
| `static`       | ❌ (except nested classes)        | ✅                        | ✅                                      |
| `synchronized` | ❌                                | ✅                        | ❌                                      |
| `native`       | ❌                                | ✅                        | ❌                                      |
| `transient`    | ❌                                | ❌                        | ✅ (field not serialized)               |
| `volatile`     | ❌                                | ❌                        | ✅ (field updated across threads)       |
| `strictfp`     | ✅                                | ✅                        | ❌                                      |

---

### 🔑 Key Points

* **Classes** → Only `public`, `default`, `final`, `abstract`, `strictfp` allowed.
* **Methods** → Most modifiers apply here (access + abstract/final/static/synchronized/native/strictfp).
* **Fields (variables)** → Can be `public/protected/private/default` + `final/static/transient/volatile`.

---
