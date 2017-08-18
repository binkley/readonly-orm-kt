# An example custom read-only ORM in Kotlin

[![ktlint](https://img.shields.io/badge/code%20style-%E2%9D%A4-FF4081.svg)](https://ktlint.github.io/)

## License

This software is in the Public Domain.  Please see [LICENSE.md](LICENSE.md).

## Issues

* IntelliJ has problems with classpath for integration tests.  Moved
  integration tests to unit tests sourceset for now
  ([Issue #1](https://github.com/binkley/readonly-orm-kt/issues/1)).
* `fields()` could be automated through reflection; unclear if this is the
  right thing to do ([Issue #2](https://github.com//binkley/readonly-orm-kt/issues/2)).
