# Additional Testing Concepts (Optional)

> Estimated reading time: 15–20 minutes, including examples and reflection questions.
> You do not need to install the tools mentioned here or learn their syntax yet.

Week 7 introduced unit, integration and end-to-end tests. This reading puts those ideas into a wider picture: how teams organise testing, why they use different kinds of tests, and where tools such as Selenium, Jest and Mockito fit.

Throughout the reading, imagine a **course-registration application**. Students can browse courses, register for a place and receive a confirmation email. The application has a web interface, a Java backend and a database.

## 1. Testing and Quality Assurance

**Software testing** evaluates software and related work products, such as requirements, to discover problems and provide information about quality. It includes designing checks, choosing data, running tests and investigating results. Reviews can also find defects without running the application; these are a form of static testing.

**Quality assurance (QA)** focuses on the processes used to build and deliver software. It aims to prevent problems by improving how the team works.

For our registration application:

| Activity | What it contributes |
|---|---|
| Agreeing on clear acceptance criteria before development | Prevents misunderstandings about the required behaviour |
| Establishing a review process for changes | Helps the team detect issues consistently |
| Checking that a full course rejects new registrations | Tests the product's behaviour |
| Improving the release process after repeated deployment mistakes | Reduces the chance of repeating those mistakes |

Testing provides feedback that can help improve those processes. QA and testing support each other, but their names do not mean exactly the same thing.

In job titles, **QA engineer** is often used for someone who designs tests, investigates defects and builds automation. The job title may cover more practical testing work than the formal definition of quality assurance suggests. Read the responsibilities, not just the title.

### Who is responsible?

Developers commonly write unit and integration tests alongside their code. Testers or QA engineers may explore the product, identify risks, design broader tests and build automation. Product owners and users help decide whether the outcome meets their needs.

These responsibilities overlap. A QA engineer can write code, and a developer can perform exploratory testing. Quality is a team responsibility; it should not become a final checkpoint where one person must find everyone else's mistakes.

## 2. Test Levels: How Much Are We Checking?

Here is a short recap using our application:

| Scope | Example | What it can tell us |
|---|---|---|
| **Unit** | Test the rule that a student cannot register twice | Whether a small unit's behaviour is correct in isolation |
| **Integration** | Use the real repository with a test database to save and retrieve a registration | Whether connected components work together |
| **End-to-end (E2E)** | Open the website, sign in, register and check the confirmation page and saved registration | Whether a complete journey works across the participating parts |

A unit is not necessarily one method. It might be a small class or a closely related group of objects. The important question is which behaviour is under test and which dependencies participate.

### System testing

System testing evaluates the complete system against its requirements. It can cover functionality, performance and other qualities in a representative environment.

It overlaps with E2E testing, but the terms emphasise different things. **System testing focuses on the complete system under test; E2E testing follows a complete workflow**, potentially across several systems. Teams sometimes use the terms loosely, so clarify what a test actually includes.

For example, a system test might check that the application enforces registration permissions through its API. An E2E test might follow a student's browser journey through registration and an external email-testing service. Neither term automatically means every real external service must be contacted.

## 3. The Test Pyramid: Why Many Small Tests?

The test pyramid is a guideline for balancing an automated test suite. It usually suggests **many unit tests, fewer integration tests and a smaller number of E2E tests**.

| Layer | Typical relative number | Typical cost and feedback |
|---|---|---|
| E2E | Few | More setup, slower execution, broader failures |
| Integration | Some | Checks real boundaries; needs more infrastructure |
| Unit | Many | Usually fast, focused and easy to run repeatedly |

Consider a rule that limits registration to students aged 18 or older. We can cheaply test ages 17, 18 and 19 at unit level. Repeating every age case through a browser would require opening pages, filling forms and waiting for responses each time.

We still need integration tests to discover issues such as a database constraint rejecting valid data. We also need selected E2E tests to discover issues such as the Register button sending the wrong request. A correct Java method does not prove that the full feature works.

The practical aim is to **check a behaviour at the smallest useful scope, then add broader tests for risks that smaller tests cannot cover**. A few complete journeys can give valuable confidence without duplicating every boundary case through the UI.

