# Stage 1
FROM ghcr.io/graalvm/native-image-community:25 AS builder

WORKDIR /app

COPY . .

RUN ./gradlew nativeCompile

# Stage 2
FROM debian:bookworm-slim

WORKDIR /app

COPY --from=builder /app/build/native/nativeCompile/graal-demo .

RUN apt-get update && apt-get install -y zlib1g && apt-get clean

EXPOSE 8080

ENTRYPOINT ["/app/graal-demo"]