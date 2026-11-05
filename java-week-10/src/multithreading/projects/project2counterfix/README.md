# Mini Project: Counter Fix

## Goal

Understand race conditions and fix them using `synchronized`.

## Task

You have a shared counter.

Two threads both increase the counter many times.

At first, the result may be wrong because both threads modify the same data.

Your job is to fix the program.

## Requirements

- Create a shared counter
- Start 2 threads
- Each thread should increment the counter 100000 times
- Wait for both threads using `join()`
- Print the final result

## Expected result

The correct result should be:

200000

## Step 1

Run the unsafe version first.

## Step 2

Fix it using `synchronized`.

## Bonus

Try with 4 threads instead of 2.