There is no universal percentage to follow. A service with little business logic but many database interactions may need substantial integration coverage. Count useful checks and risks covered, not just test methods. One test method can contain several cases, and a thousand weak assertions can miss an important defect.

## 4. Test Purposes: Smoke, Regression and Acceptance

These labels describe why we test. They can overlap with the levels above.

### Smoke testing — Is the build usable enough to continue?

A smoke suite is a small set of broad, shallow checks. For example:

- The application starts.
- The course list can be loaded.
- A basic registration can be submitted.

If the server cannot start, running a large browser suite is unlikely to provide useful extra information. Smoke tests can quickly reveal that the build or environment has a major problem.

Smoke testing does not prove that every feature works. The term is also used for a minimal load-test run that checks whether the load-test script works before applying heavier traffic; context matters.

### Regression testing — Did a change break existing behaviour?

Suppose we change the registration validation. Tests for previously working behaviour help us detect accidental damage from that change. Unit, integration and E2E tests can all be part of regression testing.

After fixing a defect, we also check that the specific defect is fixed. This is **confirmation testing**. Checking other existing behaviour for unintended effects is regression testing. A test added for the original defect can remain in the regression suite.

### User acceptance testing (UAT) — Does this meet the users' needs?

Users or business representatives evaluate whether the outcome is suitable for its intended use.

For example, a course coordinator tries registration and discovers that they cannot identify students who need accessibility support. Every technical test might pass, yet the workflow may still fail an important business need.

UAT should use agreed acceptance criteria and realistic tasks. It is more than asking someone whether they like the application. Some acceptance checks can be automated; user judgement and stakeholder acceptance still matter.

## 5. Manual and Automated Testing

**Manual testing** involves a person performing and evaluating checks. A tester might explore registration using confusing inputs, different navigation paths or interruptions.

**Automated testing** uses software to execute checks and evaluate results. It is especially useful for repeatable checks that should run frequently.

| Situation | Useful approach |
|---|---|
| Recheck twenty known validation cases after every change | Automated tests |
| Explore whether registration instructions are confusing | Human investigation |
| Repeat the main registration journey across browsers | Browser automation, with human investigation when needed |
| Investigate an unexpected failure | People use logs, tools, experiments and possibly new automated tests |

Manual testing can be systematic and skilled. Automation also requires human work: someone chooses what matters, defines expected results and maintains the checks. Automated tests only check what we have taught them to check.

An exploratory session combines learning about the product with designing and performing tests. It is not simply clicking randomly. A tester might focus on the question: “What happens if registration is interrupted and retried?”

## 6. Black-Box, White-Box and Grey-Box Perspectives

- **Black-box:** Design tests from observable behaviour and requirements without relying on the internal implementation. Example: an underage student receives a clear rejection.
- **White-box:** Use implementation knowledge to target branches, conditions or paths. Example: notice separate branches for duplicate registration and a full course, then test both.
- **Grey-box:** Use some internal knowledge while testing through external interfaces. Example: know how registrations are stored and inspect test data while investigating an API failure.

These perspectives do not replace test levels. A unit test can be designed from a public method's contract, and a broader test can use knowledge of the implementation.

Coverage tools can show which code ran. However, **executing a line does not prove that its result was checked correctly**. High coverage is useful information, not proof of correctness or a substitute for meaningful cases.

## 7. Mocking and Mockito: Controlling Dependencies

Imagine that `RegistrationService` uses an `EmailSender`. A unit test of registration rules should not need a real email account or send messages to real students.

A **test double** is a replacement used instead of a real dependency during testing. You can write a simple replacement yourself, or use a library.

**Mockito** is a Java mocking framework. It can create replacement objects, configure their responses and verify interactions with them. In a registration test, we could arrange the following:

1. Give the real `RegistrationService` a Mockito replacement for `EmailSender`.
2. Call the real registration method with valid input.
3. Verify that it asked `EmailSender` to send the expected confirmation.

In another test, we could make the replacement simulate an email-service failure and check the application's response. No actual email server needs to fail.

