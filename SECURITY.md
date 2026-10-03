# Security Policy

## Supported Versions

| Version | Supported |
|---------|-----------|
| 1.0.x   | ✅         |
| < 1.0   | ❌         |

## Reporting a Vulnerability

If you discover a security vulnerability in CodeLearn Pro, please report it responsibly.

**Do not open a public GitHub issue for security vulnerabilities.**

Instead, email the maintainer directly:

**endaleabinet67+codelearn@gmail.com**

Please include:

- A description of the vulnerability
- Steps to reproduce it
- The potential impact
- Any suggested fix (optional)
- Your name and contact info if you want credit

## What to Expect

- **Acknowledgment** within 48 hours
- **Initial assessment** within 5 business days
- **Regular updates** until the issue is resolved
- **Credit** in the release notes if you want it

## Scope

In scope:

- The Android app (this repository)
- Code execution flow (Judge0 CE integration)
- Data stored locally on the device
- Any authentication or authorization logic

Out of scope:

- The Judge0 CE public API itself (report those to the Judge0 project)
- GitHub's infrastructure
- The privacy policy site hosting

## Safe Harbor

We will not pursue legal action against researchers who:

- Report vulnerabilities privately and in good faith
- Do not exploit the vulnerability beyond what is necessary to demonstrate it
- Do not access, modify, or delete user data
- Give us reasonable time to fix the issue before public disclosure

## Known Non-Issues

These are not considered vulnerabilities:

- The Judge0 CE public instance returning errors or being slow (rate limits apply)
- The absence of obfuscation in debug builds
- The presence of the Android debug bridge in development builds