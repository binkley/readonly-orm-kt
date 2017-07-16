# An example custom read-only ORM in Kotlin

## License

This software is in the Public Domain.  Please see [LICENSE.md](LICENSE.md).

## Issues

* IntelliJ has problems with classpath for integration tests.  Moved
  integration tests to unit tests sourceset for now (Issue #1).
* `fields()` could be automated through reflection; unclear if this is the
  right thing to do (Issue #2).
