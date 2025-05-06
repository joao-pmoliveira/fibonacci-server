# Labseq Server

Quarkus-based REST API server that exposes a single endpoint "/labseq/{id}" to retrieve the value at a given index in the sequence.

---

## Build Steps

### Docker

Build image:

```
docker build -f src/main/docker/Dockerfile.jvm -t quarkus/labseq-server .
```

Run container:

```
docker run -i -t -p 8080:8080 quarkus/labseq-server
```

Using curl to test:
```
curl http:localhost:8080/labseq/100000
```
or the browser
