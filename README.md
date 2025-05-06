# Labseq Server

Quarkus-based REST API server that exposes a single endpoint "/labseq/{id}" to retrieve the value at a given index in the sequence.

---

Included by Quarkus:


## Packaging and running the application

The application can be packaged using:

```shell script
./mvnw package
```

It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.