Configuring a replacement's response is often called **stubbing**. Checking whether it received an expected call is interaction verification. The terms “mock” and “stub” are sometimes used loosely; focus on what the replacement does in the test.

This connects to dependency injection: if `RegistrationService` receives its dependencies through its constructor, the application can provide the real sender and a unit test can provide a test double.

**Keep the behaviour under test real.** If we mock `RegistrationService` itself and tell it to return success, we have not checked its registration logic. Also, verifying that an email was requested does not prove that the real email integration works. That requires a separate integration check.

## 8. Tools: Which Job Does Each One Do?

Tools do not define the test's level by themselves. A JUnit test might exercise one small class or a real database integration. What it runs against determines its scope.

### Java and JavaScript

| Tool | Main role | Example use |
|---|---|---|
| **JUnit** | Structure, run and assert results in Java tests | Check validation rules or run a repository integration test |
| **Mockito** | Replace Java dependencies and verify interactions | Check that confirmation is requested without contacting an email server |
| **Testcontainers** | Manage temporary containerised dependencies for tests | Start PostgreSQL and test a repository against a real database engine |
| **REST Assured** | Send HTTP requests and assert API responses from Java | Check that registering through an API returns the expected status and data |
| **Jest** | JavaScript testing framework with assertions and mocking facilities | Test a JavaScript validation function or component behaviour |
| **Vitest** | JavaScript/TypeScript testing framework integrated with the Vite ecosystem | Run tests for a frontend project using Vite |

Jest has a similar role to JUnit at a broad level: developers define tests and assertions, then run them. Their APIs and ecosystems differ. Neither tool is limited to one test level, and neither automatically means a complete browser journey is being tested.

Testcontainers does not replace JUnit. JUnit can run a test while Testcontainers provides the database it needs. REST Assured can similarly be used inside a JUnit test.

### Selenium and Playwright: Automating a Browser

**Selenium WebDriver** lets code control a browser: open a page, locate an element, enter text and click a button. It supports languages including Java and JavaScript.

A Selenium test for our application might open the course page, click Register, fill in the form and check the confirmation message. With Java, JUnit could organise the test and perform assertions while Selenium drives the browser.

**Playwright** also automates browsers. Its JavaScript/TypeScript test framework, Playwright Test, includes a runner, assertions and debugging tools. It can test similar journeys; Playwright also has APIs for other languages, including Java.

These tools can automate E2E tests, but browser automation is not automatically E2E. If a test replaces every backend response, it checks a narrower UI scope. Know which parts are real.

Browser tests can fail because of timing, unstable test data or environmental problems. A **flaky test** sometimes passes and sometimes fails without a relevant change to the application. Investigate the cause; repeatedly rerunning until it turns green can hide real problems.

## 9. Functional and Non-Functional Testing

**Functional testing** checks what the system does: whether it accepts a valid registration or rejects a duplicate.

**Non-functional testing** checks qualities such as performance, usability, reliability and security. A system may produce correct results but still be too slow or expose private information. The distinction is useful, although a feature such as an access-control rule can also have specific functional checks.

### Performance and load testing

Performance testing examines behaviour such as response time, throughput and resource use. **Load testing is one kind of performance testing**, not a separate unrelated category.

| Test | Example question |
|---|---|
| **Load** | Does registration meet its response-time target at the expected peak traffic? |
| **Stress** | What happens beyond expected capacity, and can the system recover? |
| **Spike** | What happens when many students arrive suddenly when registration opens? |
| **Endurance / soak** | Does performance degrade or memory usage grow during a long run? |

Define a measurable target before testing. For example: “At the agreed workload, at least 95% of registration requests should finish within one second, with fewer than 1% unexpected errors.” These are illustrative targets; the team must choose targets and workloads appropriate to its product.

**Grafana k6** and **Apache JMeter** can generate traffic and collect performance measurements. Simulating traffic at the API level is often more practical for load generation than opening thousands of full browsers. Still, the workload should represent realistic user activity and data.

A fast test on a developer laptop does not establish production capacity. The environment, database size, traffic pattern and infrastructure affect the results.

### Security testing

