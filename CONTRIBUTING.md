# Contributing to CodeLearn Pro

Thanks for your interest in contributing. This document explains how to report issues, suggest features, and submit pull requests.

## Table of Contents

- [Code of Conduct](#code-of-conduct)
- [How Can I Contribute?](#how-can-i-contribute)
- [Reporting Bugs](#reporting-bugs)
- [Suggesting Features](#suggesting-features)
- [Development Setup](#development-setup)
- [Style Guidelines](#style-guidelines)
- [Commit Messages](#commit-messages)
- [Pull Request Process](#pull-request-process)

## Code of Conduct

This project follows a simple rule: be respectful. Harassment, insults, and dismissive behavior are not tolerated. See [CODE_OF_CONDUCT.md](CODE_OF_CONDUCT.md) for the full policy.

## How Can I Contribute?

There are several ways to help:

- **Report bugs** — found something broken? Open an issue.
- **Suggest features** — have an idea? Open an issue with the `feature request` label.
- **Improve documentation** — fix typos, clarify instructions, add examples.
- **Write code** — fix a bug or build a feature. See the PR process below.
- **Add lessons** — the app needs more lessons. See "Adding Lessons" below.
- **Translate** — help bring the app to more languages.

## Reporting Bugs

Before opening a bug report:

1. **Search existing issues** to avoid duplicates.
2. **Try the latest build** — the bug may already be fixed.
3. **Reproduce it consistently** — intermittent bugs are hard to fix.

When opening a bug report, use the bug report template and include:

- **Device model** (e.g., Samsung Galaxy A12)
- **Android version** (e.g., Android 13)
- **App version** (from the About screen or Settings)
- **Steps to reproduce** — numbered list
- **Expected behavior** — what should have happened
- **Actual behavior** — what actually happened
- **Screenshots or screen recording** if possible
- **Logcat output** if you can capture it

## Suggesting Features

Feature requests are welcome. In your issue, describe:

- **The problem** you're trying to solve
- **Your proposed solution**
- **Alternatives** you've considered
- **Why it matters** to you or other users

Vague requests like "make it better" can't be acted on. Specific requests like "add a quiz after each lesson" can.

## Development Setup

### Prerequisites

- Android Studio Hedgehog (2023.1.1) or newer
- JDK 17
- Android SDK 36
- Git

### Steps

1. **Fork the repository** on GitHub.

2. **Clone your fork:**
   ```bash
   git clone https://github.com/YOUR_USERNAME/CodeLearnPro.git
   cd CodeLearnPro