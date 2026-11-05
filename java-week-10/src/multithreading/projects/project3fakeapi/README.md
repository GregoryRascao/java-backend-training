# Mini Project: Fake API Calls

## Goal

Learn the basics of asynchronous programming using `CompletableFuture`.

## Task

Imagine your program needs data from 2 different APIs.

We will simulate this with `Thread.sleep()`.

Create:

- one method that returns `"User data"`
- one method that returns `"Order data"`

Each method should wait a little before returning.

Then run both methods asynchronously and combine their results.

## Requirements

- Use `CompletableFuture.supplyAsync()`
- Use `thenCombine()`
- Print the final combined result

## Example result

User data + Order data

## Bonus

Add a third fake API call:
- `"Payment data"`