Security testing investigates whether the system protects data and resists misuse. For the registration application:

- Can one student access another student's private registration details?
- Can a normal user perform coordinator-only actions?
- Does malicious input get treated as SQL or as data?
- Are passwords, tokens or personal details exposed in responses or logs?

**ZAP** can help inspect and scan a running web application for security weaknesses. Static analysis and dependency scanning can identify other risks before deployment. These approaches complement each other; a scanner cannot prove that an application is secure. Use active security testing in environments where testing is authorised.

## 10. CI/CD: Running Tests When Code Changes

**Continuous integration (CI)** combines frequent integration of code changes with automated builds and checks. A push or pull request can trigger a pipeline so the team gets feedback without relying on someone remembering to run every test locally.

Tools such as **GitHub Actions** and **Jenkins** coordinate those steps. They run testing tools; they do not replace them.

A possible pipeline for our application is:

1. Check out the code and prepare the required environment.
2. Compile the application and run unit tests.
3. Run integration tests with a test database.
4. Build a deployable package and deploy it to a test environment.
5. Run smoke checks and selected E2E journeys.
6. Publish results so the team can investigate failures.

Teams choose where each suite belongs. Fast checks often run on every pull request. Expensive load tests or broader security checks may run on a schedule or before a release. CI configuration and branch rules can make required passing checks a condition of merging.

**Continuous delivery** keeps validated software ready to release, with production release potentially requiring a decision. **Continuous deployment** automatically releases changes that pass the pipeline to production. Both are abbreviated CD, so ask which meaning is intended.

A passing pipeline means the configured checks passed. It does not mean every possible problem has been checked or that human acceptance and exploration have become unnecessary.

## 11. Putting the Labels Together

One test can have several descriptions because the labels answer different questions:

| Question | Example label |
|---|---|
| How much of the application participates? | Integration test |
| Why are we running it? | Regression check |
| Which quality are we checking? | Functional behaviour |
| How was it designed? | From the API's external contract: black-box perspective |
| How is it executed? | Automated with JUnit and REST Assured |
| When does it run? | On each pull request in CI |

For example, an automated API test that checks duplicate-registration handling after every change can fit all those descriptions. Calling it a regression test does not stop it from also being an integration test.

Before adding a test, ask: **What could go wrong, what evidence would reveal it, and what is the simplest useful way to get that evidence?** The answer helps choose the scope, data and tool.

## Check Your Understanding

You do not need to write code for these questions:

1. A unit test passes, but registration fails because the SQL query uses the wrong column name. Which broader check could reveal this?
2. A Mockito test verifies that confirmation was requested. What has it proved, and what has it not proved?
3. A browser test checks a critical registration journey after every release. Which labels could describe it besides “E2E”?
4. All tests pass, but a coordinator cannot complete their real task. What might be missing from the team's quality work?

## Further Reading and Tool Documentation

These links are for reference. You are not expected to learn every tool now.

- [ISTQB Foundation Level: testing terminology and syllabus](https://istqb.org/certifications/certified-tester-foundation-level-ctfl-v4-0/)
- [Google Testing Blog: balancing E2E and smaller tests](https://testing.googleblog.com/2015/04/just-say-no-to-more-end-to-end-tests.html)
- [JUnit User Guide](https://docs.junit.org/5.11.4/user-guide/)
- [Mockito](https://site.mockito.org/) · [Testcontainers for Java](https://java.testcontainers.org/) · [REST Assured](https://rest-assured.io/)
- [Jest](https://jestjs.io/docs/getting-started) · [Vitest](https://vitest.dev/guide/)
- [Selenium](https://www.selenium.dev/documentation/overview/) · [Playwright](https://playwright.dev/docs/intro)
- [Grafana k6: load test types](https://grafana.com/docs/k6/latest/testing-guides/test-types/) · [Apache JMeter](https://jmeter.apache.org/)
- [ZAP](https://www.zaproxy.org/getting-started/)
- [GitHub Actions: continuous integration](https://docs.github.com/en/actions/get-started/continuous-integration) · [Jenkins](https://www.jenkins.io/doc/)
